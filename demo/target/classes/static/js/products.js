$(document).ready(function() {
    //вывод товаров из json
    $.ajax({
            url: "/products",
            type: "GET",
            dataType: "json",
            success: function(getProductList){
                var productsList = getProductList;
                $('#productsContainer').empty();
                $.each(getProductList, function(key, productsList) {
                    var productHtml = "<div class='product col-lg-4 col-md-6 col-sm-12 mb-4'>" +
                        "<div class='card h-100'>" +
                        "<div class='card-body'>" +
                        "<img src='"+productsList.img+"' width='200px' height='300px' class='card-img-top mx-auto d-block' alt='Product Image'>"+
                        "<h4 class='card-title'>" + productsList.name + "</h4>" +
                        "<p class='card-text'>" + productsList.category + "</p>" +
                        "<h3 class='card-text'>" + productsList.price + " руб/шт</h3>" +
                        "<button type='button' id ='"+productsList.id+"' class='add-cart btn btn-primary'>Добавить в корзину</button>"+
                        "</div>" +
                        "</div>" +
                        "</div>";
                    $('#productsContainer').append(productHtml);
                });;
            }
        })
   //получение параметров для фильтрации по кнопке
    $('#filter-button').click(function() {
        var name = $('#filter-name').val();
        var category = $('#filter-category').val();
        var minPrice = $('#filter-min-price').val();
        var maxPrice = $('#filter-max-price').val();
        // передача парметров на фильтр и получение списка на вывод
        $.ajax({
            url: "/products/filter",
            type: "POST",
            data: JSON.stringify({ name: name, category: category, minPrice: minPrice, maxPrice: maxPrice }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(filteredProducts) {
                
                $('#productsContainer').empty();

                
                $.each(filteredProducts, function(key, product) {
                    var productHtml = "<div class='product col-lg-4 col-md-6 col-sm-12 mb-4'>" +
                        "<div class='card h-100'>" +
                        "<div class='card-body'>" +
                        "<img src='"+product.img+"' width='200px' height='300px' class='card-img-top mx-auto d-block' alt='Product Image'>"+
                        "<h4 class='card-title'>" + product.name + "</h4>" +
                        "<p class='card-text'>" + product.category + "</p>" +
                        "<h3 class='card-text'>" + product.price + " руб/шт</h3>" +
                        "<button type='button' id ='"+product.id+"' class='add-cart btn btn-primary'>Добавить в корзину</button>"+
                        "</div>" +
                        "</div>" +
                        "</div>";
                    $('#productsContainer').append(productHtml);
                });
            },
            error: function() {
                console.log('Error filtering products');
            }
        });
    });
    $('#sort-price').click(function() {
        let sortBy = "price";
        
        // передача парметров на фильтр и получение списка на вывод
        $.ajax({
            url: "/products/sort",
            type: "POST",
            data: JSON.stringify({ sortBy: sortBy}),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(sortedProducts) {
                
                $('#productsContainer').empty();

                
                $.each(sortedProducts, function(key, product) {
                    var productHtml = "<div class='product col-lg-4 col-md-6 col-sm-12 mb-4'>" +
                        "<div class='card h-100'>" +
                        "<div class='card-body'>" +
                        "<img src='"+product.img+"' width='200px' height='300px' class='card-img-top mx-auto d-block' alt='Product Image'>"+
                        "<h4 class='card-title'>" + product.name + "</h4>" +
                        "<p class='card-text'>" + product.category + "</p>" +
                        "<h3 class='card-text'>" + product.price + " руб/шт</h3>" +
                        "<button type='button' id ='"+product.id+"' class='add-cart btn btn-primary'>Добавить в корзину</button>"+
                        "</div>" +
                        "</div>" +
                        "</div>";
                    $('#productsContainer').append(productHtml);
                });
            },
            error: function() {
                console.log('Error sorting products');
            }
        });
    });

        
    
});
$(document).on('click', '.add-cart', function() {
    var productId = $(this)[0].id;
    console.log(productId);
    $.ajax({
        type: "POST",
        url: "/cart",
        data: {
            productId: productId
        },
        success: function(data) {
            // Обработка успешного ответа сервера
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Обработка ошибки
        }
    });
    $.ajax({
        type: "GET",
        url: "/cart/quantity",
        success: function(data) {
            console.log(data);
            $("#cart-quantity").text(data.quantity);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            // Обработка ошибки
        }
    });
    

});

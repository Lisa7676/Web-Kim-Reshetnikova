$(document).ready(function() {
    $('#generate-list').click(function(){
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
                        "<h4 class='card-title'>" + productsList.name + "</h4>" +
                        "<p class='card-text'>" + productsList.category + "</p>" +
                        "<p class='card-text'>" + productsList.price + "</p>" +
                        "</div>" +
                        "</div>" +
                        "</div>";
                    $('#productsContainer').append(productHtml);
                    console.log(productHtml);
                });;
            }
        })
    })

    // Apply filter when filter button is clicked
    $('#filter-button').click(function() {
        var category = $('#filter-category').val();
        var minPrice = $('#minPriceInput').val();
        var maxPrice = $('#maxPriceInput').val();

        // Send AJAX request to filter products
        $.ajax({
            url: "/products/filter",
            type: "POST",
            data: JSON.stringify({ category: category, minPrice: minPrice, maxPrice: maxPrice }),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(filteredProducts) {
                // Clear existing products from products container
                $('#productsContainer').empty();

                // Loop through each filtered product and add it to the products container
                $.each(filteredProducts, function(key, product) {
                    var productHtml = "<div class='product col-lg-4 col-md-6 col-sm-12 mb-4'>" +
                        "<div class='card h-100'>" +
                        "<div class='card-body'>" +
                        "<h4 class='card-title'>" + product.name + "</h4>" +
                        "<p class='card-text'>" + product.category + "</p>" +
                        "<p class='card-text'>" + product.price + "</p>" +
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

});

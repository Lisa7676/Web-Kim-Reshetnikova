$(document).ready(function() {

    

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
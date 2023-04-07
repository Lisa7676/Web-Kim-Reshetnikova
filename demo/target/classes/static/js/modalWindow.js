
$(document).ready(function() {
  var selectCity = getCookie("selectedCity");
//если нет куки вызываем выбор города
  if (selectCity==null) {
    document.getElementById("city-button").click();
  }
  else {
    var button = document.getElementById("city-button");
    button.innerHTML = selectCity;
  }

// функция для получения значения куки по имени
  function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) {
      return parts.pop().split(";").shift();
  }}

//сохранение куки по выбранному значению
  $('#save-button').click(function() {
    var selectedCity = $('#city-select').val();
    document.cookie = "selectedCity=" + selectedCity + "; path=/";
    var selectCity = getCookie("selectedCity");
    var button = document.getElementById("city-button");
    button.innerHTML = selectCity;
  });
});
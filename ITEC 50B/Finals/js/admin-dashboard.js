$(document).ready(function(){
    $(".progress-line-amount").css("width", $("#income").text());
    $(".progress-line-clients").css("width", $("#clients").text());
    $(".progress-line-incomplete-orders").css("width", $("#incomplete-orders").text());
    $(".progress-line-total-orders").css("width", $("#completed-orders").text());
});
  
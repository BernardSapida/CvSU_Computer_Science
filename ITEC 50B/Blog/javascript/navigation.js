$(document).ready(function(){
    $("#navigation").click(function(){
        $("body").toggleClass("disableScroll");
        $(".top").toggleClass("topAnimate");
        $(".middle").toggleClass("middleAnimate");
        $(".bottom").toggleClass("bottomAnimate");
        $(".screen_navigation").toggleClass("show");
        $("#navigation").css({"z-index":"2", "position":"sticky"});
    });
});

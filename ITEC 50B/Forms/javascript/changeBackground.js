$(document).ready(function(){
    $("#switch").click(function(){
        $("body").toggleClass("lightsOff").css({"transition":"all 350ms ease-in-out"});
        $("#switch").toggleClass("lightsOff").css({"transition":"all 350ms ease-in-out"});
        $("lightsOffText h1").toggleClass("lightsOff").css({"transition":"all 350ms ease-in-out"});
        $(".lightsOffPrimary, .lightsOffSecondary").toggleClass("lightsOff").css({"transition":"all 350ms ease-in-out"});
        $(".radio-btn").toggleClass("lightsOff").css({"transition":"all 350ms ease-in-out"});
    });
});
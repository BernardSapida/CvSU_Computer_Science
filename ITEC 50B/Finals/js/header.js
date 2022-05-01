$(document).ready(function(){
    $("#navigation_responsive").click(function(){
      $("ul.nav_links").toggleClass("open", $('#hamburger-menu')[0].checked);
    });
});

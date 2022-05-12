if ( window.history.replaceState ) {
    window.history.replaceState( null, null, window.location.href );
}

// $("#contactForm").submit(function(e) {
//     e.preventDefault();

    // let name = $("#name").val();
    // let email = $("#email").val();
    // let subject = $("#subject").val();
    // let message = $("#message").val();

    // if(name == "") {
    //     $(".err_name").addClass("display_err");
    // } else {
    //     $(".err_name").removeClass("display_err");
    // }

    // if(email == "") {
    //     $(".err_email").addClass("display_err");
    // } else {
    //     $(".err_email").removeClass("display_err");
    // }

    // if(subject == "") {
    //     $(".err_subject").addClass("display_err");
    // } else {
    //     $(".err_subject").removeClass("display_err");
    // }

    // if(message == "") {
    //     $(".err_message").addClass("display_err");
    // } else {
    //     $(".err_message").removeClass("display_err");
    // }

    // if(name == "" || email == "" || subject == "" || message == "") return false;

    // return true;
// });
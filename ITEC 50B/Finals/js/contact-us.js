$("#contactForm").submit(function(e) {
    e.preventDefault();
    
    let name = $("#name").val();
    let email = $("#email").val();
    let subject = $("#subject").val();
    let message = $("#message").val();
    let submit = $("#submit").val();
});
function validateContact() {
    let firstname = document.getElementById("firstname").value;
    let secondname = document.getElementById("secondname").value;
    let email = document.getElementById("email").value;
    let subject = document.getElementById("subject").value;
    let message = document.getElementById("message").value;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

    if(firstname.trim().length == 0) {
        alert("Please put your Firstname!");
        return false;
    }
    if(firstname.trim().length < 2) {
        alert("Your firstname is too short!");
        return false;
    }
    if(secondname.trim().length == 0) {
        alert("Please put your Secondname!");
        return false;
    }
    if(secondname.trim().length < 2) {
        alert("Your secondname is too short!");
        return false;
    }
    if(email.trim().length == 0) {
        alert("Please put your Email Address!");
        return false;
    }
    if(!email.match(mailformat)) {
        alert("Your email is invalid!");
        return false;
    }
    if(subject.trim().length == 0) {
        alert("Please put your Subject!");
        return false;
    }
    if(subject.trim().length < 2) {
        alert("Your subject is too short!");
        return false;
    }
    if(message.trim().length == 0) {
        alert("Please put your Message!"); 
        return false;
    };
    if(subject.trim().length < 2) {
        alert("Your message is too short!");
        return false;
    }

    alert(`Sorry ${firstname} ${secondname}, your message didn't send! This website is not done yet!`);
    window.location.href = "index.html";
    return false;
}
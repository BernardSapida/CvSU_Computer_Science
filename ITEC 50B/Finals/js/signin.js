document.querySelector("#eye").addEventListener("click", showPassword);

function showPassword() {
    let eye = document.getElementById("eye");
    let password = document.getElementById("signin_password");

    if(Array.from(eye.classList).indexOf("fa-eye-slash") != -1) {
        eye.classList.remove("fa-eye-slash");
        eye.classList.toggle("fa-eye");
        password.setAttribute("type", "text");
    } else {
        eye.classList.remove("fa-eye");
        eye.classList.toggle("fa-eye-slash");
        password.setAttribute("type", "password");
    }
}
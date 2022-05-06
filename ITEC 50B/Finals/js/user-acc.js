document.querySelector("#eye_user-password-current").addEventListener("click", showCurrentPassword);
document.querySelector("#eye_user-password-new").addEventListener("click", showNewPassword);
document.querySelector("#eye_user-password-confirm").addEventListener("click", showConfirmPassword);

function showCurrentPassword() {
    let eye = document.getElementById("eye_user-password-current");
    let password = document.getElementById("user-password-current");

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

function showNewPassword() {
    let eye = document.getElementById("eye_user-password-new");
    let password = document.getElementById("user-password-new");

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

function showConfirmPassword() {
    let eye = document.getElementById("eye_user-password-confirm");
    let password = document.getElementById("user-password-confirm");

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

// $(document).ready(function(){
//     $("#eye_user-password-current").click(function() {
//         console.log($(`#${$(this).attr('id').slice(9,)}`).val());
//     });
// });
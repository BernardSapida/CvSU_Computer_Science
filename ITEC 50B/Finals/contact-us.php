<?php
use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require 'PHPMailer/src/Exception.php';
require 'PHPMailer/src/PHPMailer.php';
require 'PHPMailer/src/SMTP.php';

if(isset($_POST["submit_message"])) {
    $name = htmlspecialchars($_POST["name"]);
    $email = $_POST["email"];
    $subject = htmlspecialchars($_POST["subject"]);
    $message = htmlspecialchars($_POST["message"]);
    $errName = "";
    $errEmail = "";
    $errInvalidEmail = "";
    $errSubject = "";
    $errMessage = "";

    if(!empty($name) && !empty($email) && !empty($subject) && !empty($message) && filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $connect = mysqli_connect("localhost","root","", "burgerhub") or die("ERROR: Could not connect. " .  $connect->connect_error);;
        $sql = "INSERT INTO client_messages (id, image, fullname, email, subject, message) VALUES ('','default.jpeg', '$name', '$email', '$subject', '$message')";
        mysqli_query($connect, $sql);

        $mail = new PHPMailer(true);

        try {
            $mail->isSMTP();                                                            //Send using SMTP
            $mail->Host       = 'smtp.office365.com';                                   //Set the SMTP server to send through
            $mail->SMTPAuth   = true;                                                   //Enable SMTP authentication
            $mail->Username   = 'bernardsapida1706@gmail.com';                          //SMTP username
            $mail->Password   = 'JAVASCRIPT1708131117';                                 //SMTP password
            $mail->SMTPSecure = "STARTTLS";                                             //Enable implicit TLS encryption
            $mail->Port       = 587;                                                    //TCP port to connect to; use 587 if you have set `SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS`

            //Recipients
            $mail->setFrom('bernardsapida1706@gmail.com', 'BurgerHub');
            $mail->addAddress($email, $name);               //Add a recipient & Name is optional
            $mail->addReplyTo('bernardsapida1706@gmail.com', 'Reply');

            //Content
            $mail->isHTML(true);                                                        //Set email format to HTML
            $mail->Subject = 'Message from BurgerHub';
            $mail->Body    = 'We received your message, thank you for reaching us out and we will try out best to respond soonest!<br/>- Mr. Bernard';
            $mail->AltBody = 'We received your message, thank you for reaching us out and we will try out best to respond soonest!';

            // $mail->send();
            // echo 'Message has been sent';

            $name = "";
            $email = "";
            $subject = "";
            $message = "";
        } catch (Exception $e) {
            // echo "Message could not be sent. Mailer Error: {$mail->ErrorInfo}";
        }
    } else {
        if(empty($email)) {
            $errEmail = "display_err";
        } else {
            filter_var($email, FILTER_SANITIZE_EMAIL);
            if(!filter_var($email, FILTER_VALIDATE_EMAIL)) $errInvalidEmail = "display_err";
        }

        if(empty($name)) $errName = "display_err";
        if(empty($subject)) $errSubject = "display_err";
        if(empty($message)) $errMessage = "display_err";

        echo "<script>location.href = '#title_contact';</script>";
    }
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="BERNARD V. SAPIDA, JAN MARICHIE Z. MOJICA, ZILDJIAN LEE G. LOREN, JOHN HERSON L. RADONES">
    <link rel="icon" type="image/any-icon" href="images/burgerhub.ico">
    <link rel="stylesheet" href="css/client_header.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/contact.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <title>BurgerHub</title>
</head>
<body>
    <?php include_once 'header.php' ?>
    
    <!-- BurgerHub Contact Us Page -->
    <main>
        <!-- BurgerHub Contact Map -->
        <section class="section_contact-page">
            <div class="container_map">
                <h1>Contact Us</h1>
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d61831.420441104514!2d120.90147162171846!3d14.400407872058466!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3397d252b84f3c11%3A0x38b0f2e1f833e8df!2sImus%2C%20Cavite!5e0!3m2!1sen!2sph!4v1651582995336!5m2!1sen!2sph" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </section>

        <!-- BurgerHub Contact Form -->
        <section class="section_contact-form">
            <div class="container_contact">
                <div class="container_form">
                    <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST" id="contactForm">
                        <h1 id="title_contact">Get in Touch</h1>
                        <div class="container_name-and-email">
                            <label for="name">
                                <p>Name</p>
                                <input type="text" name="name" id="name" placeholder="Enter your name" autocomplete="name" value="<?php echo isset($_POST["name"]) ? $name : "" ?>">
                                <p class="err_name <?php echo $errName ?>">Name is required!</p>
                            </label>
                            <label for="email">
                                <p>Email</p>    
                                <input type="text" name="email" id="email" placeholder="Enter your email" autocomplete="email" value="<?php echo isset($_POST["email"]) ? $email : "" ?>">
                                <p class="err_email <?php echo $errInvalidEmail ?>">Email is invalid!</p>
                                <p class="err_email <?php echo $errEmail ?>">Email is required!</p>
                            </label>
                        </div>
                        <label for="subject">
                            <p>Subject</p>
                            <input type="text" name="subject" id="subject" placeholder="Enter your subject" value="<?php echo isset($_POST["subject"]) ? $subject : "" ?>">
                            <p class="err_subject <?php echo $errSubject ?>">Subject is required!</p>
                        </label>
                        <label for="message">
                            <p>Message</p>
                            <textarea name="message" id="message" cols="30" rows="10" placeholder="Enter your message"><?php echo isset($_POST["message"]) ? $message : "" ?></textarea>
                            <p class="err_message <?php echo $errMessage ?>">Message is required!</p>
                        </label>
                        <button type="submit" id="submit_message" name="submit_message"><span><i class="fa-solid fa-paper-plane"></i></span> SEND</button>
                    </form>
                </div>
            </div>
        </section>
    </main>
    
    <?php include_once 'global_footer.php' ?>

    <script src="js/contact-us.js"></script>
</body>
</html>
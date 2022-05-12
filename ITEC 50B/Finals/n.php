<?php
    session_start();
    
    if(empty($_SESSION["type"]) || $_SESSION["type"] == "admin") header("Location: index.php");
    $clientID = $_SESSION["clientid"];

    $errFirstname = "This is a required field!";
    $errLastname = "This is a required field!";
    $errMobile = "This is a required field!";
    $errAddress = "This is a required field!";
    $errEmail = "This is a required field!";
    $errCity = "This is a required field!";
    $errBarangay = "This is a required field!";
    $errImage = "This is a required field!";
    $image_new_name = "This is a required field!";
    $current_password = "This is a required field!";
    $new_password = "This is a required field!";
    $confirm_password = "This is a required field!";

    if(isset($_POST["client-account-submit"])) {
        $firstname = $_POST["client-account-firstname"];
        $lastname = $_POST["client-account-lastname"];
        $mobile = $_POST["client-account-mobile"];
        $street_address = $_POST["client-account-street-address"];
        $city = $_POST["client-account-city"];
        $barangay = $_POST["client-account-barangay"];
        $email = $_POST["client-account-email"];
        $image = $_SESSION["image"];

        $image_name = $_FILES["client-account-image"]["name"];
        $image_size = $_FILES["client-account-image"]["size"];
        $image_tmp = $_FILES["client-account-image"]["tmp_name"];
        $image_err = $_FILES["client-account-image"]["error"];

        if(!empty($firstname) && !empty($lastname) && !empty($email) && !empty($mobile) && !empty($street_address) && !empty($city) && !empty($barangay)) {
            if($image_err === 0) {
                if($image_size > 800000) {
                    $errImage = "Sorry, your profile image is too large!";
                } else {
                    $image_external = pathinfo($image_name, PATHINFO_EXTENSION);
                    $image_external_lowercase = strtolower($image_external);
                    $allowed_externals = array("jpg", "jpeg", "png");
                    
                    if(in_array($image_external_lowercase, $allowed_externals)){
                        $image_new_name = uniqid("IMG-", true) . '.' . $image_external_lowercase;
                        $image_upload_path = 'profile/' . $image_new_name;
                        move_uploaded_file($image_tmp, $image_upload_path);

                        $image = $image_new_name;
                        $_SESSION["image"] = $image;
                    }
                }
            }
            
            $connect = mysqli_connect("localhost","root","", "burgerhub") or die("ERROR: Could not connect. " .  $connect->connect_error);;
            $sql_information = "UPDATE client_information 
            SET image = '$image', `firstname` = '$firstname', `lastname` = '$lastname', `email` = '$email', `mobile` = '$mobile', `street address` = '$street_address', `city` = '$city', `barangay` = '$barangay' WHERE clientid = '$clientID'";
            mysqli_query($connect, $sql_information);

            $sql_accounts = "UPDATE client_accounts 
            SET image = '$image' WHERE clientid = '$clientID'";
            mysqli_query($connect, $sql_accounts);

            $_SESSION["mobile"] = $mobile;
            $_SESSION["street-address"] = $street_address;
            $_SESSION["city"] = $city;
            $_SESSION["barangay"] = $barangay;

            $firstname = "";
            $lastname = "";
            $mobile = "";
            $street_address = "";
            $city = "";
            $barangay = "";
            $email = "";
            $image = "";
        } else {
            if(empty($firstname)) $errFirstname = "Firstname is required!";
            if(empty($lastname)) $errLastname = "Lastname is required!";
            if(empty($email)) $errEmail = "Email is required!";
            if(empty($mobile)) $errMobile = "Mobile is required!";
            if(empty($street_address)) $errAddress = "Street Address is required!";
            if(empty($city)) $errCity = "City is required!";
            if(empty($barangay)) $errBarangay = "Barangay is required!";
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
    <link rel="stylesheet" href="css/client_account.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <title>BurgerHub</title>
</head>
<body>
    <?php include_once 'header.php' ?>

    <!-- BurgerHub Client Account Page -->
    <main>
        <!-- BurgerHub Client Account -->
        <section class="section_client-account">
            <div id="img_prev"></div>
            <h1 id="client_profiles">My Account</h1>
            <hr>
            <div class="container_client-account">
                <form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST" enctype="multipart/form-data">
                    <div class="profile_image"> 
                        <label for="client-account-image">
                            <img src="profile/<?php echo isset($_POST["client-account-image"]) ? $_POST["client-account-image"] : (empty($_SESSION['image']) ? "default.jpg" : $_SESSION['image']) ?>" id="client_profile" alt="Client Profile">
                            <input type="file" aria-label="Client Profile" name="client-account-image" id="client-account-image">
                            <div class="camera-icon"><i class="fa-solid fa-camera"></i></div>
                        </label>
                    </div>
                    <div class="container_client-account-fullname">
                        <label for="client-account-firstname">
                            <p>First Name <span>*</span></p>
                            <input type="text" name="client-account-firstname" id="client-account-firstname" autocomplete="given-name" value="<?php echo isset($_SESSION["firstname"]) ? $_SESSION["firstname"] : (isset($_POST["client-account-firstname"]) ? $firstname : ""); ?>" placeholder="Enter your first name">
                            <p class="err_message"><?php echo $errFirstname ?></p>
                        </label>
                        <label for="client-account-lastname">
                            <p>Last Name <span>*</span></p>
                            <input type="text" name="client-account-lastname" id="client-account-lastname" autocomplete="family-name" value="<?php echo isset($_SESSION["lastname"]) ? $_SESSION["lastname"] : (isset($_POST["client-account-lastname"]) ? $firstname : ""); ?>" placeholder="Enter your last name">
                            <p class="err_message"><?php echo $errLastname ?></p>
                        </label>
                    </div>
                    <label for="client-account-email">
                        <p>Email <span>*</span></p>
                        <input type="text" name="client-account-email" id="client-account-email" autocomplete="email" value="<?php echo isset($_SESSION["email"]) ? $_SESSION["email"] : (isset($_POST["client-account-email"]) ? $_POST["client-account-email"] : ""); ?>" placeholder="Enter your email">
                        <p class="err_message"><?php echo $errEmail ?></p>
                    </label>
                    <label for="client-account-mobile">
                        <p>Mobile Number <span>*</span></p>
                        <input type="text" name="client-account-mobile" id="client-account-mobile" autocomplete="tel" value="<?php echo isset($_SESSION["mobile"]) ? $_SESSION["mobile"] : (isset($_POST["client-account-mobile"]) ? $mobile : ""); ?>" placeholder="+63 947-212-6029">
                        <p class="err_message"><?php echo $errMobile ?></p>
                    </label>
                    <label for="client-account-street-address">
                        <p>Street Address <span>*</span></p>
                        <input type="text" name="client-account-street-address" id="client-account-street-address" autocomplete="street-address" value="<?php echo isset($_SESSION["street-address"]) ? $_SESSION["street-address"] : (isset($_POST["client-account-street-address"]) ? $street_address : ""); ?>" placeholder="Enter your address">
                        <p class="err_message"><?php echo $errAddress ?></p>
                    </label>
                    <div class="container_client-account-fullname">
                        <label for="client-account-firstname">
                            <p>City <span>*</span></p>
                            <input type="text" name="client-account-city" id="client-account-city" autocomplete="given-name" value="<?php echo isset($_SESSION["city"]) ? $_SESSION["city"] : (isset($_POST["client-account-city"]) ? $city : ""); ?>" placeholder="Enter your city">
                            <p class="err_message"><?php echo $errCity ?></p>
                        </label>
                        <label for="client-account-lastname">
                            <p>Barangay <span>*</span></p>
                            <input type="text" name="client-account-barangay" id="client-account-barangay" autocomplete="family-name" value="<?php echo isset($_SESSION["barangay"]) ? $_SESSION["barangay"] : (isset($_POST["client-account-barangay"]) ? $barangay : ""); ?>" placeholder="Enter your barangay">
                            <p class="err_message"><?php echo $errBarangay ?></p>
                        </label>
                    </div>
                    <button type="submit" name="client-account-submit" id="client-account-submit">Edit Account</button>
                </form>
            </div>
        </section>

        <!-- BurgerHub Client Password -->
        <section class="section_client-password">
            <h1>Password</h1>
            <hr>
            <div class="container_client-password">
                <form action="" method="POST">
                    <label for="client-email-hidden">
                        <p>Email <span>*</span></p>
                        <input type="text" name="client-email-hidden" id="client-email-hidden" value="bernardsapida1706@gmail.com" autocomplete="email" disabled>
                    </label>
                    <div class="container_client-password">
                        <label for="client-password-current">
                            <p>Current Password <span>*</span></p>
                            <div class="container_client-password-current">
                                <input type="password" name="client-password-current" id="client-password-current" autocomplete="current-password" placeholder="Current password">
                                <i class="fa-solid fa-eye-slash icon_hide-password" id="eye_client-password-current"></i>
                            </div>
                        </label>
                        <label for="client-password-new">
                            <p>New Password <span>*</span></p>
                            <div class="container_client-password-new">
                                <input type="password" name="client-password-new" id="client-password-new" autocomplete="new-password" placeholder="New password">
                                <i class="fa-solid fa-eye-slash icon_hide-password" id="eye_client-password-new"></i>
                            </div>
                        </label>
                        <label for="client-password-confirm">
                            <p>Confirm Password <span>*</span></p>
                            <div class="container_client-password-confirm">
                                <input type="password" name="client-password-confirm" id="client-password-confirm" autocomplete="new-password" placeholder="Confirm password">
                                <i class="fa-solid fa-eye-slash icon_hide-password" id="eye_client-password-confirm"></i>
                            </div>
                        </label>
                        <button type="submit" name="client-password-submit" id="client-password-submit">Edit Password</button>
                    </div>
                </form>
            </div>
        </section>
    </main>
    
    <?php include_once 'global_footer.php' ?>
    
    <script src="js/client-acc.js"></script>
    <script>
        let newUploadImage = document.getElementById("client-account-image");
        let clientProfile = document.getElementById("client_profile");
        newUploadImage.onchange = function() {
            let newImage = this.files[0];
            let text;
            if(newImage) {
                const fileReader = new FileReader();
                const imgPreview = document.getElementById("img_prev");
                fileReader.readAsDataURL(newImage);
                fileReader.addEventListener("load", function () {
                    clientProfile.src = this.result;
                }); 
            } else {
                text = 'Please select a file';
            }
            clientProfile.innerHTML = text;
        };
    </script>
    
</body>
</html>
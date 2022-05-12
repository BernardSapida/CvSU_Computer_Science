<?php
    session_start();

    if(empty($_SESSION["type"]) || $_SESSION["type"] == "admin") header("Location: index.php");
    
    error_reporting(E_ERROR | E_PARSE);
    
    $errFirstname = "";
    $errLastname = "";
    $errStreetAddress = "";
    $errCity = "";
    $errBarangay = "";
    $errEmptyCart = "";

    if(isset($_POST["submit"])) {
        $clientid = $_SESSION["clientid"];
        $firstname = $_POST["client_firstname"];
        $lastname = $_POST["client_lastname"];
        $image = $_SESSION["image"];
        $street_address = htmlspecialchars($_POST["client_address"]);
        $city = htmlspecialchars($_POST["client_city"]);
        $barangay = htmlspecialchars($_POST["client_barangay"]);
        $fp1 = $_SESSION["featured-product-1"];
        $fp2 = $_SESSION["featured-product-2"];
        $fp3 = $_SESSION["featured-product-3"];
        $burger1 = $_SESSION["burger-1"];
        $burger2 = $_SESSION["burger-2"];
        $burger3 = $_SESSION["burger-3"];
        $burger4 = $_SESSION["burger-4"];
        $burger5 = $_SESSION["burger-5"];
        $burger6 = $_SESSION["burger-6"];
        $pizza1 = $_SESSION["pizza-1"];
        $pizza2 = $_SESSION["pizza-2"];
        $pizza3 = $_SESSION["pizza-3"];
        $pizza4 = $_SESSION["pizza-4"];
        $pizza5 = $_SESSION["pizza-5"];
        $pizza6 = $_SESSION["pizza-6"];
        $fries1 = $_SESSION["fries-1"];
        $fries2 = $_SESSION["fries-2"];
        $fries3 = $_SESSION["fries-3"];
        $fries4 = $_SESSION["fries-4"];
        $fries5 = $_SESSION["fries-5"];
        $fries6 = $_SESSION["fries-6"];
        $drinks1 = $_SESSION["drinks-1"];
        $drinks2 = $_SESSION["drinks-2"];
        $drinks3 = $_SESSION["drinks-3"];
        $drinks4 = $_SESSION["drinks-4"];
        $drinks5 = $_SESSION["drinks-5"];
        $drinks6 = $_SESSION["drinks-6"];
        $quantity = $_SESSION["quantity"];
        $total = $_SESSION["total_amount"];

        if(!empty($firstname) && !empty($lastname) && !empty($street_address) && !empty($city) && !empty($barangay) && !empty($quantity)) {
            $trackingNo = explode(".", uniqid("",true))[0];
            $orderNo = explode(".", uniqid("",true))[1];

            $connect = mysqli_connect("localhost","root","", "burgerhub") or die("ERROR: Could not connect. " .  $connect->connect_error);
            $sql = "INSERT INTO `client_orders`
            (`clientid`, `firstname`, `lastname`, `image`, `street address`, `city`, `barangay`, `trackingNo`, `orderNo`, 
            `item1`, `item2`, `item3`,
            `item4`, `item5`, `item6`, `item7`, `item8`, `item9`,
            `item10`, `item11`, `item12`, `item13`, `item14`, `item15`,
            `item16`, `item17`, `item18`, `item19`, `item20`, `item21`,
            `item22`, `item23`, `item24`, `item25`, `item26`, `item27`,
            `quantity`, `total`, `status`)
            VALUES
            ('$clientid','$firstname','$lastname','$image','$street_address','$city', '$barangay', '$trackingNo', '$orderNo',
            '$fp1','$fp2','$fp3',
            '$burger1','$burger2','$burger3','$burger4','$burger5','$burger6',
            '$pizza1','$pizza2','$pizza3','$pizza4','$pizza5','$pizza6',
            '$fries1','$fries2','$fries3','$fries4','$fries5','$fries6',
            '$drinks1','$drinks2','$drinks3','$drinks4','$drinks5','$drinks6',
            '$quantity','$total','Pending')";

            mysqli_query($connect, $sql);

            $firstname = "";
            $lastname = "";
            $street_address = "";
            $city = "";
            $barangay = "";
            $_SESSION["featured-product-1"] = 0;
            $_SESSION["featured-product-2"] = 0;
            $_SESSION["featured-product-3"] = 0;
            $_SESSION["burger-1"] = 0;
            $_SESSION["burger-2"] = 0;
            $_SESSION["burger-3"] = 0;
            $_SESSION["burger-4"] = 0;
            $_SESSION["burger-5"] = 0;
            $_SESSION["burger-6"] = 0;
            $_SESSION["pizza-1"] = 0;
            $_SESSION["pizza-2"] = 0;
            $_SESSION["pizza-3"] = 0;
            $_SESSION["pizza-4"] = 0;
            $_SESSION["pizza-5"] = 0;
            $_SESSION["pizza-6"] = 0;
            $_SESSION["fries-1"] = 0;
            $_SESSION["fries-2"] = 0;
            $_SESSION["fries-3"] = 0;
            $_SESSION["fries-4"] = 0;
            $_SESSION["fries-5"] = 0;
            $_SESSION["fries-6"] = 0;
            $_SESSION["drinks-1"] = 0;
            $_SESSION["drinks-2"] = 0;
            $_SESSION["drinks-3"] = 0;
            $_SESSION["drinks-4"] = 0;
            $_SESSION["drinks-5"] = 0;
            $_SESSION["drinks-6"] = 0;
            $_SESSION["quantity"] = 0;
            $_SESSION['total_amount'] = 0;
            $_SESSION["menu"] = array();
        } else {
            if(empty($firstname)) $errFirstname = "Firstname is required!";
            if(empty($lastname)) $errLastname = "Lastname is required!";
            if(empty($street_address)) $errStreetAddress = "Street address is required!";
            if(empty($city)) $errCity = "City is required!";
            if(empty($barangay)) $errBarangay = "Barangay is required!";
            if(empty($quantity)) $errEmptyCart = "Your cart is empty!";
        }
    }

    $quantity = $_SESSION["quantity"];
    $_SESSION['total_amount'] = 10;
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
    <link rel="stylesheet" href="css/client_cart.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <title>BurgerHub</title>
</head>
<body>
    <?php include_once 'header.php' ?>

    <!-- BurgerHub Cart -->
    <main>
        <!-- BurgerHub Cart Users -->
        <section class="section_cart-acc">
            <h1>Order Cart</h1>
            <div class="error_empty-cart">
                <?php 
                    if(!empty($errEmptyCart)) echo "<p>$errEmptyCart</p>";
                    else if(!empty($firstname) || !empty($lastname) || !empty($street_address) || !empty($city) || !empty($barangay)) echo "<p>Fill in all required fields!</p>";
                ?>
            </div>
            <div class="container_cart-acc">
                <div class="container_cart-form">
                    <div class="container_form-header">
                        <h1>LOGIN</h1>
                        <div class="container_user-info">
                            <p class="user-name"><?php echo $_SESSION['firstname'] . " " . $_SESSION['lastname'] ?></p>
                            <p class="user-contact">+63 <?php echo isset($_SESSION["mobile"]) ? $_SESSION["mobile"] : "No Phone Number" ?></p>
                        </div>
                    </div>
                    <div class="container_form">
                        <h1>Personal Information</h1>
                        <form action="<?php $_SERVER['PHP_SELF'] ?>" method="POST">
                            <div class="container_fullname">
                                <label for="client_firstname">
                                    <p>First Name <span>*</span></p>
                                    <input type="text" name="client_firstname" id="client_firstname" placeholder="Enter your first name" value="<?php echo isset($_SESSION["firstname"]) ? $_SESSION["firstname"] : ""; ?>" autocomplete="given-name">
                                    <p class="err_message"><?php echo $errFirstname ?></p>
                                </label>
                                <label for="client_lastname">
                                    <p>Last Name <span>*</span></p>
                                    <input type="text" name="client_lastname" id="client_lastname" placeholder="Enter your last name" value="<?php echo isset($_SESSION["lastname"]) ? $_SESSION["lastname"] : ""; ?>" autocomplete="family-name">
                                    <p class="err_message"><?php echo $errLastname ?></p>
                                </label>
                            </div>
                            <label for="client_address">
                                <p>Street Address <span>*</span></p>
                                <input type="text" name="client_address" id="client_address" placeholder="Enter your address" autocomplete="street-address" value="<?php echo isset($_SESSION["street-address"]) ? $_SESSION["street-address"] : (isset($_POST["client_address"]) ? $street_address : ""); ?>">
                                <p class="err_message"><?php echo $errStreetAddress ?></p>
                            </label>
                            <div class="container_city-country">
                                <label for="client_city">
                                    <p>City <span>*</span></p>
                                    <input type="text" name="client_city" id="client_city" placeholder="Enter your city" autocomplete="address-line1" value="<?php echo isset($_SESSION["city"]) ? $_SESSION["city"] : (isset($_POST["client_city"]) ? $city : ""); ?>">
                                    <p class="err_message"><?php echo $errCity ?></p>
                                </label>
                                <label for="client_barangay">
                                    <p>Barangay <span>*</span></p>
                                    <input type="text" name="client_barangay" id="client_barangay" placeholder="Enter your barangay" autocomplete="address-line2" value="<?php echo isset($_SESSION["barangay"]) ? $_SESSION["barangay"] : (isset($_POST["client_barangay"]) ? $barangay : ""); ?>">
                                    <p class="err_message"><?php echo $errBarangay ?></p>
                                </label>
                            </div>
                            <div class="container_cart-btn">
                                <button type="button">Cancel</button>
                                <button type="submit" name="submit">Submit</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="container_cart">
                    <div class="container_cart-header">
                        <h1>Your Order</h1>
                        <p class="edit"><i class="fa-solid fa-pen-to-square"></i> Edit</p>
                    </div>
                    <hr>
                    <div class="container_cart-items">
                    <?php
                        if(!empty($_SESSION["menu"])) {
                            foreach($_SESSION["menu"] as $key => $value) {
                                if($value != 0) {
                                    echo '<div class="container_items-added">
                                        <div class="container_items-image">
                                            <img src="images/menu/'.$key.'.png" alt="burger">
                                        </div>
                                        <div class="container_items-description">
                                            <h1 class="item-name">'.$key.'</h1>
                                            <p class="item-info">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Aliquam, quasi!</p>
                                            <p class="item-price">₱381.00 <span class="item-quantity">x '.$value.'</span></p>
                                        </div>
                                    </div>';
                                    // echo $key . " = " . $value . "<br>";
                                    $quantity++;
                                    $_SESSION['total_amount'] += 381;
                                }
                            }
                        } else {
                            echo '<div class="container_cart-empty">
                                <p><i class="fa-solid fa-cart-arrow-down"></i></p>
                                <h1>Your cart is empty</h1>
                            </div>';
                        }                 
                    ?>
                    </div>
                    <hr>
                    <div class="container_delivery-discount">
                        <div class="container_delivery">
                            <p class="title-delivery">Delivery</p>
                            <p class="delivery-fee">₱50 <span>Food Panda</span></p>
                        </div>
                        <div class="container_discount">
                            <p class="title-discount">Discount</p>
                            <p class="discount">-₱40</p>
                        </div>
                    </div>
                    <hr>
                    <div class="container_total-amount">
                        <div class="container_total">
                            <p class="title-total">Total:</p>
                            <p class="total-amount">₱<?php echo (empty(number_format($_SESSION['total_amount'])) || number_format($_SESSION['total_amount']) == 10) ? 0 : number_format($_SESSION['total_amount']); ?></p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <?php include_once 'global_footer.php' ?>
</body>
</html>
<?php
    session_start();

    // if(empty($_SESSION["type"]) || $_SESSION["type"] == "admin") header("Location: index.php");
    
    error_reporting(E_ERROR | E_PARSE);

    if(isset($_POST["add_to_cart"])) {
        $_SESSION["quantity"] = 0;
        
        (isset($_POST["featured-product-1"])) ? $_SESSION["featured-product-1"] += $_POST["featured-product-1"] : 0;
        (isset($_POST["featured-product-2"])) ? $_SESSION["featured-product-2"] += $_POST["featured-product-2"] : 0;
        (isset($_POST["featured-product-3"])) ? $_SESSION["featured-product-3"] += $_POST["featured-product-3"] : 0;
        (isset($_POST["burger-1"])) ? $_SESSION["burger-1"] += $_POST["burger-1"] : 0;
        (isset($_POST["burger-2"])) ? $_SESSION["burger-2"] += $_POST["burger-2"] : 0;
        (isset($_POST["burger-3"])) ? $_SESSION["burger-3"] += $_POST["burger-3"] : 0;
        (isset($_POST["burger-4"])) ? $_SESSION["burger-4"] += $_POST["burger-4"] : 0;
        (isset($_POST["burger-5"])) ? $_SESSION["burger-5"] += $_POST["burger-5"] : 0;
        (isset($_POST["burger-6"])) ? $_SESSION["burger-6"] += $_POST["burger-6"] : 0;
        (isset($_POST["pizza-1"])) ? $_SESSION["pizza-1"] += $_POST["pizza-1"] : 0;
        (isset($_POST["pizza-2"])) ? $_SESSION["pizza-2"] += $_POST["pizza-2"] : 0;
        (isset($_POST["pizza-3"])) ? $_SESSION["pizza-3"] += $_POST["pizza-3"] : 0;
        (isset($_POST["pizza-4"])) ? $_SESSION["pizza-4"] += $_POST["pizza-4"] : 0;
        (isset($_POST["pizza-5"])) ? $_SESSION["pizza-5"] += $_POST["pizza-5"] : 0;
        (isset($_POST["pizza-6"])) ? $_SESSION["pizza-6"] += $_POST["pizza-6"] : 0;
        (isset($_POST["fries-1"])) ? $_SESSION["fries-1"] += $_POST["fries-1"] : 0;
        (isset($_POST["fries-2"])) ? $_SESSION["fries-2"] += $_POST["fries-2"] : 0;
        (isset($_POST["fries-3"])) ? $_SESSION["fries-3"] += $_POST["fries-3"] : 0;
        (isset($_POST["fries-4"])) ? $_SESSION["fries-4"] += $_POST["fries-4"] : 0;
        (isset($_POST["fries-5"])) ? $_SESSION["fries-5"] += $_POST["fries-5"] : 0;
        (isset($_POST["fries-6"])) ? $_SESSION["fries-6"] += $_POST["fries-6"] : 0;
        (isset($_POST["drinks-1"])) ? $_SESSION["drinks-1"] += $_POST["drinks-1"] : 0;
        (isset($_POST["drinks-2"])) ? $_SESSION["drinks-2"] += $_POST["drinks-2"] : 0;
        (isset($_POST["drinks-3"])) ? $_SESSION["drinks-3"] += $_POST["drinks-3"] : 0;
        (isset($_POST["drinks-4"])) ? $_SESSION["drinks-4"] += $_POST["drinks-4"] : 0;
        (isset($_POST["drinks-5"])) ? $_SESSION["drinks-5"] += $_POST["drinks-5"] : 0;
        (isset($_POST["drinks-6"])) ? $_SESSION["drinks-6"] += $_POST["drinks-6"] : 0;

        $_SESSION["menu"] = array(
            "featured-product-1" => $_SESSION["featured-product-1"],
            "featured-product-2" => $_SESSION["featured-product-2"],
            "featured-product-3" => $_SESSION["featured-product-3"],
            "burger_1" => $_SESSION["burger-1"],
            "burger_2" => $_SESSION["burger-2"],
            "burger_3" => $_SESSION["burger-3"],
            "burger_4" => $_SESSION["burger-4"],
            "burger_5" => $_SESSION["burger-5"],
            "burger_6" => $_SESSION["burger-6"],
            "pizza_1" => $_SESSION["pizza-1"],
            "pizza_2" => $_SESSION["pizza-2"],
            "pizza_3" => $_SESSION["pizza-3"],
            "pizza_4" => $_SESSION["pizza-4"],
            "pizza_5" => $_SESSION["pizza-5"],
            "pizza_6" => $_SESSION["pizza-6"],
            "Fries_Barbeque" => $_SESSION["fries-1"],
            "Fries_CheddarCheese" => $_SESSION["fries-2"],
            "Fries_ChiliBarbeque" => $_SESSION["fries-3"],
            "Fries_Salted" => $_SESSION["fries-4"],
            "Fries_SourCream" => $_SESSION["fries-5"],
            "Fries_Wasabi" => $_SESSION["fries-6"],
            "Drinks_Avocado" => $_SESSION["drinks-1"],
            "Drinks_Berry" => $_SESSION["drinks-2"],
            "Drinks_Lemonade" => $_SESSION["drinks-3"],
            "Drinks_Mango" => $_SESSION["drinks-4"],
            "Drinks_Pineapple" => $_SESSION["drinks-5"],
            "Drinks_Strawberry" => $_SESSION["drinks-6"]
        );

        foreach($_SESSION["menu"] as $key => $value) {
            $_SESSION["quantity"] += (int)$value;
        }

        // echo "<script>location.href = '#burger-6';</script>";
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
    <link rel="stylesheet" href="css/client_menu.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <title>BurgerHub</title>
</head>
<body>
    <?php include_once 'header.php' ?>

    <!-- BurgerHub Menu -->
    <main>
        <!-- BurgerHub Featured Products -->
        <form action="<?php echo $_SERVER['PHP_SELF']; ?>" method="POST">
            <section class="section_featured-products">
                <h1>Featured Products</h1>
                <div class="container_featured-products">
                    <div class="container_products">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_1.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="featured-product-1">
                                        <button type="button" id="featured-product-1-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="featured-product-1" id="featured-product-1" value="0">
                                        </p>
                                        <button type="button" id="featured-product-1-plus-btn" aria-label="Increment quantity" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-featured-product-1" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_products">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_2.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="featured-product-2">
                                        <button type="button" id="featured-product-2-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="featured-product-2" id="featured-product-2" value="0">
                                        </p>
                                        <button type="button" id="featured-product-2-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-featured-product-2" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_products">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_3.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="featured-product-3">
                                        <button type="button" id="featured-product-3-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="featured-product-3" id="featured-product-3" value="0">
                                        </p>
                                        <button type="button" id="featured-product-3-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-featured-product-3" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                </div>
            </section>
    
            <!-- BurgerHub Burgers -->
            <section class="section_burgers-menu">
                <h1>Our Burgers</h1>
                <div class="container_burgers-menu">
                    <div class="container_burgers">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_1.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="burger-1">
                                        <button type="button" id="burger-1-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="burger-1" id="burger-1" value="0">
                                        </p>
                                        <button type="button" id="burger-1-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-burger-1" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_burgers">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_2.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="burger-2">
                                        <button type="button" id="burger-2-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="burger-2" id="burger-2" value="0">
                                        </p>
                                        <button type="button" id="burger-2-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-burger-2" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_burgers">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_3.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="burger-3">
                                        <button type="button" id="burger-3-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="burger-3" id="burger-3" value="0">
                                        </p>
                                        <button type="button" id="burger-3-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-burger-3" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_burgers">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_4.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="burger-4">
                                        <button type="button" id="burger-4-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="burger-4" id="burger-4" value="0">
                                        </p>
                                        <button type="button" id="burger-4-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-burger-4" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_burgers">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_5.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="burger-5">
                                        <button type="button" id="burger-5-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="burger-5" id="burger-5" value="0">
                                        </p>
                                        <button type="button" id="burger-5-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-burger-5" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_burgers">
                        <div class="container_image">
                            <img src="images/menu/burger/burger_6.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Burger Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="burger-6">
                                        <button type="button" id="burger-6-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="burger-6" id="burger-6" value="0">
                                        </p>
                                        <button type="button" id="burger-6-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-burger-6" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                </div>
            </section>
    
            <!-- BurgerHub Pizza -->
            <section class="section_pizza-menu">
                <h1>Our Pizza</h1>
                <div class="container_pizza-menu">
                    <div class="container_pizza">
                        <div class="container_image">
                            <img src="images/menu/pizza/pizza_1.png" alt="Pizza">
                        </div>
                        <div class="container_description">
                            <h1>Pizza Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="pizza-1">
                                        <button type="button" id="pizza-1-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="pizza-1" id="pizza-1" value="0">
                                        </p>
                                        <button type="button" id="pizza-1-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-pizza-1" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_pizza">
                        <div class="container_image">
                            <img src="images/menu/pizza/pizza_2.png" alt="Pizza">
                        </div>
                        <div class="container_description">
                            <h1>Pizza Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="pizza-2">
                                        <button type="button" id="pizza-2-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="pizza-2" id="pizza-2" value="0">
                                        </p>
                                        <button type="button" id="pizza-2-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-pizza-2" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_pizza">
                        <div class="container_image">
                            <img src="images/menu/pizza/pizza_3.png" alt="Pizza">
                        </div>
                        <div class="container_description">
                            <h1>Pizza Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="pizza-3">
                                        <button type="button" id="pizza-3-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="pizza-3" id="pizza-3" value="0">
                                        </p>
                                        <button type="button" id="pizza-3-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-pizza-3" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_pizza">
                        <div class="container_image">
                            <img src="images/menu/pizza/pizza_4.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Pizza Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="pizza-4">
                                        <button type="button" id="pizza-4-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="pizza-4" id="pizza-4" value="0">
                                        </p>
                                        <button type="button" id="pizza-4-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-pizza-4" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_pizza">
                        <div class="container_image">
                            <img src="images/menu/pizza/pizza_5.png" alt="Pizza">
                        </div>
                        <div class="container_description">
                            <h1>Pizza Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="pizza-5">
                                        <button type="button" id="pizza-5-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="pizza-5" id="pizza-5" value="0">
                                        </p>
                                        <button type="button" id="pizza-5-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-pizza-5" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_pizza">
                        <div class="container_image">
                            <img src="images/menu/pizza/pizza_6.png" alt="Pizza">
                        </div>
                        <div class="container_description">
                            <h1>Pizza Name</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="pizza-6">
                                        <button type="button" id="pizza-6-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="pizza-6" id="pizza-6" value="0">
                                        </p>
                                        <button type="button" id="pizza-6-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-pizza-6" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                </div>
            </section>
    
            <!-- BurgerHub Fries -->
            <section class="section_fries-menu">
                <h1>Our Fries</h1>
                <div class="container_fries-menu">
                    <div class="container_fries">
                        <div class="container_image">
                            <img src="images/menu/fries/Fries_Barbeque.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Fries Barbeque</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="fries-1">
                                        <button type="button" id="fries-1-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="fries-1" id="fries-1" value="0">
                                        </p>
                                        <button type="button" id="fries-1-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-fries-1" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_fries">
                        <div class="container_image">
                            <img src="images/menu/fries/Fries_CheddarCheese.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Fries Cheddar Cheese</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="fries-2">
                                        <button type="button" id="fries-2-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="fries-2" id="fries-2" value="0">
                                        </p>
                                        <button type="button" id="fries-2-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-fries-2" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_fries">
                        <div class="container_image">
                            <img src="images/menu/fries/Fries_ChiliBarbeque.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Fries Chili Barbeque</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="fries-3">
                                        <button type="button" id="fries-3-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="fries-3" id="fries-3" value="0">
                                        </p>
                                        <button type="button" id="fries-3-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-fries-3" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_fries">
                        <div class="container_image">
                            <img src="images/menu/fries/Fries_Salted.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Fries Salted</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="fries-4">
                                        <button type="button" id="fries-4-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="fries-4" id="fries-4" value="0">
                                        </p>
                                        <button type="button" id="fries-4-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-fries-4" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_fries">
                        <div class="container_image">
                            <img src="images/menu/fries/Fries_SourCream.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Fries Sour Cream</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="fries-5">
                                        <button type="button" id="fries-5-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="fries-5" id="fries-5" value="0">
                                        </p>
                                        <button type="button" id="fries-5-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-fries-5" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_fries">
                        <div class="container_image">
                            <img src="images/menu/fries/Fries_Wasabi.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Fries Wasabi</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="fries-6">
                                        <button type="button" id="fries-6-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="fries-6" id="fries-6" value="0">
                                        </p>
                                        <button type="button" id="fries-6-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-fries-6" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                </div>
            </section>
    
            <!-- BurgerHub Drinks -->
            <section class="section_drinks-menu">
                <h1>Our Drinks</h1>
                <div class="container_drinks-menu">
                    <div class="container_drinks">
                        <div class="container_image">
                            <img src="images/menu/drinks/Drinks_Avocado.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Avocado Shake</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="drinks-1">
                                        <button type="button" id="drinks-1-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="drinks-1" id="drinks-1" value="0">
                                        </p>
                                        <button type="button" id="drinks-1-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-drinks-1" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_drinks">
                        <div class="container_image">
                            <img src="images/menu/drinks/Drinks_Berry.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Berry Shake</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="drinks-2">
                                        <button type="button" id="drinks-2-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="drinks-2" id="drinks-2" value="0">
                                        </p>
                                        <button type="button" id="drinks-2-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-drinks-2" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_drinks">
                        <div class="container_image">
                            <img src="images/menu/drinks/Drinks_Lemonade.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Lemonade Shake</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="drinks-3">
                                        <button type="button" id="drinks-3-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="drinks-3" id="drinks-3" value="0">
                                        </p>
                                        <button type="button" id="drinks-3-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-drinks-3" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_drinks">
                        <div class="container_image">
                            <img src="images/menu/drinks/Drinks_Mango.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Mango Shake</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="drinks-4">
                                        <button type="button" id="drinks-4-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="drinks-4" id="drinks-4" value="0">
                                        </p>
                                        <button type="button" id="drinks-4-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-drinks-4" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_drinks">
                        <div class="container_image">
                            <img src="images/menu/drinks/Drinks_Pineapple.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Pineapple Shake</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="drinks-5">
                                        <button type="button" id="drinks-5-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="drinks-5" id="drinks-5" value="0">
                                        </p>
                                        <button type="button" id="drinks-5-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-drinks-5" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                    <div class="container_drinks">
                        <div class="container_image">
                            <img src="images/menu/drinks/Drinks_Strawberry.png" alt="Burger">
                        </div>
                        <div class="container_description">
                            <h1>Strawberry Shake</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit  dolor sit amet.</p>
                            <div class="container_price-order">
                                <p class="price">₱381.00</p>
                                <div class="container_order-quantity">
                                    <label for="drinks-6">
                                        <button type="button" id="drinks-6-minus-btn" aria-label="Decrement quantity"><i class="fa-solid fa-minus"></i></button>
                                        <p class="order-quantity">
                                            <input type="number" name="drinks-6" id="drinks-6" value="0">
                                        </p>
                                        <button type="button" id="drinks-6-plus-btn" aria-label="Increment quantity"><i class="fa-solid fa-plus"></i></button>
                                    </label>
                                </div>
                            </div>
                            <button type="submit" id="btn_cart-drinks-6" name="add_to_cart">ADD TO CART</button>
                        </div>
                    </div>
                </div>
            </section>
        </form>
    </main>
    
    <?php include_once 'global_footer.php' ?>
    
    <script src="js/menu-acc.js"></script>
</body>
</html>
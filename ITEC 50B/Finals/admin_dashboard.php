<?php
    session_start();

    if(empty($_SESSION["type"]) || $_SESSION["type"] == "client") header("Location: index.php");

    $connect = mysqli_connect("localhost","root","", "burgerhub");
    $sql = mysqli_query($connect,"SELECT * FROM client_orders");
    $sql_accounts_incomplete_orders = mysqli_query($connect,"SELECT * FROM client_orders where status != 'Completed'");
    $sql_accounts_complete_orders = mysqli_query($connect,"SELECT * FROM client_orders where status = 'Completed'");
    $sql_accounts = mysqli_query($connect,"SELECT * FROM client_accounts");

    $total_income = 0;

    while($row = mysqli_fetch_array($sql_accounts_complete_orders)) {
        $total_income += $row['total'];
    }

    $target_income = 100000;
    $accumulated_income = floor(($total_income/100000)*100);
    $accumulated_clients = floor(empty(mysqli_num_rows($sql_accounts)) ? 0 : (mysqli_num_rows($sql_accounts)/150)*100);
    $accumulated_incomplete_orders = floor((empty(mysqli_num_rows($sql_accounts_incomplete_orders)) ? 0 : mysqli_num_rows($sql_accounts_incomplete_orders)/50)*100);
    $accumulated_complete_orders = floor((empty(mysqli_num_rows($sql_accounts_complete_orders)) ? 0 : mysqli_num_rows($sql_accounts_complete_orders)/100)*100);

    if(isset($_GET["test"])) echo $_GET["test"];
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="BERNARD V. SAPIDA, JAN MARICHIE Z. MOJICA, ZILDJIAN LEE G. LOREN, JOHN HERSON L. RADONES">
    <link rel="icon" type="image/any-icon" href="images/burgerhub.ico">
    <link rel="stylesheet" href="css/admin_header.css">
    <link rel="stylesheet" href="css/admin_dashboard.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"/>
    <title>BurgerHub</title>
</head>
<body>
    <?php include_once 'header.php' ?>

    <!-- BurgerHub Index Page -->
    <main>
        <!-- BurgerHub Sign In -->
        <section class="section_dashboard">
            <div class="container_dashboard-header">
                <h1>BurgerHub Dashboard</h1>
                <p>Welcome to BurgerHub admin panel</p>
            </div>
            <div class="container_dashboard">
                <div class="container_cards">
                    <div class="card-title-header">
                        <p class="title">Total Income</p>
                        <p class="badges income">Updated</p>
                    </div>
                    <p class="amount">₱<?php echo ($total_income != 0) ? number_format($total_income) : 0; ?></p>
                    <div class="card-track">
                        <p class="track-label">Total Income</p>
                        <p class="track-percentage income" id="income"><?php echo !empty($accumulated_income) ? $accumulated_income . "%" : "0%" ?></p>
                    </div>
                    <div class="progress-line">
                        <div class="progress-line-amount"></div>
                    </div>
                </div>
                <div class="container_cards">
                    <div class="card-title-header">
                        <p class="title">Clients</p>
                        <p class="badges clients">Overall</p>
                    </div>
                    <p class="amount"><?php echo (mysqli_num_rows($sql_accounts) != 0) ? mysqli_num_rows($sql_accounts) : 0; ?></p>
                    <div class="card-track">
                        <p class="track-label">Total Clients</p>
                        <p class="track-percentage clients" id="clients"><?php echo !empty($accumulated_clients) ? $accumulated_clients . "%" : "0%" ?></p>
                    </div>
                    <div class="progress-line">
                        <div class="progress-line-clients"></div>
                    </div>
                </div>
                <div class="container_cards">
                    <div class="card-title-header">
                        <p class="title">Incomplete Orders</p>
                        <p class="badges incomplete-orders">New</p>
                    </div>
                    <p class="amount"><?php echo (mysqli_num_rows($sql_accounts_incomplete_orders) != 0) ? mysqli_num_rows($sql_accounts_incomplete_orders) : 0; ?></p>
                    <div class="card-track">
                        <p class="track-label">Total Incomplete Orders</p>
                        <p class="track-percentage incomplete-orders" id="incomplete-orders"><?php echo !empty($accumulated_incomplete_orders) ? $accumulated_incomplete_orders . "%" : "0%" ?></p>
                    </div>
                    <div class="progress-line">
                        <div class="progress-line-incomplete-orders"></div>
                    </div>
                </div>
                <div class="container_cards">
                    <div class="card-title-header">
                        <p class="title">Completed Orders</p>
                        <p class="badges completed-orders">Overall</p>
                    </div>
                    <p class="amount"><?php echo (mysqli_num_rows($sql_accounts_complete_orders) != 0) ? mysqli_num_rows($sql_accounts_complete_orders) : 0; ?></p>
                    <div class="card-track">
                        <p class="track-label">Total Orders</p>
                        <p class="track-percentage completed-orders" id="completed-orders"><?php echo !empty($accumulated_complete_orders) ? $accumulated_complete_orders . "%" : "0%" ?></p>
                    </div>
                    <div class="progress-line">
                        <div class="progress-line-total-orders"></div>
                    </div>
                </div>
            </div>
        </section>
        <section class="section_tabular-orders">
            <div class="container_tabular-order">
                <table>
                    <caption>Client Orders</caption>
                    <thead>
                        <tr>
                            <th class="client_number">#</th>
                            <th class="client_image">Image</th>
                            <th class="client_name">Customer</th>
                            <th class="client_tracking-number">Tracking Number</th>
                            <th class="client_order-no">Order No.</th>
                            <th class="client_quantity">Quantity</th>
                            <th class="client_amount">Amount</th>
                            <th class="client_order-time">Order Time</th>
                            <th class="client_status">Status</th>
                            <th class="client_details">Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                            while($row = mysqli_fetch_array($sql)) {
                                echo "<tr>";
                                    echo "<td>" . $row['id'] . "</td>";
                                    echo "<td><img src='images/profiles/Profile.png' alt='Profile Image'></td>";
                                    echo "<td>" . $row['firstname'] . " " . $row['lastname'] . "</td>";
                                    echo "<td>" . $row['trackingNo'] . "</td>";
                                    echo "<td>" .$row['orderNo'] . "</td>";
                                    echo "<td>" . $row['quantity'] . "</td>";
                                    echo "<td>₱" . number_format($row['total']) . "</td>";
                                    echo "<td>" . $row['date'] . "</td>";
                                    echo "<td><div class='status ". ($row['status'] == 'Pending' ? 'pending' : ($row['status'] == 'Processing' ? "processing" : ($row['status'] == 'Delivering' ? "delivering" : ($row['status'] == 'Completed' ? "completed" : ""))))."'></div>" . $row['status'] . "</td>";
                                    echo "<td><button type='button' onclick='location.href=\"admin_dashboard.php?test=100\"' aria-label='View details'>View Details</button></td>";
                                echo "</tr>";
                            }
                        ?>
                    </tbody>
                </table>
            </div>
        </section>
    </main>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="js/admin-dashboard.js"></script>
    <?php include_once 'global_footer.php' ?>
</body>
</html>
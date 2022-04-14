<%--
  Created by IntelliJ IDEA.
  User: macmini2
  Date: 08/04/2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Business Casual - Start Bootstrap Theme</title>
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
<header>
    <h1 class="site-heading text-center text-faded d-none d-lg-block">
        <span class="site-heading-upper text-primary mb-3">A place for you and your friend</span>
        <span class="site-heading-lower">Pet Friends</span>
    </h1>
</header>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
    <div class="container">
        <a class="navbar-brand text-uppercase fw-bold d-lg-none" href="index.html">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item px-lg-4"><a class="nav-link text-uppercase" href="index3.html">Home</a></li>
                <li class="nav-item px-lg-4"><a class="nav-link text-uppercase" href="ClientServlet" role="button">See all places</a></li>
                <li class="nav-item px-lg-4"><a class="nav-link text-uppercase" href="add_form.html">Add new place</a></li>
                <li class="nav-item px-lg-4"><a class="nav-link text-uppercase" href="log_in.html">Log in</a></li>
            </ul>
        </div>
    </div>
</nav>
<section class="page-section cta">
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <div class="cta-inner bg-faded text-center rounded">
                    <center>
<div class="jumbotron">
    <div class="container">
        <h2>Provide data of new place</h2>

        <form action="AdminServlet" method="get">
            <input type="hidden" name="command" value="ADD">
            <div class="form-group">
                <label for="Name">Name of place</label>
                <input type="text" class="form-control" name="nameInput"/>
            </div>
            <div class="form-group">
                <label for="Address">Address</label>
                <input type="text" class="form-control" name="addressInput"/>
            </div>
            <div class="form-group">
                <label for="Descrip">Description </label>
                <input type="text" class="form-control" name="descripInput" placeholder="">
            </div>
            <br>
            <button type="submit" class="btn btn-info">Add</button>
        </form>
        <div class="row">
            <div class="container-fluid">

                <div class="col-sm-9">
                    <a href="AdminServlet" class="btn btn-lg btn-primary" role="button" aria-disabled="true">Back to table</a>
                </div>
            </div>
        </div>

    </div>
</div>

                    </center>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="row form-group"></div>
<div class="row form-group"></div>


</body>
</html>

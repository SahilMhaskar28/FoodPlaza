<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FlavorTown | Home</title>
 
<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="home_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Message.jsp"></jsp:include>

<!-- Recommended Dishes -->
<div class="container my-5">        





    <h2 class="section-title">Our Top Picks Just for You</h2>
    <div class="row g-4">
        <div class="col-md-3">
            <div class="top_dishes_box">
                <img src="images/templatemo_image_01.jpg" alt="image">
                <h5 class="mt-3">Cura bitur turpis</h5>
                <p>Nulla a risus. Aliquam lectus dui, euismod id, volutpat ac, fringilla eu, ipsum.</p>
                <a href="#">Read more...</a>
            </div>
        </div>
        <div class="col-md-3">
            <div class="top_dishes_box">
                <img src="images/templatemo_image_02.jpg" alt="image">
                <h5 class="mt-3">Suspen metus lorem</h5>
                <p>Volutpat non, molestie sit amet, placerat id, elit. Praesent laoreet.</p>
                <a href="#">Read more...</a>
            </div>
        </div>
        <div class="col-md-3">
            <div class="top_dishes_box">
                <img src="images/templatemo_image_03.jpg" alt="image">
                <h5 class="mt-3">Phasellus dui velit</h5>
                <p>Laoreet id, accumsan nec, dui. Maecenas sit amet est et enim laoreet rutrum.</p>
                <a href="#">Read more...</a>
            </div>
        </div>
        <div class="col-md-3">
            <div class="top_dishes_box">
                <img src="images/templatemo_image_04.jpg" alt="image">
                <h5 class="mt-3">Donec iaculis felis</h5>
                <p>Donec a massa ut pede pulvinar vulputate. Nulla et augue. Vivamus nec dui.</p>
                <a href="#">Read more...</a>
            </div>
        </div>
    </div>
</div>

<!-- Welcome Section -->
<div class="container my-5">
    <h2 class="section-title">Discover the Taste of FlavorTown</h2>
    <div class="row g-4">
        <div class="col-md-8">
            <img src="images/templatemo_image_05.jpg" alt="Welcome" class="img-fluid rounded shadow-sm mb-3">
            <p>Donec malesuada elit vel enim. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse id velit elementum mi egestas ullamcorper.</p>
            <p>Suspendisse vitae nibh ac nunc mattis blandit. Morbi consectetur ullamcorper felis. Nulla nec elit. Aliquam et mauris. Ut euismod congue diam.</p>
            <a href="#">Read more...</a>
        </div>
        <div class="col-md-4">
            <h3 class="section-subtitle">Freshly Cooked, Freshly Served!</h3>
            <img src="images/templatemo_image_06.jpg" alt="New" class="img-fluid rounded shadow-sm mb-3">
            <p>Curabitur turpis. Nulla a risus. Aliquam lectus dui, euismod id, volutpat ac, fringilla eu, ipsum.</p>
            <a href="#">Read more...</a>
        </div>
    </div>
</div>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>

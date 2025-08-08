<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">



<!-- Google Font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<!-- Custom Styling -->
<style>
    body {
        font-family: 'Poppins', sans-serif;
    }
    .navbar-custom {
        background-color: #1e3d59; /* Deep blue-grey */
    }
    .navbar-custom .nav-link {
        color: #f1f1f1;
        font-weight: 500;
        transition: color 0.3s ease;
    }
    .navbar-custom .nav-link:hover {
        color: #ffc107; /* Amber on hover */
    }
    .navbar-brand {
        font-weight: 600;
        color: #ffffff;
    }
    .navbar-brand:hover {
        color: #ffc107;
    }
</style>

<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<% String login = (String) session.getAttribute("login"); %>

<body>

<!-- Modern Navbar -->
<nav class="navbar navbar-expand-lg navbar-custom">
  <div class="container-fluid">
    <a class="navbar-brand d-flex align-items-center gap-2" href="MyIndex.jsp">
  <i class="fa-solid fa-utensils fs-4 text-warning"></i>
  <span class="fw-bold fs-4 text-white">FlavorTown</span>
</a>

    <button class="navbar-toggler text-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ms-auto">

        <li class="nav-item">
          <a class="nav-link" href="MyIndex.jsp">Home</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="FoodServlet?process=allFood">Food Menus</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>

        <% if(login!=null && login.equals("admin")) { %>
          <li class="nav-item">
            <a class="nav-link" href="AddFood.jsp">Add Food</a>
          </li>
        <% } %>

        <% if(login!=null && login.equals("customer")) { %>
          <li class="nav-item">
            <a class="nav-link" href="CustomerServlet?process=updateProfile">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="CartServlet?process=showMyCart">My Cart</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="OrderServlet?process=myOrders">My Orders</a>
          </li>
        <% } %>

        <% if(login == null) { %>
          <li class="nav-item">
            <a class="nav-link" href="Login.jsp">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="AddCustomer.jsp">Register</a>
          </li>
        <% } %>

        <% if(login != null) { %>
          <li class="nav-item">
            <a class="nav-link" href="LoginServlet">Logout</a>
          </li>
        <% } %>

      </ul>
    </div>
  </div>
</nav>

<!-- Page Content -->
<div class="container mt-4">

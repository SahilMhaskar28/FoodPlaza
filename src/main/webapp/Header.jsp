<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>

<% String login = (String) session.getAttribute("login"); %>

<body>
<!--  Free CSS Template by TemplateMo.com  --> 
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        	<li class="current"><a href="MyIndex.jsp"><b>Home</b></a></li>
            <li><a href="FoodServlet?process=allFood"><b>Food Menus</b></a></li>
            <li><a href="#"><b>Contact</b></a></li>
            
            <% if(login!=null && login.equals("admin")){%>
                   
            <li><a href="AddFood.jsp"><b>Add Food</b></a></li>
            
            <%}%>
            
            <% if(login!=null && login.equals("customer")){%>
            <li><a href="CustomerServlet?process=updateProfile"><b>Profile</b></a></li>
            <li><a href="CartServlet?process=showMyCart"><b>My Cart</b></a></li>
            <li ><a href="OrderServlet?process=myOrders"><b>My Orders</b></a></li>         
            <%} %>
            
           <%if(login==null){ %> 
            <li ><a href="Login.jsp"><b>Login</b></a></li>
            <li ><a href="AddCustomer.jsp"><b>Register</b></a></li>
           <%}%> 
           
            <%if(login!=null){ %> 
            <li ><a href="LoginServlet"><b>Logout</b></a></li>
           <%}%> 
           
        </ul>
    </div> <!-- end of menu -->
</body>
</html>
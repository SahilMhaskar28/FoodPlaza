<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<%
String login=(String) session.getAttribute("login");
%>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Message.jsp"></jsp:include>

<table class="table table-bordered table-striped text-center align-middle">

	<thead class="table-success">
		<tr>
			<th>FoodId</th>
			<th>FoodName</th>
			<th>FoodType</th>
			<th>FoodCategory</th>
			<th>FoodDescription</th>
			<th>FoodPrice</th>
			<th>Image</th>
			<%if (login!=null){ %>
			<th colspan="3">Action</th>
			<%} %>
		</tr>
	</thead>
	
	<c:forEach var="f" items="${flistObj}">
	
	<tbody>
		<tr>	
			<td>${f.foodId}</td>
			<td>${f.foodName}</td>
			<td>${f.foodType}</td>
			<td>${f.foodCategory}</td>
			<td>${f.foodDesc}</td>
			<td>${f.foodPrice}</td>
			<td><img src="images/${f.image}" height="100px" width="100px"></td>
	
			<% if(login!=null && login.equals("admin")){%>
			<td><a href="FoodServlet?process=updateFood&foodId=${f.foodId}" class="btn btn-success">Update</a></td>
			<td><a href="FoodServlet?process=deleteFood&foodId=${f.foodId}" class="btn btn-danger">Delete</a></td>
			<%} %>
	
			<% if(login!=null && login.equals("customer")){%>
			<td>
  <a class="btn btn-warning text-white btn-sm d-flex align-items-center justify-content-center gap-2 px-3 py-2" 
     href="CartServlet?process=addToCart&foodId=${f.foodId}">
    <i class="bi bi-cart-plus"></i> Add to Cart
  </a>
</td>

			<%} %>
		</tr>
	</tbody>
			
	</c:forEach>
	
</table>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<table class="table table-striped table-bordered text-center">
	<thead class="table-success">
		<tr>
			<th>Order Number</th>
			<th>Order Date</th>
			<th>Total Bill</th>
			<th>Status</th>
			<th>Actions</th>
		</tr>
	</thead>

	<tbody>		
	<c:forEach var="o" items="${oList}">
		<tr>
			<td> ${o.orderId}</td>
			<td> ${o.orderDate}</td>
			<td> ${o.totalBill}</td>
			<td> ${o.orderStatus}</td>
			<td><a href="OrderServlet?process=getDetails&&orderId=${o.orderId}"></a>Details</td>	
		</tr>	
		</c:forEach>		
	</tbody>

</table>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
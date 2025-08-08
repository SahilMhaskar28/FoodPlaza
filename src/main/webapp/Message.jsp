<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>
<%
String msg = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errmsg");

%>

<%
if(msg!= null){ %>
<h5 class="alert alert-success" role="alert"><%= msg %></h5>

<%} else if(errmsg!=null) {%>
<h5 class="alert alert-danger" role="alert"><%= errmsg %></h5>
<%}%>

</body>
</html>
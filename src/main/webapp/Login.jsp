<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Message.jsp"></jsp:include>
<form action="LoginServlet" method="post">
<table class="table table-success">

<tr>
<th>UserName:</th>
<td><input type="text" name="userName" class="form-control"></td>
</tr>

<tr>
<th>Password:</th>
<td><input type="text" name="password" class="form-control"></td>
</tr>

<tr>
<td><input type="submit" value="Login" class="btn btn-success"></td>
<td><input type="reset" value="Clear" class="btn btn-danger"></td>
</tr>

</table>
</form>

<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
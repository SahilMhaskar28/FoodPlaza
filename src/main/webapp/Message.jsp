<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String msg = (String) session.getAttribute("msg");
String errmsg = (String) session.getAttribute("errmsg");

%>

<%
if(msg!= null){ %>
<h3><%= msg %></h3>

<%} else if(errmsg!=null) {%>
<h3><%= errmsg %></h3>
<%}
%>



<c:if test="msg!= null">

</c:if>


</body>
</html>
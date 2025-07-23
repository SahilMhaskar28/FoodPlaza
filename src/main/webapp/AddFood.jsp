<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Message.jsp"></jsp:include>
<form action="FoodServlet" method="post">
<input type="hidden" name="process" value="addFood">
 <table class="table table-success">
            <tr>
                <th>FoodName:</th>
                <td><input type="text" name="foodName" class="form-control"></td>
            </tr>

            <tr>
                <th>FoodType:</th>
                <td><input type="text" name="foodType" class="form-control"></td>
            </tr>

            <tr>
                <th>FoodCategory:</th>
                <td><input type="text" name="foodCategory" class="form-control"></td>
            </tr>

            <tr>
                <th>FoodDescription:</th>
                <td><input type="text" name="foodDescription" class="form-control"></td>
            </tr>

            <tr>
                <th>FoodPrice:</th>
                <td><input type="text" name="foodPrice" class="form-control"></td>
            </tr>

            <tr>
                <th>FoodImage:</th>
                <td><input type="text" name="foodImage" class="form-control"></td>
            </tr>
            
            <tr>
               <td><input type="submit" value="Add" class="btn btn-success "></td>
               <td><input type="reset" value="Clear" class="btn btn-danger"></td>
            </tr>
        </table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
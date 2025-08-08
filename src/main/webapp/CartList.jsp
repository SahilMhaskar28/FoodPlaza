<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
    <script type="Myjquery.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
    $(function () {
        calculateTotal();
    });

    function calculateTotal() {
        var total = 0;
        $(".totalprice").each(function () {
            // Remove ₹ and spaces and convert to float
            var val = parseFloat($(this).text().replace(/[^\d.]/g, ""));
            if (!isNaN(val)) {
                total += val;
            }
        });
        $("#totalBill").val("₹ " + total.toFixed(2));
    }

    function updateQuantity(element) {
        var $input = $(element);
        var quantity = parseInt($input.val());
        var cartid = $input.data("cartid");

        if (quantity < 1 || isNaN(quantity)) {
            quantity = 1;
            $input.val(1);
        }

        $.post("CartServlet", {
            cartid: cartid,
            quantity: quantity,
            process: "updateCartQuantity"
        }, function (newSubtotal) {
            // Update the subtotal cell in the same row
            var $row = $input.closest("tr");
            $row.find(".totalprice").text("₹ " + parseFloat(newSubtotal).toFixed(2));

            // Recalculate total
            calculateTotal();
        });
    }
</script>

    <style>
        body {
            background-color: #f4f7f9;
        }
        .cart-container {
            background: #e6f2e6;
            padding: 30px;
            border-radius: 10px;
        }
        .action-btn {
            width: 100px;
        }
        .total-row td {
            font-weight: bold;
        }
    </style>
</head>
<body>

<%
String login = (String) session.getAttribute("login");
%>

<jsp:include page="Header.jsp" />
<jsp:include page="Message.jsp" />

<div class="container mt-5 cart-container">
    <h3 class="text-center mb-4">Your Cart</h3>

    <form action="OrderServlet" method="post">
    <input type="hidden" name="process" value="placeOrder">
        <table class="table table-bordered text-center align-middle">
            <thead class="table-success">
                <tr>
                    <th>Cart ID</th>
                    <th>Food Name</th>
                    <th>Quantity</th>
                    <th>Price (Each)</th>
                    <th>Subtotal</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${cObj}">
                    <tr>
                        <td>${c.cartid}</td>
                        <td>${c.fname}</td>
                        <td>
                            <input type="number" name="quantities" class="form-control text-center" value="${c.fquantity}" min="1"
                                onchange="updateQuantity(this)" data-cartid="${c.cartid}" />
                        </td>
                        <td>&#8377; ${c.fprice}</td>
                        <td class="totalprice" id="subtotal">&#8377; ${c.totalPrice}</td>
                        <td>
                            <a class="btn btn-danger btn-sm action-btn" href="<c:url value='CartServlet?process=deleteItem&cartid=${c.cartid}' />">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${empty cObj}">
            <div class="alert alert-warning text-center">Your cart is empty!</div>
        </c:if>

        <div class="row mt-4">
            <div class="col-md-4">
                <a class="btn btn-warning w-100 text-white" href="<c:url value='CartServlet?process=clearCart' />">Clear</a>
            </div>
            <div class="col-md-4">
                <button type="submit" name="process" value="order" class="btn btn-success w-100">Order</button>
            </div>
            <div class="col-md-4 text-end">
                <label><strong>Total Bill:</strong></label>
                 <input type="text" readonly class="form-control text-end" id="totalBill" />
            </div>
        </div>
    </form>
</div>

<jsp:include page="Footer.jsp" />
</body>
</html>

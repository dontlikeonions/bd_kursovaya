<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <link rel="stylesheet" href="./css/table-style.css"/>
    <link rel="stylesheet" href="./css/show-style.css">
    <title>Customers</title>
</head>
<body>

<h1>Ordered products list</h1>

<div class="button-holder">
    <button onclick="location.href='./InsertOrderedProducts'">Add new row</button>
    <button onclick="location.href='index.jsp'">Home page</button>
</div>


<table>
    <tr>
        <th>Order ID</th>
        <th>Product ID</th>
        <th>Amount</th>
        <th class="last-cell">Actions</th>
    </tr>

    <c:forEach var="orderedProduct" items="${orderedProducts}">
        <tr>
            <td> ${orderedProduct.orderId} </td>
            <td> ${orderedProduct.productId} </td>
            <td> ${orderedProduct.amount} </td>
            <td class="last-cell">
                <form method="get" action="<c:url value="./UpdateOrderedProduct" />" style="display:inline;">
                    <input type="hidden" name="order_id" value="${orderedProduct.orderId}">
                    <input type="hidden" name="oldProductId" value="${orderedProduct.productId}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
                <form method="post" action="<c:url value="./DeleteOrderedProduct" />" style="display:inline;">
                    <input type="hidden" name="order_id" value="${orderedProduct.orderId}">
                    <input type="hidden" name="product_id" value="${orderedProduct.productId}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

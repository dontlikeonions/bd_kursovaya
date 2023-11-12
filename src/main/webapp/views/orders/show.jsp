<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <link rel="stylesheet" href="./css/table-style.css"/>
    <link rel="stylesheet" href="./css/show-style.css">
    <title>Orders</title>
</head>
<body>

<h1>Orders list</h1>

<div class="button-holder">
    <button onclick="location.href='./InsertOrder'">Add new row</button>
    <button onclick="location.href='index.jsp'">Home page</button>
</div>


<table>
    <tr>
        <th>ID</th>
        <th>Customer ID</th>
        <th>Delivery ID</th>
        <th>Order date</th>
        <th class="last-cell">Actions</th>
    </tr>

    <c:forEach var="order" items="${orders}">
        <tr>
            <td> ${order.id} </td>
            <td> ${order.customerId} </td>
            <td> ${order.deliveryId} </td>
            <td> ${order.orderDate} </td>
            <td class="last-cell">
                <form method="get" action="<c:url value="./UpdateOrder" />" style="display:inline;">
                    <input type="hidden" name="id" value="${order.id}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
                <form method="post" action="<c:url value="./DeleteOrder" />" style="display:inline;">
                    <input type="hidden" name="id" value="${order.id}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <link rel="stylesheet" href="./css/table-style.css">
    <link rel="stylesheet" href="./css/show-style.css">
    <title>Couriers</title>
</head>
<body>

<h1>Deliveries list</h1>

<div class="button-holder">
    <button onclick="location.href='./InsertDelivery'">Add new row</button>
    <button onclick="location.href='index.jsp'">Home page</button>
</div>


<table>
    <tr>
        <th>ID</th>
        <th>Courier ID</th>
        <th>Customer ID</th>
        <th>Date</th>
        <th>Status</th>
        <th class="last-cell">Actions</th>
    </tr>

    <c:forEach var="delivery" items="${deliveries}">
        <tr>
            <td> ${delivery.id} </td>
            <td> ${delivery.courierId} </td>
            <td> ${delivery.customerId} </td>
            <td> ${delivery.deliveryDate} </td>
            <td> ${delivery.status} </td>
            <td class="last-cell">
                <form method="get" action="<c:url value="./UpdateDelivery" />" style="display:inline;">
                    <input type="hidden" name="id" value="${delivery.id}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
                <form method="post" action="<c:url value="./DeleteDelivery" />" style="display:inline;">
                    <input type="hidden" name="id" value="${delivery.id}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

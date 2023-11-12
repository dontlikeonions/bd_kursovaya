<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./css/table-style.css">
    <link rel="stylesheet" href="./css/show-style.css">
    <title>General view</title>
</head>


<body>

<h1>General view</h1>

<div class="button-holder">
    <button onclick="location.href='index.jsp'">Home page</button>
</div>

<div class="table-container">

    <h2>For clients</h2>

    <table class="table-left">
        <tr>
            <th>Customer ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Order date</th>
            <th>Delivery date</th>
            <th>Status</th>
            <th>Courier's phone</th>
        </tr>

        <c:forEach var="entry" items="${entriesLeft}">
            <tr>
                <td> ${entry.customerId} </td>
                <td> ${entry.fName} </td>
                <td> ${entry.lName} </td>
                <td> ${entry.orderDate} </td>
                <td> ${entry.deliveryDate} </td>
                <td> ${entry.status} </td>
                <td> ${entry.phone} </td>
            </tr>
        </c:forEach>
    </table>

    <h2>For couriers</h2>

    <table class="table-right">
        <tr>
            <th>Courier ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Delivery ID</th>
            <th>Order ID</th>
            <th>Status</th>
            <th>Delivery date</th>
            <th>Customer's phone</th>
        </tr>

        <c:forEach var="entry" items="${entriesRight}">
            <tr>
                <td> ${entry.courierId} </td>
                <td> ${entry.fName} </td>
                <td> ${entry.lName} </td>
                <td> ${entry.deliveryId} </td>
                <td> ${entry.orderId} </td>
                <td> ${entry.status} </td>
                <td> ${entry.deliveryDate} </td>
                <td> ${entry.phone} </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

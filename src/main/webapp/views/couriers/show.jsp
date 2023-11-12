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

<h1>Couriers list</h1>

<div class="button-holder">
    <button onclick="location.href='./InsertCourier'">Add new row</button>
    <button onclick="location.href='index.jsp'">Home page</button>
</div>

<table>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Licence plate</th>
        <th class="last-cell">Actions</th>
    </tr>

    <c:forEach var="courier" items="${couriers}">
        <tr>
            <td> ${courier.id} </td>
            <td> ${courier.fName} </td>
            <td> ${courier.lName} </td>
            <td> ${courier.phone} </td>
            <td> ${courier.licencePlate} </td>
            <td class="last-cell">
                <form method="get" action="<c:url value="./UpdateCourier" />" style="display:inline;">
                    <input type="hidden" name="id" value="${courier.id}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
                <form method="post" action="<c:url value="./DeleteCourier" />" style="display:inline;">
                    <input type="hidden" name="id" value="${courier.id}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

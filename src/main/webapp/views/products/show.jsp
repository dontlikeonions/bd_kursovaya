<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <link rel="stylesheet" href="./css/show-style.css?2v">
    <link rel="stylesheet" href="./css/table-style.css?2v"/>

    <title>Couriers</title>
</head>
<body>

<h1>Products list</h1>

<div class="button-holder">
    <button onclick="location.href='./InsertProduct'">Add new row</button>
    <button onclick="location.href='index.jsp'">Home page</button>
</div>


<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Cost</th>
        <th class="last-cell">Actions</th>
    </tr>

    <c:forEach var="product" items="${products}">
        <tr>
            <td> ${product.id} </td>
            <td> ${product.productName} </td>
            <td class="wide-cell"> ${product.description} </td>
            <td> ${product.cost} </td>
            <td class="last-cell">
                <form method="get" action="<c:url value="./UpdateProduct" />" style="display:inline;">
                    <input type="hidden" name="id" value="${product.id}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
                <form method="post" action="<c:url value="./DeleteProduct" />" style="display:inline;">
                    <input type="hidden" name="id" value="${product.id}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=UTF-8">
    <link rel="stylesheet" href="./css/table-style.css">
    <link rel="stylesheet" href="./css/show-style.css">
    <title>Customers</title>
</head>
<body>

<h1>Customers list</h1>

<div class="button-holder">
    <button onclick="location.href='./InsertCustomer'">Add new row</button>
    <button onclick="location.href='index.jsp'">Home page</button>
</div>


<table>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Address</th>
        <th class="last-cell">Actions</th>
    </tr>

    <c:forEach var="customer" items="${customers}">
        <tr>
            <td> ${customer.id} </td>
            <td> ${customer.fName} </td>
            <td> ${customer.lName} </td>
            <td> ${customer.phone} </td>
            <td> ${customer.email} </td>
            <td> ${customer.address} </td>
            <td class="last-cell">
                <form method="get" action="<c:url value="./UpdateCustomer" />" style="display:inline;">
                    <input type="hidden" name="id" value="${customer.id}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
                <form method="post" action="<c:url value="./DeleteCustomer" />" style="display:inline;">
                    <input type="hidden" name="id" value="${customer.id}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
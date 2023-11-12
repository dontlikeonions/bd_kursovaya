<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>Editing</h1>

<form method="post">
    <input type="hidden" value="${customer.id}" name="customer_id"/>

    <div class="form-group">
        <label>First name:</label><br>
        <label>
            <input type="text" name="f_name" value="${customer.fName}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Last name:</label><br>
        <label>
            <input type="text" name="l_name" value="${customer.lName}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Phone number:</label><br>
        <label>
            <input type="text" name="phone" value="${customer.phone}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Email:</label><br>
        <label>
            <input type="text" name="email" value="${customer.email}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Address:</label><br>
        <label>
            <input type="text" name="address" value="${customer.address}"/><br><br>
        </label>
    </div>

    <input type="submit" class="button" value="Save"/>
</form>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit order</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>Editing</h1>

<form method="post">
    <input type="hidden" value="${order.id}" name="courier_id"/>

    <div class="form-group">
        <label>Customer ID:</label><br>
        <label>
            <input type="number" name="customer_id" value="${order.customerId}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Delivery ID:</label><br>
        <label>
            <input type="number" name="delivery_id" value="${order.deliveryId}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Order date:</label><br>
        <label>
            <input type="datetime-local" name="order_date" value="${order.orderDate}"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Save"/>
</form>

</body>
</html>

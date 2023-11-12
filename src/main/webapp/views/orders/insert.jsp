<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>New order</h1>

<form method="post">
    <div class="form-group">
        <label>Customer ID:</label><br>
        <label>
            <input type="number" name="customer_id"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Delivery ID:</label><br>
        <label>
            <input type="number" name="delivery_id"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Order date:</label><br>
        <label>
            <input type="datetime-local" name="order_date"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Add"/>
</form>

</body>
</html>
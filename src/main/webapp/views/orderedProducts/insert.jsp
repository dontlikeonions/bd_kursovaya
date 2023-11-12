<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>New ordered product</h1>

<form method="post">
    <div class="form-group">
        <label>Order ID:</label><br>
        <label>
            <input type="number" name="order_id"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Product ID:</label><br>
        <label>
            <input type="number" name="orderedProductsIds"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Amount:</label><br>
        <label>
            <input type="number" name="amount"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Add"/>
</form>

</body>
</html>
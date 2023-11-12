<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit ordered product</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>Editing</h1>

<form method="post">
    <input type="hidden" value="${orderedProduct.productId}" name="oldProductId">

    <div class="form-group">
        <label>Order ID:</label><br>
        <label>
            <input type="number" name="order_id" value="${orderedProduct.orderId}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Product ID:</label><br>
        <label>
            <input type="number" name="product_id" value="${orderedProduct.productId}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Amount:</label><br>
        <label>
            <input type="number" name="amount" value="${orderedProduct.amount}"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Save"/>
</form>

</body>
</html>
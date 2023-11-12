<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<form method="post">
    <input type="hidden" value="${product.id}" name="courier_id"/>

    <div class="form-group">
        <label>Name:</label><br>
        <label>
            <input type="text" name="product_name" value="${product.productName}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Description:</label><br>
        <label>
            <input type="text" name="description" value="${product.description}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Cost:</label><br>
        <label>
            <input type="number" name="cost" value="${product.cost}"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Save"/>
</form>

</body>
</html>
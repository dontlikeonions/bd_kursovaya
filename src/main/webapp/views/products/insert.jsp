<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>New product</h1>

<form method="post">
    <div class="form-group">
        <label>Name:</label><br>
        <label>
            <input type="text" name="product_name"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Description:</label><br>
        <label>
            <input type="text" name="description"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Cost:</label><br>
        <label>
            <input type="number" name="cost"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Add"/>
</form>

</body>
</html>
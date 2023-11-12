<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>New delivery</h1>

<form method="post">
    <div class="form-group">
        <label>Courier ID:</label><br>
        <label>
            <input type="number" name="courier_id"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Customer ID:</label><br>
        <label>
            <input type="number" name="customer_id"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Date:</label><br>
        <label>
            <input type="datetime-local" name="delivery_date"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Status:</label><br>
        <label>
            <input type="text" name="status"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Add"/>
</form>

</body>
</html>
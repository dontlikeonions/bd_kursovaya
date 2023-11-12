<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit delivery</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>Editing</h1>

<form method="post">
    <input type="hidden" value="${delivery.id}" name="courier_id"/>

    <div class="form-group">
        <label>Courier ID:</label><br>
        <label>
            <input type="number" name="courier_id" value="${delivery.courierId}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Customer ID:</label><br>
        <label>
            <input type="number" name="customer_id" value="${delivery.customerId}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Date:</label><br>
        <label>
            <input type="datetime-local" name="delivery_date" value="${delivery.deliveryDate}"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Status:</label><br>
        <label>
            <input type="text" name="status" value="${delivery.status}"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Save"/>
</form>

</body>
</html>
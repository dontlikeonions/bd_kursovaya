<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit courier</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>Editing</h1>

<form method="post">
    <input type="hidden" value="${courier.id}" name="courier_id"/>

    <div class="form-group">
        <label>First name:</label><br>
        <label>
            <input type="text" name="f_name" value="${courier.fName}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Last name:</label><br>
        <label>
            <input type="text" name="l_name" value="${courier.lName}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Phone number:</label><br>
        <label>
            <input type="text" name="phone" value="${courier.phone}"/><br><br>
        </label>
    </div>

    <div class="form-group">
        <label>Licence plate:</label><br>
        <label>
            <input type="text" name="licence_plate" value="${courier.licencePlate}"/><br><br>
        </label>
    </div>

    <input type="submit" class="button" value="Save"/>
</form>

</body>
</html>
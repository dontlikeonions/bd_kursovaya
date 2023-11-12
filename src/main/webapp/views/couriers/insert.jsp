<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new</title>
    <link rel="stylesheet" href="./css/insert-update-style.css">
</head>
<body>

<h1>New courier</h1>

<form method="post">
    <div class="form-group">
        <label>First name:</label><br>
        <label>
            <input type="text" name="f_name"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Last name:</label><br>
        <label>
            <input type="text" name="l_name"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Phone number:</label><br>
        <label>
            <input type="text" name="phone"/>
        </label><br><br>
    </div>

    <div class="form-group">
        <label>Licence plate:</label><br>
        <label>
            <input type="text" name="licence_plate"/>
        </label><br><br>
    </div>

    <input type="submit" class="button" value="Add"/>
</form>

</body>
</html>
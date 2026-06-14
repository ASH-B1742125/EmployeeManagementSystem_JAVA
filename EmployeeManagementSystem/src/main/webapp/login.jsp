<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<div class="container">

    <h2>Employee Management System</h2>

    <h3>Login</h3>

    <form action="login" method="post">

        <label>Username</label>
        <br>
        <input type="text" name="username" required>
        <br><br>

        <label>Password</label>
        <br>
        <input type="password" name="password" required>
        <br><br>

        <input type="submit" value="Login">

    </form>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

<div class="container">

    <h2>Add Employee</h2>

    <form action="addEmployee" method="post">

        <label>Name</label>
        <br>
        <input type="text" name="name" required>
        <br><br>

        <label>Department</label>
        <br>
        <input type="text" name="department" required>
        <br><br>

        <label>Salary</label>
        <br>
        <input type="number" name="salary" required>
        <br><br>

        <label>Email</label>
        <br>
        <input type="email" name="email" required>
        <br><br>

        <input type="submit" value="Add Employee">

    </form>

    <br>

    <a href="adminDashboard.jsp">
        Back to Dashboard
    </a>

</div>

</body>
</html>
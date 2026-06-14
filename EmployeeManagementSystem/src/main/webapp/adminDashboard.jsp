<%@ page import="com.example.model.User" %>

<%
User user =
(User)session.getAttribute("user");

if(user == null) {

    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>

<div class="container">

    <h1>Admin Dashboard</h1>

    <p>Welcome, Admin</p>

    <hr>

    <a href="addEmployee.jsp">
        Add Employee
    </a>

    <br><br>

    <a href="viewEmployees">
        View Employees
    </a>

    <br><br>

    <a href="pagination">
        Pagination Demo
    </a>

    <br><br>

    <a href="sortEmployees?column=name">
        Sort Employees
    </a>

    <br><br>

    <a href="logout">
        Logout
    </a>

</div>

</body>
</html>
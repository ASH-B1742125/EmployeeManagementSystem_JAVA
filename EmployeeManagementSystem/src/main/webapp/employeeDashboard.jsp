<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Employee Dashboard</title>
</head>
<body>

<div class="container">

    <h1>Employee Dashboard</h1>

    <p>Welcome Employee</p>

    <hr>

    <a href="viewEmployees">
        View Employee Records
    </a>

    <br><br>

    <a href="logout">
        Logout
    </a>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.model.Employee" %>

<%
Employee emp =
(Employee)request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>

<div class="container">

<h2>Edit Employee</h2>

<form action="updateEmployee" method="post">

    <input type="hidden"
           name="id"
           value="<%= emp.getId() %>">

    Name:
    <input type="text"
           name="name"
           value="<%= emp.getName() %>">
    <br><br>

    Department:
    <input type="text"
           name="department"
           value="<%= emp.getDepartment() %>">
    <br><br>

    Salary:
    <input type="number"
           name="salary"
           value="<%= emp.getSalary() %>">
    <br><br>

    Email:
    <input type="email"
           name="email"
           value="<%= emp.getEmail() %>">
    <br><br>

    <input type="submit"
           value="Update Employee">

</form>
<br>

<a href="viewEmployees">
    Back to Employee List
</a>

</div>
</body>
</html>
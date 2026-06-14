<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Sorted Employees</title>
</head>
<body>
<div class="container">

<h2>Employee Sorting</h2>

<a href="sortEmployees?column=name">
    Sort By Name
</a>

|

<a href="sortEmployees?column=department">
    Sort By Department
</a>

|

<a href="sortEmployees?column=salary">
    Sort By Salary
</a>

<br><br>

<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Email</th>
</tr>

<%

List<Employee> employees =
(List<Employee>)request.getAttribute("employees");

if(employees != null) {

    for(Employee emp : employees) {

%>

<tr>

    <td><%= emp.getId() %></td>
    <td><%= emp.getName() %></td>
    <td><%= emp.getDepartment() %></td>
    <td><%= emp.getSalary() %></td>
    <td><%= emp.getEmail() %></td>

</tr>

<%

    }
}

%>

</table>
<br><br>
<a href="adminDashboard.jsp">
        Back to Dashboard
    </a>
</div>
</body>
</html>
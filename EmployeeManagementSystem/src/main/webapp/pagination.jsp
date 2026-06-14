<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>Pagination Demo</title>
</head>
<body>
<div class="container">
<h2>Employee List (Pagination)</h2>

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

%>

</table>

<br><br>

<a href="pagination?page=1">1</a>
<a href="pagination?page=2">2</a>
<a href="pagination?page=3">3</a>
<a href="adminDashboard.jsp">
        Back to Dashboard 
   </a>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>View Employees</title>
</head>
<body>
<div class="container">

<h2>Employee Records</h2>

<a href="adminDashboard.jsp">
    Back to Dashboard
</a>

<br><br>
<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Email</th>
    <th>Action</th>
</tr>

<%

List<Employee> employees =
(List<Employee>)request.getAttribute(
        "employees");

for(Employee emp : employees) {

%>

<tr>

    <td><%= emp.getId() %></td>

    <td><%= emp.getName() %></td>

    <td><%= emp.getDepartment() %></td>

    <td><%= emp.getSalary() %></td>

    <td><%= emp.getEmail() %></td>
    
    <td>

		<a href="editEmployee?id=<%= emp.getId() %>">
	    Edit
		</a>
	
		<a href="deleteEmployee?id=<%= emp.getId() %>"
	   onclick="return confirm('Delete this employee?')">
	    Delete
		</a>

</td>

</tr>

<%

}

%>

</table>

</div>

</body>
</html>
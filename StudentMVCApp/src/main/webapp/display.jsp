<%@page import="in.ineuron.Dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% Student student=(Student)application.getAttribute("std");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
	<h1 style='text-align:center;'>Student Details</h1>
	<table align='center' border='1'>
	<tr>
	<th>Student Id</th><th>Student Name</th><th>Student Location</th><th>Student Email</th><th>Student Age</th>
	</tr>
	<tr>
	<th><%=student.getId()%></th><th><%=student.getName()%></th><th><%=student.getLocation()%></th>
	<th><%=student.getEmail()%></th><th><%=student.getAge()%></th></tr>
   </table>
</body>
</html>
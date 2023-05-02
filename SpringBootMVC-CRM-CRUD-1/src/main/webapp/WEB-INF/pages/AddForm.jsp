<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/add-form.css" />
</head>
<body>
<div id="wrapper">
<div id="header">
<h2>Register Customer</h2>
</div>
</div>
<div id="container">
<div id="content">
<form:form action="saveCustomer" method="POST" modelAttribute="customer">
	<table>
		<tr>
			<td><form:hidden path="cid"/></td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td><form:input path="cname"/></td>
		</tr>
		<tr>
			<td>Customer Email</td>
			<td><form:input path="email"/><td>
		</tr>
		<tr>
			<td>Customer Age</td>
			<td><form:input path="age"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type='submit' value='save' class='save'/></td>
		</tr>
	</table>
</form:form>
</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body >
<div id="wrapper">
	<div id="header">
		<h2>Customer Relationship Manager</h2>
	</div>
</div>
<div id="container">
	<div id="content" >
<input type='button' value='Add Customer'
				onclick="window.location.href='showForm'; return false;" class="add-button" />
				
		<table>
			<tr>
				<td><b>Customer Name</b></td>
				<td><b>Customer Email</b></td>
				<td><b>Customer Age</b></td>
				<td><b>Action</b></td>
			</tr>
			<c:forEach var="customer" items="${custlist}">
			
			<c:url var="update" value="/customer/updateForm">
			<c:param name="id" value="${customer.cid}" />
			</c:url>
			
			<c:url var="delete" value="/customer/deleteForm">
			<c:param name="id" value="${customer.cid}" />
			</c:url>
			
			<tr>
				<td>${customer.cname}</td>
				<td>${customer.email}</td>
				<td>${customer.age}</td>
				<td>
	             <a href="${update}">Update</a>
	                       |
	             <a href="${delete}"
	                 onclick="confirm('Are you sure u want to delete this customer?')">Delete</a>
				</td>
			</tr>
			</c:forEach>
		
		</table>
	</div>
</div>
</body>
</html>
<%@page import="in.ineuron.Dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%Student st =(Student) application.getAttribute("stud"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit form</title>
</head>
<body>
<h1 style='text-align:center;'>Student Details</h1>
	<form action='./Controller/updateform' method='post'>
		<table align='center' >
			<tr><th>Student Id</th><td><input type='text' name='id' value=<%=st.getId()%> /></td></tr>
			<tr><th>Student Name</th><td><input type='text' name='name' value=<%=st.getName()%> /></td></tr>
			<tr><th>Student Location</th><td><input type='text' name='location' value=<%=st.getLocation()%> /></td></tr>
			<tr><th>Student Email</th><td><input type='text' name='email' value=<%=st.getEmail()%> /></td></tr>
			<tr><th>Student Age</th><td><input type='text' name='age' value=<%=st.getAge()%> /></td></tr>
				<tr><th></th><td><input type='submit' name='submit'/></td></tr>
		</table>
	</form>
</body>
</html>
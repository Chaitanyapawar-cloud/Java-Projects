<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h3 {text-align: center;}
.center {
  text-align: center;
  color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Stock Calculator</title>
</head>
<body >
<h1 class="center" >Stock Calculator</h1>
<h3>${msg}</h3>
	<form method="get" action="processform">
		<table align="center" >
			<tr>
			<td>Stock Name</td>
			<td><input name="companyName" type="text"></td>
			</tr>
			<tr>
			<td>Stock Quantity</td>
			<td><input name="qnty" type="text"></td>
			</tr>
			<tr>
			<td></td>
			<td><input value="submit" type="submit"></td>
			</tr>
			
		</table>
	</form>
</body>
</html>
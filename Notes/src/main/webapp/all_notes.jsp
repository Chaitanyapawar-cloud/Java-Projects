<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes</title>
 <%@include file="All_js_css.jsp" %>
</head>
<body>
<div class="container ">
	<%@include file="navbar.jsp" %>
	<h1>Please All Notes</h1><br>


	<%
		Session s= FactoryProvider.getFactory().openSession();
		Query q=s.createQuery("from Note");
		List <Note> l=q.list();
		for(Note n:l)
		{
	%>
	<div class="card" style="width: 100;">
  <img class="card-img-top pl-2 pt-2" style="width:70px" src="img/essay.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title"><%=n.getTitle()%></h5>
    <p class="card-text"><%=n.getContent() %></p>
    <p ><b class="text-primary">
    <% SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    java.util.Date d=n.getAddedDate();
    String str =sdf.format(d);
    out.println(str);
    %>
    </b></p>
    <div class="container text-center">
    <a href="DeleteServlet?note_id=<%=n.getId()%>" class="btn btn-danger">Delete</a>
    <a href="edit.jsp?note_id=<%=n.getId()%>" class="btn btn-primary">Update</a>
    </div>
  </div>
  </div>
  <div><br/></div>
	<%   }
		s.close();
	%>
	
</div>	

</body>
</html>
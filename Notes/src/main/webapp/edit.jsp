<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Note</title>
 <%@include file="All_js_css.jsp" %>
</head>
<body>

  <div class="container ">
	<%@include file="navbar.jsp" %>
	<h1>This is Update Page</h1><br/>
	
	<% int Id=Integer.parseInt(request.getParameter("note_id").trim());
			Session s=FactoryProvider.getFactory().openSession();
		
			Note note= (Note)s.get(Note.class,Id); 
	 %>
<form action="UpdateServlet" method="post">
<input type="hidden" name="note_id" value=<%=note.getId() %>>
  <div class="form-group">
    <label for="title">Note Title</label>
    <input required name ="title" type="text" class="form-control" id="title" aria-describedby="emailHelp" value=<%=note.getTitle() %>>
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea name ="content" required id="content" placeholder="Enter Note Content here" class="form-control" style="height:300px"><%=note.getContent() %></textarea>
  </div>
 
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Save Note</button>
  </div>
</form>
</div>

</body>
</html>
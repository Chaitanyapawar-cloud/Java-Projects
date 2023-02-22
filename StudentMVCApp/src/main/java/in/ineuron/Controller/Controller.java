package in.ineuron.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.Dto.Student;
import in.ineuron.Factory.StudentServiceFactory;
import in.ineuron.Service.IStudentService;


@WebServlet("/Controller/*")
public class Controller extends HttpServlet {
	

	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException
	{
		String reqURI= request.getRequestURI();
		IStudentService std= StudentServiceFactory.getStudentService();
		
		RequestDispatcher rd =null;
		
		if(reqURI.endsWith("layout")) 
		{
			System.out.println(reqURI);
			rd = request.getRequestDispatcher("../layout.jsp");
				rd.forward(request, response);
			
		}
		if(reqURI.endsWith("addform")) 
		{
			Student student =new Student();
			student.setName(request.getParameter("name"));
			student.setLocation(request.getParameter("location"));
			student.setEmail(request.getParameter("email"));
			student.setAge(Integer.parseInt(request.getParameter("age")));
			String res= std.save(student);
			if(res.equalsIgnoreCase("success"))
			{
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			}
			else if(res.equalsIgnoreCase("failure"))
			{
				rd = request.getRequestDispatcher("../failure.jsp");
				rd.forward(request, response);
				
			}
			else {
				rd = request.getRequestDispatcher("../notfound.jsp");
				rd.forward(request, response);
			}
			
		}
		if(reqURI.endsWith("searchform"))
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Student student = std.CheckById(id);
			if(student!=null)
			{
				ServletContext sc= getServletContext();
				sc.setAttribute("std", student);
				rd = request.getRequestDispatcher("../display.jsp");
				rd.forward(request, response);
			}
			else 
			{
				rd = request.getRequestDispatcher("../notfound.jsp");
				rd.forward(request, response);
			}
		}
		if(reqURI.endsWith("editform")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Student st = std.CheckById(id);
			if(st!=null)
			{
				ServletContext sc= getServletContext();
				sc.setAttribute("stud", st);
				rd = request.getRequestDispatcher("../edit.jsp");
				rd.forward(request, response);
			}
			else {
				rd = request.getRequestDispatcher("../notfound.jsp");
				rd.forward(request, response);
			}
		}
		if(reqURI.endsWith("updateform")) 
		{
			Student student =new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			student.setName(request.getParameter("name"));
			student.setLocation(request.getParameter("location"));
			student.setEmail(request.getParameter("email"));
			student.setAge(Integer.parseInt(request.getParameter("age")));
			String res= std.Update(student);
			if(res.equalsIgnoreCase("success"))
			{
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			}
			else if(res.equalsIgnoreCase("failure"))
			{
				rd = request.getRequestDispatcher("../failure.jsp");
				rd.forward(request, response);
				
			}
			else {
				rd = request.getRequestDispatcher("../notfound.jsp");
				rd.forward(request, response);
			}
			
		}
		if(reqURI.endsWith("deleteform")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Student stdt = std.CheckById(id);
			String status ="";
			if(stdt!=null) {
				status = std.DeleteById(id);
			}
		
			if(status.equalsIgnoreCase("success"))
			{
				rd = request.getRequestDispatcher("../success.jsp");
				rd.forward(request, response);
			}
			else if(status.equalsIgnoreCase("failure"))
			{
				rd = request.getRequestDispatcher("../failure.jsp");
				rd.forward(request, response);
				
			}
			else {
				rd = request.getRequestDispatcher("../notfound.jsp");
				rd.forward(request, response);
			}
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}

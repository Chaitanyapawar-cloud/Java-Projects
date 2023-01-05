

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")
public class Unregister extends HttpServlet {
	private Connection con= null;
	public void init() throws ServletException 
	{

		ServletContext context=getServletContext();
		String url=context.getInitParameter("jdbcURL");
		String user=context.getInitParameter("user");
		String password=context.getInitParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
		} 
		catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Getting data from html page
		
		String mobileno=request.getParameter("mobno");
	
		
		//JDBC data insert
		PreparedStatement pst=null;
		String delquery="delete from eventreg  where Mobno=?";
		
		int ra=0;
		
			try {
				if(con!=null)
				{
					
					pst=con.prepareStatement(delquery);
				
					pst.setString(1, mobileno);
					
					ra=pst.executeUpdate();
					
					
				}
				
				
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Giving Response to user
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<head><title>Registration Result</title></head>");
			out.println("<body>");
			if(ra==1)
			{
				out.println("<h1 align='center' style='color:green'>  UnRegistered Sucessfully</h1>");
			}
			else
			{
				out.println("<h1 align='center' style='color:red'>  Can't UnRegistereted</h1>");
				out.println("<h4 align='center'><a href='./removereg.html'>Try Again</a><h4>");	
			}
			out.println("</body></html>");
			out.close();
	}


		
	}



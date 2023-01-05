

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet(
		urlPatterns = { "/eventreg" }, 
		initParams = { 
				@WebInitParam(name = "jdbcURL", value = "jdbc:mysql://localhost:3306/csp"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "Polonk@18")
		})
public class Registration extends HttpServlet
{
	private Connection con= null;
	public void init() throws ServletException
	{
		ServletContext cont= getServletContext();
		String jdbcURL=cont.getInitParameter("jdbcURL");
		String user=cont.getInitParameter("user");
		String password=cont.getInitParameter("password");
		

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(jdbcURL,user,password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Getting data from html page
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		String city=request.getParameter("city");
		
		//JDBC data insert
		PreparedStatement pst=null;
		String inquery="insert into eventreg values(?,?,?,?)";
		int ra=0;
		
			try {
				if(con!=null)
				{
					pst=con.prepareStatement(inquery);
					pst.setString(1,name);
					pst.setString(2, email);
					pst.setString(3, mobileno);
					pst.setString(4, city);
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
				out.println("<h1 align='center' style='color:green'> Registration Sucessful</h1>");
			}
			else
			{
				out.println("<h1 align='center' style='color:red'> Registration Unsucessful</h1>");
				out.println("<h4 align='center'><a href='./reg.html'>Return Registration Page</a><h4>");	
			}
			out.println("</body></html>");
			out.close();
	}

}



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


@WebServlet("/update")
public class UpdateRegistration extends HttpServlet {

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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Getting data from html page
				
				String mobileno=null;
				String email= null;
				String city=null;
				
				mobileno=request.getParameter("mobileno");
				email=request.getParameter("email");
				 city=request.getParameter("city");
				
				//JDBC data insert
				PreparedStatement pst=null;
				String upquery1="update eventreg set Email=?,City=? where Mobno=?";
				String upquery2="update eventreg set Email=? where Mobno=?";
				String upquery3="update eventreg set City=? where Mobno=?";
				int ra=0;
				
					try {
						if(con!=null)
						{
							 if ((!email.equals(null)) && (!city.equals(null)))
							{
								pst=con.prepareStatement(upquery1);
								pst.setString(1,email);
								pst.setString(2,city);
								pst.setString(3, mobileno);
								
								ra=pst.executeUpdate();
							}
							 else if(!email.equals(null))
							{
							pst=con.prepareStatement(upquery2);
							pst.setString(1,email);
							pst.setString(2, mobileno);
							
							ra=pst.executeUpdate();
							}
							else if(!city.equals(null))
							{
								pst=con.prepareStatement(upquery3);
								pst.setString(1,city);
								pst.setString(2, mobileno);
								
								ra=pst.executeUpdate();
							}
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
						out.println("<h1 align='center' style='color:green'> Update Registration Sucessful</h1>");
					}
					else
					{
						out.println("<h1 align='center' style='color:red'> Update Registration Unsucessful</h1>");
						out.println("<h4 align='center'><a href='./updatereg.html'>Return Registration Page</a><h4>");	
					}
					out.println("</body></html>");
					out.close();
			}

		
	}



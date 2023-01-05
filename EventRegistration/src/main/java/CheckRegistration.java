

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/check")
public class CheckRegistration extends HttpServlet {
	private Connection con=null;
	
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//1 Get Data from html page
		
		String Mobileno=request.getParameter("mobno");
		
		
		//2 Fetch data from db
		PreparedStatement pst=null;
		ResultSet rs=null;
		String name="";
		String email="";
		String mobileno="";
		String city="";
		 if(con!=null)
		 {
			 try {
				 String Query="select * from eventreg where Mobno=?";
				 pst=con.prepareStatement(Query);
				pst.setString(1, Mobileno);
				rs=pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if(rs!=null)
		 {
			 try {
				rs.next();
				name=rs.getString(1);
				email=rs.getString(2);
				mobileno=rs.getString(3);
				city=rs.getString(4);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		
		
		
		
		
		//3 Post data on response
		 response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<head><title>Registered Details</title></head>");
			out.println("<style>table{width: 50%;}th {height: 70px;}td {text-align:center;}</style>");
			out.println("<body>");
			if(rs!=null)
			{
				out.println("<h1 align='center' style='color:Purple'> Registered Details</h1>");
				 out.println("<table align='center' border='1'>");
			      out.println("<tr><th>Name</th>");
			      out.println("<td>"+name+"</td></tr>");
			      
			      out.println("<tr><th>Email</th>");
			      out.println("<td>"+email+"</td></tr>");
			      
			      out.println("<tr><th>Mobile No</th>");
			      out.println("<td>"+mobileno+"</td></tr>");
			      
			      out.println("<tr><th>City</th>");
			      out.println("<td>"+city+"</td></tr>");
			      
			}
			else
			{
				out.println("<h1 align='center' style='color:red'> Not Registered No</h1>");
					
			}
			out.println("</table></body></html>");
			out.close();
	}

}

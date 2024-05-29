package in.besent.serveletproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Regform")
public class RegistractionPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter out = resp.getWriter();
				
		String Myname = req.getParameter("name1");
		String Myemail = req.getParameter("email");
		String Mypassword = req.getParameter("password");
		String Gender = req.getParameter("gender");
		String Country = req.getParameter("country");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","Morgan@001");
			
			PreparedStatement ps = con.prepareStatement("insert into userDetails values(?,?,?,?,?)");
			ps.setString(1, Myname);
			ps.setString(2, Myemail);
			ps.setString(3, Mypassword);
			ps.setString(4, Gender);
			ps.setString(5, Country);
			
			int result = ps.executeUpdate();
			if(result > 0) {
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> Registration Successful </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			}else {
				resp.setContentType("text/html");
				out.print("<h3  style='color:red'> Registration UnSuccessful </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> Exception: "+e.getMessage()+" </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, resp);
			
		}


		
	}

}
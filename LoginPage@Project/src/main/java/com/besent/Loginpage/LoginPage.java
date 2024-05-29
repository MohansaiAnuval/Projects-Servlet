package com.besent.Loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;


@WebServlet("/loginpage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","Morgan@001");
			
			PreparedStatement ps = con.prepareStatement("select * from userDetails where email=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				
				HttpSession hs = req.getSession();
				hs.setAttribute("key_name", result.getString("name"));
				out.print("<h3 style='color:green'>Registraction Successful</h3>");
				resp.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("/welcome.jsp");
				rd.include(req, resp);
			}else {
				
				out.print("<h3 style='color:red'>Registraction UnSuccessful</h3>");
				resp.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
				
			}
			
		} catch (Exception e) {
			out.print("<h3 style='color:red'>Exception: "+e.getMessage()+"</h3>");
			resp.setContentType("text/html");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, resp);
			
		}
	}

}

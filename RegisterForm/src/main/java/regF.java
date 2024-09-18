import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.plaf.synth.SynthScrollBarUI;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class regF extends HttpServlet {
	 private static final String url = "jdbc:mysql://127.0.0.1:3306/reg_db";
	    private static final String username = "root";
	    private static final String p = "Jordan@22@sql";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		String password = req.getParameter("pass1");
		String gender = req.getParameter("gender1");
		String city = req.getParameter("city1");
		
		
		try {
			String query = "INSERT INTO register(name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded succesfully!");
			
			Connection connection = DriverManager.getConnection(url,username, p);
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, gender);
			ps.setString(5, city);
			
			int affectedRows = ps.executeUpdate();
			if (affectedRows > 0) {				
				resp.setContentType("text/html");
				RequestDispatcher rd = req.getRequestDispatcher("/reg.jsp");
				rd.forward(req, resp);
				out.print("<h2 style='color:Green' > Registered successfully in Database. </h2>");
				
			} else {
				resp.setContentType("text/html");
				out.print("<footer style='color:Red' > Registeration Failed due to some Technical Issue!! <br> Sorry for Inconvinient. </footer>");
				RequestDispatcher rd = req.getRequestDispatcher("/reg.jsp");
				rd.forward(req, resp);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h2 style='color:Red' >  " + e.getMessage() + " </h2>");
		}
		
	}

}

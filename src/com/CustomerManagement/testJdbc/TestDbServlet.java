package com.CustomerManagement.testJdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDbServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connection variable
		String dbUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "student";		
		String password = "student";
		String driver = "com.mysql.jdbc.Driver";
		
		
		//get connection to thee database
		try
		{
			PrintWriter out = response.getWriter();
			out.println("connecting to database: "+dbUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(dbUrl, user, password);
			out.println("Success ! !");
			myConn.close();
			
			
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

}

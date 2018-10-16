package com.training.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.training.entity.Employee;
import com.training.ifaces.EmployeeDAO;
import com.trianing.utils.EmployeeDAOImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con;
	List<Employee> empList;
		
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
		try {
			Context ctx=new InitialContext();
			
			DataSource dataSource=(DataSource)ctx.lookup("java:comp/env/jdbc/ds1");
			
			con=dataSource.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		RequestDispatcher dispatcher = null;
	
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		System.out.println(con);
		
		EmployeeDAO dao = new EmployeeDAOImpl(con);
		Employee emp = new Employee();
		
		emp.setUserName(userName);
		emp.setPassWord(passWord);
		int row =0;
		try {
			 row = dao.addEmployee(emp);
				dispatcher = request.getRequestDispatcher("RegSuccess.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(row);
		
		dispatcher.forward(request, response);
		
		
		
		
		
	}

}

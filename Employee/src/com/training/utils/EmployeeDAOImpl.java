package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Employee;
import com.training.ifaces.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection con;
	String sql;
	PreparedStatement pstmt;
	int rowAdded;
	ResultSet rs;
	
	public EmployeeDAOImpl(Connection con) {
		super();
		this.con = con;
		// TODO Auto-generated constructor stub
	}


	@Override
	public int addEmployee(Employee emp) throws SQLException {
		
		sql = "insert into empram values(?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, emp.getUserName());
		pstmt.setString(2, emp.getPassWord());
		
		rowAdded = 0;
		
		rowAdded = pstmt.executeUpdate();
		pstmt.close();
		
		return rowAdded;
	}


	@Override
	public List<Employee> getAllEmployee() throws SQLException {
		List<Employee> empList = new ArrayList<>();
		
		sql = "select * from empram";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			String userName = rs.getString("userName");
			String passWord = rs.getString("passWord");
			
			Employee emp = new Employee(userName,passWord);
			
			empList.add(emp);
			
		}
		pstmt.close();
		return empList;
		
	
	}

	public void closeConnection() throws SQLException{
		con.close();
	}


	

}

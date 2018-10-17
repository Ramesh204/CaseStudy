package com.trianing.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.training.entity.Car;
import com.training.entity.Customer;
import com.training.ifaces.DAO;

public class CustomerDAOImpl implements DAO<Customer> {
	Connection con;
	String sql;
	PreparedStatement pstmt;
	int rowAdded;
	int rowDeleted;
	ResultSet rs;
	
	
	public CustomerDAOImpl() throws Exception {
		super();
		Context ctx = new InitialContext();

		DataSource ds =
		(DataSource)ctx.lookup("java:/comp/env/jdbc/ds1");
		
		con = ds.getConnection();	
		
		System.out.println(con);
	}

	@Override
	public int add(Customer object) throws SQLException {
		
		sql = "insert into customerram values(?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, object.getCustomerId());
		pstmt.setString(2, object.getCustomerName());
		pstmt.setString(3, object.getMobileNumber());
		rowAdded = 0;
		
		rowAdded = pstmt.executeUpdate();
		
		sql = "insert into carram values(?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, object.getCar().getCarNumber());
		pstmt.setString(2, object.getCar().getCarModel());
		pstmt.setLong(3, object.getCustomerId());
		
		rowAdded+=pstmt.executeUpdate();
		
		System.out.println(rowAdded);
		
		return rowAdded;
	}

	@Override
	public Customer getCustomerDetails(long customerId) throws SQLException {
		
		sql = "select * from customerram natural join carram where customerId=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1,customerId);
		rs = pstmt.executeQuery();
		
		Car car = null;
		Customer cust=  null;
		
		while(rs.next()){
			String customerName = rs.getString("customerName");
			String mobileNumber = rs.getString("mobileNumber");
			
			String carNumber = rs.getString("carNumber");
			String carModel = rs.getString("carModel");
			
			 car = new Car(carNumber, carModel);
			 cust = new Customer(customerId, customerName, mobileNumber, car);
		}
		
		
		return cust;
	}

	@Override
	public int updateCustomerDetails(long customerId, String property, String updateVal) throws SQLException {
				
		sql = "update customerram set "+property+"=? where customerId=?";
				
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, updateVal);
		pstmt.setLong(2, customerId);
		
		rowAdded = 0;
		
		rowAdded = pstmt.executeUpdate();
		return rowAdded;
	}

	@Override
	public int deleteCustomer(long customerId) throws SQLException {
		
		sql = "delete from carram where customerId=?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, customerId);
		
		rowDeleted = 0;
		
		rowDeleted = pstmt.executeUpdate();
		
		sql = "delete from customerram where customerId=?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setLong(1, customerId);
		
		rowDeleted+=pstmt.executeUpdate();
		
		System.out.println(rowDeleted);
		
		return rowDeleted;
		

	}
	
	

	
	
	
	
	
}

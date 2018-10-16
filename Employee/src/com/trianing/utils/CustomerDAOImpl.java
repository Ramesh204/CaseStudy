package com.trianing.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.training.entity.Customer;
import com.training.ifaces.DAO;

public class CustomerDAOImpl implements DAO<Customer> {
	Connection con;
	String sql;
	PreparedStatement pstmt;
	int rowAdded;
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
		
		return rowAdded;
	}
	
	
	
	
}

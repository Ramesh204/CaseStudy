package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.training.entity.Car;
import com.training.entity.Service;
import com.training.ifaces.DAO;
import com.training.ifaces.ServiceDAO;

public class ServiceDAOImpl implements DAO<Service>,ServiceDAO {

	Connection con;
	String sql;
	PreparedStatement pstmt;
	int rowAdded;
	ResultSet rs;
	
	
	
	public ServiceDAOImpl() throws Exception {
		super();
		Context ctx = new InitialContext();

		DataSource ds =
		(DataSource)ctx.lookup("java:/comp/env/jdbc/ds1");
		
		con = ds.getConnection();	
		
		System.out.println(con);
	}



	@Override
	public int add(Service object) throws SQLException {
		
		sql = "insert into serviceram values(?,?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, object.getServiceId());
		pstmt.setString(2, object.getServiceType());
		pstmt.setLong(3, object.getServiceAmount());
		pstmt.setString(4, object.getCar().getCarNumber());
		
		rowAdded = 0;
		rowAdded = pstmt.executeUpdate();
		pstmt.close();
		return rowAdded;
	}



	@Override
	public Service getServices(long serviceId) throws SQLException {
		
		sql = "select * from serviceram where serviceId=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, serviceId);
		rs = pstmt.executeQuery();
		
		Service service = null;
		Car car = null;
		while(rs.next()){
			String serviceType = rs.getString("serviceType");
			long serviceAmount = rs.getLong("serviceAmount");
			String carNumber  = rs.getString("carNumber");
			car = new Car(carNumber);
			service = new Service(serviceId, serviceType, serviceAmount, car);
		}
		pstmt.close();
		return service;
	}
	
	public void closeConnection() throws SQLException{
		con.close();
	}

}

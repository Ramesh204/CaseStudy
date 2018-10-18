package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.*;
import org.apache.log4j.Logger;

import com.training.entity.Policy;
import com.training.ifaces.InsuranceDAO;

public class InsuranceDAOImpl implements InsuranceDAO {

	Connection con;
	String sql;
	PreparedStatement pstmt;
	int rowAdded;
	ResultSet rs;
	List<Policy> policyList = new ArrayList<>();
	Policy policy;
	
	public InsuranceDAOImpl() throws Exception {
		super();
		Context ctx = new InitialContext();


		DataSource ds =
		(DataSource)ctx.lookup("java:/comp/env/jdbc/ds1");
		
		con = ds.getConnection();	
		
		System.out.println(con);
	}

	@Override
	public int addPolicy(Policy policy) throws SQLException {
		
		sql = "insert into insuranceram values(?,?,?,?)";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, policy.getCarNumber());
		pstmt.setLong(2, policy.getPolicyId());
		pstmt.setString(3, policy.getPolicyName());
		pstmt.setLong(4, policy.getPolicyAmount());
		rowAdded = 0;
		rowAdded = pstmt.executeUpdate();
		pstmt.close();
		return rowAdded;
	}

	

	@Override
	public List<Policy> getPolicies() throws SQLException {
		
		
		sql = "select * from insuranceram";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		
		while(rs.next()){
			String carNumber = rs.getString("carNumber");
			long policyId = rs.getLong("policyId");
			String policyName = rs.getString("policyName");
			long policyAmount = rs.getLong("policyAmount");
			
			policy = new Policy(carNumber, policyId, policyName, policyAmount);
			policyList.add(policy);
			
		}
		pstmt.close();		
		return policyList;
	}

	
	@Override
	public List<Policy> getPoliciesofCar(String carNumber) throws SQLException {
		
		
		sql = "select * from insuranceram where carNumber=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, carNumber);
		rs = pstmt.executeQuery();
		
		
		while(rs.next()){
		
			long policyId = rs.getLong("policyId");
			String policyName = rs.getString("policyName");
			long policyAmount = rs.getLong("policyAmount");
			
			policy = new Policy(carNumber, policyId, policyName, policyAmount);
			policyList.add(policy);
			
		}
		Logger  log = Logger.getLogger("second");
		String message = "Policies are requested for carNumber:"+carNumber;
		log.info(message);
		
		pstmt.close();		
		return policyList;
	}

	@Override
	public long getPolicyAmount(String carNumber, String policyName) throws SQLException {
		
		long policyAmount=0;
		sql = "select policyAmount from insuranceram where carNumber=? and policyName=? ";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, carNumber);
		pstmt.setString(2, policyName);
		rs = pstmt.executeQuery();
		while(rs.next()){
			policyAmount = rs.getLong("policyAmount");
		}
		
		Logger  log = Logger.getLogger("second");
		String message = "Insurance is  Requested for carNumber:"+carNumber +"and policyName:"+policyName+".";
		log.info(message);
		
		pstmt.close();
		
		return policyAmount;
	}
	
	
	public void closeConnection() throws SQLException{
		con.close();
	}
}

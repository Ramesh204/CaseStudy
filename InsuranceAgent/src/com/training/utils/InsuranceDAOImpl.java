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
				
		return policyList;
	}
	
	
}

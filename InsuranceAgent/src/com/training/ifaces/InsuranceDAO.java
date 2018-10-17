package com.training.ifaces;

import java.sql.SQLException;
import java.util.List;

import com.training.entity.Policy;

public interface InsuranceDAO {

	public int addPolicy(Policy policy) throws SQLException;
	
	public List<Policy> getPoliciesofCar(String carNumber) throws SQLException;
	
	public List<Policy> getPolicies() throws SQLException;
	
	public long getPolicyAmount(String carNumber,String policyName) throws SQLException;
}

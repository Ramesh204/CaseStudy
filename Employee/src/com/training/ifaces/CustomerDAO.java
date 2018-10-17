package com.training.ifaces;

import java.sql.SQLException;

import com.training.entity.Customer;

public interface CustomerDAO {
	
public Customer getCustomerDetails(long customerId) throws SQLException;
	
	public int updateCustomerDetails(long customerId,String property,String updateVal) throws SQLException;
	
	public int deleteCustomer(long customerId) throws SQLException;
}

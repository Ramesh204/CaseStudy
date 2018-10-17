package com.training.ifaces;

import java.sql.SQLException;

public interface DAO<T> {

	public int add(T object) throws SQLException;
	
	public T getCustomerDetails(long customerId) throws SQLException;
	
	public int updateCustomerDetails(long customerId,String property,String updateVal) throws SQLException;
	
	public int deleteCustomer(long customerId) throws SQLException;
}

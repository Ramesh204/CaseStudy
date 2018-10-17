package com.training.ifaces;

import java.sql.SQLException;

public interface DAO<T> {

	public int add(T object) throws SQLException;
	
	
}

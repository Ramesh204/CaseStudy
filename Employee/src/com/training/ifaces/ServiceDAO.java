package com.training.ifaces;

import java.sql.SQLException;

import com.training.entity.Service;

public interface ServiceDAO {
	
	public Service getServices(long serviceId) throws SQLException;
}

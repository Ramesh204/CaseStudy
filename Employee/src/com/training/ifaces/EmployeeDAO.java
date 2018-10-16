package com.training.ifaces;

import java.sql.SQLException;
import java.util.List;

import com.training.entity.Employee;

public interface EmployeeDAO {
	
	public int addEmployee(Employee emp) throws SQLException;
	
	public List<Employee> getAllEmployee() throws SQLException;
	
	
}

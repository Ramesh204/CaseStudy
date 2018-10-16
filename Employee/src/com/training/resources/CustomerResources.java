package com.training.resources;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.training.entity.Customer;
import com.training.ifaces.DAO;
import com.trianing.utils.CustomerDAOImpl;

@Path("customer")
public class CustomerResources {

	DAO<Customer> custDao;
	
	public CustomerResources() throws Exception {
		super();
		custDao = new CustomerDAOImpl();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "You Had Configured JERSEY Property in Customer Resources";
	}

	@POST
	@Path("add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addCustomer(@FormParam("customerId") long customerId,@FormParam("customerName") String customerName,@FormParam("mobileNumber") String mobileNumber) throws SQLException {
		System.out.println("hello");
		Customer cust = new Customer(customerId, customerName, mobileNumber);
		custDao.add(cust);	
		return cust.getCustomerName()+" has added to the record";
		
	}
	
}

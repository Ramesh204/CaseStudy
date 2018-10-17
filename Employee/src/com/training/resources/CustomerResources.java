package com.training.resources;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.training.entity.Car;
import com.training.entity.Customer;
import com.training.ifaces.CustomerDAO;
import com.training.ifaces.DAO;
import com.training.utils.CustomerDAOImpl;

@Path("customer")
public class CustomerResources {

	CustomerDAOImpl custDao;
	
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
	public String addCustomer(@FormParam("customerId") long customerId,@FormParam("customerName") String customerName,@FormParam("mobileNumber") String mobileNumber,@FormParam("carNumber") String carNumber,@FormParam("carModel") String carModel) throws SQLException {
		System.out.println("hello");
		Car car = new Car(carNumber, carModel);
		Customer cust = new Customer(customerId, customerName, mobileNumber, car);
		custDao.add(cust);	
		return cust.getCustomerName()+ " and "+cust.getCar().getCarNumber() +" has added to the record";
		
	}
	
	@POST
	@Path("details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDetails(@FormParam("customerId") long customerId) throws SQLException { 
		
		return Response.status(200).entity(custDao.getCustomerDetails(customerId)).build();
	}
	
	@POST
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(@FormParam("customerId") long customerId,@FormParam("property") String property,@FormParam("updateVal") String updateVal) throws SQLException{
		
		System.out.println("hi");
		custDao.updateCustomerDetails(customerId, property, updateVal);
		
		return property+"is updated";
	}
	
	@POST
	@Path("delete")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(@FormParam("customerId") long customerId) throws SQLException{
	
		int row = custDao.deleteCustomer(customerId);
		
		return customerId+"is deleted "+row+"are deleted";
	}
}

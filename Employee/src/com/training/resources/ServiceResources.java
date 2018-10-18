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
import com.training.entity.Service;
import com.training.utils.ServiceDAOImpl;

@Path("service")
public class ServiceResources {
	
	ServiceDAOImpl servDao ;

	public ServiceResources() throws Exception {
		super();
		servDao = new ServiceDAOImpl();
	}
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "You Had Configured JERSEY Property in Service Resources";
	}
	
	@POST
	@Path("add")
	@Produces(MediaType.TEXT_PLAIN)
	public String addService(@FormParam("serviceId") long serviceId,@FormParam("serviceType") String serviceType,@FormParam("serviceAmount") long serviceAmount,@FormParam("carNumber") String carNumber) throws SQLException{
		
		Car car = new Car(carNumber);
		
		System.out.println(carNumber);
		Service service = new Service(serviceId, serviceType, serviceAmount, car);
		servDao.add(service);
		System.out.println(service.getServiceType());
		
		return service.getServiceType()+ "is added to the DB";
	}
	
	@GET
	@Path("details/{serviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getServices(@PathParam("serviceId") long  serviceId) throws SQLException{
		return Response.status(200).entity(servDao.getServices(serviceId)).build();
	}
	
}

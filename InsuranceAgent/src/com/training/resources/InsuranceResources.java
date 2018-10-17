
package com.training.resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.*;

import com.training.entity.Policy;
import com.training.ifaces.InsuranceDAO;
import com.training.utils.InsuranceDAOImpl;

@Path("insurance")
public class InsuranceResources {
	
	InsuranceDAO dao;
	
	public InsuranceResources() throws Exception {
		super();
		dao = new InsuranceDAOImpl();
		
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "You Had Configured JERSEY Property in Insurance Resources";
	}
	
//	@POST
//	@Path("add")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String addPolicy(Policy policy) throws SQLException {
//		dao.addPolicy(policy);
//		
//		return policy.getPolicyName();
//	}
	
	
	@POST
	@Path("addPolicy")
	@Produces(MediaType.TEXT_PLAIN)
	public String submit(@FormParam("carNumber") String carNumber,@FormParam("policyId") long policyId,@FormParam("policyName") String policyName,@FormParam("policyAmount") long policyAmount) throws SQLException{
		System.out.println("hi");
		Policy policy = new Policy(carNumber, policyId, policyName, policyAmount);
		dao.addPolicy(policy);
		return policy.getPolicyName();
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() throws SQLException{
		return Response.status(200).entity(dao.getPolicies()).build();
	}
	
	
	@GET
	@Path("allPolicies/{carNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPolicesofcar(@PathParam("carNumber") String carNumber) throws SQLException{
		return Response.status(200).entity(dao.getPoliciesofCar(carNumber)).build();
	}
	
	@GET
	@Path("policyAmount/{carNumber}/{policyName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPolicyAmount(@PathParam("carNumber") String carNumber,@PathParam("policyName") String policyName) throws SQLException{
		return Response.status(200).entity(dao.getPolicyAmount(carNumber, policyName)).build();
	}
	

}

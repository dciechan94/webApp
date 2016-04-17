package com.boundary;

import javax.annotation.security.DenyAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/resttest")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class TestResource {
	
	@GET
	@Path("/get")
	public String getRequest() {
		return "GetResponse";
	}
	
	@POST
	@Path("/post")
	public String postRequest(String x) {
		return x;
	}
	
	@PUT
	@Path("/put")
	public String putRequest() {
		return "PutResponse";
	}
	
	@DELETE
	@Path("/delete")
	public String deleteRequest() {
		return "DeleteResponse";
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public TestDTO produceJsonRequest() {
		return new TestDTO("JSON");
	}
	
	@GET
	@Path("/permit")
	//@PermitAll
	public String permitAllRequest() {
		return "Allowed";
	}
	
	@GET
	@Path("/deny")
	@DenyAll
	public String denyAllRequest() {
		return "Allowed";
	}
	
	
	public static class TestDTO {
		public String value;
		
		public TestDTO(String pValue) {
			value = pValue;
		}
	}
	
}

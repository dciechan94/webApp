package com.boundary;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Res2 {
	
	
	@GET
	//@Path("/")
	@PermitAll
	public StrDTO func() {
		return new StrDTO("Hello");
	}
	
	
	public static class StrDTO {
		public String value;
		
		public StrDTO( String pValue ) {
			value = pValue;
		}
	}
}

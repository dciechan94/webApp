package com.boundary;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class Res {
	
	@GET
	//@RolesAllowed("Role1")
	public String func() {
		System.out.println("Shiiiiiiiit");
		System.out.println("Shiiiiiiiit");
		System.out.println("Shiiiiiiiit");
		System.out.println("Shiiiiiiiit");
		System.out.println("Shiiiiiiiit");
		System.out.println("Shiiiiiiiit");
		
		return "Helloooo";
	}
}

package com.boundary;

import com.service.WithInjectLoggerService;
import com.service.WithInjectService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/resttest")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectResource {
	
	@Inject
    WithInjectService service;

    @Inject
    WithInjectLoggerService serviceWithLogger;

	@GET
	@Path("/inject")
	public String injectRequired() {

		if(service != null) {
			if(service.injected()) {
				return "Injected";
			}
		}
		return "NotInjected";
	}

    @GET
    @Path("/injectLogger")
    public String injectLoggerRequired() {

        if(service != null) {
            if(service.injected()) {
                return "Injected";
            }
        }
        return "NotInjected";
    }
}

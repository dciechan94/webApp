package com.webapp.tasks.boundary;

import com.google.common.collect.Lists;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {
//	@Inject
//	Logger logger;
	//Logger logger = new SimpleLoggerFactory().getLogger("xxx");
	
	//@Inject
	//CustomInjectClass xxx;
	
	@GET
	@Path("/tasks")
	@PermitAll
	public List<StrDTO> func() {
		List<StrDTO> tasks = Lists.newLinkedList();
		
		tasks.add(new StrDTO("Task1", "Desc1"));
		tasks.add(new StrDTO("Task2", "Desc2"));
		tasks.add(new StrDTO("Task3", "Desc3"));
		System.out.println("Tasks Sent");
		//logger.info("logging");
		return tasks;
	}
	
	@GET
	@Path("/taskss")
	@PermitAll
	public List<StrDTO> func2() {
		List<StrDTO> tasks = Lists.newLinkedList();
		
		tasks.add(new StrDTO("Task1", "Desc1"));
		tasks.add(new StrDTO("Task2", "Desc2"));
		tasks.add(new StrDTO("Task3", "Desc3"));
		method1();
		System.out.println("Tasks Sent");
		//logger.info("logging");
		return tasks;
	}
	//TODO: Stupid method
	//NOTE: Nothing else I can say
	//FIXME: Please fast
	void method1() {
		  BigDecimal bd=new BigDecimal(10);
		  bd.add(new BigDecimal(5)); // this will trigger the rule
		  if( bd == bd) 
			  System.out.println("lool");
	}
	
	//@JsonInclude(JsonInclude.Include.NON_NULL)
	public static class StrDTO {
		public String name;
		public String description;
		
		public StrDTO( String pValue, String pDescription ) {
			name = pValue;
			description = pDescription;
		}
	}
}

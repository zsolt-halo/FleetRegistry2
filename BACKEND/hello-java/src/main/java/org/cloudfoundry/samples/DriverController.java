package org.cloudfoundry.samples;


import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
//import javax.ws.rs.*;

//import org.springframework.web.bind.annotation.RequestParam;

@Path("/driver")
public class DriverController {
	
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Driver> getAll() throws Exception {
		DriverModel my = new DriverModel();
		//my.createDriver("asd", "asd", "123");
		return my.getAllDriver();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Driver getById(@PathParam("id")String id) throws Exception {
		DriverModel my = new DriverModel();
		return my.getById(id);
	}
	
	/*@POST
	@Path("/{first_name}/{last_name}/{phone_number}")
	@Produces(MediaType.APPLICATION_JSON)
	public void update(@PathParam("first_name")String first_name,@PathParam("last_name")String last_name,@PathParam("phone_number")String phone_number) throws Exception {
		DriverModel my = new DriverModel();
		my.updateDriver("asd", "mák", "13223434");
	}*/
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void create(@QueryParam("js")String obj) throws Exception {
		Gson json = new Gson();
		Driver d = json.fromJson(obj, Driver.class);
		DriverModel my = new DriverModel();
		my.createDriver(d.first_name, d.last_name, d.phone_number);
	}
	
	@GET
	@Path("/env")
	@Produces(MediaType.TEXT_HTML)
	public String getEnv() {
		return java.lang.System.getenv("VCAP_SERVICES");
	}
}

package org.cloudfoundry.apis;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.gson.*;
//import javax.ws.rs.*;

//import org.springframework.web.bind.annotation.RequestParam;

@Path("/driver")
public class DriverController {

	@GET
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public ArrayList<Driver> getAll() throws Exception {
		DriverModel my = new DriverModel();
		return my.getAllDriver();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public Driver getById(@PathParam("id") String id) throws Exception {
		DriverModel my = new DriverModel();
		return my.getById(id);
	}

	@POST
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Driver addDriver(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Driver d = json.fromJson(obj, Driver.class);
		DriverModel my = new DriverModel();
		return my.addDriver(d.first_name, d.last_name, d.phone_number, d.rank, d.user_name, d.password);
	}

	@PUT
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Driver updateDriver(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Driver d = json.fromJson(obj, Driver.class);
		DriverModel my = new DriverModel();
		return my.updateDriver(d.id, d.first_name, d.last_name, d.phone_number, d.rank, d.user_name, d.password, d.deleted);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public void deleteDriver(@PathParam("id") String id) throws Exception {
		DriverModel my = new DriverModel();
		my.deleteDriver(id);
	}

	@GET
	@Path("/env")
	@Produces(MediaType.TEXT_HTML)
	public String getEnv() {
		return java.lang.System.getenv("VCAP_SERVICES");
	}
}

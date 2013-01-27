package org.cloudfoundry.apis;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

@Path("/vehicle")
public class VehicleController {

	@GET
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public ArrayList<Vehicle> getAll() throws Exception {
		VehicleModel my = new VehicleModel();
		return my.getAllVehicle();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public Vehicle getById(@PathParam("id") String id) throws Exception {
		VehicleModel my = new VehicleModel();
		return my.getById(id);
	}

	@POST
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Vehicle addVehicle(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Vehicle d = json.fromJson(obj, Vehicle.class);
		VehicleModel my = new VehicleModel();
		return my.addVehicle(d.model, d.license_plate_number, d.color, d.station_id);
	}

	@PUT
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Vehicle updateVehicle(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Vehicle d = json.fromJson(obj, Vehicle.class);
		VehicleModel my = new VehicleModel();
		return my.updateVehicle(d.id,  d.model, d.license_plate_number, d.color, d.station_id, d.deleted);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public void deleteVehicle(@PathParam("id") String id) throws Exception {
		VehicleModel my = new VehicleModel();
		my.deleteVehicle(id);
	}
}

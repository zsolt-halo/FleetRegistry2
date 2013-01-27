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

@Path("/station")
public class StationController {

	@GET
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public ArrayList<Station> getAll() throws Exception {
		StationModel my = new StationModel();
		return my.getAllStation();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public Station getById(@PathParam("id") String id) throws Exception {
		StationModel my = new StationModel();
		return my.getById(id);
	}

	@POST
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Station addStation(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Station d = json.fromJson(obj, Station.class);
		StationModel my = new StationModel();
		return my.addStation(d.address, d.capacitiy, d.longitude, d.latitude);
	}

	@PUT
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Station updateStation(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Station d = json.fromJson(obj, Station.class);
		StationModel my = new StationModel();
		return my.updateStation(d.id, d.address, d.capacitiy, d.longitude, d.latitude, d.deleted);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public void deleteStation(@PathParam("id") String id) throws Exception {
		StationModel my = new StationModel();
		my.deleteStation(id);
	}
}

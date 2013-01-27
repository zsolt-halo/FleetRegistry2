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

@Path("/work")
public class WorkController {

	@GET
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public ArrayList<Work> getAll() throws Exception {
		WorkModel my = new WorkModel();
		return my.getAllWork();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public Work getById(@PathParam("id") String id) throws Exception {
		WorkModel my = new WorkModel();
		return my.getById(id);
	}

	@POST
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Work addWork(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Work d = json.fromJson(obj, Work.class);
		WorkModel my = new WorkModel();
		return my.addWork(d.start_date, d.workTypeId, d.driver_id, d.longitude, d.latitude, d.vehicle_id, d.partner_id);
	}

	@PUT
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Work updateWork(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Work d = json.fromJson(obj, Work.class);
		WorkModel my = new WorkModel();
		return my.updateWork(d.id, d.start_date, d.workTypeId, d.driver_id, d.longitude, d.latitude, d.vehicle_id, d.partner_id, d.deleted);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public void deleteWork(@PathParam("id") String id) throws Exception {
		WorkModel my = new WorkModel();
		my.deleteWork(id);
	}
}

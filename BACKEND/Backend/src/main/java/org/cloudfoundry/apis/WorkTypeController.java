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

@Path("/workType")
public class WorkTypeController {

	@GET
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public ArrayList<WorkType> getAll() throws Exception {
		WorkTypeModel my = new WorkTypeModel();
		return my.getAllWorkType();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public WorkType getById(@PathParam("id") String id) throws Exception {
		WorkTypeModel my = new WorkTypeModel();
		return my.getById(id);
	}

	@POST
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public WorkType addWorkType(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		WorkType d = json.fromJson(obj, WorkType.class);
		WorkTypeModel my = new WorkTypeModel();
		return my.addWorkType(d.type, d.time);
	}

	@PUT
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public WorkType updateWorkType(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		WorkType d = json.fromJson(obj, WorkType.class);
		WorkTypeModel my = new WorkTypeModel();
		return my.updateWorkType(d.id, d.type, d.time);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public void deleteWorkType(@PathParam("id") String id) throws Exception {
		WorkTypeModel my = new WorkTypeModel();
		my.deleteWorkType(id);
	}
}

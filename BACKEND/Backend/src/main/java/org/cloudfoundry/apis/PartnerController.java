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

@Path("/partner")
public class PartnerController {

	@GET
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public ArrayList<Partner> getAll() throws Exception {
		PartnerModel my = new PartnerModel();
		return my.getAllPartner();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public Partner getById(@PathParam("id") String id) throws Exception {
		PartnerModel my = new PartnerModel();
		return my.getById(id);
	}

	@POST
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Partner addPartner(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Partner d = json.fromJson(obj, Partner.class);
		PartnerModel my = new PartnerModel();
		return my.addPartner(d.name,d.address,d.phone_number,d.longitude,d.latitude);
	}

	@PUT
	@Path("/")
	@Produces("application/json;charset=utf-8")
	public Partner updatePartner(@QueryParam("obj") String obj) throws Exception {
		Gson json = new Gson();
		Partner d = json.fromJson(obj, Partner.class);
		PartnerModel my = new PartnerModel();
		return my.updatePartner(d.id, d.name,d.address,d.phone_number,d.longitude,d.latitude, d.deleted);
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json;charset=utf-8")
	public void deletePartner(@PathParam("id") String id) throws Exception {
		PartnerModel my = new PartnerModel();
		my.deletePartner(id);
	}
}

package com.ragas.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.ragas.model.Model;
import com.ragas.serviceImpl.ServiceImpl;
import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/api")
public class Controller {

	ServiceImpl si=new ServiceImpl();
	String msg=null;
	
	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getData() {
		msg = si.getData();
			return Response.status(Status.OK).entity(msg).build();

	}
	
	@GET
	@Path("/data/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDataById(@PathParam("id") int id) {
		msg = si.getDataById(id);
		return Response.status(200).entity(msg).build();
	}
	
	@DELETE
	@Path("/delete/{idToDel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delData(@PathParam("idToDel") int id) {
		msg = si.delData(id);
		System.out.println(msg);
		return Response.status(200).entity(msg).build();
	}
	
	@POST 
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addData(Model m){
		msg = si.addData(m);
		return Response.status(200).entity(msg).build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updData(Model m) {
		msg = si.updateData(m);
		return Response.status(200).entity(msg).build();
	}
	
}

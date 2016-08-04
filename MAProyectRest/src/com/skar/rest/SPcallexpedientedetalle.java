package com.skar.rest;

import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.skar.bean.SP_expedientedetalle;
import com.skar.model.SP_ExpedienteDetalleDAO;

@Path("/spcallexpedientedetalle")
public class SPcallexpedientedetalle {
	
	@GET
    @Path("/{param}/{param2}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response  getSPExpedienteDetalle(@PathParam("param")String numDoc,@PathParam("param2")int num){
		SP_ExpedienteDetalleDAO dao = new SP_ExpedienteDetalleDAO();
		List<SP_expedientedetalle> respuesta= dao.getSP(numDoc,num);
		
		Gson gson = new Gson();
	     // convert your list to json
		Type listOfTestObject = new TypeToken<List<SP_expedientedetalle>>(){}.getType();
	     String jsonCartList = gson.toJson(respuesta,listOfTestObject)	;
	     // print your generated json
	     System.out.println("jsonCartList: " + jsonCartList);
	     return Response.status(200).entity(jsonCartList).build();
	}

}

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
import com.skar.bean.SP_buscarcipdni;
import com.skar.bean.SP_expedientedetalle;
import com.skar.model.SP_buscarcipdniDAO;

@Path("/spcallbuscacipdni")
public class SPcallbuscacipdni {
	
	@GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getSPBuscarcipdni(@PathParam("param") String numDoc){
		SP_buscarcipdniDAO dao = new SP_buscarcipdniDAO();
		SP_buscarcipdni respuesta = dao.getSP(numDoc);
		Gson gson = new Gson();
	     String jsonCartList = gson.toJson(respuesta)	;
		
		return Response.status(200).entity(jsonCartList).build();
	}
	
}

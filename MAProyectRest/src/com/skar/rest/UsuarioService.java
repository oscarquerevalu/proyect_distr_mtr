package com.skar.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.skar.bean.Respuesta;
import com.skar.bean.Usuario;
import com.skar.model.PersonaDAO;
import com.skar.model.UsuarioDAO;

@Path("/usuarioService")
public class UsuarioService {
	
	@GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  getPersonaHTML(@PathParam("param") String numDoc) {
    	JSONObject jsonObject = new JSONObject();
    	PersonaDAO dao = new PersonaDAO();
    	Respuesta rpta = dao.getPersona(numDoc);
    	jsonObject.put("NUM_DOCUMENTO", rpta.getNUM_DOCUMENTO());
    	jsonObject.put("NOMBRES", rpta.getNOMBRES());
    	jsonObject.put("APE_PATERNO", rpta.getAPE_PATERNO());
    	jsonObject.put("APE_MATERNO", rpta.getAPE_MATERNO());
    	jsonObject.put("FEC_NACIMIENTO", rpta.getFEC_NACIMIENTO());
    	jsonObject.put("COD_SEXO", rpta.getCOD_SEXO());
    	jsonObject.put("DES_DEPARTAMENTO", rpta.getDES_DEPARTAMENTO());
    	jsonObject.put("DES_PROVINCIA", rpta.getDES_PROVINCIA());
    	jsonObject.put("DES_DISTRITO", rpta.getDES_DISTRITO());
    	jsonObject.put("ENCONTRO_RENIEC", rpta.isENCONTRO_RENIEC());
    	jsonObject.put("MENSAJE_RENIEC", rpta.getMENSAJE_RENIEC());
    	jsonObject.put("ENCONTRO_FOSERECE", rpta.isENCONTRO_FOSERECE());
    	jsonObject.put("MENSAJE_FOSERECE", rpta.getMENSAJE_FOSERECE());
    	jsonObject.put("RETIRO_FOSERECE", rpta.isRETIRO_FOSERECE());
    	jsonObject.put("ESTADO_LOGIN", rpta.getESTADO_LOGIN());
		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
    }
	
	@GET
    @Path("/updateLogin/{dni}/{nomSis}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  updatePersonaLogin(@PathParam("dni") String dni,@PathParam("nomSis") String nomSis) {
    	JSONObject jsonObject = new JSONObject();
    	PersonaDAO dao = new PersonaDAO();
    	String mensaje = dao.updatePersonaLoging(dni, nomSis);
    	jsonObject.put("MENSAJE", mensaje);
		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
    }
	
	@GET
    @Path("/crearUsuario/{usu}/{nom}/{ape}/{dni}/{dis}/{vec}/{tit}/{clv}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response  crearUsuario(@PathParam("usu") String usu,@PathParam("nom") String nom,@PathParam("ape")
    String ape,@PathParam("dni") int dni,@PathParam("dis") int dis,@PathParam("vec") String vec,@PathParam("tit") 
    String tit,@PathParam("clv") String clv) {
    	JSONObject jsonObject = new JSONObject();
    	UsuarioDAO dao = new UsuarioDAO();
    	Usuario usuario = new Usuario();
    	usuario.setIdusuario(usu);;
    	usuario.setApellido(ape);
    	usuario.setClave(clv);
    	usuario.setDni(dni);
    	usuario.setIddistrito(dis);
    	usuario.setNombre(nom);
    	usuario.setTitular(tit);
    	usuario.setVecino(vec);
    	String mensaje = dao.crearUsuario(usuario);
    	jsonObject.put("MENSAJE", mensaje);
		String result = "" + jsonObject;
		return Response.status(200).entity(result).build();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaludoPlain() {
        return "Hola mundo!"  ;
    }

}

package com.skar.rest;

import java.io.IOException;
import java.util.List;

import com.skar.bean.Respuesta;
import com.skar.bean.SP_buscarcipdni;
import com.skar.bean.SP_expedientedetalle;
import com.skar.bean.Usuario;
import com.skar.model.PersonaDAO;
import com.skar.model.SP_ExpedienteDetalleDAO;
import com.skar.model.SP_buscarcipdniDAO;
import com.skar.model.UsuarioDAO;

public class Main {

	public static void main(String[] args) throws IOException
	   {
//		BuscarDocumento doc = new BuscarDocumento();
//		byte[] fileBytes;
//   	 	fileBytes = doc.getImageData("FOTODNI001");
//        OutputStream targetFile=  
//        new FileOutputStream(
//             "e://new.pdf");
//
//        targetFile.write(fileBytes);
//        targetFile.close();
		
//		PersonaDAO dao =  new PersonaDAO();
//		SP_buscarcipdniDAO dao2 =  new SP_buscarcipdniDAO();
//		SP_ExpedienteDetalleDAO dao3 =  new SP_ExpedienteDetalleDAO();
//		
//		Respuesta rpta = dao.getPersona("43870651");
//		
//		SP_buscarcipdni rpta2 = dao2.getSP("43260265");
//		
//		List<SP_expedientedetalle> rpta3 = dao3.getSP("EX0000022",1);
//		
//		System.out.println(rpta.isENCONTRO_RENIEC());
//		System.out.println(rpta.isENCONTRO_FOSERECE());
//		System.out.println(rpta.getMENSAJE_RENIEC());
//		System.out.println(rpta.getMENSAJE_FOSERECE());
		
		UsuarioDAO usudao = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		usuario.setApellido("Querevalu");
		usuario.setClave("123");
		usuario.setDni(46854961);
		usuario.setIddistrito(1);
		usuario.setIdusuario("oquerevalu");
		usuario.setNombre("Oscar");
		usuario.setTitular("1");
		usuario.setVecino("1");
		
		usudao.crearUsuario(usuario);
		
	   }
}

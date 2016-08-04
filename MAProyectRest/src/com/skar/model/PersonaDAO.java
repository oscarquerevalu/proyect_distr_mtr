package com.skar.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skar.bean.Respuesta;

import pe.com.mapfre.www.PERSONA;
import pe.com.mapfre.www.WsConsultaDatosSoapProxy;

public class PersonaDAO {
	
	public Respuesta getPersona(String numDoc){
		Respuesta rpta = new Respuesta();
		
		try {
			WsConsultaDatosSoapProxy stub = new WsConsultaDatosSoapProxy();
			PERSONA persona = stub.consultaPersonaXML("DNI", numDoc);

			if(persona.getAPE_PATERNO().equals("")){
				rpta.setENCONTRO_RENIEC(false);
				rpta.setMENSAJE_RENIEC("Persona no se encontro en Reniec, verificar numero de DNI");
				
				return rpta;
			}
			else
				rpta.setENCONTRO_RENIEC(true);
				
				rpta.setNUM_DOCUMENTO(persona.getNUM_DOCUMENTO());
				rpta.setNOMBRES(persona.getNOMBRES());
				rpta.setAPE_PATERNO(persona.getAPE_PATERNO());
				rpta.setAPE_MATERNO(persona.getAPE_MATERNO());
				rpta.setCOD_SEXO(persona.getCOD_SEXO());
				rpta.setFEC_NACIMIENTO(persona.getFEC_NACIMIENTO());
				rpta.setDES_DEPARTAMENTO(persona.getDES_DEPARTAMENTO());
				rpta.setDES_DISTRITO(persona.getDES_DISTRITO());
				rpta.setDES_PROVINCIA(persona.getDES_PROVINCIA());
				
				rpta.setMENSAJE_RENIEC("Persona encontrada con Exito");
				
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			rpta.setENCONTRO_RENIEC(false);
			rpta.setMENSAJE_RENIEC("Servicio Reniec no se encuentra disponible, por favor intentenlo mas tarde");
		}
		
		PreparedStatement pstmt;
		String query;
		try {
			
         Connection conn = (new ConnModel()).dbConnect();
         try
         {
                 query = "select case when persc_vresolucion_retiro is null then 0 else 1 end from Persona where persc_vdni = ? ";
                 pstmt = conn.prepareStatement(query);
                 pstmt.setString(1, numDoc);
                 ResultSet rs = pstmt.executeQuery();
                 
                 rpta.setENCONTRO_FOSERECE(false);
                 if (rs.next())
                {
                	 if(rs.getString(1).equals("1")){
                		 rpta.setENCONTRO_FOSERECE(true);
                		 rpta.setRETIRO_FOSERECE(true);
                		 rpta.setMENSAJE_FOSERECE("Persona retirada");
                	 }
                	 else{
                		 rpta.setENCONTRO_FOSERECE(true);
                		 rpta.setMENSAJE_FOSERECE("Persona no se encuentra en retiro");
                	 }
                	 
                }
                 else{
                	 rpta.setENCONTRO_FOSERECE(false);
                	 rpta.setMENSAJE_FOSERECE("Persona no pertenece a la Marina");
                 }
                 
                 query = "select persc_cestado from personaLogin where persc_vdni = ? ";
                 pstmt = conn.prepareStatement(query);
                 pstmt.setString(1, numDoc);
                 rs = pstmt.executeQuery();
                 
                 if (rs.next()){
                 		 rpta.setESTADO_LOGIN(rs.getString(1));
                 }
         }
         catch (Exception e){
                 e.printStackTrace();
                 rpta.setENCONTRO_FOSERECE(false);
            	 rpta.setMENSAJE_FOSERECE("Problemas con el servicio de Foserece");
         }
         finally {
       	  try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
         }
         
         
		} catch (Exception e) {
			// TODO: handle exception
			rpta.setENCONTRO_FOSERECE(false);
       	 rpta.setMENSAJE_FOSERECE("Problemas con el servicio de Foserece.");
		}
		
		return rpta;
	}
	
	public String updatePersonaLoging(String dni,String nomSis){
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String mensaje = "Registro con exito";
		String updateTableSQL = "UPDATE PERSONALOGIN SET persc_vsistema = ?, persc_cestado = ? "
				                  + " WHERE persc_vdni = ?";

		try {
			try {
				dbConnection = (new ConnModel()).dbConnect();
				preparedStatement = dbConnection.prepareStatement(updateTableSQL);

				preparedStatement.setString(1, nomSis);
				preparedStatement.setString(2, "1");
				preparedStatement.setString(3, dni);

				// execute update SQL stetement
				preparedStatement.executeUpdate();

				System.out.println("Record is updated to PERSONALOGIN table!");

			} catch (SQLException e) {

				System.out.println(e.getMessage());
				mensaje = "Erro Al actualizar " + e.getMessage();

			} finally {

				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (dbConnection != null) {
					dbConnection.close();
				}

			}
		} catch (SQLException e) {
			// TODO: handle exception
			mensaje = "Erro SQL " + e;
		}
		

		
		return mensaje;
		
	}

}

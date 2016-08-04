package com.skar.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skar.bean.SP_buscarcipdni;

public class SP_buscarcipdniDAO {

	public SP_buscarcipdni getSP(String nroDoc){
		CallableStatement cstmt = null;
		ResultSet rs = null;
		SP_buscarcipdni rpta = new SP_buscarcipdni();
		try {

			Connection conn = (new ConnModel()).dbConnect();
			try
			{
				cstmt = conn.prepareCall(
						"{call usp_Expediente_Buscar_Cip_Dni(?)}");
				cstmt.setString(1, nroDoc);
				cstmt.execute();
				rs = cstmt.getResultSet();

				rpta.setMensaje("No se encontro registro");
				if (rs.next()){
					rpta.setPer_persc_vdni(rs.getString(1));
					rpta.setPer_persc_vnombres(rs.getString(2));
					rpta.setPer_persc_vapellido_paterno(rs.getString(3));
					rpta.setPer_persc_vapellido_materno(rs.getString(4));
					rpta.setCodExpediente(rs.getString(5));
					rpta.setEx_fechaCreacion(rs.getString(6));
					rpta.setEx_estado(rs.getString(7));
					rpta.setCau_idCausal(rs.getString(8));
					rpta.setCau_nombreCausal(rs.getString(9));
					rpta.setFechaPago(rs.getString(10));
					rpta.setHorarioAtencion(rs.getString(11));
					rpta.setMensaje("Registro Encontrado");
				}	

			}
			catch (Exception e){
				e.printStackTrace();
				rpta.setMensaje("Problemas con el servicio de Foserece");
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
			rpta.setMensaje("Problemas con el servicio de Foserece.");
		}

		return rpta;
	}

}

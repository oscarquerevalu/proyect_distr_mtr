package com.skar.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skar.bean.SP_expedientedetalle;

public class SP_ExpedienteDetalleDAO {

	public List<SP_expedientedetalle> getSP(String nroDoc,int param){
		CallableStatement cstmt = null;
		ResultSet rs = null;
		List<SP_expedientedetalle> rptaLst = new ArrayList<SP_expedientedetalle>();
		try {

			Connection conn = (new ConnModel()).dbConnect();
			try
			{
				cstmt = conn.prepareCall(
						"{call usp_ExpedienteDetalle_Listar(?,?)}");
				cstmt.setString(1, nroDoc);
				cstmt.setInt(2, param);
				cstmt.execute();
				rs = cstmt.getResultSet();
				while(rs.next()){
					SP_expedientedetalle rpta = new SP_expedientedetalle();
					rpta.setIdDetExpediente(rs.getString(1));
					rpta.setCodExpediente(rs.getString(2));
					rpta.setIdDocumento(rs.getString(3));
					rpta.setNombreDocumento(rs.getString(4));
					rpta.setNroDocumento(rs.getString(5));
					rpta.setFechaDocumento(rs.getString(6));
					rpta.setActivo(rs.getString(7));
					rpta.setDocumentoDigital(rs.getString(8));
					rpta.setComentario(rs.getString(9));
					rpta.setBeneficiarioNombre(rs.getString(10));
					rpta.setBeneficiarioDNI(rs.getString(11));
					rpta.setTipoRequisito(rs.getString(12));
					rpta.setArchivo(rs.getString(13));
					rpta.setImagen(rs.getString(14));
					rpta.setVerTextBoxs(rs.getString(15));
					rptaLst.add(rpta);
				}	

			}
			catch (Exception e){
				e.printStackTrace();
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
		}

		return rptaLst;
	}

}

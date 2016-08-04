package com.skar.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SP_expedientedetalle {
	
	private String idDetExpediente;
	private String codExpediente;
	private String idDocumento;
	private String nombreDocumento; 
	private String nroDocumento;
	private String fechaDocumento;   
	private String activo;    
	private String documentoDigital;   
	private String comentario;    
	private String beneficiarioNombre;   
	private String beneficiarioDNI;
	private String tipoRequisito;    
	private String archivo;   
	private String imagen;
	private String verTextBoxs;
	public String getCodExpediente() {
		return codExpediente;
	}
	public void setCodExpediente(String codExpediente) {
		this.codExpediente = codExpediente;
	}
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public String getNombreDocumento() {
		return nombreDocumento;
	}
	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getFechaDocumento() {
		return fechaDocumento;
	}
	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	public String getDocumentoDigital() {
		return documentoDigital;
	}
	public void setDocumentoDigital(String documentoDigital) {
		this.documentoDigital = documentoDigital;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getBeneficiarioNombre() {
		return beneficiarioNombre;
	}
	public void setBeneficiarioNombre(String beneficiarioNombre) {
		this.beneficiarioNombre = beneficiarioNombre;
	}
	public String getBeneficiarioDNI() {
		return beneficiarioDNI;
	}
	public void setBeneficiarioDNI(String beneficiarioDNI) {
		this.beneficiarioDNI = beneficiarioDNI;
	}
	public String getTipoRequisito() {
		return tipoRequisito;
	}
	public void setTipoRequisito(String tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getVerTextBoxs() {
		return verTextBoxs;
	}
	public void setVerTextBoxs(String verTextBoxs) {
		this.verTextBoxs = verTextBoxs;
	}
	public String getIdDetExpediente() {
		return idDetExpediente;
	}
	public void setIdDetExpediente(String idDetExpediente) {
		this.idDetExpediente = idDetExpediente;
	}
}

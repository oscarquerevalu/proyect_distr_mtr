/**
 * WsConsultaDatosSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.mapfre.www;

public interface WsConsultaDatosSoap extends java.rmi.Remote {
    public pe.com.mapfre.www.VEHICULO consultaPlacaXML(java.lang.String numPlaca) throws java.rmi.RemoteException;
    public pe.com.mapfre.www.PERSONA consultaPersonaXML(java.lang.String tipoDoc, java.lang.String numDoc) throws java.rmi.RemoteException;
    public double valor_Sub_Modelo(int p_cod_marca, int p_cod_modelo, int p_cod_sub_modelo, int p_anio_sub_modelo) throws java.rmi.RemoteException;
}

/**
 * WsConsultaDatosLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package pe.com.mapfre.www;

public class WsConsultaDatosLocator extends org.apache.axis.client.Service implements pe.com.mapfre.www.WsConsultaDatos {

    public WsConsultaDatosLocator() {
    }


    public WsConsultaDatosLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsConsultaDatosLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wsConsultaDatosSoap
    private java.lang.String wsConsultaDatosSoap_address = "http://www7.mapfre.com.pe/wsConsultaEQUIFAX/wsConsultaDatos.asmx";

    public java.lang.String getwsConsultaDatosSoapAddress() {
        return wsConsultaDatosSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsConsultaDatosSoapWSDDServiceName = "wsConsultaDatosSoap";

    public java.lang.String getwsConsultaDatosSoapWSDDServiceName() {
        return wsConsultaDatosSoapWSDDServiceName;
    }

    public void setwsConsultaDatosSoapWSDDServiceName(java.lang.String name) {
        wsConsultaDatosSoapWSDDServiceName = name;
    }

    public pe.com.mapfre.www.WsConsultaDatosSoap getwsConsultaDatosSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsConsultaDatosSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsConsultaDatosSoap(endpoint);
    }

    public pe.com.mapfre.www.WsConsultaDatosSoap getwsConsultaDatosSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            pe.com.mapfre.www.WsConsultaDatosSoapStub _stub = new pe.com.mapfre.www.WsConsultaDatosSoapStub(portAddress, this);
            _stub.setPortName(getwsConsultaDatosSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsConsultaDatosSoapEndpointAddress(java.lang.String address) {
        wsConsultaDatosSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (pe.com.mapfre.www.WsConsultaDatosSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                pe.com.mapfre.www.WsConsultaDatosSoapStub _stub = new pe.com.mapfre.www.WsConsultaDatosSoapStub(new java.net.URL(wsConsultaDatosSoap_address), this);
                _stub.setPortName(getwsConsultaDatosSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("wsConsultaDatosSoap".equals(inputPortName)) {
            return getwsConsultaDatosSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.mapfre.com.pe/", "wsConsultaDatos");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.mapfre.com.pe/", "wsConsultaDatosSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wsConsultaDatosSoap".equals(portName)) {
            setwsConsultaDatosSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

package pe.com.mapfre.www;

public class WsConsultaDatosSoapProxy implements pe.com.mapfre.www.WsConsultaDatosSoap {
  private String _endpoint = null;
  private pe.com.mapfre.www.WsConsultaDatosSoap wsConsultaDatosSoap = null;
  
  public WsConsultaDatosSoapProxy() {
    _initWsConsultaDatosSoapProxy();
  }
  
  public WsConsultaDatosSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsConsultaDatosSoapProxy();
  }
  
  private void _initWsConsultaDatosSoapProxy() {
    try {
      wsConsultaDatosSoap = (new pe.com.mapfre.www.WsConsultaDatosLocator()).getwsConsultaDatosSoap();
      if (wsConsultaDatosSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsConsultaDatosSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsConsultaDatosSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsConsultaDatosSoap != null)
      ((javax.xml.rpc.Stub)wsConsultaDatosSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public pe.com.mapfre.www.WsConsultaDatosSoap getWsConsultaDatosSoap() {
    if (wsConsultaDatosSoap == null)
      _initWsConsultaDatosSoapProxy();
    return wsConsultaDatosSoap;
  }
  
  public pe.com.mapfre.www.VEHICULO consultaPlacaXML(java.lang.String numPlaca) throws java.rmi.RemoteException{
    if (wsConsultaDatosSoap == null)
      _initWsConsultaDatosSoapProxy();
    return wsConsultaDatosSoap.consultaPlacaXML(numPlaca);
  }
  
  public pe.com.mapfre.www.PERSONA consultaPersonaXML(java.lang.String tipoDoc, java.lang.String numDoc) throws java.rmi.RemoteException{
    if (wsConsultaDatosSoap == null)
      _initWsConsultaDatosSoapProxy();
    return wsConsultaDatosSoap.consultaPersonaXML(tipoDoc, numDoc);
  }
  
  public double valor_Sub_Modelo(int p_cod_marca, int p_cod_modelo, int p_cod_sub_modelo, int p_anio_sub_modelo) throws java.rmi.RemoteException{
    if (wsConsultaDatosSoap == null)
      _initWsConsultaDatosSoapProxy();
    return wsConsultaDatosSoap.valor_Sub_Modelo(p_cod_marca, p_cod_modelo, p_cod_sub_modelo, p_anio_sub_modelo);
  }
  
  
}
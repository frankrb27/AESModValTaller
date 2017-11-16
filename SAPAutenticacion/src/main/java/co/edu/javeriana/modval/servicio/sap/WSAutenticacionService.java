
package co.edu.javeriana.modval.servicio.sap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * WSDL File for WSAutenticacion
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WSAutenticacion_Service", targetNamespace = "http://www.sap.servicio.com/wsdl/WSAutenticacion.wsdl", wsdlLocation = "file:/C:/Users/frank/git/BancoABC/SAPAutenticacion/src/main/resources/co/edu/javeriana/modval/wsdl/SAPAutenticacion.wsdl")
public class WSAutenticacionService
    extends Service
{

    private final static URL WSAUTENTICACIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException WSAUTENTICACIONSERVICE_EXCEPTION;
    private final static QName WSAUTENTICACIONSERVICE_QNAME = new QName("http://www.sap.servicio.com/wsdl/WSAutenticacion.wsdl", "WSAutenticacion_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/frank/git/BancoABC/SAPAutenticacion/src/main/resources/co/edu/javeriana/modval/wsdl/SAPAutenticacion.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSAUTENTICACIONSERVICE_WSDL_LOCATION = url;
        WSAUTENTICACIONSERVICE_EXCEPTION = e;
    }

    public WSAutenticacionService() {
        super(__getWsdlLocation(), WSAUTENTICACIONSERVICE_QNAME);
    }

    public WSAutenticacionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSAUTENTICACIONSERVICE_QNAME, features);
    }

    public WSAutenticacionService(URL wsdlLocation) {
        super(wsdlLocation, WSAUTENTICACIONSERVICE_QNAME);
    }

    public WSAutenticacionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSAUTENTICACIONSERVICE_QNAME, features);
    }

    public WSAutenticacionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSAutenticacionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WSAutenticacionPortType
     */
    @WebEndpoint(name = "WSAutenticacion_Port")
    public WSAutenticacionPortType getWSAutenticacionPort() {
        return super.getPort(new QName("http://www.sap.servicio.com/wsdl/WSAutenticacion.wsdl", "WSAutenticacion_Port"), WSAutenticacionPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSAutenticacionPortType
     */
    @WebEndpoint(name = "WSAutenticacion_Port")
    public WSAutenticacionPortType getWSAutenticacionPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.sap.servicio.com/wsdl/WSAutenticacion.wsdl", "WSAutenticacion_Port"), WSAutenticacionPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSAUTENTICACIONSERVICE_EXCEPTION!= null) {
            throw WSAUTENTICACIONSERVICE_EXCEPTION;
        }
        return WSAUTENTICACIONSERVICE_WSDL_LOCATION;
    }

}

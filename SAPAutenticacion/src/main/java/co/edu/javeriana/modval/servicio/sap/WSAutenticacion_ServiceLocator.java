/**
 * WSAutenticacion_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.edu.javeriana.modval.servicio.sap;

public class WSAutenticacion_ServiceLocator extends org.apache.axis.client.Service implements co.edu.javeriana.modval.servicio.sap.WSAutenticacion_Service {

/**
 * WSDL File for WSAutenticacion
 */

    public WSAutenticacion_ServiceLocator() {
    }


    public WSAutenticacion_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSAutenticacion_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSAutenticacion_Port
    private java.lang.String WSAutenticacion_Port_address = "http://127.0.0.1:9030/sap-autenticacion/WSAutenticacion/";

    public java.lang.String getWSAutenticacion_PortAddress() {
        return WSAutenticacion_Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSAutenticacion_PortWSDDServiceName = "WSAutenticacion_Port";

    public java.lang.String getWSAutenticacion_PortWSDDServiceName() {
        return WSAutenticacion_PortWSDDServiceName;
    }

    public void setWSAutenticacion_PortWSDDServiceName(java.lang.String name) {
        WSAutenticacion_PortWSDDServiceName = name;
    }

    public co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType getWSAutenticacion_Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSAutenticacion_Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSAutenticacion_Port(endpoint);
    }

    public co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType getWSAutenticacion_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.edu.javeriana.modval.servicio.sap.WSAutenticacion_BindingStub _stub = new co.edu.javeriana.modval.servicio.sap.WSAutenticacion_BindingStub(portAddress, this);
            _stub.setPortName(getWSAutenticacion_PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSAutenticacion_PortEndpointAddress(java.lang.String address) {
        WSAutenticacion_Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                co.edu.javeriana.modval.servicio.sap.WSAutenticacion_BindingStub _stub = new co.edu.javeriana.modval.servicio.sap.WSAutenticacion_BindingStub(new java.net.URL(WSAutenticacion_Port_address), this);
                _stub.setPortName(getWSAutenticacion_PortWSDDServiceName());
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
        if ("WSAutenticacion_Port".equals(inputPortName)) {
            return getWSAutenticacion_Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.examples.com/wsdl/WSAutenticacion.wsdl", "WSAutenticacion_Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.examples.com/wsdl/WSAutenticacion.wsdl", "WSAutenticacion_Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSAutenticacion_Port".equals(portName)) {
            setWSAutenticacion_PortEndpointAddress(address);
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

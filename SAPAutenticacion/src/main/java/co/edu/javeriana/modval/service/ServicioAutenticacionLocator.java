/**
 * ServicioAutenticacionLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.edu.javeriana.modval.service;

public class ServicioAutenticacionLocator extends org.apache.axis.client.Service implements co.edu.javeriana.modval.service.ServicioAutenticacion {

/**
 * WSDL File for Autenticacion
 */

    public ServicioAutenticacionLocator() {
    }


    public ServicioAutenticacionLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioAutenticacionLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AutenticacionInterface
    private java.lang.String AutenticacionInterface_address = "http://www.sap.com/Autenticacion/";

    public java.lang.String getAutenticacionInterfaceAddress() {
        return AutenticacionInterface_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AutenticacionInterfaceWSDDServiceName = "AutenticacionInterface";

    public java.lang.String getAutenticacionInterfaceWSDDServiceName() {
        return AutenticacionInterfaceWSDDServiceName;
    }

    public void setAutenticacionInterfaceWSDDServiceName(java.lang.String name) {
        AutenticacionInterfaceWSDDServiceName = name;
    }

    public co.edu.javeriana.modval.service.AutenticacionInterface getAutenticacionInterface() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AutenticacionInterface_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAutenticacionInterface(endpoint);
    }

    public co.edu.javeriana.modval.service.AutenticacionInterface getAutenticacionInterface(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            co.edu.javeriana.modval.service.Autenticacion_BindingStub _stub = new co.edu.javeriana.modval.service.Autenticacion_BindingStub(portAddress, this);
            _stub.setPortName(getAutenticacionInterfaceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAutenticacionInterfaceEndpointAddress(java.lang.String address) {
        AutenticacionInterface_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.edu.javeriana.modval.service.AutenticacionInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                co.edu.javeriana.modval.service.Autenticacion_BindingStub _stub = new co.edu.javeriana.modval.service.Autenticacion_BindingStub(new java.net.URL(AutenticacionInterface_address), this);
                _stub.setPortName(getAutenticacionInterfaceWSDDServiceName());
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
        if ("AutenticacionInterface".equals(inputPortName)) {
            return getAutenticacionInterface();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.sap.com/wsdl/Autenticacion.wsdl", "ServicioAutenticacion");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.sap.com/wsdl/Autenticacion.wsdl", "AutenticacionInterface"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AutenticacionInterface".equals(portName)) {
            setAutenticacionInterfaceEndpointAddress(address);
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

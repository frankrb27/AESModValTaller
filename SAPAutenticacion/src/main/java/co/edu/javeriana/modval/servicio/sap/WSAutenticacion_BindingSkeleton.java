/**
 * WSAutenticacion_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.edu.javeriana.modval.servicio.sap;

public class WSAutenticacion_BindingSkeleton implements co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType, org.apache.axis.wsdl.Skeleton {
    private co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "clave"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("autenticar", _params, new javax.xml.namespace.QName("", "autorizado"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:examples:wsautenticacion", "autenticar"));
        _oper.setSoapAction("autenticar");
        _myOperationsList.add(_oper);
        if (_myOperations.get("autenticar") == null) {
            _myOperations.put("autenticar", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("autenticar")).add(_oper);
    }

    public WSAutenticacion_BindingSkeleton() {
        this.impl = new co.edu.javeriana.modval.servicio.sap.WSAutenticacion_BindingImpl();
    }

    public WSAutenticacion_BindingSkeleton(co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType impl) {
        this.impl = impl;
    }
    public boolean autenticar(java.lang.String usuario, java.lang.String clave) throws java.rmi.RemoteException
    {
        boolean ret = impl.autenticar(usuario, clave);
        return ret;
    }

}

/**
 * Autenticacion_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.edu.javeriana.modval.service;

public class Autenticacion_BindingSkeleton implements co.edu.javeriana.modval.service.AutenticacionInterface, org.apache.axis.wsdl.Skeleton {
    private co.edu.javeriana.modval.service.AutenticacionInterface impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.sap.com/schemas", "Cliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.sap.com/schemas", "Cliente"), co.edu.javeriana.modval.object.Cliente.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("validar", _params, new javax.xml.namespace.QName("http://www.sap.com/schemas", "ResultadoValidacion"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.sap.com/schemas", "ResultadoValidacion"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "Validar"));
        _oper.setSoapAction("validar");
        _myOperationsList.add(_oper);
        if (_myOperations.get("validar") == null) {
            _myOperations.put("validar", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("validar")).add(_oper);
    }

    public Autenticacion_BindingSkeleton() {
        this.impl = new co.edu.javeriana.modval.service.Autenticacion_BindingImpl();
    }

    public Autenticacion_BindingSkeleton(co.edu.javeriana.modval.service.AutenticacionInterface impl) {
        this.impl = impl;
    }
    public co.edu.javeriana.modval.object.ResultadoValidacion validar(co.edu.javeriana.modval.object.Cliente input) throws java.rmi.RemoteException
    {
        co.edu.javeriana.modval.object.ResultadoValidacion ret = impl.validar(input);
        return ret;
    }

}

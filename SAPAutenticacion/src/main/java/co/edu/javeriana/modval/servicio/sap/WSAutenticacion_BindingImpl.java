/**
 * WSAutenticacion_BindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.edu.javeriana.modval.servicio.sap;

public class WSAutenticacion_BindingImpl implements co.edu.javeriana.modval.servicio.sap.WSAutenticacion_PortType{
    public boolean autenticar(java.lang.String usuario, java.lang.String clave) throws java.rmi.RemoteException {
        return usuario.equals(clave);
    }

}

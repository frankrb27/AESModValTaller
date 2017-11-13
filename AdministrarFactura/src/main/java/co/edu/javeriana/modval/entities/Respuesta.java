package co.edu.javeriana.modval.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Respuesta", propOrder = {
        "factura","mensaje"
})
public class Respuesta {

	private Factura factura;
	private String mensaje;

	/**
	 * Constructor
	 */
	public Respuesta(){}
	
	/**
	 * Constructor con parámetros
	 * @param idConvenio
	 * @param mensaje
	 */
	public Respuesta(Factura factura, String mensaje){
		this.factura = factura;
		this.mensaje = mensaje;
	}
	
	/**
	 * Constructor con parámetros
	 * @param factura
	 */
	public Respuesta(Factura factura){
		this.factura = factura;
	}
	
	/**
	 * Constructor con parámetros
	 * @param mensaje
	 */
	public Respuesta(String mensaje){
		this.mensaje = mensaje;
	}	

	/**
	 * @return the factura
	 */
	public Factura getFactura() {
		return factura;
	}

	/**
	 * @param factura the factura to set
	 */
	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
		
}

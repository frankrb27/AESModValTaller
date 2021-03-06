package co.edu.javeriana.modval.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Respuesta", propOrder = {
        "idConvenio","mensaje"
})
public class Respuesta {

	private String idConvenio;
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
	public Respuesta(String idConvenio, String mensaje){
		this.idConvenio = idConvenio;
		this.mensaje = mensaje;
	}	
	
	/**
	 * @return the idConvenio
	 */
	public String getIdConvenio() {
		return idConvenio;
	}

	/**
	 * @param idConvenio the idConvenio to set
	 */
	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
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

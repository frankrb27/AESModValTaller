package co.edu.javeriana.modval.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	@XmlElement
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
	@XmlElement
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}

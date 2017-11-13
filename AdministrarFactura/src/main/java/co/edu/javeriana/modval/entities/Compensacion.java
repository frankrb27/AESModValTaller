package co.edu.javeriana.modval.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Compensacion", propOrder = {
        "idRadicado","idConvenio","idFactura"
})
public class Compensacion {

	private String idRadicado;
	private String idConvenio;
	private String idFactura;
	
    /**
     * Constructor
     */
    public Compensacion() {}

    /**
     * Constructor
     * @param idRadicado
     * @param idConvenio
     * @param idFactura
     */
    public Compensacion(String idRadicado, String idConvenio, String idFactura) {
    	this.idRadicado = idRadicado;
    	this.idConvenio = idConvenio;
    	this.idFactura = idFactura;
    }

	/**
	 * @return the idRadicado
	 */
	public String getIdRadicado() {
		return idRadicado;
	}

	/**
	 * @param idRadicado the idRadicado to set
	 */
	public void setIdRadicado(String idRadicado) {
		this.idRadicado = idRadicado;
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
	 * @return the idFactura
	 */
	public String getIdFactura() {
		return idFactura;
	}

	/**
	 * @param idFactura the idFactura to set
	 */
	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}    
}

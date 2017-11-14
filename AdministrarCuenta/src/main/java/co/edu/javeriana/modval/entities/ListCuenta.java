package co.edu.javeriana.modval.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Administrador
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListCuenta", propOrder = {
        "cuenta"
})
public class ListCuenta {
	private List<Cuenta> cuenta;
	
	/**
	 * Constructor
	 */
	public ListCuenta (){}
	
	/**
	 * @return the cuenta
	 */
	public List<Cuenta> getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}	
}

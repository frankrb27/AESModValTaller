package co.edu.javeriana.modval.entities;

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
@XmlType(name = "Cuenta", propOrder = {
        "numeroDocumento","idCuenta","tipoCuenta","saldo"
})
public class Cuenta {
	private String numeroDocumento;
	private String idCuenta;
	private String tipoCuenta;
	private double saldo;
	
	/**
	 * Constructor
	 */
	public Cuenta (){}
	
	/**
	 * Constructor
	 * @param numeroDocumento
	 * @param idCuenta
	 * @param tipoCuenta
	 * @param saldo
	 */
	public Cuenta (String numeroDocumento, String idCuenta, String tipoCuenta, double saldo){
		this.numeroDocumento = numeroDocumento;
		this.idCuenta = idCuenta;
		this.tipoCuenta  = tipoCuenta;
		this.saldo = saldo;
	}
	
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the idCuenta
	 */
	public String getIdCuenta() {
		return idCuenta;
	}
	/**
	 * @param idCuenta the idCuenta to set
	 */
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	/**
	 * @return the tipoCuenta
	 */
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	/**
	 * @param tipoCuenta the tipoCuenta to set
	 */
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}

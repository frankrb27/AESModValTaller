package co.edu.javeriana.modval.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListConvenio", propOrder = {
        "convenio"
})
public class ListConvenio {

	private List<Convenio> convenio;
	
    /**
     * Constructor
     */
    public ListConvenio() {}

	/**
	 * @return the convenio
	 */
	public List<Convenio> getConvenio() {
		return convenio;
	}

	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(List<Convenio> convenio) {
		this.convenio = convenio;
	}
	
}
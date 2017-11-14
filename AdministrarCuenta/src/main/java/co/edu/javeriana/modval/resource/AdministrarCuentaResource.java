package co.edu.javeriana.modval.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.modval.control.AdministrarCuentaService;
import co.edu.javeriana.modval.entities.Cuenta;
import co.edu.javeriana.modval.entities.ListCuenta;

/**
 * @author Administrador
 *
 */
@RestController
@RequestMapping("banco/convenio/v1")
public class AdministrarCuentaResource {

	@Autowired
	private AdministrarCuentaService administrarCuentaService;

	@RequestMapping(path = "cuentas/{idCuenta}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Cuenta consultarCuenta(@PathVariable("idCuenta") String idCuenta) {
		try{
			//Consultar cuenta
			Cuenta cuenta = administrarCuentaService.getCuenta(idCuenta);
			if(cuenta!=null && cuenta.getIdCuenta()!=null){
				return cuenta;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	@RequestMapping(path = "cuentas/cliente/{numeroDocumento}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ListCuenta consultarCuentaPorCliente(@PathVariable("numeroDocumento") String numeroDocumento) {
		try{
			//Consultar cuenta
			ListCuenta listCuenta = administrarCuentaService.getCuentaPorCliente(numeroDocumento);
			if(listCuenta!=null){
				return listCuenta;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}		
}

package co.edu.javeriana.modval.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.modval.control.AdministrarFacturaService;
import co.edu.javeriana.modval.entities.Compensacion;
import co.edu.javeriana.modval.entities.Convenio;
import co.edu.javeriana.modval.entities.Cuenta;
import co.edu.javeriana.modval.entities.Factura;
import co.edu.javeriana.modval.entities.Respuesta;

@RestController
@RequestMapping("banco/convenio/v1")
public class AdministrarFacturaResource {

	@Autowired
	private AdministrarFacturaService consultarFacturaService;

	private static final String TS_SERVER = "127.0.0.1";
	private static final int TS_PORT = 9000;
	private static String TS_URL_CONVENIOS = String.format("http://%s:%d/banco/convenio/v1/convenios/", TS_SERVER, TS_PORT);

	private static final String TS_SERVER_COMPENSACION = "127.0.0.1";
	private static final int TS_PORT_COMPENSACION = 9020;
	private static String TS_URL_COMPENSACION = String.format("http://%s:%d/banco/convenio/v1/compensacion?", TS_SERVER_COMPENSACION, TS_PORT_COMPENSACION);

	private static final String TS_SERVER_CUENTA = "127.0.0.1";
	private static final int TS_PORT_CUENTA = 9040;
	private static String TS_URL_CUENTA = String.format("http://%s:%d/banco/convenio/v1/cuentas/", TS_SERVER_CUENTA, TS_PORT_CUENTA);

	@RequestMapping(path = "factura/{idFactura}", method = RequestMethod.GET,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Respuesta consultarFactura(@PathVariable("idFactura") String idFactura) {
		try{
			//Consultar convenio
			Convenio convenio = consultarFacturaService.getConvenio(TS_URL_CONVENIOS, idFactura.substring(0,5));
			if(convenio!=null && convenio.getUrlConsulta()!=null && convenio.isREST()){
				//Invocar servicio
				String responseXML = consultarFacturaService.invokeRest(convenio.getUrlConsulta().concat(idFactura.substring(5)), HttpMethod.GET);
				Factura factura = consultarFacturaService.getFactura(responseXML,convenio.getTemplateConsulta());
				return new Respuesta(factura);
			}else{
				return new Respuesta("Factura no existe");
			}
		}catch(Exception e){
			e.printStackTrace();
			return new Respuesta("Error al consultar factura");
		}
	}

	@RequestMapping(path = "factura/{idFactura}/{valorFactura}/{idCuenta}", method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Respuesta pagarFactura(@PathVariable("idFactura") String idFactura, @PathVariable("valorFactura") String valorFactura, @PathVariable("idCuenta") String idCuenta) {
		try{
			//Consultar convenio
			Convenio convenio = consultarFacturaService.getConvenio(TS_URL_CONVENIOS, idFactura.substring(0,5));
			Cuenta cuenta = consultarFacturaService.getCuenta(TS_URL_CUENTA, idCuenta);
			if(convenio!=null && convenio.getUrlPago()!=null && convenio.isREST()){
				if(Double.parseDouble(valorFactura) > cuenta.getSaldo()){
					return new Respuesta("La cuenta no tiene fondos suficientes para realizar la transacción");
				}else{
					//Invocar servicio
					String responseXML = consultarFacturaService.invokeRest(convenio.getUrlPago().concat(idFactura.substring(5)), HttpMethod.POST);
					Respuesta respuesta = consultarFacturaService.getRespuesta(responseXML,convenio.getTemplatePago());
					return respuesta;
				}
			}else{
				return new Respuesta("Factura no existe");
			}
		}catch(Exception e){
			e.printStackTrace();
			return new Respuesta("Error al consultar factura");
		}
	}

	@RequestMapping(path = "factura/{idFactura}", method = RequestMethod.DELETE,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Respuesta compensarFactura(@PathVariable("idFactura") String idFactura) {
		try{
			//Consultar convenio
			Convenio convenio = consultarFacturaService.getConvenio(TS_URL_CONVENIOS, idFactura.substring(0,5));
			if(convenio!=null && convenio.getUrlCompensacion()!=null && convenio.isREST()){
				//Invocar servicio
				String responseXML = consultarFacturaService.invokeRest(convenio.getUrlCompensacion().concat(idFactura.substring(5)), HttpMethod.DELETE);
				Respuesta respuesta = consultarFacturaService.getRespuesta(responseXML,convenio.getTemplateCompensacion());
				return respuesta;
			}else{
				Compensacion compensacion = consultarFacturaService.getCompensacion(TS_URL_COMPENSACION, idFactura.substring(0,5), idFactura.substring(5));
				return new Respuesta("El convenio no soporta la operación de compensación, se ha enviado la solicitud al área correspondiente. Número de radicado "+compensacion.getIdRadicado());
			}
		}catch(Exception e){
			e.printStackTrace();
			return new Respuesta("Error al compensar la factura");
		}
	}	
}

package co.edu.javeriana.modval.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.modval.control.AdministrarFacturaService;
import co.edu.javeriana.modval.entities.Convenio;
import co.edu.javeriana.modval.entities.Factura;
import co.edu.javeriana.modval.entities.Respuesta;

@RestController
@RequestMapping("banco/convenio/v1")
public class AdministrarFacturaResource {

	@Autowired
	private AdministrarFacturaService consultarFacturaService;
	
    private static final String TS_SERVER = "localhost";
    private static final int TS_PORT = 9000;
    private static String TS_URL = String.format("http://%s:%d/banco/convenio/v1/convenios/", TS_SERVER, TS_PORT);
    
	@RequestMapping(path = "factura/{idFactura}", method = RequestMethod.GET,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Respuesta consultarConvenio(@PathVariable("idFactura") String idFactura) {
		try{
			//Consultar convenio
			Convenio convenio = consultarFacturaService.getConvenio(TS_URL, idFactura.substring(0,5));
			if(convenio!=null && convenio.getUrlConsulta()!=null){
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
}

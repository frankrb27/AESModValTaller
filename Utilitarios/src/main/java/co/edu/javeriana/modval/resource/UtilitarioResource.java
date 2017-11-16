package co.edu.javeriana.modval.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banco/convenio/v1")
public class UtilitarioResource {

	@RequestMapping(path = "utilitario/{idFactura}/{mensaje}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String generarNotifiacion(@PathVariable("idFactura") String idFactura, @PathVariable("mensaje") String mensaje) {
		System.out.println(String.format("Mensaje enviado: [idFactura: %s, mensaje: %s]", idFactura, mensaje));
		return "Estado: OK";
	}	
}

package co.edu.javeriana.modval.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("banco/convenio/v1")
public class UtilitarioResource {

	@RequestMapping(path = "utilitario/{mensaje}", method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public String generarNotifiacion(@PathVariable("mensaje") String mensaje) {
		return String.format("Estado: OK");
	}	

}

package co.edu.javeriana.modval.resources;

import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.modval.entities.Compensacion;

@RestController
@RequestMapping("banco/convenio/v1")
public class AdministrarCompensacionResource {

	@RequestMapping(path = "compensacion", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Compensacion generarCompensacion(@PathParam("idConvenio") String idConvenio, @PathParam("idFactura") String idFactura) {
		return new Compensacion(String.valueOf(UUID.randomUUID()).split("-")[0], idConvenio, idFactura);
	}	
}

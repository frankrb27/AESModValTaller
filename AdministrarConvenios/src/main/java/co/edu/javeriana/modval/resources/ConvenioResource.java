package co.edu.javeriana.modval.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.modval.control.ConvenioService;
import co.edu.javeriana.modval.entities.Convenio;
import co.edu.javeriana.modval.entities.Respuesta;

@RestController
@RequestMapping("banco/convenio/v1")
public class ConvenioResource {

	@Autowired
	private ConvenioService pagoConvenioService;

	@RequestMapping(path = "convenios/{idConvenio}", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Convenio consultarConvenio(@PathVariable("idConvenio") String idConvenio) {
		try{
			//Consultar convenio
			Convenio convenio = pagoConvenioService.getConvenio(idConvenio);
			if(convenio!=null && convenio.getIdConvenio()!=null && !convenio.getIdConvenio().equals("null")){
				return convenio;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(path = "convenios/{idConvenio}", method = RequestMethod.DELETE,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Respuesta eliminarConvenio(@PathVariable("idConvenio") String idConvenio) {
		try{
			//Consultar convenio
			Convenio convenio = pagoConvenioService.getConvenio(idConvenio);
			if(convenio!=null){
				return new Respuesta(idConvenio, "Convenio eliminado");
			}else{
				System.out.println("Convenio no existe");
				return new Respuesta(idConvenio, "Convenio no existe");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al eliminar el convenio");
			System.out.println(e);
			return new Respuesta(idConvenio, "Error al eliminar el convenio");
		}
	}	
	
	@RequestMapping(path = "convenios/recargar", method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Respuesta recargar() {
		try{
			//Consultar convenio
			pagoConvenioService.cargarConvenios();
			return new Respuesta(null,"Convenios recargados");
		}catch(Exception e){
			e.printStackTrace();
			return new Respuesta(null,"Error al recargar los convenios");
		}
	}	
}

package co.edu.javeriana.modval.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.javeriana.modval.entities.Convenio;
import co.edu.javeriana.modval.entities.ListConvenio;

@Service
public class ConvenioService {
	List<Convenio> listConvenios = null;
	
	/**
	 * Constructor para cargar convenios existentes
	 */
	public ConvenioService() {		
		cargarConvenios();
	}
	
	/**
	 * Cargar convenios registrados en el archivo
	 */
	public void cargarConvenios() {
		File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File ("Convenios/convenios.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         listConvenios = new ArrayList<Convenio>();
	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null) {
	            String convenio[] = linea.split("##");
	            System.out.println("[0]"+convenio[0]);
	            System.out.println("[1]"+convenio[1]);
	            System.out.println("[2]"+convenio[2]);
	            System.out.println("[3]"+convenio[3]);
	            System.out.println("[4]"+convenio[4]);
	            System.out.println("[5]"+convenio[5]);
	            System.out.println("[6]"+convenio[6]);
	            System.out.println("[7]"+convenio[7]);
	            System.out.println("[8]"+convenio[8]);
	            listConvenios.add(new Convenio(convenio[0],
	            		convenio[1],
	            		convenio[2],
	            		convenio[3].equals("null")?null:convenio[2],
	            		convenio[4].equals("null")?null:convenio[3],
	            		convenio[5].equals("null")?null:convenio[4],
	            		convenio[6].equals("null")?null:convenio[5],
	            		convenio[7].equals("null")?null:convenio[6],
	            		convenio[8].equals("true")));
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	/**
	 * Retornar convenio consultado
	 * @param idConvenio
	 * @return
	 */
	public Convenio getConvenio(String idConvenio){
		for(Convenio convenio : listConvenios) {
			if(convenio.getIdConvenio().equals(idConvenio)) {
				return convenio;
			}
		}
		return new Convenio();
	}
	
	/**
	 * Retornar lista de convenio
	 * @return
	 */
	public ListConvenio getConvenio(){
		ListConvenio listConvenio = new ListConvenio();
		List<Convenio> convenios = new ArrayList<Convenio>();
		for(Convenio convenio : listConvenios) {
				convenios.add(convenio);
		}
		listConvenio.setConvenio(convenios);
		return listConvenio;
	}	
}

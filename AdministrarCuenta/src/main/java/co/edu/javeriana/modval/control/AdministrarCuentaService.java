/**
 * 
 */
package co.edu.javeriana.modval.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.javeriana.modval.entities.Cuenta;
import co.edu.javeriana.modval.entities.ListCuenta;

/**
 * @author Administrador
 *
 */
@Service
public class AdministrarCuentaService {

	List<Cuenta> listCuenta = null;

	/**
	 * Constructor para cargar cuentas existentes
	 */
	public AdministrarCuentaService() {		
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
			archivo = new File ("Cuentas/cuentas.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			listCuenta = new ArrayList<Cuenta>();
			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null) {
				String cuenta[] = linea.split("##");
				System.out.println("[0]"+cuenta[0]);
				System.out.println("[1]"+cuenta[1]);
				System.out.println("[2]"+cuenta[2]);
				System.out.println("[3]"+cuenta[3]);
				listCuenta.add(new Cuenta(cuenta[0],
						cuenta[1],
						cuenta[2],
						Double.parseDouble(cuenta[3])));
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
	 * Retornar cuenta consultado
	 * @param idCuenta
	 * @return
	 */
	public Cuenta getCuenta(String idCuenta){
		for(Cuenta cuenta : listCuenta) {
			if(cuenta.getIdCuenta().equals(idCuenta)) {
				return cuenta;
			}
		}
		return new Cuenta();
	}	
	
	/**
	 * Retornar cuentas del cliente
	 * @param numeroDocumento
	 * @return
	 */
	public ListCuenta getCuentaPorCliente(String numeroDocumento){
		ListCuenta cuentaCliente = new ListCuenta();
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		for(Cuenta cuenta : listCuenta) {
			if(cuenta.getNumeroDocumento().equals(numeroDocumento)) {
				cuentas.add(cuenta);
			}
		}
		cuentaCliente.setCuenta(cuentas);
		return cuentaCliente;
	}		
}

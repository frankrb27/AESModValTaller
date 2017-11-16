package co.edu.javeriana.modval;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import io.spring.guides.gs_producing_web_service.Client;

@Component
public class AuthorizationRepository {
	private static final Map<String, Client> client = new HashMap<>();

	@PostConstruct
	public void initData() {
		Client client1 = new Client();
		client1.setName("Cliente de prueba #1");
		client1.setDocumentNumber("101010");
		client1.setAuthorized(true);

		client.put(client1.getDocumentNumber(), client1);

		Client client2 = new Client();
		client2.setName("Cliente de prueba #2");
		client2.setDocumentNumber("101011");
		client2.setAuthorized(true);
		client.put(client2.getDocumentNumber(), client2);

		Client client3 = new Client();
		client3.setName("Cliente de prueba #3");
		client3.setDocumentNumber("101012");
		client3.setAuthorized(true);
		client.put(client3.getDocumentNumber(), client3);
		
		Client client4 = new Client();
		client4.setName("Cliente de prueba #4");
		client4.setDocumentNumber("101013");
		client4.setAuthorized(true);
		client.put(client4.getDocumentNumber(), client4);		
	}

	public Client findClient(String userName, String password) {
		if(userName.equals(password)){
			return client.get(userName);
		}else{
			return null;
		}
	}
}
package co.edu.javeriana.modval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetAuthorizationRequest;
import io.spring.guides.gs_producing_web_service.GetAuthorizationResponse;

@Endpoint
public class AuthorizationEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private AuthorizationRepository authorizationRepository;

	@Autowired
	public AuthorizationEndpoint(AuthorizationRepository authorizationRepository) {
		this.authorizationRepository = authorizationRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAuthorizationRequest")
	@ResponsePayload
	public GetAuthorizationResponse getCountry(@RequestPayload GetAuthorizationRequest request) {
		GetAuthorizationResponse response = new GetAuthorizationResponse();
		response.setClient(authorizationRepository.findClient(request.getUserName(), request.getPassword()));
		return response;
	}
}
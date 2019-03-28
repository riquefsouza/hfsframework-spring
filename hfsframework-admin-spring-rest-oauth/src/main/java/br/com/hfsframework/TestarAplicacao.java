/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import br.com.hfsframework.security.model.UsuarioVO;
import br.com.hfsframework.util.interceptors.HeaderRequestInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class TestarAplicacao.
 */
public class TestarAplicacao {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		RestTemplateBuilder builder = new RestTemplateBuilder();		
		RestTemplate restTemplate = builder.basicAuthentication("admin-hfsframework", "admin").build();
		
		MultiValueMap<String, String> request = new LinkedMultiValueMap<String, String>();
		request.set("username", "henrique");
		request.set("password", "admin");
		request.set("grant_type", "password");
		//request.set("scope", "write");
		//request.set("client_secret", "admin");
		//request.set("client_id", "admin-hfsframework");
		
		Map<String, Object> token = restTemplate
			.postForObject("http://localhost:8080/oauth/token", request, Map.class);
		
		System.out.println("response: " + token + " - " + token.get("access_token"));
				
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "Bearer "+token.get("access_token")));
		interceptors.add(new HeaderRequestInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));

		RestTemplate restTemplate2 = new RestTemplate();
		restTemplate2.setInterceptors(interceptors);
		
        //String admUsuario = restTemplate2.getForObject("http://localhost:8080/admUsuarios", String.class);
		//AdmUsuario admUsuario = restTemplate2.getForObject("http://localhost:8080/admUsuarios/93203", AdmUsuario.class);
        //System.out.println(admUsuario);
		
		//Iterable<UsuarioVO> lista = new ArrayList<>();		
		//ResponseEntity<? extends ArrayList<User>> responseEntity = restTemplate.getForEntity(restEndPointUrl, (Class<? extends ArrayList<User>>)ArrayList.class, userId);		
		//lista = restTemplate2.getForObject("http://localhost:8080/admUsuarios/getListaUsuarioIps", lista.getClass());
		//UsuarioVO[] vetor = restTemplate2.getForObject("http://localhost:8080/admUsuarios/getListaUsuarioIps", UsuarioVO[].class);
		//List<UsuarioVO> lista = Arrays.asList(vetor);
	    
		//for (UsuarioVO item : lista) {
			//System.out.println(item.toString());
		//}
		
		UsuarioVO[] vetor = restTemplate2.getForObject("http://localhost:8080/admUsuarios/getListaUsuarioIps", UsuarioVO[].class);
		List<UsuarioVO> lista = Arrays.asList(vetor);
	    
		for (UsuarioVO item : lista) {
			System.out.println(item.getLogin() + " - " + item.getIp());
		}
		
	}

}

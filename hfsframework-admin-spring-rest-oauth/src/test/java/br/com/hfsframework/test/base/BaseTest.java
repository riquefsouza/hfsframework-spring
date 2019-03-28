/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.test.base;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonFactory;
//import org.springframework.boot.json.JacksonJsonParser;
import com.fasterxml.jackson.core.JsonParser;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseTest.
 */
public abstract class BaseTest {

    /** The content type. */
    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("UTF-8"));
    
    /** The mock mvc. */
    protected MockMvc mockMvc;
    
    /** The mapping jackson 2 http message converter. */
    protected HttpMessageConverter<Object> mappingJackson2HttpMessageConverter;
    
    /** The web application context. */
    @Autowired
	protected WebApplicationContext webApplicationContext;
    
    /** The spring security filter chain. */
    @Autowired
    protected FilterChainProxy springSecurityFilterChain;
    
    /** The access token. */
    protected String accessToken;
    
    /**
     * Sets the converters.
     *
     * @param converters the new converters
     */
    @Autowired
    protected void setConverters(HttpMessageConverter<Object>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull(this.mappingJackson2HttpMessageConverter, 
        		"the JSON message converter must not be null");
    }
    	
	/**
	 * Json.
	 *
	 * @param o the o
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected String json(Object o) throws IOException {
	    MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
	    this.mappingJackson2HttpMessageConverter.write(
	            o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
	    return mockHttpOutputMessage.getBodyAsString();
	}

    /**
     * Obtain access token.
     *
     * @param username the username
     * @param password the password
     * @return the string
     * @throws Exception the exception
     */
    protected String obtainAccessToken(String username, String password) throws Exception {
  	  
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "admin-hfsframework");
        params.add("username", username);
        params.add("password", password);
     
        ResultActions result 
          = mockMvc.perform(post("/oauth/token")
            .params(params)
            .with(httpBasic("admin-hfsframework","admin"))
            .accept(contentType))
            .andExpect(status().isOk())
            .andExpect(content().contentType(contentType));
     
        String resultString = result.andReturn().getResponse().getContentAsString();
     
        //JsonParser jsonParser = new JsonParser();
        JsonParser jsonParser = new JsonFactory().createParser(resultString);
        //return jsonParser.parseMap(resultString).get("access_token").toString();
        return jsonParser.getValueAsString("access_token");
    }
	
}

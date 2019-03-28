/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.test.admin;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.hfsframework.Aplicacao;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.test.base.BaseTest;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmPerfilRestTest extends BaseTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmPerfilRestTest.class);
	
    /** The admPerfil list. */
    private List<AdmPerfil> admPerfilList = new ArrayList<AdmPerfil>();

    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .addFilter(springSecurityFilterChain).build();
        
        accessToken = obtainAccessToken("henrique.souza", "admin");
                
        admPerfilList.add(new AdmPerfil(1L, "Geral", true, false));
        admPerfilList.add(new AdmPerfil(2L, "Administrador", false, true));
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admPerfilList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(post("/admPerfils")
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(bean))
					        .contentType(contentType))
					        .andExpect(status().isOk());
					
					log.info(bean.getId() + " - " + bean.getDescricao());
					
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
    	);
    }

    /**
     * B listar.
     *
     * @throws Exception the exception
     */
    @Test
    public void b_listar() throws Exception {
        mockMvc.perform(get("/admPerfils")
        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(this.admPerfilList.size())))
                .andExpect(jsonPath("$[0].id", is(this.admPerfilList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].nomeCargo", is(this.admPerfilList.get(0).getDescricao())))
                .andExpect(jsonPath("$[1].id", is(this.admPerfilList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].nomeCargo", is(this.admPerfilList.get(1).getDescricao())));
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
    	this.admPerfilList.stream().forEach(bean -> 
        {
			try {
		        mockMvc.perform(get("/admPerfils/" + bean.getId())
		        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
		                .andExpect(status().isOk())
		                .andExpect(content().contentType(contentType))
		                .andExpect(jsonPath("$.id", is(bean.getId().intValue())))
		                .andExpect(jsonPath("$.nomeCargo", is(bean.getDescricao())));
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	);
    }
    
    /**
     * D update.
     *
     * @throws Exception the exception
     */
    @Test
    public void d_update() throws Exception {
    	this.admPerfilList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(put("/admPerfils/"+bean.getId())
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(bean))
					        .contentType(contentType))
					        .andExpect(status().isOk());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
    	);
    }

    /**
     * E delete.
     *
     * @throws Exception the exception
     */
    @Test
    public void e_delete() throws Exception {
    	this.admPerfilList.stream().forEach(bean -> 
    		{
				try {
			        mockMvc.perform(delete("/admPerfils/"+bean.getId())
			        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
			                .andExpect(status().isNoContent());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

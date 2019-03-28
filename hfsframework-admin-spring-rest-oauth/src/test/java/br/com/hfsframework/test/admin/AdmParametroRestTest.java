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
import br.com.hfsframework.admin.model.AdmParametro;
import br.com.hfsframework.test.base.BaseTest;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmParametroRestTest extends BaseTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmParametroRestTest.class);
	
    /** The admParametro list. */
    private List<AdmParametro> admParametroList = new ArrayList<AdmParametro>();

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
        
    	admParametroList.add(new AdmParametro(1L, "Tribunal Regional do Trabalho da 1a. Região", "Nome do tribunal onde o sistema está instalado.", "NOME_TRIBUNAL", 1L));
    	admParametroList.add(new AdmParametro(2L, "TRT1", "Sigla do tribunal onde o sistema está instalado.", "SIGLA_TRIBUNAL", 1L));
    	admParametroList.add(new AdmParametro(3L, "080009", "Código númérico de 6 dígitos que identifica o órgão no SIAFI.", "CODIGO_UNIDADE_GESTORA", 1L));
    	admParametroList.add(new AdmParametro(4L, "102", "Código númérico de 3 dígitos da UG no código de barras da GRU.", "APELIDO_UNIDADE_GESTORA", 1L));
    	admParametroList.add(new AdmParametro(5L, "false", "Bloquear o sistema para que os usuários, exceto do administador, não façam login", "BLOQUEAR_LOGIN", 2L));
    	admParametroList.add(new AdmParametro(6L, "Produção", "Define o ambiente onde o sistema está instalado. Este parâmetro pode ser preenchido com: desenvolvimento, homologação ou produção", "AMBIENTE_SISTEMA", 2L));
    	admParametroList.add(new AdmParametro(7L, "NOME_USUARIO", "Define o atributo usado para efetuar login no sistema. Este parâmetro pode ser preenchido com: NOME_USUARIO ou CPF", "ATRIBUTO_LOGIN", 2L));
    	admParametroList.add(new AdmParametro(8L, "smtp.com.br", "Servidor SMTP para que o sistema envie e-mail.", "SMTP_SERVIDOR", 3L));
    	admParametroList.add(new AdmParametro(9L, "25", "Porta do servidor SMTP para que o sistema envie e-mail.", "SMTP_PORTA", 3L));
    	admParametroList.add(new AdmParametro(10L, null, "Usuário para login no servidor SMTP.", "SMTP_USERNAME", 3L));
    	admParametroList.add(new AdmParametro(11L, null, "Senha para login no servidor SMTP.", "SMTP_PASSWORD", 3L));
    	admParametroList.add(new AdmParametro(12L, "sistema@teste.com.br", "E-mail do sistema.", "SMTP_EMAIL_FROM", 3L));
    	admParametroList.add(new AdmParametro(13L, "teste.com.br", "Servidor do Proxy.", "PROXY_SERVIDOR", 4L));
    	admParametroList.add(new AdmParametro(14L, "8080", "Porta do Proxy.", "PROXY_PORTA", 4L));
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admParametroList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(post("/admParametros")
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
        mockMvc.perform(get("/admParametros")
        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(this.admParametroList.size())))
                .andExpect(jsonPath("$[0].id", is(this.admParametroList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].nomeCargo", is(this.admParametroList.get(0).getDescricao())))
                .andExpect(jsonPath("$[1].id", is(this.admParametroList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].nomeCargo", is(this.admParametroList.get(1).getDescricao())));
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
    	this.admParametroList.stream().forEach(bean -> 
        {
			try {
		        mockMvc.perform(get("/admParametros/" + bean.getId())
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
    	this.admParametroList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(put("/admParametros/"+bean.getId())
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
    	this.admParametroList.stream().forEach(bean -> 
    		{
				try {
			        mockMvc.perform(delete("/admParametros/"+bean.getId())
			        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
			                .andExpect(status().isNoContent());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

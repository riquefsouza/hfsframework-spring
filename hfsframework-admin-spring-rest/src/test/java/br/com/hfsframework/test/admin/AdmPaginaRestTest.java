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
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.test.base.BaseTest;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPaginaRestTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmPaginaRestTest extends BaseTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmPaginaRestTest.class);
	
    /** The admPagina list. */
    private List<AdmPagina> admPaginaList = new ArrayList<AdmPagina>();

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
        
        
        admPaginaList.add(new AdmPagina(1L,"admin/admParametroCategoria/listarAdmParametroCategoria.xhtml", "Categoria dos Parâmetros de Configuração (Administrativo)"));
        admPaginaList.add(new AdmPagina(2L,"admin/admParametroCategoria/editarAdmParametroCategoria.xhtml", "Editar Categoria dos Parâmetros de Configuração (Administrativo)"));
        admPaginaList.add(new AdmPagina(3L,"admin/admParametro/listarAdmParametro.xhtml", "Parâmetros de Configuração (Administrativo)"));
        admPaginaList.add(new AdmPagina(4L,"admin/admParametro/editarAdmParametro.xhtml", "Editar Parâmetros de Configuração (Administrativo)"));
        admPaginaList.add(new AdmPagina(5L,"admin/admPerfil/listarAdmPerfil.xhtml", "Administrar Perfil (Administrativo)"));
        admPaginaList.add(new AdmPagina(6L,"admin/admPerfil/editarAdmPerfil.xhtml", "Editar Administrar Perfil (Administrativo)"));
        admPaginaList.add(new AdmPagina(7L,"admin/admPagina/listarAdmPagina.xhtml", "Administrar Página (Administrativo)"));
        admPaginaList.add(new AdmPagina(8L,"admin/admPagina/editarAdmPagina.xhtml", "Editar Administrar Página (Administrativo)"));
        admPaginaList.add(new AdmPagina(9L,"admin/admMenu/listarAdmMenu.xhtml", "Administrar Menu (Administrativo)"));
        admPaginaList.add(new AdmPagina(10L,"admin/admMenu/editarAdmMenu.xhtml", "Editar Administrar Menu (Administrativo)"));
        admPaginaList.add(new AdmPagina(11L,"admin/admUsuario/listarAdmUsuario.xhtml", "Administrar Usuário (Administrativo)"));
        admPaginaList.add(new AdmPagina(12L,"admin/admUsuario/editarAdmUsuario.xhtml", "Editar Administrar Usuário (Administrativo)"));
        admPaginaList.add(new AdmPagina(13L,"admin/vwAdmLog/listarVwAdmLog.xhtml", "Visualizar os Logs de Auditoria (Administrativo)"));
        admPaginaList.add(new AdmPagina(16L,"admin/visualizarArqLogServidor.xhtml", "Visualizar Arquivo de Log do Servidor (Administrativo)"));
        admPaginaList.add(new AdmPagina(17L,"alterarSenha.xhtml", "Alterar Senha"));


    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admPaginaList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(post("/admPaginas")
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(bean))
					        .contentType(contentType))
					        .andExpect(status().isOk());
					
					log.info(bean.getId() + " - " + bean.getDescricao() + " - " + bean.getUrl());
					
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
        mockMvc.perform(get("/admPaginas")
        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(this.admPaginaList.size())))
                .andExpect(jsonPath("$[0].id", is(this.admPaginaList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].descricao", is(this.admPaginaList.get(0).getDescricao())))
                .andExpect(jsonPath("$[0].url", is(this.admPaginaList.get(0).getUrl())))
                .andExpect(jsonPath("$[1].id", is(this.admPaginaList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].descricao", is(this.admPaginaList.get(1).getDescricao())))
        		.andExpect(jsonPath("$[1].url", is(this.admPaginaList.get(1).getUrl())));
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
    	this.admPaginaList.stream().forEach(bean -> 
        {
			try {
		        mockMvc.perform(get("/admPaginas/" + bean.getId())
		        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
		                .andExpect(status().isOk())
		                .andExpect(content().contentType(contentType))
		                .andExpect(jsonPath("$.id", is(bean.getId().intValue())))
		                .andExpect(jsonPath("$.descricao", is(bean.getDescricao())))
		                .andExpect(jsonPath("$.url", is(bean.getUrl())));
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
    	this.admPaginaList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(put("/admPaginas/"+bean.getId())
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
    	this.admPaginaList.stream().forEach(bean -> 
    		{
				try {
			        mockMvc.perform(delete("/admPaginas/"+bean.getId())
			        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
			                .andExpect(status().isNoContent());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

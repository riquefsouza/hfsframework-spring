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
        
        
        admPaginaList.add(new AdmPagina(1L,"admin/admParametroCategoria/listarAdmParametroCategoria.xhtml", "br.com.hfsframework.admin.view.admParametroCategoria.AdmParametroCategoriaMB"));
        admPaginaList.add(new AdmPagina(2L,"admin/admParametroCategoria/editarAdmParametroCategoria.xhtml", "br.com.hfsframework.admin.view.admParametroCategoria.AdmParametroCategoriaMB"));
        admPaginaList.add(new AdmPagina(3L,"admin/admParametro/listarAdmParametro.xhtml", "br.com.hfsframework.admin.view.admParametro.AdmParametroMB"));
        admPaginaList.add(new AdmPagina(4L,"admin/admParametro/editarAdmParametro.xhtml", "br.com.hfsframework.admin.view.admParametro.AdmParametroMB"));
        admPaginaList.add(new AdmPagina(5L,"admin/admPerfil/listarAdmPerfil.xhtml", "br.com.hfsframework.admin.view.admPerfil.AdmPerfilMB"));
        admPaginaList.add(new AdmPagina(6L,"admin/admPerfil/editarAdmPerfil.xhtml", "br.com.hfsframework.admin.view.admPerfil.AdmPerfilMB"));
        admPaginaList.add(new AdmPagina(7L,"admin/admFuncionalidade/listarAdmFuncionalidade.xhtml", "br.com.hfsframework.admin.view.admFuncionalidade.AdmFuncionalidadeMB"));
        admPaginaList.add(new AdmPagina(8L,"admin/admFuncionalidade/editarAdmFuncionalidade.xhtml", "br.com.hfsframework.admin.view.admFuncionalidade.AdmFuncionalidadeMB"));
        admPaginaList.add(new AdmPagina(9L,"admin/admPagina/listarAdmPagina.xhtml", "br.com.hfsframework.admin.view.admPagina.AdmPaginaMB"));
        admPaginaList.add(new AdmPagina(10L,"admin/admPagina/editarAdmPagina.xhtml", "br.com.hfsframework.admin.view.admPagina.AdmPaginaMB"));
        admPaginaList.add(new AdmPagina(11L,"admin/admMenu/listarAdmMenu.xhtml", "br.com.hfsframework.admin.view.admMenu.AdmMenuMB"));
        admPaginaList.add(new AdmPagina(12L,"admin/admMenu/editarAdmMenu.xhtml", "br.com.hfsframework.admin.view.admMenu.AdmMenuMB"));
        admPaginaList.add(new AdmPagina(13L,"admin/admCargo/listarAdmCargo.xhtml", "br.com.hfsframework.admin.view.admCargo.AdmCargoMB"));
        admPaginaList.add(new AdmPagina(14L,"admin/admCargo/editarAdmCargo.xhtml", "br.com.hfsframework.admin.view.admCargo.AdmCargoMB"));
        admPaginaList.add(new AdmPagina(15L,"admin/admFuncionario/listarAdmFuncionario.xhtml", "br.com.hfsframework.admin.view.admFuncionario.AdmFuncionarioMB"));
        admPaginaList.add(new AdmPagina(16L,"admin/admFuncionario/editarAdmFuncionario.xhtml", "br.com.hfsframework.admin.view.admFuncionario.AdmFuncionarioMB"));
        admPaginaList.add(new AdmPagina(17L,"admin/admSetor/listarAdmSetor.xhtml", "br.com.hfsframework.admin.view.admSetor.AdmSetorMB"));
        admPaginaList.add(new AdmPagina(18L,"admin/admSetor/editarAdmSetor.xhtml", "br.com.hfsframework.admin.view.admSetor.AdmSetorMB"));
        admPaginaList.add(new AdmPagina(19L,"admin/admUsuario/listarAdmUsuario.xhtml", "br.com.hfsframework.admin.view.admUsuario.AdmUsuarioMB"));
        admPaginaList.add(new AdmPagina(20L,"admin/vwAdmLog/listarVwAdmLog.xhtml", "br.com.hfsframework.admin.view.vwAdmLog.VwAdmLogMB"));
        admPaginaList.add(new AdmPagina(21L,"admin/admLogColuna/listarAdmLogColuna.xhtml", "br.com.hfsframework.admin.view.admLogColuna.AdmLogColunaMB"));
        admPaginaList.add(new AdmPagina(22L,"admin/admLogColuna/editarAdmLogColuna.xhtml", "br.com.hfsframework.admin.view.admLogColuna.AdmLogColunaMB"));
        admPaginaList.add(new AdmPagina(23L,"admin/visualizarArqLogServidor.xhtml", "br.com.hfsframework.admin.view.VisualizarArqLogServidorMB"));

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
					
					log.info(bean.getId() + " - " + bean.getManagedBean() + " - " + bean.getUrl());
					
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
                .andExpect(jsonPath("$[0].managedBean", is(this.admPaginaList.get(0).getManagedBean())))
                .andExpect(jsonPath("$[0].url", is(this.admPaginaList.get(0).getUrl())))
                .andExpect(jsonPath("$[1].id", is(this.admPaginaList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].managedBean", is(this.admPaginaList.get(1).getManagedBean())))
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
		                .andExpect(jsonPath("$.managedBean", is(bean.getManagedBean())))
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

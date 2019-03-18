/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.test.admin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hfsframework.Aplicacao;
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.service.AdmPaginaService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPaginaServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmPaginaServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmPaginaServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmPagina> admPaginaList = new ArrayList<AdmPagina>();

    /** The service. */
    @Autowired
    private AdmPaginaService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        
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
					// given
					Optional<AdmPagina> obj = service.insert(bean);
					
					// when
					Optional<AdmPagina> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getDescricao())
						.isEqualTo(obj.get().getDescricao());
					
					log.info(obj.get().getId() + " - " + obj.get().getDescricao());
					
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
    	// given
		List<AdmPagina> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admPaginaList.size())
			.isEqualTo(lista.size());
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
					// given
					Optional<AdmPagina> obj = service.load(bean.getId());
					
					// then
					assertThat(bean.getDescricao())
						.isEqualTo(obj.get().getDescricao());
					
					log.info(bean.getId() + " - " + bean.getDescricao());
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
					// given
					Optional<AdmPagina> obj = service.update(bean);
					
					// when
					Optional<AdmPagina> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getDescricao())
						.isEqualTo(obj.get().getDescricao());
					
					log.info(bean.getId() + " - " + bean.getDescricao());
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
					// given
					service.delete(bean);
					
					// when
					Optional<AdmPagina> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

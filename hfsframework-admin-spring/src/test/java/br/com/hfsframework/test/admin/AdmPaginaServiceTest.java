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
					// given
					Optional<AdmPagina> obj = service.insert(bean);
					
					// when
					Optional<AdmPagina> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getManagedBean())
						.isEqualTo(obj.get().getManagedBean());
					
					log.info(obj.get().getId() + " - " + obj.get().getManagedBean());
					
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
					assertThat(bean.getManagedBean())
						.isEqualTo(obj.get().getManagedBean());
					
					log.info(bean.getId() + " - " + bean.getManagedBean());
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
					assertThat(found.get().getManagedBean())
						.isEqualTo(obj.get().getManagedBean());
					
					log.info(bean.getId() + " - " + bean.getManagedBean());
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

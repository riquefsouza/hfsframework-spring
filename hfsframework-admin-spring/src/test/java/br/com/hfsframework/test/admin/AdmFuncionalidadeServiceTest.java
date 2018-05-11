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
import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.service.AdmFuncionalidadeService;
import br.com.hfsframework.admin.service.AdmPaginaService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionalidadeServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmFuncionalidadeServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmFuncionalidadeServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmFuncionalidade> admFuncionalidadeList = new ArrayList<AdmFuncionalidade>();

    /** The service. */
    @Autowired
    private AdmFuncionalidadeService service;

    @Autowired
    private AdmPaginaService pagService;

    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        
    	admFuncionalidadeList.add(new AdmFuncionalidade(1L,"Categoria dos Parâmetros de Configuração (Administrativo)", pagService.load(1L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(2L,"Editar Categoria dos Parâmetros de Configuração (Administrativo)", pagService.load(2L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(3L,"Parâmetros de Configuração (Administrativo)", pagService.load(3L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(4L,"Editar Parâmetros de Configuração (Administrativo)", pagService.load(4L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(5L,"Administrar Perfil (Administrativo)", pagService.load(5L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(6L,"Editar Administrar Perfil (Administrativo)", pagService.load(6L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(7L,"Administrar Funcionalidade (Administrativo)", pagService.load(7L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(8L,"Editar Administrar Funcionalidade (Administrativo)", pagService.load(8L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(9L,"Administrar Página (Administrativo)", pagService.load(9L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(10L,"Editar Administrar Página (Administrativo)", pagService.load(10L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(11L,"Administrar Menu (Administrativo)", pagService.load(11L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(12L,"Editar Administrar Menu (Administrativo)", pagService.load(12L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(13L,"Administrar os Cargos (Administrativo)", pagService.load(13L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(14L,"Editar Administrar os Cargos (Administrativo)", pagService.load(14L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(15L,"Administrar os Funcionários (Administrativo)", pagService.load(15L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(16L,"Editar Administrar os Funcionários (Administrativo)", pagService.load(16L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(17L,"Administrar os Setores (Administrativo)", pagService.load(17L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(18L,"Editar Administrar os Setores (Administrativo)", pagService.load(18L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(19L,"Visualizar os Usuários (Administrativo)", pagService.load(19L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(20L,"Visualizar os Logs de Auditoria (Administrativo)", pagService.load(20L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(21L,"Administrar os Campos do Log de Auditoria (Administrativo)", pagService.load(21L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(22L,"Editar Administrar os Campos do Log de Auditoria (Administrativo)", pagService.load(22L).get()));
    	admFuncionalidadeList.add(new AdmFuncionalidade(23L,"Visualizar Arquivo de Log do Servidor (Administrativo)", pagService.load(23L).get()));
        
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admFuncionalidadeList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmFuncionalidade> obj = service.insert(bean);
					
					// when
					Optional<AdmFuncionalidade> found = service.load(obj.get().getId());
					
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
		List<AdmFuncionalidade> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admFuncionalidadeList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.admFuncionalidadeList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmFuncionalidade> obj = service.load(bean.getId());
					
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
    	this.admFuncionalidadeList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmFuncionalidade> obj = service.update(bean);
					
					// when
					Optional<AdmFuncionalidade> found = service.load(obj.get().getId());
					
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
    	this.admFuncionalidadeList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmFuncionalidade> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

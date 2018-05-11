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
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.service.AdmMenuService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmMenuServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmMenuServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmMenuServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmMenu> admMenuList = new ArrayList<AdmMenu>();

    /** The service. */
    @Autowired
    private AdmMenuService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        admMenuList.add(new AdmMenu(1L,"Administrativo",null,null,1));
        admMenuList.add(new AdmMenu(2L,"Categoria dos Parâmetros de Configuração (Administrativo)",service.load(1L).get(),1L,2));
        admMenuList.add(new AdmMenu(3L,"Parâmetros de Configuração (Administrativo)",service.load(1L).get(),3L,3));
        admMenuList.add(new AdmMenu(4L,"Administrar Perfil (Administrativo)",service.load(1L).get(),5L,4));
        admMenuList.add(new AdmMenu(5L,"Administrar Funcionalidade (Administrativo)",service.load(1L).get(),7L,5));
        admMenuList.add(new AdmMenu(6L,"Administrar Página (Administrativo)",service.load(1L).get(),9L,6));
        admMenuList.add(new AdmMenu(7L,"Administrar Menu (Administrativo)",service.load(1L).get(),11L,7));
        admMenuList.add(new AdmMenu(8L,"Administrar os Cargos (Administrativo)",service.load(1L).get(),13L,8));
        admMenuList.add(new AdmMenu(9L,"Administrar os Funcionários (Administrativo)",service.load(1L).get(),15L,9));
        admMenuList.add(new AdmMenu(10L,"Administrar os Setores (Administrativo)",service.load(1L).get(),17L,10));
        admMenuList.add(new AdmMenu(11L,"Visualizar os Usuários (Administrativo)",service.load(1L).get(),19L,11));
        admMenuList.add(new AdmMenu(12L,"Visualizar os Logs de Auditoria (Administrativo)",service.load(1L).get(),20L,12));
        admMenuList.add(new AdmMenu(13L,"Administrar os Campos do Log de Auditoria (Administrativo)",service.load(1L).get(),21L,13));
        admMenuList.add(new AdmMenu(14L,"Visualizar Arquivo de Log do Servidor (Administrativo)",service.load(1L).get(),22L,14));       
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admMenuList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmMenu> obj = service.insert(bean);
					
					// when
					Optional<AdmMenu> found = service.load(obj.get().getId());
					
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
		List<AdmMenu> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admMenuList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.admMenuList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmMenu> obj = service.load(bean.getId());
					
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
    	this.admMenuList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmMenu> obj = service.update(bean);
					
					// when
					Optional<AdmMenu> found = service.load(obj.get().getId());
					
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
    	this.admMenuList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmMenu> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

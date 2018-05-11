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
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmPerfilService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmPerfilServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmPerfilServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmPerfilServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmPerfil> admPerfilList = new ArrayList<AdmPerfil>();

    /** The service. */
    @Autowired
    private AdmPerfilService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        
        admPerfilList.add(new AdmPerfil(1L,"Geral", true, false));
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
					// given
					Optional<AdmPerfil> obj = service.insert(bean);
					
					// when
					Optional<AdmPerfil> found = service.load(obj.get().getId());
					
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
		List<AdmPerfil> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admPerfilList.size())
			.isEqualTo(lista.size());
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
					// given
					Optional<AdmPerfil> obj = service.load(bean.getId());
					
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
    	this.admPerfilList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmPerfil> obj = service.update(bean);
					
					// when
					Optional<AdmPerfil> found = service.load(obj.get().getId());
					
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
    	this.admPerfilList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmPerfil> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

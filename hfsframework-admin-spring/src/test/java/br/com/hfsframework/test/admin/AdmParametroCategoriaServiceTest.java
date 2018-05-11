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
import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroCategoriaServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmParametroCategoriaServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmParametroCategoriaServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmParametroCategoria> admParametroCategoriaList = new ArrayList<AdmParametroCategoria>();

    /** The service. */
    @Autowired
    private AdmParametroCategoriaService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        
        admParametroCategoriaList.add(new AdmParametroCategoria(1L, "Parâmetros do Tribunal", 1L));
        admParametroCategoriaList.add(new AdmParametroCategoria(2L, "Parâmetros de Login", 2L));
        admParametroCategoriaList.add(new AdmParametroCategoria(3L, "Parâmetros de E-mail", 3L));
        admParametroCategoriaList.add(new AdmParametroCategoria(4L, "Parâmetros de Conexão de Rede", 4L));
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admParametroCategoriaList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmParametroCategoria> obj = service.insert(bean);
					
					// when
					Optional<AdmParametroCategoria> found = service.load(obj.get().getId());
					
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
		List<AdmParametroCategoria> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admParametroCategoriaList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.admParametroCategoriaList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmParametroCategoria> obj = service.load(bean.getId());
					
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
    	this.admParametroCategoriaList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmParametroCategoria> obj = service.update(bean);
					
					// when
					Optional<AdmParametroCategoria> found = service.load(obj.get().getId());
					
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
    	this.admParametroCategoriaList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmParametroCategoria> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

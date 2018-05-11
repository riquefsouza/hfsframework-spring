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
import br.com.hfsframework.admin.model.AdmLogColuna;
import br.com.hfsframework.admin.service.AdmLogColunaService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmLogColunaServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmLogColunaServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmLogColunaServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmLogColuna> admLogColunaList = new ArrayList<AdmLogColuna>();

    /** The service. */
    @Autowired
    private AdmLogColunaService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {        
        admLogColunaList.add(new AdmLogColuna("nome", "nomeExibicao", "comando"));        
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admLogColunaList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmLogColuna> obj = service.insert(bean);
					
					// when
					Optional<AdmLogColuna> found = service.load(obj.get().getNome());
					
					// then
					assertThat(found.get().getNomeExibicao())
						.isEqualTo(obj.get().getNomeExibicao());
					
					log.info(obj.get().getNome() + " - " + obj.get().getNomeExibicao());
					
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
		List<AdmLogColuna> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admLogColunaList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.admLogColunaList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmLogColuna> obj = service.load(bean.getNome());
					
					// then
					assertThat(bean.getNomeExibicao())
						.isEqualTo(obj.get().getNomeExibicao());
					
					log.info(bean.getNome() + " - " + bean.getNomeExibicao());
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
    	this.admLogColunaList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmLogColuna> obj = service.update(bean);
					
					// when
					Optional<AdmLogColuna> found = service.load(obj.get().getNome());
					
					// then
					assertThat(found.get().getNomeExibicao())
						.isEqualTo(obj.get().getNomeExibicao());
					
					log.info(bean.getNome() + " - " + bean.getNomeExibicao());
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
    	this.admLogColunaList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmLogColuna> found = service.load(bean.getNome());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

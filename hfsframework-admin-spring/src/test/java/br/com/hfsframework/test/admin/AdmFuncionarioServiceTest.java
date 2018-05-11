/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.test.admin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
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
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.service.AdmFuncionarioService;
import br.com.hfsframework.util.DataUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionarioServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmFuncionarioServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmFuncionarioServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmFuncionario> admFuncionarioList = new ArrayList<AdmFuncionario>();

    /** The service. */
    @Autowired
    private AdmFuncionarioService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        admFuncionarioList.add(new AdmFuncionario(93203L, "HENRIQUE FIGUEIREDO DE SOUZA", 
        		new BigDecimal("63266661630"), "henrique.souza@com.br", "(21)3174-1958", "(11)95267-5198", 
        		"DIREM", 77L, DataUtil.toDate("17/03/2014", DataUtil.DATA_PADRAO), null, true));        
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admFuncionarioList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmFuncionario> obj = service.insert(bean);
					
					// when
					Optional<AdmFuncionario> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getNome())
						.isEqualTo(obj.get().getNome());
					
					log.info(obj.get().getId() + " - " + obj.get().getNome());
					
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
		List<AdmFuncionario> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admFuncionarioList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.admFuncionarioList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmFuncionario> obj = service.load(bean.getId());
					
					// then
					assertThat(bean.getNome())
						.isEqualTo(obj.get().getNome());
					
					log.info(bean.getId() + " - " + bean.getNome());
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
    	this.admFuncionarioList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmFuncionario> obj = service.update(bean);
					
					// when
					Optional<AdmFuncionario> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getNome())
						.isEqualTo(obj.get().getNome());
					
					log.info(bean.getId() + " - " + bean.getNome());
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
    	this.admFuncionarioList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmFuncionario> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

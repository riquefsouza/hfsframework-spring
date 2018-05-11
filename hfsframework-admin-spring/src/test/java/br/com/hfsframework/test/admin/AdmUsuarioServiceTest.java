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
import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.util.DataUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuarioServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmUsuarioServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmUsuarioServiceTest.class);
	
    /** The adm cargo list. */
    private List<AdmUsuario> admUsuarioList = new ArrayList<AdmUsuario>();

    /** The service. */
    @Autowired
    private AdmUsuarioService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        admUsuarioList.add(new AdmUsuario(93203L,"henrique.souza","Henrique Figueiredo de Souza", 
        		DataUtil.toDate("17/07/2017 00:00:00",DataUtil.DATA_HORA_PADRAO),
        		new BigDecimal("2685748474"),"riquefsouza@gmail.com","","7ce0359f12857f2a90c7de465f40a95f01cb5da9"));
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admUsuarioList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmUsuario> obj = service.insert(bean);
					
					// when
					Optional<AdmUsuario> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getLogin())
						.isEqualTo(obj.get().getLogin());
					
					log.info(obj.get().getId() + " - " + obj.get().getLogin());
					
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
		List<AdmUsuario> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.admUsuarioList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.admUsuarioList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmUsuario> obj = service.load(bean.getId());
					
					// then
					assertThat(bean.getLogin())
						.isEqualTo(obj.get().getLogin());
					
					log.info(bean.getId() + " - " + bean.getLogin());
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
    	this.admUsuarioList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<AdmUsuario> obj = service.update(bean);
					
					// when
					Optional<AdmUsuario> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getLogin())
						.isEqualTo(obj.get().getLogin());
					
					log.info(bean.getId() + " - " + bean.getLogin());
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
    	this.admUsuarioList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<AdmUsuario> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

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
import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.admin.service.VwAdmLogService;
import br.com.hfsframework.util.DataUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class VwAdmLogServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VwAdmLogServiceTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(VwAdmLogServiceTest.class);
	
    /** The adm cargo list. */
    private List<VwAdmLog> vwAdmLogList = new ArrayList<VwAdmLog>();

    /** The service. */
    @Autowired
    private VwAdmLogService service;
    
    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
    	vwAdmLogList.add(new VwAdmLog(1L,"sem usuario", DataUtil.toDate("2017-11-22 12:07:29",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171122120729L));
    	vwAdmLogList.add(new VwAdmLog(2L,"93203", DataUtil.toDate("2017-10-31 13:18:38",DataUtil.DATA_HORA_JSON_PADRAO),"U","10.1.107.123","Menu","adm_menu","mnu_seq",20171031131838L));
    	vwAdmLogList.add(new VwAdmLog(3L,"sem usuario", DataUtil.toDate("2017-10-31 12:37:09",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","",20171031123709L));
    	vwAdmLogList.add(new VwAdmLog(4L,"sem usuario", DataUtil.toDate("2017-10-31 12:37:02",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","",20171031123702L));
    	vwAdmLogList.add(new VwAdmLog(5L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:53",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq",20171031123653L));
    	vwAdmLogList.add(new VwAdmLog(6L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:36",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Pagina Perfil","adm_pagina_perfil","",20171031123636L));
    	vwAdmLogList.add(new VwAdmLog(7L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:26",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Pagina","adm_pagina","pag_seq",20171031123626L));
    	vwAdmLogList.add(new VwAdmLog(8L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:53",DataUtil.DATA_HORA_JSON_PADRAO),"D","127.0.0.1","Pagina","adm_pagina","pag_seq",20171031123153L));
    	vwAdmLogList.add(new VwAdmLog(9L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:45",DataUtil.DATA_HORA_JSON_PADRAO),"D","127.0.0.1","Pagina Perfil","adm_pagina_perfil","",20171031123145L));
    	vwAdmLogList.add(new VwAdmLog(10L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:33",DataUtil.DATA_HORA_JSON_PADRAO),"D","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq",20171031123133L));
    	vwAdmLogList.add(new VwAdmLog(11L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:23",DataUtil.DATA_HORA_JSON_PADRAO),"D","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","",20171031123123L));
    	vwAdmLogList.add(new VwAdmLog(12L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:14",DataUtil.DATA_HORA_JSON_PADRAO),"D","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","",20171031123114L));
    	vwAdmLogList.add(new VwAdmLog(13L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:04",DataUtil.DATA_HORA_JSON_PADRAO),"D","127.0.0.1","Menu","adm_menu","mnu_seq",20171031123104L));
    	vwAdmLogList.add(new VwAdmLog(14L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:51",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122651L));
    	vwAdmLogList.add(new VwAdmLog(15L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:45",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122645L));
    	vwAdmLogList.add(new VwAdmLog(16L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:43",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122643L));
    	vwAdmLogList.add(new VwAdmLog(17L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:41",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122641L));
    	vwAdmLogList.add(new VwAdmLog(18L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:35",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122635L));
    	vwAdmLogList.add(new VwAdmLog(19L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:32",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122632L));
    	vwAdmLogList.add(new VwAdmLog(20L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:29",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Menu","adm_menu","mnu_seq",20171031122629L));
    	vwAdmLogList.add(new VwAdmLog(21L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:56",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Menu","adm_menu","mnu_seq",20171031121656L));
    	vwAdmLogList.add(new VwAdmLog(22L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:25",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","",20171031121625L));
    	vwAdmLogList.add(new VwAdmLog(23L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:18",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","",20171031121618L));
    	vwAdmLogList.add(new VwAdmLog(24L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:06",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq",20171031121606L));
    	vwAdmLogList.add(new VwAdmLog(25L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:33",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Pagina Perfil","adm_pagina_perfil","",20171031121533L));
    	vwAdmLogList.add(new VwAdmLog(26L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:17",DataUtil.DATA_HORA_JSON_PADRAO),"U","127.0.0.1","Pagina","adm_pagina","pag_seq",20171031121517L));
    	vwAdmLogList.add(new VwAdmLog(27L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:11",DataUtil.DATA_HORA_JSON_PADRAO),"I","127.0.0.1","Pagina","adm_pagina","pag_seq",20171031121511L));
    	
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.vwAdmLogList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<VwAdmLog> obj = service.insert(bean);
					
					// when
					Optional<VwAdmLog> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getTabela())
						.isEqualTo(obj.get().getTabela());
					
					log.info(obj.get().getId() + " - " + obj.get().getTabela());
					
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
		List<VwAdmLog> lista = StreamSupport.stream(service.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		// then
		assertThat(this.vwAdmLogList.size())
			.isEqualTo(lista.size());
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
	    	this.vwAdmLogList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<VwAdmLog> obj = service.load(bean.getId());
					
					// then
					assertThat(bean.getTabela())
						.isEqualTo(obj.get().getTabela());
					
					log.info(bean.getId() + " - " + bean.getTabela());
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
    	this.vwAdmLogList.stream().forEach(bean -> 
	        {
				try {
					// given
					Optional<VwAdmLog> obj = service.update(bean);
					
					// when
					Optional<VwAdmLog> found = service.load(obj.get().getId());
					
					// then
					assertThat(found.get().getTabela())
						.isEqualTo(obj.get().getTabela());
					
					log.info(bean.getId() + " - " + bean.getTabela());
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
    	this.vwAdmLogList.stream().forEach(bean -> 
    		{
				try {
					// given
					service.delete(bean);
					
					// when
					Optional<VwAdmLog> found = service.load(bean.getId());
					
					// then					
					assertEquals(found.isPresent(), false);
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

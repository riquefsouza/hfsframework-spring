/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.test.admin;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.hfsframework.Aplicacao;
import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.test.base.BaseTest;
import br.com.hfsframework.util.DataUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class VwAdmLogValorTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VwAdmLogValorRestTest extends BaseTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(VwAdmLogValorRestTest.class);
	
    /** The vwAdmLogValor list. */
    private List<VwAdmLogValor> vwAdmLogValorList = new ArrayList<VwAdmLogValor>();

    /**
     * Setup.
     *
     * @throws Exception the exception
     */
    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .addFilter(springSecurityFilterChain).build();
        
        accessToken = obtainAccessToken("henrique.souza", "admin");
        
    	vwAdmLogValorList.add(new VwAdmLogValor(1L,"sem usuario", DataUtil.toDate("2017-11-22 12:07:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171122120729L,"seq","14","14"));
    	vwAdmLogValorList.add(new VwAdmLogValor(2L,"sem usuario", DataUtil.toDate("2017-11-22 12:07:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171122120729L,"descricao","Visualizar Arquivo de Log do Servidor (Administrativo)","Visualizar Arquivo de Log do Servidor (Administrativo)"));
    	vwAdmLogValorList.add(new VwAdmLogValor(3L,"sem usuario", DataUtil.toDate("2017-11-22 12:07:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171122120729L,"ordem","14","14"));
    	vwAdmLogValorList.add(new VwAdmLogValor(4L,"sem usuario", DataUtil.toDate("2017-11-22 12:07:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171122120729L,"pai seq","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(5L,"sem usuario", DataUtil.toDate("2017-11-22 12:07:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171122120729L,"fun seq","22","23"));
    	vwAdmLogValorList.add(new VwAdmLogValor(6L,"93203", DataUtil.toDate("2017-10-31 13:18:38", DataUtil.DATA_HORA_JSON_PADRAO), "U","10.1.107.123","Menu","adm_menu","mnu_seq", 20171031131838L,"pai seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(7L,"93203", DataUtil.toDate("2017-10-31 13:18:38", DataUtil.DATA_HORA_JSON_PADRAO), "U","10.1.107.123","Menu","adm_menu","mnu_seq", 20171031131838L,"descricao","Alterar a Senha do Usuário","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(8L,"93203", DataUtil.toDate("2017-10-31 13:18:38", DataUtil.DATA_HORA_JSON_PADRAO), "U","10.1.107.123","Menu","adm_menu","mnu_seq", 20171031131838L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(9L,"93203", DataUtil.toDate("2017-10-31 13:18:38", DataUtil.DATA_HORA_JSON_PADRAO), "U","10.1.107.123","Menu","adm_menu","mnu_seq", 20171031131838L,"ordem","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(10L,"93203", DataUtil.toDate("2017-10-31 13:18:38", DataUtil.DATA_HORA_JSON_PADRAO), "U","10.1.107.123","Menu","adm_menu","mnu_seq", 20171031131838L,"seq","15","15"));
    	vwAdmLogValorList.add(new VwAdmLogValor(11L,"sem usuario", DataUtil.toDate("2017-10-31 12:37:09", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","", 20171031123709L,"prf seq","","2"));
    	vwAdmLogValorList.add(new VwAdmLogValor(12L,"sem usuario", DataUtil.toDate("2017-10-31 12:37:09", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","", 20171031123709L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(13L,"sem usuario", DataUtil.toDate("2017-10-31 12:37:02", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","", 20171031123702L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(14L,"sem usuario", DataUtil.toDate("2017-10-31 12:37:02", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","", 20171031123702L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(15L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:53", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031123653L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(16L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:53", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031123653L,"descricao","","Altera a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(17L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:53", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031123653L,"seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(18L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:36", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina Perfil","adm_pagina_perfil","", 20171031123636L,"prf seq","","2"));
    	vwAdmLogValorList.add(new VwAdmLogValor(19L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:36", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina Perfil","adm_pagina_perfil","", 20171031123636L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(20L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:26", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031123626L,"mb","","br.com.hfsframework.security.AlterarSenhaMB"));
    	vwAdmLogValorList.add(new VwAdmLogValor(21L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:26", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031123626L,"url","","alterarSenha.xhtml"));
    	vwAdmLogValorList.add(new VwAdmLogValor(22L,"sem usuario", DataUtil.toDate("2017-10-31 12:36:26", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031123626L,"seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(23L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:53", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031123153L,"seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(24L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:53", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031123153L,"url","","alterarSenha.xhtml"));
    	vwAdmLogValorList.add(new VwAdmLogValor(25L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:53", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031123153L,"mb","","br.com.hfsframework.security.AlterarSenhaMB"));
    	vwAdmLogValorList.add(new VwAdmLogValor(26L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:45", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Pagina Perfil","adm_pagina_perfil","", 20171031123145L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(27L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:45", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Pagina Perfil","adm_pagina_perfil","", 20171031123145L,"prf seq","","2"));
    	vwAdmLogValorList.add(new VwAdmLogValor(28L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:33", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031123133L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(29L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:33", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031123133L,"seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(30L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:33", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031123133L,"descricao","","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(31L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:23", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","", 20171031123123L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(32L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:23", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","", 20171031123123L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(33L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:14", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","", 20171031123114L,"prf seq","","2"));
    	vwAdmLogValorList.add(new VwAdmLogValor(34L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:14", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","", 20171031123114L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(35L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:04", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031123104L,"pai seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(36L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:04", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031123104L,"seq","","15"));
    	vwAdmLogValorList.add(new VwAdmLogValor(37L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:04", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031123104L,"ordem","","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(38L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:04", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031123104L,"fun seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(39L,"sem usuario", DataUtil.toDate("2017-10-31 12:31:04", DataUtil.DATA_HORA_JSON_PADRAO), "D","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031123104L,"descricao","","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(40L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:51", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122651L,"seq","15","15"));
    	vwAdmLogValorList.add(new VwAdmLogValor(41L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:51", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122651L,"descricao","Alterar a Senha do Usuário","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(42L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:51", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122651L,"fun seq","24",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(43L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:51", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122651L,"pai seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(44L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:51", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122651L,"ordem","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(45L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:45", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122645L,"descricao","Alterar a Senha do Usuário","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(46L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:45", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122645L,"fun seq","24","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(47L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:45", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122645L,"ordem","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(48L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:45", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122645L,"seq","16","15"));
    	vwAdmLogValorList.add(new VwAdmLogValor(49L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:45", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122645L,"pai seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(50L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:43", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122643L,"seq","15","14"));
    	vwAdmLogValorList.add(new VwAdmLogValor(51L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:43", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122643L,"pai seq","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(52L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:43", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122643L,"descricao","Visualizar Arquivo de Log do Servidor (Administrativo)","Visualizar Arquivo de Log do Servidor (Administrativo)"));
    	vwAdmLogValorList.add(new VwAdmLogValor(53L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:43", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122643L,"ordem","14","14"));
    	vwAdmLogValorList.add(new VwAdmLogValor(54L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:43", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122643L,"fun seq","22","22"));
    	vwAdmLogValorList.add(new VwAdmLogValor(55L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:41", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122641L,"fun seq","21","21"));
    	vwAdmLogValorList.add(new VwAdmLogValor(56L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:41", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122641L,"descricao","Administrar os Campos do Log de Auditoria (Administrativo)","Administrar os Campos do Log de Auditoria (Administrativo)"));
    	vwAdmLogValorList.add(new VwAdmLogValor(57L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:41", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122641L,"seq","14","13"));
    	vwAdmLogValorList.add(new VwAdmLogValor(58L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:41", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122641L,"pai seq","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(59L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:41", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122641L,"ordem","13","13"));
    	vwAdmLogValorList.add(new VwAdmLogValor(60L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:35", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122635L,"pai seq","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(61L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:35", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122635L,"seq","13","14"));
    	vwAdmLogValorList.add(new VwAdmLogValor(62L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:35", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122635L,"fun seq","21","21"));
    	vwAdmLogValorList.add(new VwAdmLogValor(63L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:35", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122635L,"descricao","Administrar os Campos do Log de Auditoria (Administrativo)","Administrar os Campos do Log de Auditoria (Administrativo)"));
    	vwAdmLogValorList.add(new VwAdmLogValor(64L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:35", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122635L,"ordem","13","13"));
    	vwAdmLogValorList.add(new VwAdmLogValor(65L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:32", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122632L,"pai seq","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(66L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:32", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122632L,"ordem","14","14"));
    	vwAdmLogValorList.add(new VwAdmLogValor(67L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:32", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122632L,"descricao","Visualizar Arquivo de Log do Servidor (Administrativo)","Visualizar Arquivo de Log do Servidor (Administrativo)"));
    	vwAdmLogValorList.add(new VwAdmLogValor(68L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:32", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122632L,"seq","14","15"));
    	vwAdmLogValorList.add(new VwAdmLogValor(69L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:32", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122632L,"fun seq","22","22"));
    	vwAdmLogValorList.add(new VwAdmLogValor(70L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122629L,"seq","15","16"));
    	vwAdmLogValorList.add(new VwAdmLogValor(71L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122629L,"ordem","1","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(72L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122629L,"descricao","Alterar a Senha do Usuário","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(73L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122629L,"fun seq","24","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(74L,"sem usuario", DataUtil.toDate("2017-10-31 12:26:29", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031122629L,"pai seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(75L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:56", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031121656L,"ordem","","1"));
    	vwAdmLogValorList.add(new VwAdmLogValor(76L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:56", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031121656L,"fun seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(77L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:56", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031121656L,"descricao","","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(78L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:56", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031121656L,"seq","","15"));
    	vwAdmLogValorList.add(new VwAdmLogValor(79L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:56", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Menu","adm_menu","mnu_seq", 20171031121656L,"pai seq","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(80L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:25", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","", 20171031121625L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(81L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:25", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Perfil","adm_funcionalidade_perfil","", 20171031121625L,"prf seq","","2"));
    	vwAdmLogValorList.add(new VwAdmLogValor(82L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:18", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","", 20171031121618L,"fun seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(83L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:18", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade Pagina","adm_funcionalidade_pagina","", 20171031121618L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(84L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:06", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031121606L,"seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(85L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:06", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031121606L,"descricao","","Alterar a Senha do Usuário"));
    	vwAdmLogValorList.add(new VwAdmLogValor(86L,"sem usuario", DataUtil.toDate("2017-10-31 12:16:06", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Funcionalidade","adm_funcionalidade","fun_seq", 20171031121606L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(87L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:33", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina Perfil","adm_pagina_perfil","", 20171031121533L,"prf seq","","2"));
    	vwAdmLogValorList.add(new VwAdmLogValor(88L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:33", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina Perfil","adm_pagina_perfil","", 20171031121533L,"pag seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(89L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:17", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031121517L,"seq","24","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(90L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:17", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031121517L,"mb","","br.com.hfsframework.security.AlterarSenhaMB"));
    	vwAdmLogValorList.add(new VwAdmLogValor(91L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:17", DataUtil.DATA_HORA_JSON_PADRAO), "U","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031121517L,"url","alterarSenha.xhtml","alterarSenha.xhtml"));
    	vwAdmLogValorList.add(new VwAdmLogValor(92L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:11", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031121511L,"mb","",""));
    	vwAdmLogValorList.add(new VwAdmLogValor(93L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:11", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031121511L,"seq","","24"));
    	vwAdmLogValorList.add(new VwAdmLogValor(94L,"sem usuario", DataUtil.toDate("2017-10-31 12:15:11", DataUtil.DATA_HORA_JSON_PADRAO), "I","127.0.0.1","Pagina","adm_pagina","pag_seq", 20171031121511L,"url","","alterarSenha.xhtml"));
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.vwAdmLogValorList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(post("/vwAdmLogValors")
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(bean))
					        .contentType(contentType))
					        .andExpect(status().isOk());
					
					log.info(bean.getId() + " - " + bean.getTabela());
					
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
        mockMvc.perform(get("/vwAdmLogValors")
        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(this.vwAdmLogValorList.size())))
                .andExpect(jsonPath("$[0].id", is(this.vwAdmLogValorList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].tabela", is(this.vwAdmLogValorList.get(0).getTabela())))
                .andExpect(jsonPath("$[1].id", is(this.vwAdmLogValorList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].tabela", is(this.vwAdmLogValorList.get(1).getTabela())));
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
    	this.vwAdmLogValorList.stream().forEach(bean -> 
        {
			try {
		        mockMvc.perform(get("/vwAdmLogValors/" + bean.getId())
		        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
		                .andExpect(status().isOk())
		                .andExpect(content().contentType(contentType))
		                .andExpect(jsonPath("$.id", is(bean.getId().intValue())))
		                .andExpect(jsonPath("$.tabela", is(bean.getTabela())));
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
    	this.vwAdmLogValorList.stream().forEach(bean -> 
	        {
				try {
					mockMvc.perform(put("/vwAdmLogValors/"+bean.getId())
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(bean))
					        .contentType(contentType))
					        .andExpect(status().isOk());
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
    	this.vwAdmLogValorList.stream().forEach(bean -> 
    		{
				try {
			        mockMvc.perform(delete("/vwAdmLogValors/"+bean.getId())
			        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
			                .andExpect(status().isNoContent());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

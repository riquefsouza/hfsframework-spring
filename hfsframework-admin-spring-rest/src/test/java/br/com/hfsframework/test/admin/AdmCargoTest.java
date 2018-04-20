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
import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.test.base.BaseTest;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmCargoTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Aplicacao.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdmCargoTest extends BaseTest {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AdmCargoTest.class);
	
    /** The adm cargo list. */
    private List<AdmCargo> admCargoList = new ArrayList<AdmCargo>();

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
        
        /*
			select 'admCargoList.add(new AdmCargo(' || (row_number() OVER (ORDER BY car_seq)) || 'L,"' || car_descricao || '"));'
			from adm_cargo         
         */
        
        admCargoList.add(new AdmCargo(1L,"DIRETOR GERAL"));
        admCargoList.add(new AdmCargo(2L,"ESCRITURARIO"));
        admCargoList.add(new AdmCargo(3L,"OFICIAL DE JUSTICA AVALIADOR PJ"));
        admCargoList.add(new AdmCargo(4L,"SUPLENTE DE JUIZ DE JCJ"));
        admCargoList.add(new AdmCargo(5L,"CHEFE DE SECRETARIA"));
        admCargoList.add(new AdmCargo(6L,"DIRETOR DE SECRETARIA"));
        admCargoList.add(new AdmCargo(7L,"DIR DISTRIB MANDADOS JUDICIAIS"));
        admCargoList.add(new AdmCargo(8L,"DEPOSITARIO"));
        admCargoList.add(new AdmCargo(9L,"DISTRIBUIDOR DE FEITOS JUDICIAIS"));
        admCargoList.add(new AdmCargo(10L,"JUIZ CORREGEDOR"));
        admCargoList.add(new AdmCargo(11L,"JUIZ VICE CORREGEDOR"));
        admCargoList.add(new AdmCargo(12L,"JUIZ CLASSISTA TRT TRABALHADORES"));
        admCargoList.add(new AdmCargo(13L,"JUIZ CLASSISTA TRT EMPREGADORES"));
        admCargoList.add(new AdmCargo(14L,"JUIZ TOGADO TRT"));
        admCargoList.add(new AdmCargo(15L,"JUIZ CONVOCADO TRT"));
        admCargoList.add(new AdmCargo(16L,"JUIZ TITULAR DE VARA DO TRABALHO"));
        admCargoList.add(new AdmCargo(17L,"JUIZ DESIGNADO VT"));
        admCargoList.add(new AdmCargo(18L,"JUIZ SUBSTITUTO"));
        admCargoList.add(new AdmCargo(19L,"SECRETARIO GERAL DA PRESIDENCIA"));
        admCargoList.add(new AdmCargo(20L,"SUPL JUIZ CLASS REP EMPREGADOS"));
        admCargoList.add(new AdmCargo(21L,"SUPL JUIZ CLASS REP EMPREGADORES"));
        admCargoList.add(new AdmCargo(22L,"SUPL JUIZ CLASS TRT TRABALHADORES"));
        admCargoList.add(new AdmCargo(23L,"SUPL JUIZ CLASS TRT EMPREGADORES"));
        admCargoList.add(new AdmCargo(24L,"JUIZ CLASSISTA REP EMPREGADOS"));
        admCargoList.add(new AdmCargo(25L,"JUIZ CLASSISTA REP EMPREGADORES"));
        admCargoList.add(new AdmCargo(26L,"CARGO EXTINTO"));
        admCargoList.add(new AdmCargo(27L,"FUNCIONARIO ACOMPANHA CONJUGE"));
        admCargoList.add(new AdmCargo(28L,"SERVIDOR REQUISITADO"));
        admCargoList.add(new AdmCargo(29L,"SERVIDOR REMOVIDO"));
        admCargoList.add(new AdmCargo(30L,"ASSESSOR DE JUIZ"));
        admCargoList.add(new AdmCargo(31L,"ASSESSOR DA PRESIDENCIA 3"));
        admCargoList.add(new AdmCargo(32L,"DIRETOR DE SERVICOS"));
        admCargoList.add(new AdmCargo(33L,"DIRETOR DE DIVISAO"));
        admCargoList.add(new AdmCargo(34L,"SECRETARIO DO TRIBUNAL PLENO"));
        admCargoList.add(new AdmCargo(35L,"ASSESSOR DA CORREGEDORIA"));
        admCargoList.add(new AdmCargo(36L,"TECNICO JUDICIARIO (AG ADMIN)"));
        admCargoList.add(new AdmCargo(37L,"TECNICO JUDICIARIO (AG SEG JUD)"));
        admCargoList.add(new AdmCargo(38L,"TECNICO JUDICIARIO (AG TELE ELET)"));
        admCargoList.add(new AdmCargo(39L,"ANALISTA JUDICIARIO (ANALIST SIST)"));
        admCargoList.add(new AdmCargo(40L,"TECNICO JUDICIARIO (ARTIF ART GRAF)"));
        admCargoList.add(new AdmCargo(41L,"TECNICO JUDICIARIO (ART CARP MARC)"));
        admCargoList.add(new AdmCargo(42L,"TECNICO JUDICIARIO (ART ELET COM)"));
        admCargoList.add(new AdmCargo(43L,"TECNICO JUDICIARIO (ARTIF MECAN)"));
        admCargoList.add(new AdmCargo(44L,"ANALISTA JUDICIARIO (ASSIST SOC)"));
        admCargoList.add(new AdmCargo(45L,"TECNICO JUDICIARIO (ATEND JUDIC)"));
        admCargoList.add(new AdmCargo(46L,"TECNICO JUDICIARIO (AUX JUDIC)"));
        admCargoList.add(new AdmCargo(47L,"ANALISTA JUDICIARIO (BIBLIOTEC)"));
        admCargoList.add(new AdmCargo(48L,"ANALISTA JUDICIARIO (CONTADOR)"));
        admCargoList.add(new AdmCargo(49L,"ANALISTA JUDICIARIO (ENFERMEIRO)"));
        admCargoList.add(new AdmCargo(50L,"ANALISTA JUDICIARIO (MEDICO)"));
        admCargoList.add(new AdmCargo(51L,"ANALISTA JUDICIARIO (OF JUST AV)"));
        admCargoList.add(new AdmCargo(52L,"TECNICO JUDICIARIO (OPER COMP)"));
        admCargoList.add(new AdmCargo(53L,"ANALISTA JUDICIARIO (TECN ADM)"));
        admCargoList.add(new AdmCargo(54L,"ANALISTA JUDICIARIO (TECN JUDIC)"));
        admCargoList.add(new AdmCargo(55L,"ASSESSOR DO DIRETOR GERAL"));
        admCargoList.add(new AdmCargo(56L,"TECNICO JUD - AREA JUDICIARIA"));
        admCargoList.add(new AdmCargo(57L,"TECNICO JUD - AREA ADMINISTRATIVA"));
        admCargoList.add(new AdmCargo(58L,"TECNICO JUD - SERV GER(TRANSP E SEG)"));
        admCargoList.add(new AdmCargo(59L,"AGENTE DE SEGURANCA JUDICIARIA"));
        admCargoList.add(new AdmCargo(60L,"TECNICO JUD - SERV GER(TELEC E ELET)"));
        admCargoList.add(new AdmCargo(61L,"TECNICO JUD - SERV GER(ARTES GRAFIC)"));
        admCargoList.add(new AdmCargo(62L,"TECNICO JUD - SERV GER (CARP E MARC)"));
        admCargoList.add(new AdmCargo(63L,"TECNICO JUD - SERV GERAIS (MECANICA)"));
        admCargoList.add(new AdmCargo(64L,"ANALISTA JUD - AESP (SERVICO SOCIAL)"));
        admCargoList.add(new AdmCargo(65L,"ANALISTA JUD - AESP(BIBLIOTECONOMIA)"));
        admCargoList.add(new AdmCargo(66L,"ANALISTA JUD - AESP (ENFERMAGEM)"));
        admCargoList.add(new AdmCargo(67L,"ANALISTA JUD - AESP(PSICOLOGIA)"));
        admCargoList.add(new AdmCargo(68L,"ANALISTA JUD - AREA JUD(EXEC MANDAD)"));
        admCargoList.add(new AdmCargo(69L,"OFICIAL DE JUSTICA AVALIADOR FEDERAL"));
        admCargoList.add(new AdmCargo(70L,"ANALISTA JUD - AREA JUD - OF JUSTICA AVAL FEDERAL"));
        admCargoList.add(new AdmCargo(71L,"ANALISTA JUD - AREA ADM(ADMINISTR)"));
        admCargoList.add(new AdmCargo(72L,"ANALISTA JUD - AREA JUDICIARIA"));
        admCargoList.add(new AdmCargo(73L,"ANALISTA JUD - AREA ADMINISTRATIVA"));
        admCargoList.add(new AdmCargo(74L,"ANALISTA JUD - AREA ADM(PLANEJ)"));
        admCargoList.add(new AdmCargo(75L,"ANALISTA JUD - AREA ADM(CONTABILIDADE)"));
        admCargoList.add(new AdmCargo(76L,"ANALISTA JUD - AESP(MEDICINA)"));
        admCargoList.add(new AdmCargo(77L,"ANALISTA JUD - AESP(TECNO INFORMAÇÃO)"));
        admCargoList.add(new AdmCargo(78L,"ESTAGIARIO - NIVEL MEDIO"));
        admCargoList.add(new AdmCargo(79L,"ESTAGIARIO - NIVEL SUPERIOR"));
        admCargoList.add(new AdmCargo(80L,"ESTAGIARIO - NIVEL SUPERIOR 6H"));
        admCargoList.add(new AdmCargo(81L,"TECNICO JUD - AREA ADM - (SEGURANÇA)"));
        admCargoList.add(new AdmCargo(82L,"TECNICO JUD - AREA ADM - (MECANICA)"));
        admCargoList.add(new AdmCargo(83L,"TECNICO JUD - AREA ADM - (TELEC E ELET)"));
        admCargoList.add(new AdmCargo(84L,"TECNICO JUD - AREA ADM - (CARP E MARC)"));
        admCargoList.add(new AdmCargo(85L,"TECNICO JUD - AREA ADM - ARTES GRÁFICAS"));
        admCargoList.add(new AdmCargo(86L,"TECNICO JUD - AREA ADM - (TRANSPORTE)"));
        admCargoList.add(new AdmCargo(87L,"TECNICO JUD - AESP (TECNO INFORMAÇÃO)"));
        admCargoList.add(new AdmCargo(88L,"TECNICO JUD - AESP (OPERAÇÃO COMP)"));
        admCargoList.add(new AdmCargo(89L,"ANALISTA JUD - AESP(ARQUIVOLOGIA)"));
        admCargoList.add(new AdmCargo(90L,"ANALISTA JUD - AESP(ESTATISTICA)"));
        admCargoList.add(new AdmCargo(91L,"ANALISTA JUD - AESP-(MEDICINA CARDIOLOGIA)"));
        admCargoList.add(new AdmCargo(92L,"ANALISTA JUD - AESP-(MEDICINA DO TRABALHO)"));
        admCargoList.add(new AdmCargo(93L,"ANALISTA JUD - AESP (MEDICINA PSIQUIATRIA)"));
        admCargoList.add(new AdmCargo(94L,"TECNICO JUD - AESP (ENFERMAGEM)"));
        admCargoList.add(new AdmCargo(95L,"COMISSIONADO SEM PROVIMENTO"));
        admCargoList.add(new AdmCargo(96L,"COORDENADOR CJ-2"));
        admCargoList.add(new AdmCargo(97L,"AGENTE ESPECIALIZADO"));
        admCargoList.add(new AdmCargo(98L,"AGENTE ESPECIALIZADO TURMA/GAB."));
        admCargoList.add(new AdmCargo(99L,"ASSESSOR JURIDICO 2"));
        admCargoList.add(new AdmCargo(100L,"ASSESSOR DESEN CON QUAL SEG TEC INF"));
        admCargoList.add(new AdmCargo(101L,"ASSISTENTE DA PRESIDENCIA"));
        admCargoList.add(new AdmCargo(102L,"ASSESSOR DE APOIO EXTERNO E INSTITUC"));
        admCargoList.add(new AdmCargo(103L,"ASSESSOR DA PRESIDENCIA ACC 2"));
        admCargoList.add(new AdmCargo(104L,"ASSISTENTE DE DIRETOR DE SECRETARIA  (VT)"));
        admCargoList.add(new AdmCargo(105L,"ASSISTENTE SECRETARIO DE JUIZ  (VT)"));
        admCargoList.add(new AdmCargo(106L,"ASSISTENTE DE JUIZ SUBSTITUTO"));
        admCargoList.add(new AdmCargo(107L,"SECRETARIO CALCULISTA DE VT"));
        admCargoList.add(new AdmCargo(108L,"ASSESSOR DA PRESIDENCIA 2"));
        admCargoList.add(new AdmCargo(109L,"ASSESSOR DA PRESIDENCIA AJU"));
        admCargoList.add(new AdmCargo(110L,"ASSESSOR DA PRESIDENCIA ACC"));
        admCargoList.add(new AdmCargo(111L,"ASSESSOR DA PRESIDENCIA ARR"));
        admCargoList.add(new AdmCargo(112L,"ASSESSOR DA PRESIDENCIA AIC"));
        admCargoList.add(new AdmCargo(113L,"ASSESSOR DA PRESIDENCIA"));
        admCargoList.add(new AdmCargo(114L,"ASSESSOR DA PRESIDENCIA ACE"));
        admCargoList.add(new AdmCargo(115L,"ASSISTENTE (FC-2)"));
        admCargoList.add(new AdmCargo(116L,"ASSESSOR"));
        admCargoList.add(new AdmCargo(117L,"ASSISTENTE ADMINISTRATIVO"));
        admCargoList.add(new AdmCargo(118L,"ASSISTENTE ADMINISTRATIVO (gab)"));
        admCargoList.add(new AdmCargo(119L,"ASSESSOR ADMINISTRATIVO"));
        admCargoList.add(new AdmCargo(120L,"ASSIST GERAL SECRET PRES"));
        admCargoList.add(new AdmCargo(121L,"ASSISTENTE DIRETOR GERAL"));
        admCargoList.add(new AdmCargo(122L,"ASSISTENTE CHEFE"));
        admCargoList.add(new AdmCargo(123L,"ASSIST CHEFE DE DIVISAO"));
        admCargoList.add(new AdmCargo(124L,"ASSIST DIR SECRETARIA"));
        admCargoList.add(new AdmCargo(125L,"ASSISTENTE DE DIRETOR DE SECRETARIA"));
        admCargoList.add(new AdmCargo(126L,"ASSIST TEC ESPECIALIZADO"));
        admCargoList.add(new AdmCargo(127L,"ASSISTENTE DE GABINETE"));
        admCargoList.add(new AdmCargo(128L,"ASSISTENTE SECRETARIO"));
        admCargoList.add(new AdmCargo(129L,"ASSISTENTE SECRETARIO - GRACO"));
        admCargoList.add(new AdmCargo(130L,"ASSISTENTE SECRETARIO I"));
        admCargoList.add(new AdmCargo(131L,"ASSISTENTE SECRETARIO apoio graco"));
        admCargoList.add(new AdmCargo(132L,"ASSISTENTE DE CHEFE DE POSTO AVANÇADO"));
        admCargoList.add(new AdmCargo(133L,"CHEFE DE POSTO AVANÇADO FC-6"));
        admCargoList.add(new AdmCargo(134L,"ANALISTA ESPECIALIZADO"));
        admCargoList.add(new AdmCargo(135L,"ASSISTENTE DE JUIZ DIRETOR DE FORO DA CAPITAL"));
        admCargoList.add(new AdmCargo(136L,"ANALISTA DE CONTROLE INTERNO"));
        admCargoList.add(new AdmCargo(137L,"ASSISTENTE ESPECIALIZADO"));
        admCargoList.add(new AdmCargo(138L,"SECRETARIO-GERAL DA PRESIDENCIA"));
        admCargoList.add(new AdmCargo(139L,"ASSISTENTE SECRETARIO (jurisp)"));
        admCargoList.add(new AdmCargo(140L,"ASSISTENTE SECRETARIO (socioamb)"));
        admCargoList.add(new AdmCargo(141L,"ASSESSOR DA PRESIDENCIA COORDENADOR"));
        admCargoList.add(new AdmCargo(142L,"CHEFE DE SECAO ESPECIALIZADA"));
        admCargoList.add(new AdmCargo(143L,"ASSESSOR DA PRESIDENCIA I"));
        admCargoList.add(new AdmCargo(144L,"ASSESSOR DA PRESIDENCIA II"));
        admCargoList.add(new AdmCargo(145L,"ASSESSOR DE PLANEJ E ORCAMENTO PRES"));
        admCargoList.add(new AdmCargo(146L,"ASSESSOR TECNICO DE PLANEJ E ORCAMEN"));
        admCargoList.add(new AdmCargo(147L,"CHEFE DE SEC DE TURMA"));
        admCargoList.add(new AdmCargo(148L,"CHEFE DE COORDENADORIA"));
        admCargoList.add(new AdmCargo(149L,"COORDENADOR CPL"));
        admCargoList.add(new AdmCargo(150L,"CHEFE DE GABINETE"));
        admCargoList.add(new AdmCargo(151L,"CHEFE DE GABINETE 2"));
        admCargoList.add(new AdmCargo(152L,"CHEFE DE DIVISAO"));
        admCargoList.add(new AdmCargo(153L,"CHEFE DE COMISSAO"));
        admCargoList.add(new AdmCargo(154L,"ASSISTENTE DE SUPERVISOR"));
        admCargoList.add(new AdmCargo(155L,"DIRETOR-GERAL"));
        admCargoList.add(new AdmCargo(156L,"DIRETOR DA SECRETARIA-GERAL JUDICIÁRIA"));
        admCargoList.add(new AdmCargo(157L,"ESPECIALISTA DE CONTROLE INTERNO"));
        admCargoList.add(new AdmCargo(158L,"ESPECIALISTA EM TECNOLOGIA DA INFORMACAO"));
        admCargoList.add(new AdmCargo(159L,"SUPERVISOR E"));
        admCargoList.add(new AdmCargo(160L,"ASSISTENTE JURIDICO"));
        admCargoList.add(new AdmCargo(161L,"ASSISTENTE DE DIRETOR"));
        admCargoList.add(new AdmCargo(162L,"ASSISTENTE DE COORDENADOR"));
        admCargoList.add(new AdmCargo(163L,"ASSISTENTE DE COORDENADOR DE CPL"));
        admCargoList.add(new AdmCargo(164L,"ANALISTA DA AREA FINANCEIRA"));
        admCargoList.add(new AdmCargo(165L,"ANALISTA DE NEGOCIOS"));
        admCargoList.add(new AdmCargo(166L,"ASSISTENTE DE APOIO"));
        admCargoList.add(new AdmCargo(167L,"ASSISTENTE TECNICO DE PAGAMENTO"));
        admCargoList.add(new AdmCargo(168L,"ASSISTENTE DE DIRETOR GERAL"));
        admCargoList.add(new AdmCargo(169L,"ASSESSOR JURIDICO"));
        admCargoList.add(new AdmCargo(170L,"ASSESSOR DE CONTRATAÇÃO"));
        admCargoList.add(new AdmCargo(171L,"ASSESSOR DE CONFORMIDADE"));
        admCargoList.add(new AdmCargo(172L,"CHEFE DE SECAO"));
        admCargoList.add(new AdmCargo(173L,"ESPECIALISTA DE CONTRATAÇÃO"));
        admCargoList.add(new AdmCargo(174L,"ESPECIALISTA DE MANUTENÇÃO E INFRAESTRUTURA PREDIAL"));
        admCargoList.add(new AdmCargo(175L,"DIRETOR DE DEPARTAMENTO"));
        admCargoList.add(new AdmCargo(176L,"DIRETOR DE SECRETARIA 2"));
        admCargoList.add(new AdmCargo(177L,"DIRETOR DE SECRETARIA DE VT (JCJ)"));
        admCargoList.add(new AdmCargo(178L,"ASSISTENTE DE DIRETOR CJ-1"));
        admCargoList.add(new AdmCargo(179L,"ASSISTENTE (VT)"));
        admCargoList.add(new AdmCargo(180L,"JUIZ CORREGEDOR 2"));
        admCargoList.add(new AdmCargo(181L,"JUIZ VICE CORREGEDOR 2"));
        admCargoList.add(new AdmCargo(182L,"SUPERVISOR DA COMISSÃO DE INVENTÁRIO ALMOX PATRIM"));
        admCargoList.add(new AdmCargo(183L,"SUPERVISOR"));
        admCargoList.add(new AdmCargo(184L,"SUPERVISOR (Ouvidoria)"));
        admCargoList.add(new AdmCargo(185L,"PRESIDENTE DO TRIBUNAL"));
        admCargoList.add(new AdmCargo(186L,"PRESIDENTE COMISSAO PERMANENTE AUDITORIA"));
        admCargoList.add(new AdmCargo(187L,"SECRETARIO GERAL DA PRESIDENCIA 2"));
        admCargoList.add(new AdmCargo(188L,"SECRETARIO DIRETOR GERAL"));
        admCargoList.add(new AdmCargo(189L,"SECRETARIO TRIBUNAL PLENO"));
        admCargoList.add(new AdmCargo(190L,"SECRETARIO DE AUDIENCIAS"));
        admCargoList.add(new AdmCargo(191L,"SECRETARIO ESPEC CALCULISTA"));
        admCargoList.add(new AdmCargo(192L,"SUPERVISOR DE SETOR (extinta)"));
        admCargoList.add(new AdmCargo(193L,"VICE PRESIDENTE DO TRIBUNAL"));
        admCargoList.add(new AdmCargo(194L,"ASSIST CHEFE SECRETARIA"));
        admCargoList.add(new AdmCargo(195L,"BIBLIOTECARIO"));
        admCargoList.add(new AdmCargo(196L,"CEDIDO FC-01 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(197L,"CEDIDO FC-02 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(198L,"CEDIDO FC-03 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(199L,"CEDIDO FC-04 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(200L,"CEDIDO FC-05 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(201L,"CEDIDO FC-06 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(202L,"CEDIDO FC-07 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(203L,"CEDIDO FC-08 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(204L,"CEDIDO FC-09 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(205L,"CEDIDO FC-10 CONTROLE SEC LEGISLACAO"));
        admCargoList.add(new AdmCargo(206L,"CARGO FICTICIO - FUNCIONARIO INATIVO"));
        
    }

    /**
     * A insert.
     *
     * @throws Exception the exception
     */
    @Test
    public void a_insert() throws Exception {
    	this.admCargoList.stream().forEach(cargo -> 
	        {
				try {
					mockMvc.perform(post("/admCargos")
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(cargo))
					        .contentType(contentType))
					        .andExpect(status().isOk());
					
					log.info(cargo.getId() + " - " + cargo.getNomeCargo());
					
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
        mockMvc.perform(get("/admCargos")
        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(this.admCargoList.size())))
                .andExpect(jsonPath("$[0].id", is(this.admCargoList.get(0).getId().intValue())))
                .andExpect(jsonPath("$[0].nomeCargo", is(this.admCargoList.get(0).getNomeCargo())))
                .andExpect(jsonPath("$[1].id", is(this.admCargoList.get(1).getId().intValue())))
                .andExpect(jsonPath("$[1].nomeCargo", is(this.admCargoList.get(1).getNomeCargo())));
    }

    /**
     * C search.
     *
     * @throws Exception the exception
     */
    @Test
    public void c_search() throws Exception {
    	this.admCargoList.stream().forEach(cargo -> 
        {
			try {
		        mockMvc.perform(get("/admCargos/" + cargo.getId())
		        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
		                .andExpect(status().isOk())
		                .andExpect(content().contentType(contentType))
		                .andExpect(jsonPath("$.id", is(cargo.getId().intValue())))
		                .andExpect(jsonPath("$.nomeCargo", is(cargo.getNomeCargo())));
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
    	this.admCargoList.stream().forEach(cargo -> 
	        {
				try {
					mockMvc.perform(put("/admCargos/"+cargo.getId())
							.header("Authorization", "Bearer " + accessToken).accept(contentType)
					        .content(this.json(cargo))
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
    	this.admCargoList.stream().forEach(cargo -> 
    		{
				try {
			        mockMvc.perform(delete("/admCargos/"+cargo.getId())
			        		.header("Authorization", "Bearer " + accessToken).accept(contentType))
			                .andExpect(status().isNoContent());
				} catch (Exception e) {
					log.error(e.getMessage());
				}
			}
		);
    }
    
}

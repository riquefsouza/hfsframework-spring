/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view;

import java.io.File;
import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hfsframework.base.view.BaseViewController;
import br.com.hfsframework.util.arquivo.ArquivoUtil;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;
import springfox.documentation.annotations.ApiIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizarArqLogServidorController.
 */
@ApiIgnore
@Controller
@TratamentoErrosEsperados
@RequestMapping("/visualizarArqLogServidorMB")
public class VisualizarArqLogServidorController extends BaseViewController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The mapeamento. */
	private String mapeamento;

	/** The pagina listar. */
	private String paginaListar;
	
	/** The numero linhas. */
	private Integer numeroLinhas;

	/** The conteudo arquivo log. */
	private String conteudoArquivoLog;

	/**
	 * Instantiates a new visualizar arq log servidor MB.
	 */
	public VisualizarArqLogServidorController() {
		this.paginaListar = "/private/admin/visualizarArqLogServidor";
		this.mapeamento = "visualizarArqLogServidorMB";

		this.numeroLinhas = 100;
		this.conteudoArquivoLog = "";
	}
	
	/**
	 * On pesquisar.
	 */
	@PostMapping("/pesquisar")
	public RedirectView onPesquisar(Integer numeroLinhas) {
		String arquivoServerLog = System.getProperty("jboss.server.log.dir") + "/server.log";
		File arquivoLog = new File(arquivoServerLog);
		if (arquivoLog.exists()) {
			this.conteudoArquivoLog = ArquivoUtil.lerNumeroLinhas(arquivoLog, getNumeroLinhas().intValue());
		} else {
			this.conteudoArquivoLog = String.format("Arquivo de log %s não encontrado", new Object[] { arquivoLog });
		}

		return new RedirectView(getMapeamento()+"/listar");
	}

	/**
	 * On limpar pesquisa.
	 */
	@GetMapping("/limpar")
	public RedirectView onLimparPesquisa() {
		this.numeroLinhas = 100;
		this.conteudoArquivoLog = "";
		return new RedirectView(getMapeamento()+"/listar");
	}
	
	/**
	 * Pagina.
	 *
	 * @return the string
	 */
	@GetMapping("/listar")
	public String listar() {
		return paginaListar;
	}

	/**
	 * Cancelar.
	 *
	 * @return the string
	 */
	public String cancelar() {
		return getPaginaDesktop();
	}

	/**
	 * Gets the numero linhas.
	 *
	 * @return the numero linhas
	 */
	public Integer getNumeroLinhas() {
		return numeroLinhas;
	}

	/**
	 * Sets the numero linhas.
	 *
	 * @param numeroLinhas
	 *            the new numero linhas
	 */
	public void setNumeroLinhas(Integer numeroLinhas) {
		this.numeroLinhas = numeroLinhas;
	}

	/**
	 * Gets the conteudo arquivo log.
	 *
	 * @return the conteudo arquivo log
	 */
	public String getConteudoArquivoLog() {
		return conteudoArquivoLog;
	}

	/**
	 * Sets the conteudo arquivo log.
	 *
	 * @param conteudoArquivoLog
	 *            the new conteudo arquivo log
	 */
	public void setConteudoArquivoLog(String conteudoArquivoLog) {
		this.conteudoArquivoLog = conteudoArquivoLog;
	}
	
	/**
	 * Pega o the pagina listar.
	 *
	 * @return o the pagina listar
	 */
	public String getPaginaListar() {
		return paginaListar;
	}
	
	/**
	 * Gets the mapeamento.
	 *
	 * @return the mapeamento
	 */
	public String getMapeamento() {
		return mapeamento;
	}

	/**
	 * Sets the mapeamento.
	 *
	 * @param mapeamento
	 *            the new mapeamento
	 */
	public void setMapeamento(String mapeamento) {
		this.mapeamento = mapeamento;
	}
	
	
}

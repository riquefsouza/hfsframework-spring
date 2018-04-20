/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base.relatorio;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.hfsframework.base.BaseViewController;
import br.com.hfsframework.util.pdf.PdfException;
import br.com.hfsframework.util.pdf.PdfUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseViewRelatorioController.
 */
//@Named
public abstract class BaseViewRelatorioController
		extends BaseViewController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The lista tipo relatorio. */
	private List<RelatorioGrupoVO> listaTipoRelatorio;

	/** The tipo relatorio. */
	private String tipoRelatorio;

	/** The renderer. */
	@Autowired
	private RelatorioRender renderer;

	/**
	 * Instantiates a new base view relatorio controller.
	 */
	public BaseViewRelatorioController() {
		super();
	}

	/**
	 * Inicia o.
	 */
	@PostConstruct
	public void init() {
		tipoRelatorio = RelatorioTipoEnum.PDF.name();
		listaTipoRelatorio = new ArrayList<RelatorioGrupoVO>();
	}

	/**
	 * Gets the parametros.
	 *
	 * @return the parametros
	 */
	public Map<String, Object> getParametros() {
		Map<String, Object> params = new HashMap<String, Object>();

		//ServletContext sc = (ServletContext) context.getExternalContext().getContext();
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    ServletContext sc = (ServletContext) attr.getRequest().getServletContext();
		String caminho = sc.getRealPath(File.separator);

		params.put("IMAGEM", caminho + "/resources/img/logo.png");
		return params;
	}

	/**
	 * Exportar.
	 *
	 * @param relatorio
	 *            the relatorio
	 * @param colecao
	 *            the colecao
	 * @param params
	 *            the params
	 * @param forcarDownload
	 *            the forcar download
	 */
	public void exportar(IBaseRelatorio relatorio, Iterable<?> colecao, Map<String, Object> params,		
			boolean forcarDownload) {
		exportar(relatorio, colecao, params, forcarDownload, true);
	}
	
	/**
	 * Exportar.
	 *
	 * @param relatorio
	 *            the relatorio
	 * @param colecao
	 *            the colecao
	 * @param params
	 *            the params
	 * @param forcarDownload
	 *            the forcar download
	 * @param renderizar
	 *            the renderizar
	 * @return the byte[]
	 */
	public byte[] exportar(IBaseRelatorio relatorio, Iterable<?> colecao, Map<String, Object> params,		
			boolean forcarDownload, boolean renderizar) {
		byte[] buffer = null;
		
		if (colecao!=null) { // && !colecao.isEmpty()) {
			RelatorioTipoEnum tipoRel = RelatorioTipoEnum.valueOf(tipoRelatorio);

			buffer = relatorio.export(colecao, params, tipoRel);
			
			if (renderizar) {
				this.renderer.render(buffer, tipoRel, "relatorio." + tipoRel.name().toLowerCase(), forcarDownload);
			}
			
		} else {
			gerarMensagemInformativa("Nenhum registro encontrado para exportar relatório.");
		}
		
		return buffer;
	}

	/**
	 * Exportar junto alternado.
	 *
	 * @param relatorio1 the relatorio 1
	 * @param relatorio2 the relatorio 2
	 * @param forcarDownload the forcar download
	 * @param renderizar the renderizar
	 * @return the byte[]
	 */
	public byte[] exportarJuntoAlternado(IBaseRelatorio relatorio1, IBaseRelatorio relatorio2,
			boolean forcarDownload, boolean renderizar) {
		byte[] buffer = null;
		RelatorioTipoEnum tipoRel = RelatorioTipoEnum.valueOf(tipoRelatorio);

		buffer = relatorio1.exportJuntoAlternado(relatorio1.getReportObject(), relatorio2.getReportObject(), tipoRel);
		
		if (renderizar) {
			this.renderer.render(buffer, tipoRel, "relatorio." + tipoRel.name().toLowerCase(), forcarDownload);
		}
		
		return buffer;
	}

	/**
	 * Exportar PD fjunto.
	 *
	 * @param buffer1
	 *            the buffer 1
	 * @param buffer2
	 *            the buffer 2
	 * @param forcarDownload
	 *            the forcar download
	 * @throws PdfException
	 *             the pdf exception
	 */
	public void exportarPDFjunto(byte[] buffer1, byte[] buffer2, boolean forcarDownload) throws PdfException {
		if (buffer1!=null && buffer2!=null) {
			RelatorioTipoEnum tipoRel = RelatorioTipoEnum.valueOf(tipoRelatorio);
			
			PdfUtil pu = new PdfUtil();
			byte[] buffer = pu.juntarAlternado(buffer1, buffer2);
			
			this.renderer.render(buffer, tipoRel, "relatorio." + tipoRel.name().toLowerCase(), forcarDownload);			
		} else {
			gerarMensagemInformativa("Nenhum registro encontrado para exportar relatório.");
		}		
	}

	/**
	 * Gets the real path.
	 *
	 * @return the real path
	 */
	public String getRealPath(){
		//ServletContext sc = (ServletContext) context.getExternalContext().getContext();
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    ServletContext sc = (ServletContext) attr.getRequest().getServletContext();		
		String caminho = sc.getRealPath("/WEB-INF/classes/relatorios");
		return caminho + File.separator;
	}
	
	/**
	 * Pega o the lista tipo relatorio.
	 *
	 * @return o the lista tipo relatorio
	 */
	public Iterable<RelatorioGrupoVO> getListaTipoRelatorio() {
		return listaTipoRelatorio;
	}

	/**
	 * Pega o the tipo relatorio.
	 *
	 * @return o the tipo relatorio
	 */
	public String getTipoRelatorio() {
		return tipoRelatorio;
	}

	/**
	 * Atribui o the tipo relatorio.
	 *
	 * @param tipoRelatorio
	 *            o novo the tipo relatorio
	 */
	public void setTipoRelatorio(String tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	/**
	 * Cancelar.
	 *
	 * @return the string
	 */
	public String cancelar() {
		return getPaginaDesktop();
	}

}

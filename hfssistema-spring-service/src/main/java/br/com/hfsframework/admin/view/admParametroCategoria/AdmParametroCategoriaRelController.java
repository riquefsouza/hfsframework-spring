/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.view.admParametroCategoria;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.base.IBaseViewRelatorio;
import br.com.hfsframework.base.relatorio.BaseViewRelatorio;
import br.com.hfsframework.base.relatorio.IBaseRelatorio;
import br.com.hfsframework.base.relatorio.RelatorioPath;
import br.com.hfsframework.base.relatorio.RelatorioTipoEnum;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroCategoriaRelMB.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admParametroCategoriaRelMB")
public class AdmParametroCategoriaRelController 
	extends BaseViewRelatorio<AdmParametroCategoria, Long, AdmParametroCategoriaService>
		implements IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The forcar download. */
	private Boolean forcarDownload;
	
	/** The relatorio. */
	//@Autowired
	@RelatorioPath("AdmParametroCategoria")
	private IBaseRelatorio relatorio;

	/**
	 * Instantiates a new adm parametro categoria rel MB.
	 */
	public AdmParametroCategoriaRelController() {
		super(new AdmParametroCategoria());
		this.forcarDownload = false;
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewRelatorio#exportar()
	 */
	public void exportar() {
		Map<String, Object> params = getParametros();
		params.put("PARAMETRO1", "");

		super.exportar(relatorio, getBusinessController().findAll(), params, forcarDownload);
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.relatorio.BaseViewRelatorioController#getListaTipoRelatorio(java.lang.String)
	 */
	@ModelAttribute("listaTipoRelatorio")
	@Override
	public List<RelatorioTipoEnum> getListaTipoRelatorio(String grupo) {
		return getListaTipoRelatorio(grupo);
	}
	
	/**
	 * Gets the forcar download.
	 *
	 * @return the forcar download
	 */
	public Boolean getForcarDownload() {
		return forcarDownload;
	}

	/**
	 * Sets the forcar download.
	 *
	 * @param forcarDownload
	 *            the new forcar download
	 */
	public void setForcarDownload(Boolean forcarDownload) {
		this.forcarDownload = forcarDownload;
	}

}

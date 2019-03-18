/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admParametroCategoria;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.base.relatorio.BaseRelatorioImpl;
import br.com.hfsframework.base.relatorio.IBaseRelatorio;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.base.view.relatorio.BaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;
import springfox.documentation.annotations.ApiIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroCategoriaRelMB.
 */
@ApiIgnore
@Controller
@TratamentoErrosEsperados
public class AdmParametroCategoriaRelController 
	extends BaseViewRelatorio<AdmParametroCategoria, Long, AdmParametroCategoriaService>
		implements IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The forcar download. */
	private Boolean forcarDownload;
	
	/** The relatorio. */
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
	public String exportar(String tipoRelatorio, String forcarDownload) {		
		this.setTipoRelatorio(tipoRelatorio);
		this.setForcarDownload(Boolean.parseBoolean(forcarDownload));
		
		Map<String, Object> params = getParametros();
		params.put("PARAMETRO1", "");

		relatorio = new BaseRelatorioImpl("AdmParametroCategoria");
		
		super.exportar(relatorio, getBusinessController().findAll(), params, this.forcarDownload);
		return "";
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.relatorio.BaseViewRelatorioController#getListaTipoRelatorio(java.lang.String)
	 */
	@Override
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return super.getListaTipoRelatorio();
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

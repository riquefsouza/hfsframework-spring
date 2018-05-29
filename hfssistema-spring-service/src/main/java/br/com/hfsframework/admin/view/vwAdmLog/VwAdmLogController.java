/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.vwAdmLog;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.admin.service.VwAdmLogService;
import br.com.hfsframework.admin.service.VwAdmLogValorService;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class VwAdmLogController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/vwAdmLogMB")
public class VwAdmLogController
		extends BaseViewConsulta<VwAdmLog, Long, VwAdmLogService>
		implements IBaseViewConsulta<VwAdmLog>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rel. */
	@Autowired
	private VwAdmLogRelController rel;
	
	/** The vw adm log filtros. */
	private VwAdmLog vwAdmLogFiltros;

	/** The vw adm log valor. */
	private VwAdmLogValor vwAdmLogValor;

	/** The vw adm log valor service. */
	@Autowired
	private VwAdmLogValorService vwAdmLogValorService;

	/** The lista entidade. */
	private List<String> listaSEntidade;
	
	/**
	 * Instantiates a new VwAdmLogController.
	 */
	public VwAdmLogController() {
		super(new VwAdmLog(),
			"/private/admin/vwAdmLog/listarVwAdmLog",
			"/vwAdmLogMB");
		
		vwAdmLogFiltros = new VwAdmLog();
		vwAdmLogValor = new VwAdmLogValor();		
		listaSEntidade = new ArrayList<String>();
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		if (getBean() != null) {
			listaSEntidade = getBusinessController().getRepositorio().findEntidades();

			if (getBean().getEntidade() != null && listaSEntidade.size() > 0) {
				getBean().setEntidade(listaSEntidade.get(0));
				selectEntidade();
			}
		}

		super.atualizaListaDataTable();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.hfsframework.base.BaseViewConsulta#atualizaListaDataTable()
	 */
	@Override
	protected void atualizaListaDataTable() {
		this.setListaEntidade(getBusinessController().findByFiltros(vwAdmLogFiltros));
	}

	/**
	 * Select entidade.
	 */
	public void selectEntidade() {
		//if (getBean().getEntidade() != null) {
			//String entidade = entidadeRepository.load(getBean().getEntidade());
			//getBean().setEntidade(entidade);
		//}
	}

	/**
	 * On pesquisar.
	 */
	@PostMapping("/pesquisar")
	public RedirectView onPesquisar(VwAdmLog filtros) {
		this.setVwAdmLogFiltros(filtros);		
		atualizaListaDataTable();	

		return new RedirectView(getMapeamento()+"/listar");
	}

	/**
	 * On limpar pesquisa.
	 */
	@GetMapping("/limpar")
	public RedirectView onLimparPesquisa() {
		vwAdmLogFiltros.limpar();
		if (this.getListaEntidade() != null) {
			this.getListaEntidade().clear();
		}
		return new RedirectView(getMapeamento()+"/listar");
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.BaseViewCadastro#listar()
	 */
	@Override
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = super.listar(this.getListaBean());
		mv.addObject("filtros", this.getVwAdmLogFiltros());
		return mv;
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.IBaseViewRelatorio#getListaTipoRelatorio()
	 */
	@Override
	@ModelAttribute("listaTipoRelatorio")
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return rel.getListaTipoRelatorio();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.IBaseViewRelatorio#exportar(java.lang.String, java.lang.String)
	 */
	@Override
	@ResponseBody
	@GetMapping(value = "/exportar/{tipoRelatorio}/{forcarDownload}")
	public String exportar(@PathVariable("tipoRelatorio") String tipoRelatorio, 
			@PathVariable("forcarDownload") String forcarDownload)  {
		return rel.exportar(tipoRelatorio, forcarDownload);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getBean()
	 */
	@Override
	public VwAdmLog getBean() {
		VwAdmLog bean = super.getEntidade();
		
		if (bean!=null) {
			if (bean.getUsuario()!=null) {
				List<VwAdmLogValor> listaLogValor =	vwAdmLogValorService.findByFiltros(
						bean.getUsuario(), bean.getDataNumero(), bean.getOperacao(), 
						bean.getIp(), bean.getEntidade(), bean.getTabela(), bean.getChave());
				
				bean.setListaLogValor(listaLogValor);
			}
		}
		
		return bean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(VwAdmLog entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<VwAdmLog> getListaBean() {
		return super.getListaEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setListaBean(java.util.
	 * List)
	 */
	@Override
	public void setListaBean(List<VwAdmLog> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Pega o the vw adm log filtros.
	 *
	 * @return o the vw adm log filtros
	 */
	public VwAdmLog getVwAdmLogFiltros() {
		return vwAdmLogFiltros;
	}

	/**
	 * Atribui o the vw adm log filtros.
	 *
	 * @param vwAdmLogFiltros
	 *            o novo the vw adm log filtros
	 */
	public void setVwAdmLogFiltros(VwAdmLog vwAdmLogFiltros) {
		this.vwAdmLogFiltros = vwAdmLogFiltros;
	}

	/**
	 * Pega o the lista entidade.
	 *
	 * @return o the lista entidade
	 */
	@ModelAttribute("listaSEntidade")
	public List<String> getListaSEntidade() {
		return listaSEntidade;
	}

	/**
	 * Atribui o the lista entidade.
	 *
	 * @param listaSEntidade
	 *            o novo the lista entidade
	 */
	public void setListaSEntidade(List<String> listaSEntidade) {
		this.listaSEntidade = listaSEntidade;
	}

	/**
	 * Gets the vw adm log valor.
	 *
	 * @return the vw adm log valor
	 */
	public VwAdmLogValor getVwAdmLogValor() {
		return vwAdmLogValor;
	}

	/**
	 * Sets the vw adm log valor.
	 *
	 * @param vwAdmLogValor the new vw adm log valor
	 */
	public void setVwAdmLogValor(VwAdmLogValor vwAdmLogValor) {
		this.vwAdmLogValor = vwAdmLogValor;
	}

}

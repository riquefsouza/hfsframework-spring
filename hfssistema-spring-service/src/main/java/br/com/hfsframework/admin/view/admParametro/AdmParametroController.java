/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admParametro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hfsframework.admin.model.AdmParametro;
import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.admin.service.AdmParametroCategoriaService;
import br.com.hfsframework.admin.service.AdmParametroService;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

/**
 * The Class AdmParametroController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admParametroMB")
public class AdmParametroController
		extends BaseViewCadastro<AdmParametro, Long, AdmParametroService>
		implements IBaseViewCadastro<AdmParametro, Long>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmParametroRelController rel;
	
	/** The adm parametro categoria repository. */
	@Autowired
	private AdmParametroCategoriaService admParametroCategoriaService;

	/** The lista adm parametro categoria. */
	private List<AdmParametroCategoria> listaAdmParametroCategoria;
	
	/**
	 * Instantiates a new AdmParametroController.
	 */
	public AdmParametroController() {
		super(new AdmParametro(),
			"/private/admin/admParametro/listarAdmParametro",
			"/private/admin/admParametro/editarAdmParametro", 
			"/admParametroMB");
		
		listaAdmParametroCategoria = new ArrayList<AdmParametroCategoria>();
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		listaAdmParametroCategoria = StreamSupport.stream(admParametroCategoriaService.findAll().spliterator(), false)
				.collect(Collectors.toList());			
		atualizaListaDataTable();

		if (getBean().getAdmParametroCategoria() != null && listaAdmParametroCategoria.size() > 0) {
			getBean().getAdmParametroCategoria().setId(listaAdmParametroCategoria.get(0).getId());
			selectAdmParametroCategoria();
		}
	}
	
	/**
	 * Select adm parametro categoria.
	 */
	public void selectAdmParametroCategoria() {
		Optional<AdmParametroCategoria> admParametroCategoria = admParametroCategoriaService
				.load(getBean().getAdmParametroCategoria().getId());
		getBean().setAdmParametroCategoria(admParametroCategoria.get());
	}
	
	@Override
	@GetMapping("/listar")
	public ModelAndView listar() {
		return super.listar();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#incluir()
	 */
	@Override
	@GetMapping("/incluir")
	public ModelAndView incluir() {
		return super.incluir(new AdmParametro());
	}
	
	@Override
	@GetMapping("/editar/{id}")	
	public ModelAndView editar(@PathVariable("id") Long id) {
		return super.editar(id);
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#salvar(java.lang.Object, 
	 * org.springframework.validation.BindingResult, 
	 * org.springframework.web.servlet.mvc.support.RedirectAttributes)
	 */
	@Override
	@PostMapping("/salvar")
	public RedirectView salvar(@Valid AdmParametro obj, 
			BindingResult result, RedirectAttributes attributes) {
		//getBean().setIdAdmParametroCategoria(getBean().getAdmParametroCategoria().getId());
		getBean().getAdmParametroCategoria().setId(getBean().getIdAdmParametroCategoria());		
		return super.salvar(obj.getId(), obj.getDescricao(), obj, result, attributes);
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseViewCadastro#excluir(java.io.Serializable)
	 */
	@Override
	@GetMapping("/excluir/{id}")
	public RedirectView excluir(@PathVariable("id") Long id) {
		return super.excluir(id);
	}

	@Override
	@ModelAttribute("listaTipoRelatorio")
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return rel.getListaTipoRelatorio();
	}
	
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
	public AdmParametro getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmParametro entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmParametro> getListaBean() {
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
	public void setListaBean(List<AdmParametro> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Gets the lista adm parametro categoria.
	 *
	 * @return the lista adm parametro categoria
	 */
	@ModelAttribute("listaAdmParametroCategoria")
	public List<AdmParametroCategoria> getListaAdmParametroCategoria() {
		return listaAdmParametroCategoria;
	}

	/**
	 * Sets the lista adm parametro categoria.
	 *
	 * @param listaAdmParametroCategoria
	 *            the new lista adm parametro categoria
	 */
	public void setListaAdmParametroCategoria(List<AdmParametroCategoria> listaAdmParametroCategoria) {
		this.listaAdmParametroCategoria = listaAdmParametroCategoria;
	}
	
}

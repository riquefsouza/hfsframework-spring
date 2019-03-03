/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admFuncionario;

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

import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.model.AdmSetor;
import br.com.hfsframework.admin.service.AdmCargoFuncionarioService;
import br.com.hfsframework.admin.service.AdmCargoService;
import br.com.hfsframework.admin.service.AdmFuncionarioService;
import br.com.hfsframework.admin.service.AdmSetorService;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionarioController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admFuncionarioMB")
public class AdmFuncionarioController
		extends BaseViewCadastro<AdmFuncionario, Long, AdmFuncionarioService>
		implements IBaseViewCadastro<AdmFuncionario, Long>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rel. */
	@Autowired
	private AdmFuncionarioRelController rel;
	
	/** The adm cargo funcionario service. */
	@Autowired
	private AdmCargoFuncionarioService admCargoFuncionarioService;
	
	/** The adm setor service. */
	@Autowired
	private AdmSetorService admSetorService;
	
	/** The lista adm setor. */
	private List<AdmSetor> listaAdmSetor;

	/** The adm cargo service. */
	@Autowired
	private AdmCargoService admCargoService;
	
	/** The lista adm cargo. */
	private List<AdmCargo> listaAdmCargo;
	
	/**
	 * Instantiates a new AdmFuncionarioController.
	 */
	public AdmFuncionarioController() {
		super(new AdmFuncionario(),
			"/private/admin/admFuncionario/listarAdmFuncionario",
			"/private/admin/admFuncionario/editarAdmFuncionario", 
			"/admFuncionarioMB");
		
		listaAdmSetor = new ArrayList<AdmSetor>();
		listaAdmCargo = new ArrayList<AdmCargo>();		
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		listaAdmSetor = StreamSupport.stream(admSetorService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		listaAdmCargo = StreamSupport.stream(admCargoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		atualizaListaDataTable();
		
		if (getBean().getSetor() != null && listaAdmSetor.size() > 0) {
			getBean().setSetor(listaAdmSetor.get(0).getId());
			selectSetor();
		}
		
		if (getBean().getAdmCargoPrincipal() != null && listaAdmCargo.size() > 0) {
			getBean().getAdmCargoPrincipal().setId(listaAdmCargo.get(0).getId());
			selectAdmCargoPrincipal();
		}
	}
	
	/**
	 * Select setor.
	 */
	public void selectSetor() {
		Optional<AdmSetor> admSetor = admSetorService.load(getBean().getSetor());
		getBean().setSetor(admSetor.get().getId());
	}
	
	/**
	 * Select adm cargo principal.
	 */
	public void selectAdmCargoPrincipal() {
		Optional<AdmCargo> admCargo = admCargoService
				.load(getBean().getAdmCargoPrincipal().getId());
		getBean().setAdmCargoPrincipal(admCargo.get());
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.BaseViewCadastro#listar()
	 */
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
		return super.incluir(new AdmFuncionario());
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.BaseViewCadastro#editar(java.io.Serializable)
	 */
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
	public RedirectView salvar(@Valid AdmFuncionario obj, 
			BindingResult result, RedirectAttributes attributes) {
		return super.salvar(obj.getId(), obj, result, attributes);
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseViewCadastro#excluir(java.io.Serializable)
	 */
	@Override
	@GetMapping("/excluir/{id}")
	public RedirectView excluir(@PathVariable("id") Long id) {
		return super.excluir(id);
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
	public AdmFuncionario getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmFuncionario entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmFuncionario> getListaBean() {
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
	public void setListaBean(List<AdmFuncionario> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Gets the adm cargos.
	 *
	 * @return the adm cargos
	 */
	public List<AdmCargo> getAdmCargos() {
		if (getBean()!=null && getBean().getId()!=null) 
			return admCargoFuncionarioService.findCargoByCodFuncionario(getBean().getId());
		else
			return null;
	}

	/**
	 * Gets the lista adm setor.
	 *
	 * @return the lista adm setor
	 */
	@ModelAttribute("listaAdmSetor")
	public List<AdmSetor> getListaAdmSetor() {
		return listaAdmSetor;
	}

	/**
	 * Sets the lista adm setor.
	 *
	 * @param listaAdmSetor the new lista adm setor
	 */
	public void setListaAdmSetor(List<AdmSetor> listaAdmSetor) {
		this.listaAdmSetor = listaAdmSetor;
	}

	/**
	 * Gets the lista adm cargo.
	 *
	 * @return the lista adm cargo
	 */
	@ModelAttribute("listaAdmCargo")
	public List<AdmCargo> getListaAdmCargo() {
		return listaAdmCargo;
	}

	/**
	 * Sets the lista adm cargo.
	 *
	 * @param listaAdmCargo the new lista adm cargo
	 */
	public void setListaAdmCargo(List<AdmCargo> listaAdmCargo) {
		this.listaAdmCargo = listaAdmCargo;
	}
	
}

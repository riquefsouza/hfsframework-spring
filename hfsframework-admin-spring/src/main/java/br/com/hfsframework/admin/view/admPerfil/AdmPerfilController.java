/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admPerfil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmCargoService;
import br.com.hfsframework.admin.service.AdmFuncionalidadeService;
import br.com.hfsframework.admin.service.AdmFuncionarioService;
import br.com.hfsframework.admin.service.AdmPaginaService;
import br.com.hfsframework.admin.service.AdmPerfilService;
import br.com.hfsframework.base.BaseDualList;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

/**
 * The Class AdmPerfilController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admPerfilMB")
public class AdmPerfilController
		extends BaseViewCadastro<AdmPerfil, Long, AdmPerfilService>
		implements IBaseViewCadastro<AdmPerfil, Long>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmPerfilRelController rel;
	
	/** The adm cargo Service. */
	@Autowired
	private AdmCargoService admCargoService;

	/** The dual list adm cargo. */
	private BaseDualList<AdmCargo> dualListAdmCargo;

	/** The lista adm cargo. */
	private List<AdmCargo> listaAdmCargo;
		
	/** The vw adm funcionario Service. */
	@Autowired
	private AdmFuncionarioService admFuncionarioService;

	/** The dual list adm funcionario. */
	private BaseDualList<AdmFuncionario> dualListAdmFuncionario;

	/** The lista adm funcionario. */
	private List<AdmFuncionario> listaAdmFuncionario;
		
	/** The adm funcionalidade Service. */
	@Autowired
	private AdmFuncionalidadeService admFuncionalidadeService;

	/** The dual list adm funcionalidade. */
	private BaseDualList<AdmFuncionalidade> dualListAdmFuncionalidade;

	/** The lista adm funcionalidade. */
	private List<AdmFuncionalidade> listaAdmFuncionalidade;
	
	/** The adm pagina Service. */
	@Autowired
	private AdmPaginaService admPaginaService;

	/** The dual list adm pagina. */
	private BaseDualList<AdmPagina> dualListAdmPagina;

	/** The lista adm pagina. */
	private List<AdmPagina> listaAdmPagina;
	
	/**
	 * Instantiates a new AdmPerfilController.
	 */
	public AdmPerfilController() {
		super(new AdmPerfil(),
			"/private/admin/admPerfil/listarAdmPerfil",
			"/private/admin/admPerfil/editarAdmPerfil", 
			"/admPerfilMB");
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		atualizaListaDataTable();
	}
	
	/**
	 * Carregar adm paginas.
	 */
	private void carregarAdmPaginas() {
		List<AdmPagina> listaAdmPaginaSelecionado = this.getBean().getId() == null ? new ArrayList<AdmPagina>()
				: this.getBusinessController().getRepositorio().findPaginasPorPerfil(this.getBean());
		this.listaAdmPagina = StreamSupport.stream(admPaginaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmPagina.removeAll(listaAdmPaginaSelecionado);
		this.dualListAdmPagina = new BaseDualList<AdmPagina>(this.listaAdmPagina, listaAdmPaginaSelecionado);
	}

	/**
	 * Carregar adm funcionarios.
	 */
	private void carregarAdmFuncionarios() {
		List<AdmFuncionario> listaAdmFuncionarioSelecionado = this.getBean().getId() == null ? new ArrayList<AdmFuncionario>()
				: this.getBusinessController().findFuncionariosPorPerfil(this.getBean());
		this.listaAdmFuncionario = StreamSupport.stream(admFuncionarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmFuncionario.removeAll(listaAdmFuncionarioSelecionado);
		this.dualListAdmFuncionario = new BaseDualList<AdmFuncionario>(this.listaAdmFuncionario, listaAdmFuncionarioSelecionado);
	}
	
	/**
	 * Carregar adm cargos.
	 */
	private void carregarAdmCargos() {
		List<AdmCargo> listaAdmCargoSelecionado = this.getBean().getId() == null ? new ArrayList<AdmCargo>()
				: this.getBusinessController().findCargosPorPerfil(this.getBean());
		this.listaAdmCargo = StreamSupport.stream(admCargoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmCargo.removeAll(listaAdmCargoSelecionado);
		this.dualListAdmCargo = new BaseDualList<AdmCargo>(this.listaAdmCargo, listaAdmCargoSelecionado);
	}
		
	/**
	 * Carregar adm funcionalidades.
	 */
	private void carregarAdmFuncionalidades() {
		List<AdmFuncionalidade> listaAdmFuncionalidadeSelecionado = this.getBean().getId() == null ? new ArrayList<AdmFuncionalidade>()
				: this.getBusinessController().getRepositorio().findFuncionalidadesPorPerfil(this.getBean());
		this.listaAdmFuncionalidade = StreamSupport.stream(admFuncionalidadeService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmFuncionalidade.removeAll(listaAdmFuncionalidadeSelecionado);
		this.dualListAdmFuncionalidade = new BaseDualList<AdmFuncionalidade>(this.listaAdmFuncionalidade, listaAdmFuncionalidadeSelecionado);
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
		this.listaAdmPagina = StreamSupport.stream(admPaginaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmPagina = new BaseDualList<AdmPagina>(this.listaAdmPagina, new ArrayList<AdmPagina>());

		this.listaAdmFuncionalidade = StreamSupport.stream(admFuncionalidadeService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmFuncionalidade = new BaseDualList<AdmFuncionalidade>(this.listaAdmFuncionalidade, new ArrayList<AdmFuncionalidade>());

		this.listaAdmFuncionario = StreamSupport.stream(admFuncionarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmFuncionario = new BaseDualList<AdmFuncionario>(this.listaAdmFuncionario, new ArrayList<AdmFuncionario>());
	    
		this.listaAdmCargo = StreamSupport.stream(admCargoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.dualListAdmCargo = new BaseDualList<AdmCargo>(this.listaAdmCargo, new ArrayList<AdmCargo>());
		
		return super.incluir(new AdmPerfil());
	}
	
	@Override
	@GetMapping("/editar/{id}")	
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView retorno = super.editar(id);		
		if (!retorno.isEmpty()) {
			carregarAdmPaginas();
			carregarAdmFuncionalidades();
			carregarAdmFuncionarios();
			carregarAdmCargos();
		}
		return retorno;		
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#salvar(java.lang.Object, 
	 * org.springframework.validation.BindingResult, 
	 * org.springframework.web.servlet.mvc.support.RedirectAttributes)
	 */
	@Override
	@PostMapping("/salvar")
	public RedirectView salvar(@Valid AdmPerfil obj, 
			BindingResult result, RedirectAttributes attributes) {
		
		getBean().setAdmPaginas(this.dualListAdmPagina.getTarget());
		getBean().setAdmFuncionalidades(this.dualListAdmFuncionalidade.getTarget());
		getBean().setAdmFuncionarios(this.dualListAdmFuncionario.getTarget());		
		getBean().setAdmCargos(this.dualListAdmCargo.getTarget());		
		
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
	public AdmPerfil getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmPerfil entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmPerfil> getListaBean() {
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
	public void setListaBean(List<AdmPerfil> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Pega o the dual list adm cargo.
	 *
	 * @return o the dual list adm cargo
	 */
	@ModelAttribute("dualListAdmCargo")
	public BaseDualList<AdmCargo> getDualListAdmCargo() {
		return dualListAdmCargo;
	}

	/**
	 * Atribui o the dual list adm cargo.
	 *
	 * @param dualListAdmCargo
	 *            o novo the dual list adm cargo
	 */
	public void setDualListAdmCargo(BaseDualList<AdmCargo> dualListAdmCargo) {
		this.dualListAdmCargo = dualListAdmCargo;
	}

	/**
	 * Gets the dual list adm funcionario.
	 *
	 * @return the dual list adm funcionario
	 */
	@ModelAttribute("dualListAdmFuncionario")
	public BaseDualList<AdmFuncionario> getDualListAdmFuncionario() {
		return dualListAdmFuncionario;
	}
		
	/**
	 * Sets the dual list adm funcionario.
	 *
	 * @param dualListAdmFuncionario
	 *            the new dual list adm funcionario
	 */
	public void setDualListAdmFuncionario(BaseDualList<AdmFuncionario> dualListAdmFuncionario) {
		this.dualListAdmFuncionario = dualListAdmFuncionario;
	}
		
	/**
	 * Gets the dual list adm funcionalidade.
	 *
	 * @return the dual list adm funcionalidade
	 */
	@ModelAttribute("dualListAdmFuncionalidade")
	public BaseDualList<AdmFuncionalidade> getDualListAdmFuncionalidade() {
		return dualListAdmFuncionalidade;
	}
		
	/**
	 * Sets the dual list adm funcionalidade.
	 *
	 * @param dualListAdmFuncionalidade
	 *            the new dual list adm funcionalidade
	 */
	public void setDualListAdmFuncionalidade(BaseDualList<AdmFuncionalidade> dualListAdmFuncionalidade) {
		this.dualListAdmFuncionalidade = dualListAdmFuncionalidade;
	}
	
	/**
	 * Pega o the dual list adm pagina.
	 *
	 * @return o the dual list adm pagina
	 */
	@ModelAttribute("dualListAdmPagina")
	public BaseDualList<AdmPagina> getDualListAdmPagina() {
		return dualListAdmPagina;
	}
		
	/**
	 * Atribui o the dual list adm pagina.
	 *
	 * @param dualListAdmPagina
	 *            o novo the dual list adm pagina
	 */
	public void setDualListAdmPagina(BaseDualList<AdmPagina> dualListAdmPagina) {
		this.dualListAdmPagina = dualListAdmPagina;
	}
	
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		CustomCollectionEditor AdmPaginaCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

		            Optional<AdmPagina> admPagina = admPaginaService.load(Long.valueOf(id));
		    		if (admPagina.isPresent()) {            
		    			return admPagina;
		    		} else {
		    			return null;
		    		}
                }
                //throw new RuntimeException(element);
                return null;
            }
        };
        binder.registerCustomEditor(List.class, "admPaginas", AdmPaginaCollector);
        
		CustomCollectionEditor AdmFuncionalidadeCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

		            Optional<AdmFuncionalidade> admFuncionalidade = admFuncionalidadeService.load(Long.valueOf(id));
		    		if (admFuncionalidade.isPresent()) {            
		    			return admFuncionalidade;
		    		} else {
		    			return null;
		    		}
                }
                //throw new RuntimeException(element);
                return null;
            }
        };
        binder.registerCustomEditor(List.class, "admFuncionalidades", AdmFuncionalidadeCollector);
        
		CustomCollectionEditor AdmFuncionarioCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

		            Optional<AdmFuncionario> admFuncionario = admFuncionarioService.load(Long.valueOf(id));
		    		if (admFuncionario.isPresent()) {            
		    			return admFuncionario;
		    		} else {
		    			return null;
		    		}
                }
                //throw new RuntimeException(element);
                return null;
            }
        };
        binder.registerCustomEditor(List.class, "admFuncionarios", AdmFuncionarioCollector);
        
		CustomCollectionEditor AdmCargoCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

		            Optional<AdmCargo> admCargo = admCargoService.load(Long.valueOf(id));
		    		if (admCargo.isPresent()) {            
		    			return admCargo;
		    		} else {
		    			return null;
		    		}
                }
                //throw new RuntimeException(element);
                return null;
            }
        };
        binder.registerCustomEditor(List.class, "admCargos", AdmCargoCollector);
        
	}
	
}

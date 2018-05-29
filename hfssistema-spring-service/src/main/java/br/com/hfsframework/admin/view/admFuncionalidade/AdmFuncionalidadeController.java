/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admFuncionalidade;

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

import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.service.AdmFuncionalidadeService;
import br.com.hfsframework.admin.service.AdmPaginaService;
import br.com.hfsframework.admin.service.AdmPerfilService;
import br.com.hfsframework.base.BaseDualList;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

/**
 * The Class AdmFuncionalidadeController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admFuncionalidadeMB")
public class AdmFuncionalidadeController
		extends BaseViewCadastro<AdmFuncionalidade, Long, AdmFuncionalidadeService>
		implements IBaseViewCadastro<AdmFuncionalidade, Long>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmFuncionalidadeRelController rel;

	@Autowired
	private AdmPerfilService admPerfilService;

	/** The dual list adm perfil. */
	private BaseDualList<AdmPerfil> dualListAdmPerfil;

	/** The lista adm perfil. */
	private List<AdmPerfil> listaAdmPerfil;
	
	/** The adm pagina Service. */
	@Autowired
	private AdmPaginaService admPaginaService;

	/** The dual list adm pagina. */
	private BaseDualList<AdmPagina> dualListAdmPagina;
	
	/** The lista adm pagina. */
	private List<AdmPagina> listaAdmPagina;

	/** The lista adm pagina inicial. */
	private List<AdmPagina> listaAdmPaginaInicial;
	
	/**
	 * Instantiates a new AdmFuncionalidadeController.
	 */
	public AdmFuncionalidadeController() {
		super(new AdmFuncionalidade(),
			"/private/admin/admFuncionalidade/listarAdmFuncionalidade",
			"/private/admin/admFuncionalidade/editarAdmFuncionalidade", 
			"/admFuncionalidadeMB");
		
		listaAdmPaginaInicial = new ArrayList<AdmPagina>();
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		listaAdmPaginaInicial = StreamSupport.stream(admPaginaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		atualizaListaDataTable();
		
		if (getBean().getAdmPaginaInicial() != null && listaAdmPaginaInicial.size() > 0) {
			getBean().getAdmPaginaInicial().setId(listaAdmPaginaInicial.get(0).getId());
			selectAdmPaginaInicial();
		}
	}
	
	/**
	 * Select adm pagina inicial.
	 */
	public void selectAdmPaginaInicial() {
		Optional<AdmPagina> AdmPaginaInicial = admPaginaService.load(getBean().getAdmPaginaInicial().getId());
		if (AdmPaginaInicial.isPresent()){
			getBean().setAdmPaginaInicial(AdmPaginaInicial.get());
		}
	}
	
	/**
	 * Carregar adm perfis.
	 */
	private void carregarAdmPerfis() {
		List<AdmPerfil> listaAdmPerfilSelecionado = this.getBean().getId() == null ? new ArrayList<AdmPerfil>()
				: this.getBusinessController().getRepositorio().findPerfisPorFuncionalidade(this.getBean());
		this.listaAdmPerfil = StreamSupport.stream(admPerfilService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmPerfil.removeAll(listaAdmPerfilSelecionado);
		this.dualListAdmPerfil = new BaseDualList<AdmPerfil>(this.listaAdmPerfil, listaAdmPerfilSelecionado);
	}

	/**
	 * Carregar adm paginas.
	 */
	private void carregarAdmPaginas() {
		List<AdmPagina> listaAdmPaginaSelecionado = this.getBean().getId() == null ? new ArrayList<AdmPagina>()
				: this.getBusinessController().getRepositorio().findPaginasPorFuncionalidade(this.getBean());
		this.listaAdmPagina = StreamSupport.stream(admPaginaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmPagina.removeAll(listaAdmPaginaSelecionado);
		this.dualListAdmPagina = new BaseDualList<AdmPagina>(this.listaAdmPagina, listaAdmPaginaSelecionado);
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
		this.listaAdmPerfil = StreamSupport.stream(admPerfilService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmPerfil = new BaseDualList<AdmPerfil>(this.listaAdmPerfil, new ArrayList<AdmPerfil>());

		this.listaAdmPagina = StreamSupport.stream(admPaginaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmPagina = new BaseDualList<AdmPagina>(this.listaAdmPagina, new ArrayList<AdmPagina>());
		
		return super.incluir(new AdmFuncionalidade());
	}
	
	@Override
	@GetMapping("/editar/{id}")	
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView retorno = super.editar(id);		
		if (!retorno.isEmpty()) {
			carregarAdmPerfis();
			carregarAdmPaginas();
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
	public RedirectView salvar(@Valid AdmFuncionalidade obj, 
			BindingResult result, RedirectAttributes attributes) {

		getBean().setAdmPerfils(this.dualListAdmPerfil.getTarget());	
		getBean().setAdmPaginas(this.dualListAdmPagina.getTarget());
		
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
	public AdmFuncionalidade getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmFuncionalidade entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmFuncionalidade> getListaBean() {
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
	public void setListaBean(List<AdmFuncionalidade> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Pega o the dual list adm perfil.
	 *
	 * @return o the dual list adm perfil
	 */
	@ModelAttribute("dualListAdmPerfil")
	public BaseDualList<AdmPerfil> getDualListAdmPerfil() {
		return dualListAdmPerfil;
	}

	/**
	 * Atribui o the dual list adm perfil.
	 *
	 * @param dualListAdmPerfil
	 *            o novo the dual list adm perfil
	 */
	public void setDualListAdmPerfil(BaseDualList<AdmPerfil> dualListAdmPerfil) {
		this.dualListAdmPerfil = dualListAdmPerfil;
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
	 * Pega o the lista adm pagina inicial.
	 *
	 * @return o the lista adm pagina inicial
	 */
	@ModelAttribute("listaAdmPaginaInicial")
	public List<AdmPagina> getListaAdmPaginaInicial() {
		return listaAdmPaginaInicial;
	}

	/**
	 * Atribui o the lista adm pagina inicial.
	 *
	 * @param listaAdmPaginaInicial
	 *            o novo the lista adm pagina inicial
	 */
	public void setListaAdmPaginaInicial(List<AdmPagina> listaAdmPaginaInicial) {
		this.listaAdmPaginaInicial = listaAdmPaginaInicial;
	}
	
	/**
	 * Inits the binder.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	protected void initBinder(final WebDataBinder binder) {
		//binder.registerCustomEditor(AdmPerfil.class, new AdmPerfilPropertyEditor());
				
		CustomCollectionEditor AdmPerfilCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

		            Optional<AdmPerfil> admPerfil = admPerfilService.load(Long.valueOf(id));
		    		if (admPerfil.isPresent()) {            
		    			return admPerfil;
		    		} else {
		    			return null;
		    		}
                }
                //throw new RuntimeException(element);
                return null;
            }
        };
        binder.registerCustomEditor(List.class, "admPerfils", AdmPerfilCollector);
		//binder.registerCustomEditor(List.class, "admPerfils", new AdmPerfilCollector(List.class));
        
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
	}

}

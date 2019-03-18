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

import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;
import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmPaginaService;
import br.com.hfsframework.admin.service.AdmPerfilService;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.base.BaseDualList;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;
import springfox.documentation.annotations.ApiIgnore;

/**
 * The Class AdmPerfilController.
 */
@ApiIgnore
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
		
	/** The vw adm usuario Service. */
	@Autowired
	private AdmUsuarioService admUsuarioService;

	/** The dual list adm usuario. */
	private BaseDualList<AdmUsuario> dualListAdmUsuario;

	/** The lista adm usuario. */
	private List<AdmUsuario> listaAdmUsuario;
		
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
	 * Carregar adm usuarios.
	 */
	private void carregarAdmUsuarios() {
		List<AdmUsuario> listaAdmUsuarioSelecionado = this.getBean().getId() == null ? new ArrayList<AdmUsuario>()
				: this.getBusinessController().findUsuariosPorPerfil(this.getBean());
		this.listaAdmUsuario = StreamSupport.stream(admUsuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmUsuario.removeAll(listaAdmUsuarioSelecionado);
		this.dualListAdmUsuario = new BaseDualList<AdmUsuario>(this.listaAdmUsuario, listaAdmUsuarioSelecionado);
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

		this.listaAdmUsuario = StreamSupport.stream(admUsuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmUsuario = new BaseDualList<AdmUsuario>(this.listaAdmUsuario, new ArrayList<AdmUsuario>());
		
		return super.incluir(new AdmPerfil());
	}
	
	@Override
	@GetMapping("/editar/{id}")	
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView retorno = super.editar(id);		
		if (!retorno.isEmpty()) {
			carregarAdmPaginas();
			carregarAdmUsuarios();
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
		getBean().setAdmUsuarios(this.dualListAdmUsuario.getTarget());
		
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
	 * Gets the dual list adm usuario.
	 *
	 * @return the dual list adm usuario
	 */
	@ModelAttribute("dualListAdmUsuario")
	public BaseDualList<AdmUsuario> getDualListAdmUsuario() {
		return dualListAdmUsuario;
	}
		
	/**
	 * Sets the dual list adm usuario.
	 *
	 * @param dualListAdmUsuario
	 *            the new dual list adm usuario
	 */
	public void setDualListAdmUsuario(BaseDualList<AdmUsuario> dualListAdmUsuario) {
		this.dualListAdmUsuario = dualListAdmUsuario;
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
               
		CustomCollectionEditor AdmUsuarioCollector = new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                if (element instanceof String) {
                    Long id = Long.parseLong((String) element);

		            Optional<AdmUsuario> admUsuario = admUsuarioService.load(Long.valueOf(id));
		    		if (admUsuario.isPresent()) {            
		    			return admUsuario;
		    		} else {
		    			return null;
		    		}
                }
                //throw new RuntimeException(element);
                return null;
            }
        };
        binder.registerCustomEditor(List.class, "admUsuarios", AdmUsuarioCollector);
        
	}
	
}

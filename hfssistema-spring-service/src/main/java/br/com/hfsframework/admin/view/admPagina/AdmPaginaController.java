/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admPagina;

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
 * The Class AdmPaginaController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admPaginaMB")
public class AdmPaginaController
		extends BaseViewCadastro<AdmPagina, Long, AdmPaginaService>
		implements IBaseViewCadastro<AdmPagina, Long>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmPaginaRelController rel;
	
	@Autowired
	private AdmPerfilService admPerfilService;

	private BaseDualList<AdmPerfil> dualListAdmPerfil;

	private List<AdmPerfil> listaAdmPerfil;
	
	@Autowired
	private AdmFuncionalidadeService admFuncionalidadeService;

	private BaseDualList<AdmFuncionalidade> dualListAdmFuncionalidade;

	private List<AdmFuncionalidade> listaAdmFuncionalidade;
	
	/**
	 * Instantiates a new AdmPaginaController.
	 */
	public AdmPaginaController() {
		super(new AdmPagina(),
			"/private/admin/admPagina/listarAdmPagina",
			"/private/admin/admPagina/editarAdmPagina", 
			"/admPaginaMB");
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		atualizaListaDataTable();
	}
	
	/**
	 * Carregar adm perfis.
	 */
	private void carregarAdmPerfis() {
		List<AdmPerfil> listaAdmPerfilSelecionado = this.getBean().getId() == null ? new ArrayList<AdmPerfil>()
				: this.getBusinessController().getRepositorio().findPerfisPorPagina(this.getBean());
		this.listaAdmPerfil = StreamSupport.stream(admPerfilService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		this.listaAdmPerfil.removeAll(listaAdmPerfilSelecionado);
		this.dualListAdmPerfil = new BaseDualList<AdmPerfil>(this.listaAdmPerfil, listaAdmPerfilSelecionado);
	}

	/**
	 * Carregar adm funcionalidades.
	 */
	private void carregarAdmFuncionalidades() {
		List<AdmFuncionalidade> listaAdmFuncionalidadeSelecionado = this.getBean().getId() == null ? new ArrayList<AdmFuncionalidade>()
				: this.getBusinessController().getRepositorio().findFuncionalidadesPorPagina(this.getBean());
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
		this.listaAdmPerfil = StreamSupport.stream(admPerfilService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmPerfil = new BaseDualList<AdmPerfil>(this.listaAdmPerfil, new ArrayList<AdmPerfil>());
		
		this.listaAdmFuncionalidade = StreamSupport.stream(admFuncionalidadeService.findAll().spliterator(), false)
				.collect(Collectors.toList());
	    this.dualListAdmFuncionalidade = new BaseDualList<AdmFuncionalidade>(this.listaAdmFuncionalidade, new ArrayList<AdmFuncionalidade>());
		
		return super.incluir(new AdmPagina());
	}
	
	@Override
	@GetMapping("/editar/{id}")	
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView retorno = super.editar(id);		
		if (!retorno.isEmpty()) {
			carregarAdmPerfis();
			carregarAdmFuncionalidades();
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
	public RedirectView salvar(@Valid AdmPagina obj, 
			BindingResult result, RedirectAttributes attributes) {
		
		getBean().setAdmPerfils(this.dualListAdmPerfil.getTarget());
		getBean().setAdmFuncionalidades(this.dualListAdmFuncionalidade.getTarget());
		
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
	public AdmPagina getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmPagina entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmPagina> getListaBean() {
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
	public void setListaBean(List<AdmPagina> listaEntidade) {
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
	 * Pega o the dual list adm funcionalidade.
	 *
	 * @return o the dual list adm funcionalidade
	 */
	@ModelAttribute("dualListAdmFuncionalidade")
	public BaseDualList<AdmFuncionalidade> getDualListAdmFuncionalidade() {
		return dualListAdmFuncionalidade;
	}
		
	/**
	 * Atribui o the dual list adm funcionalidade.
	 *
	 * @param dualListAdmFuncionalidade
	 *            o novo the dual list adm funcionalidade
	 */
	public void setDualListAdmFuncionalidade(BaseDualList<AdmFuncionalidade> dualListAdmFuncionalidade) {
		this.dualListAdmFuncionalidade = dualListAdmFuncionalidade;
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
	}
	
}

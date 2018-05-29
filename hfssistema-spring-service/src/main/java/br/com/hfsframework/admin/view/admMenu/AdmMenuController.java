/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.hfsframework.admin.model.AdmFuncionalidade;
import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.service.AdmFuncionalidadeService;
import br.com.hfsframework.admin.service.AdmMenuService;
import br.com.hfsframework.base.BaseTreeNode;
import br.com.hfsframework.base.IBaseTreeNode;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

/**
 * The Class AdmMenuController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admMenuMB")
public class AdmMenuController
		extends BaseViewConsulta<AdmMenu, Long, AdmMenuService>
		implements IBaseViewConsulta<AdmMenu>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmMenuRelController rel;
	
	/** The adm funcionalidade Service. */
	@Autowired
	private AdmFuncionalidadeService admFuncionalidadeService;

	/** The menu root. */
	private IBaseTreeNode menuRoot;

	/** The menu selecionado. */
	private IBaseTreeNode menuSelecionado;

	/** The novo item menu. */
	private AdmMenu novoItemMenu;
	
	/** The lista adm funcionalidade. */
	private List<AdmFuncionalidade> listaAdmFuncionalidade;

	/** The lista menus pai. */
	private List<AdmMenu> listaMenusPai;
	
	/**
	 * Instantiates a new AdmMenuController.
	 */
	public AdmMenuController() {
		super(new AdmMenu(),
			"/private/admin/admMenu/listarAdmMenu",
			"/admMenuMB");
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		//atualizaListaDataTable();

		atualizarArvoreMenus();
		initListaFuncionalidade();
		initListaMenusPai();
		this.novoItemMenu = new AdmMenu();
	}
	
	@Override
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mv = super.listar();
		
		mv.addObject("bean", this.getBean());
		return mv;
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
	 * @see br.com.hfsframework.base.BaseViewCadastro#excluir(java.lang.
	 * Object)
	 */
	public void excluir(AdmMenu entidade) {
		// super.excluir(entidade);
		if (this.menuSelecionado == null) {
			gerarMensagemErro("Favor selecionar um item de menu para continuar.");
			return;
		}
		AdmMenu m = (AdmMenu) this.menuSelecionado.getData();
		this.getBusinessController().apagar(m);
		atualizarArvoreMenus();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getBean()
	 */
	@Override
	public AdmMenu getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmMenu entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmMenu> getListaBean() {
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
	public void setListaBean(List<AdmMenu> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Pega o the menu root.
	 *
	 * @return o the menu root
	 */
	public IBaseTreeNode getMenuRoot() {
		return menuRoot;
	}

	/**
	 * Atribui o the menu root.
	 *
	 * @param menuRoot
	 *            o novo the menu root
	 */
	public void setMenuRoot(IBaseTreeNode menuRoot) {
		this.menuRoot = menuRoot;
	}

	/**
	 * Pega o the menu selecionado.
	 *
	 * @return o the menu selecionado
	 */
	public IBaseTreeNode getMenuSelecionado() {
		return menuSelecionado;
	}

	/**
	 * Atribui o the menu selecionado.
	 *
	 * @param menuSelecionado
	 *            o novo the menu selecionado
	 */
	public void setMenuSelecionado(IBaseTreeNode menuSelecionado) {
		this.menuSelecionado = menuSelecionado;
	}

	/**
	 * Pega o the novo item menu.
	 *
	 * @return o the novo item menu
	 */
	@ModelAttribute("novoItemMenu")
	public AdmMenu getNovoItemMenu() {
		return novoItemMenu;
	}

	/**
	 * Atribui o the novo item menu.
	 *
	 * @param novoItemMenu
	 *            o novo the novo item menu
	 */
	public void setNovoItemMenu(AdmMenu novoItemMenu) {
		this.novoItemMenu = novoItemMenu;
	}

	/**
	 * Pega o the lista adm funcionalidade.
	 *
	 * @return o the lista adm funcionalidade
	 */
	@ModelAttribute("listaAdmFuncionalidade")
	public List<AdmFuncionalidade> getListaAdmFuncionalidade() {
		return listaAdmFuncionalidade;
	}

	/**
	 * Atribui o the lista adm funcionalidade.
	 *
	 * @param listaAdmFuncionalidade
	 *            o novo the lista adm funcionalidade
	 */
	public void setListaAdmFuncionalidade(List<AdmFuncionalidade> listaAdmFuncionalidade) {
		this.listaAdmFuncionalidade = listaAdmFuncionalidade;
	}

	/**
	 * Pega o the lista menus pai.
	 *
	 * @return o the lista menus pai
	 */
	@ModelAttribute("listaMenusPai")
	public List<AdmMenu> getListaMenusPai() {
		return listaMenusPai;
	}

	/**
	 * Atribui o the lista menus pai.
	 *
	 * @param listaMenusPai
	 *            o novo the lista menus pai
	 */
	public void setListaMenusPai(List<AdmMenu> listaMenusPai) {
		this.listaMenusPai = listaMenusPai;
	}

	/**
	 * Inicia o lista menus pai.
	 */
	private void initListaMenusPai() {
		this.listaMenusPai = new ArrayList<AdmMenu>();
		List<AdmMenu> registrosCadastrados = StreamSupport.stream(getBusinessController().findAll().spliterator(), false)
		.collect(Collectors.toList());
		
		for (AdmMenu menu : registrosCadastrados) {
			if ((menu.getAdmSubMenus() != null) && (menu.getAdmFuncionalidade() == null)) {
				this.listaMenusPai.add(menu);
			}
		}
	}

	/**
	 * Inicia o lista funcionalidade.
	 */
	private void initListaFuncionalidade() {
		this.listaAdmFuncionalidade = StreamSupport.stream(admFuncionalidadeService.findAll().spliterator(), false)
		.collect(Collectors.toList());
	}

	/**
	 * Atualizar arvore menus.
	 */
	public void atualizarArvoreMenus() {
		List<AdmMenu> listaMenus = this.getBusinessController().getRepositorio().findMenuRaiz();

		AdmMenu menu = new AdmMenu();
		menu.setDescricao("Menu do Sistema");
		this.menuRoot = new BaseTreeNode(menu, null);
		for (AdmMenu itemMenu : listaMenus) {
			IBaseTreeNode m = new BaseTreeNode(itemMenu, this.menuRoot);
			montaSubMenu(itemMenu, m);
		}
	}

	/**
	 * Monta sub menu.
	 *
	 * @param menu
	 *            the menu
	 * @param pMenu
	 *            the menu
	 * @return the list
	 */
	private List<IBaseTreeNode> montaSubMenu(AdmMenu menu, IBaseTreeNode pMenu) {
		List<IBaseTreeNode> lstSubMenu = new ArrayList<IBaseTreeNode>();
		if (menu.getAdmSubMenus() != null) {
			for (AdmMenu subMenu : menu.getAdmSubMenus()) {
				if (subMenu.isSubMenu()) {
					IBaseTreeNode m = new BaseTreeNode(subMenu, pMenu);
					montaSubMenu(subMenu, m);
				} else {
					new BaseTreeNode(subMenu, pMenu);
				}
			}
		}
		return lstSubMenu;
	}

	/**
	 * Sugerir nome item menu.
	 */
	public void sugerirNomeItemMenu() {
		if ((getNovoItemMenu().getAdmFuncionalidade() != null) && (getNovoItemMenu().getDescricao() == null)) {
			getNovoItemMenu().setDescricao(getNovoItemMenu().getAdmFuncionalidade().getDescricao());
		}
	}

	/*
	 * On drag drop.
	 *
	 * @param event
	 *            the event
	 *
	public void onDragDrop(TreeDragDropEvent event) {
		IBaseTreeNode dragNode = event.getDragNode();
		IBaseTreeNode dropNode = event.getDropNode();
		int dropIndex = event.getDropIndex();

		AdmMenu menuMover = (AdmMenu) dragNode.getData();
		AdmMenu menuPai = (AdmMenu) dropNode.getData();

		int ordem = 1;
		for (IBaseTreeNode tn : dropNode.getChildren()) {
			AdmMenu menu = (AdmMenu) tn.getData();
			menu.setOrdem(Integer.valueOf(ordem));
			ordem++;
		}
		ordem = 1;
		menuMover.setOrdem(Integer.valueOf(dropIndex + 1));
		if ((menuMover.getAdmMenuPai() != null) && (!menuMover.getAdmMenuPai().equals(menuPai))) {
			for (AdmMenu menu : menuMover.getAdmMenuPai().getAdmSubMenus()) {
				menu.setOrdem(Integer.valueOf(ordem));
				ordem++;
			}
		}
		if (menuPai.getId() == null) {
			menuPai = null;
		}
		this.getBusinessController().salvarOuAtualizarDragReordenando(menuMover.getAdmMenuPai(), menuPai, menuMover);

		atualizarArvoreMenus();
	}
	*/

	/*
	 * Gets the nome recursivo.
	 *
	 * @param m
	 *            the m
	 * @return the nome recursivo
	 *
	public static String getNomeRecursivo(AdmMenu m) {
		return m.getAdmFuncionalidade() == null ? m.getDescricao()
				: m.getAdmMenuPai() != null ? getNomeRecursivo(m.getAdmMenuPai()) + " -> " + m.getDescricao() : "";
	}
	*/

	/*
	 * Listener menu selecionado.
	 *
	 * @param event
	 *            the event
	 *
	public void listenerMenuSelecionado(NodeSelectEvent event) {
		this.menuSelecionado = event.getTreeNode();
	}
	*/
	
	/*
	 * Gets the dual list vw adm funcionario.
	 *
	 * @return the dual list vw adm funcionario
	 *
	public DualListModel<AdmFuncionarioDTO> getDualListVwAdmFuncionario() {
		return dualListVwAdmFuncionario;
	}
		
	**
	 * Sets the dual list vw adm funcionario.
	 *
	 * @param dualListVwAdmFuncionario
	 *            the new dual list vw adm funcionario
	 *
	public void setDualListVwAdmFuncionario(DualListModel<AdmFuncionarioDTO> dualListVwAdmFuncionario) {
		this.dualListVwAdmFuncionario = dualListVwAdmFuncionario;
	}
	*/
	
	public void onIncluirItemMenu() {
		this.menuSelecionado = null;
		this.novoItemMenu = new AdmMenu();
		atualizarArvoreMenus();
		initListaMenusPai();
	}

	public void onEditarItemMenu() {
		atualizarArvoreMenus();
		initListaMenusPai();
		if (this.menuSelecionado == null) {
			gerarMensagemErro("Favor selecionar um item de menu para proceder esta ação.");
			//context.validationFailed();
		} else {
			AdmMenu menuSel = (AdmMenu) this.menuSelecionado.getData();
			Optional<AdmMenu> itemMenu =  this.getBusinessController()
					.load(menuSel.getId().longValue());
			if (itemMenu.isPresent()) {
				this.novoItemMenu = (AdmMenu) itemMenu.get();
			}
		}
	}

	public String salvarItemMenu() {
		int ordem;
		
		if ((this.novoItemMenu.getDescricao() == null) || (this.novoItemMenu.getDescricao().trim().isEmpty())) {
			gerarMensagemErro("Erro. Nome do Item de Menu. Campo Obrigatório.");
			//context.validationFailed();
		} else {
			/*
			if (getBusinessController().existeNovo(this.novoItemMenu.getDescricao())){
				gerarMensagemErro("Nome do Item de Menu já existe.");
				return null;					
			}
			*/
			try {
				if (this.novoItemMenu.getAdmMenuPai()!=null)
					ordem = this.novoItemMenu.getAdmMenuPai().getAdmSubMenus().size() + 2;
				else
					ordem = 1;
				
				this.novoItemMenu.setOrdem(ordem);
				if (this.novoItemMenu.getAdmFuncionalidade()!=null){
					this.novoItemMenu.setIdFuncionalidade(this.novoItemMenu.getAdmFuncionalidade().getId());
				} else {
					this.novoItemMenu.setIdFuncionalidade(null);
				}
				this.getBusinessController().salvarOuAtualizar(this.novoItemMenu);
				this.novoItemMenu = new AdmMenu();
				atualizarArvoreMenus();
			} catch (Exception e) {
				gerarMensagemErro(e, ERRO_SALVAR);
				return null;
			}			
		}
		return getPaginaListar();
	}

	public void excluirItemMenu() {
		if (this.menuSelecionado == null) {
			gerarMensagemErro("Favor selecionar um item de menu para proceder esta ação.");
			return;
		}
		try {
			AdmMenu m = (AdmMenu) this.menuSelecionado.getData();
			this.getBusinessController().apagar(m);
			atualizarArvoreMenus();
		} catch (Exception e) {
			gerarMensagemErro(e, ERRO_DELETE);
			return;
		}
	}
	
}

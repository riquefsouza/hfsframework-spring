/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseViewCadastro.
 *
 * @param <T>            the generic type
 * @param <I>            the generic type
 * @param <B>            the generic type
 */
@TratamentoErrosEsperados
public abstract class BaseViewCadastro<T extends Serializable, I extends Serializable, 
	B extends BaseBusinessService<T, I, ? extends JpaRepository<T, I>>
		> extends BaseViewController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pagina listar. */
	private String paginaListar;
	
	/** The pagina editar. */
	private String paginaEditar;

	/** The business controller. */
	@Autowired
	private B businessController;

	/** The lista entidade. */
	private Iterable<T> listaEntidade;

	/** The entidade. */
	//@Autowired
	private Optional<T> entidade;
	
	/** The modo incluir. */
	private boolean modoIncluir;
	
	/** The modo salvo. */
	private boolean modoSalvo;
	
	/** The mostrar btn incluir. */
	private boolean mostrarBtnIncluir;
	
	/** The mostrar btn excluir. */
	private boolean mostrarBtnExcluir;
	
	/** The mostrar btn editar. */
	private boolean mostrarBtnEditar;
	
	/** The mostrar btn salvar. */
	private boolean mostrarBtnSalvar;
	
	/** The mostrar btn limpar. */
	private boolean mostrarBtnLimpar;
	
	/**
	 * Instantiates a new base view cadastro.
	 *
	 * @param entidade the entidade
	 * @param paginaListar            the pagina listar
	 * @param paginaEditar            the pagina editar
	 */
	public BaseViewCadastro(Optional<T> entidade, String paginaListar, String paginaEditar){
		super();
		this.modoIncluir = false;
		this.modoSalvo = false;
		
		this.entidade = entidade;
		this.paginaListar = paginaListar;
		this.paginaEditar = paginaEditar;
		
		this.mostrarBtnIncluir = true;
		this.mostrarBtnExcluir = true;
		this.mostrarBtnEditar = true;
		this.mostrarBtnSalvar = true;
		this.mostrarBtnLimpar = true;
	}

	/**
	 * Atualiza lista data table.
	 */
	protected void atualizaListaDataTable() {
		this.listaEntidade = businessController.findAll();
	}

	/**
	 * Pega o the pagina listar.
	 *
	 * @return o the pagina listar
	 */
	public String getPaginaListar() {
		return paginaListar;
	}

	/**
	 * Pega o the pagina editar.
	 *
	 * @return o the pagina editar
	 */
	public String getPaginaEditar() {
		return paginaEditar;
	}

	/**
	 * On incluir.
	 *
	 * @param entidade
	 *            the entidade
	 * @return the string
	 */
	protected String onIncluir(Optional<T> entidade) {
		this.modoIncluir = true;
		
		setEntidade(entidade);

		return getPaginaEditar();
	}

	/**
	 * On editar.
	 *
	 * @param entidade
	 *            the entidade
	 * @return the string
	 */
	public String onEditar(Optional<T> entidade) {
		this.modoIncluir = false;
		
		if (entidade == null) {
			gerarMensagemErro(SELECIONAR_REGISTRO);
			return "";
		}
		setEntidade(entidade);
		return getPaginaEditar();
	}

	/**
	 * Preparar para excluir.
	 *
	 * @param entidade
	 *            the entidade
	 */
	public void prepararParaExcluir(Optional<T> entidade) {
		if (entidade == null) {
			gerarMensagemErro(SELECIONAR_REGISTRO);
			return;
		}
		//RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
	}

	/**
	 * Excluir.
	 *
	 * @param entidade
	 *            the entidade
	 * @param contemErro
	 *            the contem erro
	 * @param mensagemErro
	 *            the mensagem erro
	 */
	public void excluir(Optional<T> entidade, String contemErro, String mensagemErro) {
		if (entidade == null) {
			gerarMensagemErro(SELECIONAR_REGISTRO);
			return;
		}
		try {
			businessController.delete(entidade.get());
			atualizaListaDataTable();
		} catch (Exception e) {
			if (e.getCause().toString().contains(contemErro)) {
				gerarMensagemErro(e, ERRO_DELETE + mensagemErro);
			} else {
				gerarMensagemErro(e, ERRO_DELETE);
			}
			return;
		}
	}

	/**
	 * Excluir.
	 *
	 * @param entidade
	 *            the entidade
	 */
	public void excluir(Optional<T> entidade) {
		this.excluir(entidade, "", "");
	}
	
	/**
	 * Cancelar edicao.
	 *
	 * @return the string
	 */
	public String cancelarEdicao() {
		return getPaginaListar();
	}

	/**
	 * Salvar.
	 *
	 * @param id
	 *            the id
	 * @param descricao
	 *            the descricao
	 * @param contemErro
	 *            the contem erro
	 * @param mensagemErro
	 *            the mensagem erro
	 * @return the string
	 */
	protected String salvar(I id, String descricao, String contemErro, String mensagemErro) {
		
		
		if (descricao!=null){
			if (descricao.isEmpty()) {
				gerarMensagemErro("Campo 'Descrição' não pode ser vazio.");
				return null;
			}
			
			if (modoIncluir){
				if (this.businessController.existeNovo(descricao)){
					gerarMensagemErro("Campo 'Descrição' já existe.");
					return null;					
				}
			} else {				
				if (this.businessController.existeAntigo(id, descricao)){
					gerarMensagemErro("Campo 'Descrição' já existe.");
					return null;										
				}				
			}
		}
		
		
		try {
			if (id == null) {
				setEntidade(this.businessController.insert(getEntidade().get()));
			} else {
				setEntidade(this.businessController.update(getEntidade().get()));
			}
			
			this.modoSalvo = true;
			
		} catch (Exception e) {
			this.modoSalvo = false;
			
			if (e.getMessage().contains(contemErro)) {
				gerarMensagemErro(e, ERRO_SALVAR + mensagemErro);
			} else {
				gerarMensagemErro(e, ERRO_SALVAR);
			}
			return null;
		}
		atualizaListaDataTable();
		return getPaginaListar();
	}
	
	/**
	 * Salvar.
	 *
	 * @param id
	 *            the id
	 * @param descricao
	 *            the descricao
	 * @return the string
	 */
	protected String salvar(I id, String descricao) {
		return this.salvar(id, descricao, "", "");
	}

	/**
	 * Salvar.
	 *
	 * @param id
	 *            the id
	 * @return the string
	 */
	protected String salvar(I id) {
		return this.salvar(id, null, "", "");
	}

	/**
	 * Cancelar.
	 *
	 * @return the string
	 */
	public String cancelar() {
		return getPaginaDesktop();
	}

	/**
	 * Pega o the entidade.
	 *
	 * @return o the entidade
	 */
	public Optional<T> getEntidade() {
		return this.entidade;
	}

	/**
	 * Atribui o the entidade.
	 *
	 * @param entidade
	 *            o novo the entidade
	 */
	public void setEntidade(Optional<T> entidade) {
		this.entidade = entidade;
	}

	/**
	 * Pega o the lista entidade.
	 *
	 * @return o the lista entidade
	 */
	public Iterable<T> getListaEntidade() {
		return this.listaEntidade;
	}

	/**
	 * Atribui o the lista entidade.
	 *
	 * @param listaEntidade
	 *            o novo the lista entidade
	 */
	public void setListaEntidade(List<T> listaEntidade) {
		this.listaEntidade = listaEntidade;
	}

	/**
	 * Pega o the business controller.
	 *
	 * @return o the business controller
	 */
	public B getBusinessController() {
		return businessController;
	}

	/**
	 * Checa se é the modo incluir.
	 *
	 * @return o the modo incluir
	 */
	public boolean isModoIncluir() {
		return modoIncluir;
	}

	/**
	 * Checa se é the modo salvo.
	 *
	 * @return o the modo salvo
	 */
	public boolean isModoSalvo() {
		return modoSalvo;
	}

	/**
	 * Checa se é the mostrar btn excluir.
	 *
	 * @return o the mostrar btn excluir
	 */
	public boolean isMostrarBtnExcluir() {
		return mostrarBtnExcluir;
	}

	/**
	 * Atribui o the mostrar btn excluir.
	 *
	 * @param mostrarBtnExcluir
	 *            o novo the mostrar btn excluir
	 */
	public void setMostrarBtnExcluir(boolean mostrarBtnExcluir) {
		this.mostrarBtnExcluir = mostrarBtnExcluir;
	}

	/**
	 * Checa se é the mostrar btn editar.
	 *
	 * @return o the mostrar btn editar
	 */
	public boolean isMostrarBtnEditar() {
		return mostrarBtnEditar;
	}

	/**
	 * Atribui o the mostrar btn editar.
	 *
	 * @param mostrarBtnEditar
	 *            o novo the mostrar btn editar
	 */
	public void setMostrarBtnEditar(boolean mostrarBtnEditar) {
		this.mostrarBtnEditar = mostrarBtnEditar;
	}

	/**
	 * Checks if is mostrar btn incluir.
	 *
	 * @return true, if is mostrar btn incluir
	 */
	public boolean isMostrarBtnIncluir() {
		return mostrarBtnIncluir;
	}

	/**
	 * Sets the mostrar btn incluir.
	 *
	 * @param mostrarBtnIncluir
	 *            the new mostrar btn incluir
	 */
	public void setMostrarBtnIncluir(boolean mostrarBtnIncluir) {
		this.mostrarBtnIncluir = mostrarBtnIncluir;
	}

	/**
	 * Checks if is mostrar btn salvar.
	 *
	 * @return true, if is mostrar btn salvar
	 */
	public boolean isMostrarBtnSalvar() {
		return mostrarBtnSalvar;
	}

	/**
	 * Sets the mostrar btn salvar.
	 *
	 * @param mostrarBtnSalvar
	 *            the new mostrar btn salvar
	 */
	public void setMostrarBtnSalvar(boolean mostrarBtnSalvar) {
		this.mostrarBtnSalvar = mostrarBtnSalvar;
	}

	/**
	 * Checks if is mostrar btn limpar.
	 *
	 * @return true, if is mostrar btn limpar
	 */
	public boolean isMostrarBtnLimpar() {
		return mostrarBtnLimpar;
	}

	/**
	 * Sets the mostrar btn limpar.
	 *
	 * @param mostrarBtnLimpar
	 *            the new mostrar btn limpar
	 */
	public void setMostrarBtnLimpar(boolean mostrarBtnLimpar) {
		this.mostrarBtnLimpar = mostrarBtnLimpar;
	}

}

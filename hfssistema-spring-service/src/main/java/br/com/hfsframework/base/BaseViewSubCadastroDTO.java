/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;

public abstract class BaseViewSubCadastroDTO<P, T, I extends Serializable, B extends IBaseCrud<T, I>, L> extends BaseViewController implements Serializable {

	private static final long serialVersionUID = 1L;

	/** The pagina editar. */
	private L paginaEditar;

	/** The business controller. */
	@Inject
	private B businessController;

	/** The entidade pai. */
	@Inject
	private P entidadePai;

	/** The entidade. */
	@Inject
	private T entidade;
	
	/** The modo incluir. */
	private boolean modoIncluir;
	
	/** The modo salvo. */
	private boolean modoSalvo;

	/**
	 * Instantiates a new base view sub cadastro.
	 *
	 * @param paginaEditar
	 *            the pagina editar
	 */
	public BaseViewSubCadastroDTO(L paginaEditar) {
		super();
		this.modoIncluir = false;
		this.modoSalvo = false;
		
		this.paginaEditar = paginaEditar;
	}

	/**
	 * Pega o the pagina editar.
	 *
	 * @return o the pagina editar
	 */
	public String getPaginaEditar() {
		return (String)paginaEditar;
	}

	/**
	 * Preparar para excluir.
	 *
	 * @param entidade
	 *            the entidade
	 * @param nomeConfirmacao
	 *            the nome confirmacao
	 */
	public void prepararParaExcluir(T entidade, String nomeConfirmacao) {
		if (entidade == null) {
			gerarMensagemErro(SELECIONAR_REGISTRO);
			return;
		}
		//RequestContext.getCurrentInstance().execute("PF('" + nomeConfirmacao + "').show()");
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
	public void excluir(T entidade, String contemErro, String mensagemErro) {
		if (entidade == null) {
			gerarMensagemErro(SELECIONAR_REGISTRO);
			return;
		}
		try {
			businessController.delete(entidade);
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
	public void excluir(T entidade) {
		this.excluir(entidade, "", "");
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
		if (descricao != null) {
			if (descricao.isEmpty()) {
				gerarMensagemErro("Campo 'Descrição' não pode ser vazio.");
				return null;
			}
		}

		try {
			if (id == null) {
				this.businessController.insert(getEntidade());
			} else {
				setEntidade((T) this.businessController.update(getEntidade()).get());
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
		//atualizaListaDataTable();
		dialogoFechar(getEntidade());
		
		return "";
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
	 * Pega o the entidade.
	 *
	 * @return o the entidade
	 */
	public T getEntidade() {
		return this.entidade;
	}

	/**
	 * Atribui o the entidade.
	 *
	 * @param entidade
	 *            o novo the entidade
	 */
	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	/**
	 * Pega o the entidade pai.
	 *
	 * @return o the entidade pai
	 */
	public P getEntidadePai() {
		return this.entidadePai;
	}

	/**
	 * Atribui o the entidade pai.
	 *
	 * @param entidadePai
	 *            o novo the entidade pai
	 */
	public void setEntidadePai(P entidadePai) {
		this.entidadePai = entidadePai;
	}

	/**
	 * Pega o the business controller.
	 *
	 * @return o the business controller
	 */
	public B getBusinessController() {
		return businessController;
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseViewController#preProcessPDF(java.lang.Object, java.lang.String)
	 */
	public void preProcessPDF(Object document, String tituloRelatorio)
			throws IOException, BadElementException, DocumentException {
		//pdfUtils.preProcessaPDF(document, tituloRelatorio);
	}

	/**
	 * Dialogo.
	 *
	 * @param entidadePai
	 *            the entidade pai
	 * @param entidade
	 *            the entidade
	 * @param incluir
	 *            the incluir
	 */
	protected void dialogo(P entidadePai, T entidade, boolean incluir) {
		this.modoIncluir = incluir;
		
		if (!incluir) {
			if (entidade == null) {
				gerarMensagemErro(SELECIONAR_REGISTRO);
				return;
			}
		}
		setEntidadePai(entidadePai);
		setEntidade(entidade);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", false);
		//options.put("closable", true);
		// options.put("width", 400);
		// options.put("height", 400);
		// options.put("contentWidth", 640);
		// options.put("contentHeight", "auto");

		//if (incluir)
			//RequestContext.getCurrentInstance().execute("PF('dialogGarantia').show()");
		//else
			//RequestContext.getCurrentInstance().openDialog(getPaginaEditar(), options, null);
			
/*
		<p:dialog widgetVar="dialogGarantia" modal="true" draggable="false" resizable="false">
			<ui:include src="/private/contratoGarantia/editarContratoGarantia2.xhtml" >
				<ui:param name="contratoGarantiaMB" value="#{contratoGarantiaMB}" />
			</ui:include>
		</p:dialog>
		
 */
	}
	
	/**
	 * Dialogo incluir.
	 *
	 * @param entidadePai
	 *            the entidade pai
	 * @param entidade
	 *            the entidade
	 */
	public void dialogoIncluir(P entidadePai, T entidade) {
		this.dialogo(entidadePai, entidade, true);
	}
	
	/**
	 * Dialogo editar.
	 *
	 * @param entidadePai
	 *            the entidade pai
	 * @param entidade
	 *            the entidade
	 */
	public void dialogoEditar(P entidadePai, T entidade) {
		this.dialogo(entidadePai, entidade, false);		
	}

	/**
	 * On dialogo retorno.
	 *
	 * @param event
	 *            the event
	 */
	@SuppressWarnings("unchecked")
	public void onDialogoRetorno(Object event) {		
		if (event == null) {
			return;
		}
		setEntidade((T) event);
		gerarMensagemInformativa("Cadastrado realizado com sucesso! " + entidade.toString());
	}

	/**
	 * Dialogo fechar.
	 *
	 * @param entidade
	 *            the entidade
	 */
	public void dialogoFechar(T entidade) {
		//RequestContext.getCurrentInstance().closeDialog(entidade);
	}
	
	/**
	 * Dialogo mensagem.
	 *
	 * @param mensagem
	 *            the mensagem
	 */
	protected void dialogoMensagem(String mensagem) {
		//addMessageInfoDialog(mensagem);
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

}

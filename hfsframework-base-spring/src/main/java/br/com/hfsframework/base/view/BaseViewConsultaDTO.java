/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base.view;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.hfsframework.base.IBaseCrud;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseViewConsultaDTO.
 *
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 * @param <B>
 *            the generic type
 * @param <L>
 *            the generic type
 */
@TratamentoErrosEsperados
public abstract class BaseViewConsultaDTO<T, I extends Serializable, 
	B extends IBaseCrud<T, I>> extends BaseViewController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The mapeamento. */
	private String mapeamento;
	
	/** The pagina listar. */
	private String paginaListar;
	
	/** The business controller. */
	@Autowired
	private B businessController;

	/** The lista entidade. */
	private Iterable<T> listaEntidade;

	/** The entidade. */
	@Inject
	private T entidade;
	
	/**
	 * Instantiates a new base view cadastro.
	 *
	 * @param paginaListar
	 *            the pagina listar
	 */
	public BaseViewConsultaDTO(T entidade, String paginaListar, 
			String mapeamento) {
		super();
		this.entidade = entidade;
		this.paginaListar = paginaListar;
		this.mapeamento = mapeamento;
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
		return (String)paginaListar;
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
	public void setListaEntidade(Iterable<T> listaEntidade) {
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
	 * Gets the mapeamento.
	 *
	 * @return the mapeamento
	 */
	public String getMapeamento() {
		return mapeamento;
	}

	/**
	 * Sets the mapeamento.
	 *
	 * @param mapeamento
	 *            the new mapeamento
	 */
	public void setMapeamento(String mapeamento) {
		this.mapeamento = mapeamento;
	}
}

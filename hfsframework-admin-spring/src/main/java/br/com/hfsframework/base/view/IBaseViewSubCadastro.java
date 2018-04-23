/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base.view;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBaseViewSubCadastro.
 *
 * @param <P>
 *            the generic type
 * @param <T>
 *            the generic type
 */
public interface IBaseViewSubCadastro<P, T> extends Serializable {

	/**
	 * Inicia o.
	 */
	void init();
	
	/**
	 * Checks if is modo incluir.
	 *
	 * @return true, if is modo incluir
	 */
	boolean isModoIncluir();
	
	/**
	 * Checks if is modo salvo.
	 *
	 * @return true, if is modo salvo
	 */
	boolean isModoSalvo();

	/**
	 * On limpar.
	 */
	void onLimpar();
	
	/**
	 * Preparar para excluir.
	 *
	 * @param entidade
	 *            the entidade
	 * @param nomeConfirmacao
	 *            the nome confirmacao
	 */
	void prepararParaExcluir(T entidade, String nomeConfirmacao);

	/**
	 * Excluir.
	 *
	 * @param entidadePai
	 *            the entidade pai
	 * @param entidade
	 *            the entidade
	 */
	void excluir(P entidadePai, T entidade);

	/**
	 * Salvar.
	 *
	 * @return the string
	 */
	String salvar();

	/**
	 * Gets the bean.
	 *
	 * @return the bean
	 */
	T getBean();

	/**
	 * Sets the bean.
	 *
	 * @param entidade
	 *            the new bean
	 */
	void setBean(T entidade);

	/**
	 * Dialogo incluir.
	 *
	 * @param entidadePai
	 *            the entidade pai
	 */
	void dialogoIncluir(P entidadePai);
	
	/**
	 * Dialogo editar.
	 *
	 * @param entidadePai
	 *            the entidade pai
	 * @param entidade
	 *            the entidade
	 */
	void dialogoEditar(P entidadePai, T entidade);
	
	/**
	 * On dialogo retorno.
	 *
	 * @param event
	 *            the event
	 */
	void onDialogoRetorno(Object event);
	
	/**
	 * Dialogo fechar.
	 *
	 * @param entidade
	 *            the entidade
	 */
	void dialogoFechar(T entidade);
	
	/**
	 * Dialogo mensagem.
	 */
	void dialogoMensagem();
}

/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import com.lowagie.text.BadElementException;
import com.lowagie.text.DocumentException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBaseViewCadastro.
 *
 * @param <T>
 *            the generic type
 */
public interface IBaseViewCadastro<T> extends Serializable {

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
	 * On incluir.
	 *
	 * @return the string
	 */
	String onIncluir();

	/**
	 * On editar.
	 *
	 * @param entidade
	 *            the entidade
	 * @return the string
	 */
	String onEditar(T entidade);

	/**
	 * Preparar para excluir.
	 *
	 * @param entidade
	 *            the entidade
	 */
	void prepararParaExcluir(T entidade);

	/**
	 * Excluir.
	 *
	 * @param entidade
	 *            the entidade
	 */
	void excluir(T entidade);

	/**
	 * Cancelar edicao.
	 *
	 * @return the string
	 */
	String cancelarEdicao();

	/**
	 * Salvar.
	 *
	 * @return the string
	 */
	String salvar();

	/**
	 * Cancelar.
	 *
	 * @return the string
	 */
	String cancelar();

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
	 * Gets the lista bean.
	 *
	 * @return the lista bean
	 */
	List<T> getListaBean();

	/**
	 * Sets the lista bean.
	 *
	 * @param listaEntidade
	 *            the new lista bean
	 */
	void setListaBean(List<T> listaEntidade);

	/**
	 * Pre process PDF.
	 *
	 * @param document
	 *            the document
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws BadElementException
	 *             the bad element exception
	 * @throws DocumentException
	 *             the document exception
	 */
	void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException;

}

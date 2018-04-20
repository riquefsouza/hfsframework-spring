/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.hfsframework.util.exceptions.TransacaoException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IBaseCrud.
 *
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public interface IBaseCrud<T, I extends Serializable> extends Serializable {

	/** The Constant ERRO_INSERT. */
	public static final String ERRO_INSERT = "Erro de Transação ao Incluir: ";
	
	/** The Constant ERRO_UPDATE. */
	public static final String ERRO_UPDATE = "Erro de Transação ao Alterar: ";
	
	/** The Constant ERRO_DELETE. */
	public static final String ERRO_DELETE = "Erro de Transação ao Excluir: ";
	
	/**
	 * Load.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	Optional<T> load(I id);	

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	Iterable<T> findAll();
	
	/**
	 * Find all.
	 *
	 * @param p the p
	 * @return the page
	 */
	Page<T> findAll(Pageable p);

	/**
	 * Insert.
	 *
	 * @param bean
	 *            the bean
	 * @return the t
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	Optional<T> insert(T bean) throws TransacaoException;

	/**
	 * Update.
	 *
	 * @param bean
	 *            the bean
	 * @return the t
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	Optional<T> update(T bean) throws TransacaoException;

	/**
	 * Delete.
	 *
	 * @param bean
	 *            the bean
	 * @throws TransacaoException
	 *             the transacao exception
	 */
	void delete(T bean) throws TransacaoException;
	
	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	String getDescricao(I id);
	
	/**
	 * Existe novo.
	 *
	 * @param novo
	 *            the novo
	 * @return true, if successful
	 */
	boolean existeNovo(String novo);
	
	/**
	 * Existe antigo.
	 *
	 * @param id
	 *            the id
	 * @param novo
	 *            the novo
	 * @return true, if successful
	 */
	boolean existeAntigo(I id, String novo);
 
}

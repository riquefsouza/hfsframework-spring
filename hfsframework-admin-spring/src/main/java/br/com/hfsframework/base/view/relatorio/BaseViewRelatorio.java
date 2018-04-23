/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base.view.relatorio;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseViewRelatorio.
 *
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 * @param <B>
 *            the generic type
 */
@TratamentoErrosEsperados
public abstract class BaseViewRelatorio<T extends Serializable, I extends Serializable, 
	B extends BaseBusinessService<T, I, ? extends JpaRepository<T, I>>>
		extends BaseViewRelatorioController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The business controller. */
	@Autowired
	private B businessController;

	/** The entidade. */
	private T entidade;

	/**
	 * Instantiates a new base view relatorio.
	 *
	 * @param entidade the entidade
	 */
	public BaseViewRelatorio(T entidade) {
		super();
		
		this.entidade = entidade;
	}

	/**
	 * Inicia o.
	 */
	@PostConstruct
	public void init() {
		super.init();
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
	 * Pega o the business controller.
	 *
	 * @return o the business controller
	 */
	public B getBusinessController() {
		return businessController;
	}
}

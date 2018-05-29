/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.VwAdmLogValorRepository;
import br.com.hfsframework.admin.model.VwAdmLogValor;
import br.com.hfsframework.base.BaseBusinessService;

// TODO: Auto-generated Javadoc
/**
 * The Class VwAdmLogValorService.
 */
@Service
public class VwAdmLogValorService extends BaseBusinessService<VwAdmLogValor, Long, VwAdmLogValorRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Find by filtros.
	 *
	 * @param usuario the usuario
	 * @param dataNumero the data numero
	 * @param operacao the operacao
	 * @param ip the ip
	 * @param entidade the entidade
	 * @param tabela the tabela
	 * @param chave the chave
	 * @return the list
	 */
	public List<VwAdmLogValor> findByFiltros(String usuario, Long dataNumero, String operacao, String ip,
			String entidade, String tabela, String chave) {
		return repositorio.findByFiltros(usuario, dataNumero, operacao, ip, entidade, tabela, chave);
	}

}

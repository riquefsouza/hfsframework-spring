/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmFuncionarioRepository;
import br.com.hfsframework.admin.model.AdmFuncionario;
import br.com.hfsframework.base.BaseBusinessService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmFuncionarioBC.
 */
@Service
public class AdmFuncionarioService extends BaseBusinessService<AdmFuncionario, Long, AdmFuncionarioRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Find by matricula and CPF.
	 *
	 * @param id the id
	 * @param cpf the cpf
	 * @return the optional
	 */
	@Cacheable("padrao")
	public Optional<AdmFuncionario> findByMatriculaAndCPF(Long id, BigDecimal cpf){
		return repositorio.findByMatriculaAndCPF(id, cpf);
	}
}

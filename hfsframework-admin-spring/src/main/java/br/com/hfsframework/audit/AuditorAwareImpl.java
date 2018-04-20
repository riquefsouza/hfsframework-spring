/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

// TODO: Auto-generated Javadoc
/**
 * The Class AuditorAwareImpl.
 */
public class AuditorAwareImpl implements AuditorAware<String> {

	/* (non-Javadoc)
	 * @see org.springframework.data.domain.AuditorAware#getCurrentAuditor()
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Auditor Padrao");
	}

}

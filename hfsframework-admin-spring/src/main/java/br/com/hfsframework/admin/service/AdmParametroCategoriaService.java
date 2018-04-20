/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmParametroCategoriaRepository;
import br.com.hfsframework.admin.model.AdmParametroCategoria;
import br.com.hfsframework.base.BaseBusinessService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmParametroCategoriaBC.
 */
@Service
public class AdmParametroCategoriaService extends BaseBusinessService<AdmParametroCategoria, Long, AdmParametroCategoriaRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#getDescricao(java.io.Serializable)
	 */
	@Override
	public String getDescricao(Long id){
		return repositorio.getDescricao(id);
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#existeNovo(java.lang.String)
	 */
	@Override
	public boolean existeNovo(String novo){
		Long existe = repositorio.countNovo(novo.toLowerCase());
		return (existe > 0);
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseBusinessService#existeAntigoNovo(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existeAntigo(Long id, String novo){
		String antigo = getDescricao(id);
		Long existe = repositorio.countAntigo(antigo.toLowerCase(), novo.toLowerCase());
		return (existe > 0);
	}
	
}

/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.VwAdmLogRepository;
import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.base.BaseBusinessService;
import br.com.hfsframework.util.DataUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class VwAdmLogBC.
 */
@Service
public class VwAdmLogService extends BaseBusinessService<VwAdmLog, Long, VwAdmLogRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Checks if is string empty.
	 *
	 * @param s
	 *            the s
	 * @return true, if is string empty
	 */
	private boolean isStringEmpty(String s) {
		return (s == null) || (s.trim().isEmpty());
	}

	/**
	 * Find by filtros.
	 *
	 * @param filtros
	 *            the filtros
	 * @return the list
	 */
	public List<VwAdmLog> findByFiltros(VwAdmLog filtros) {
		Long nDataInicio = DataUtil.toLong(filtros.getDataInicio(), DataUtil.DATA_HORA_NUMERO_PADRAO);
		Long nDataFim = DataUtil.toLong(filtros.getDataFim(), DataUtil.DATA_HORA_NUMERO_PADRAO);
		
		if (isStringEmpty(filtros.getEntidade())){
			filtros.setEntidade(null);
		}
		if (isStringEmpty(filtros.getUsuario())){
			filtros.setUsuario(null);
		}
		if (isStringEmpty(filtros.getIp())){
			filtros.setIp(null);
		}
		if (isStringEmpty(filtros.getChave())){
			filtros.setChave(null);
		}
		if (isStringEmpty(filtros.getOperacao())){
			filtros.setOperacao(null);
		}
			
		
		List<VwAdmLog> resultado = repositorio.findByFiltros(filtros.getEntidade(), filtros.getUsuario(),
				filtros.getIp(), filtros.getOperacao(), filtros.getChave(), nDataInicio,
				nDataFim);
		
		return resultado;

	}

}

/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmLogColunaRepository;
import br.com.hfsframework.admin.model.AdmLogColuna;
import br.com.hfsframework.base.BaseBusinessService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmLogColunaBC.
 */
@Service
public class AdmLogColunaService extends BaseBusinessService<AdmLogColuna, String, AdmLogColunaRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	//@Inject
	//private EntityManager em;
	
	/**
	 * Obter colunas.
	 *
	 * @return the map
	 */
	public Map<String, AdmLogColuna> obterColunas() {
		Map<String, AdmLogColuna> colunaMap = new HashMap<String, AdmLogColuna>();
		/*
		List<AdmLogColuna> colunas = super.findAll();		
		for (AdmLogColuna coluna : colunas) {
			colunaMap.put(coluna.getNome(), coluna);
		}
		*/		
		this.findAll().forEach(coluna -> colunaMap.put(coluna.getNome(), coluna));
		
		return colunaMap;
	}

	/**
	 * Executar comando.
	 *
	 * @param connection
	 *            the connection
	 * @param comando
	 *            the comando
	 * @param valor
	 *            the valor
	 * @param tipoParametro
	 *            the tipo parametro
	 * @return the string
	 */
	public String executarComando(Connection connection, String comando, String valor, String tipoParametro) {
		String resultado = "";
		try {
			//Query q = em.createNativeQuery(comando);
			//q.setParameter(Long, arg1)
			
			ResultSet rs = null;

			PreparedStatement ps = connection.prepareStatement(comando);
			if (tipoParametro.equals("NUMBER")) {
				ps.setLong(1, Long.parseLong(valor));
			} else if (tipoParametro.equals("CHAR")) {
				ps.setString(1, valor.trim());
			} else {
				ps.setString(1, valor);
			}
			rs = ps.executeQuery();
			rs.next();
			resultado = rs.getString(1);

			rs.close();
			ps.close();
		} catch (Exception localException) {
		}
		return resultado;
	}
}

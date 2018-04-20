/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hfsframework.admin.data.AdmSetorRepository;
import br.com.hfsframework.admin.model.AdmSetor;
import br.com.hfsframework.base.BaseBusinessService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmSetorBC.
 */
@Service
public class AdmSetorService extends BaseBusinessService<AdmSetor, String, AdmSetorRepository> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Find by setor pai.
	 *
	 * @param paiSetor
	 *            the pai setor
	 * @return the list
	 */
	public List<AdmSetor> findBySetorPai(String paiSetor){
		return repositorio.findBySetorPai(paiSetor);
	}
	
	/**
	 * Find setores pais by setor.
	 *
	 * @param setor
	 *            the setor
	 * @param lista
	 *            the lista
	 */
	public void findSetoresPaisBySetor(String setor, List<String> lista){
		AdmSetor admSetor = super.load(setor).get();
		if (admSetor != null && admSetor.getPaiSetor()!=null 
				&& !admSetor.getPaiSetor().isEmpty()){
			lista.add(admSetor.getId());			
			findSetoresPaisBySetor(admSetor.getPaiSetor(), lista);	
		}
		if (admSetor != null && admSetor.getPaiSetor()==null){
			lista.add(admSetor.getId());
		}
	}
}

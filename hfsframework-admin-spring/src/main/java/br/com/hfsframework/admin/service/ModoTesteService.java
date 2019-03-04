/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.hfsframework.admin.model.AdmCargo;
import br.com.hfsframework.admin.model.AdmSetor;
import br.com.hfsframework.admin.model.ModoTesteVO;
import br.com.hfsframework.security.model.UsuarioAutenticadoVO;
import br.com.hfsframework.util.JSONListConverter;

@Service
public class ModoTesteService implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmParametroService admParametroService;
	
	@Autowired
	private AdmCargoService admCargoService;

	@Autowired
	private AdmSetorService admSetorService;
	
	@Autowired
	private JSONListConverter<ModoTesteVO> conv;

	/**
	 * Load.
	 *
	 * @param login the login
	 * @return the modo teste VO
	 */
	public ModoTesteVO load(String login) {
		List<ModoTesteVO> lista = findAll();
		return lista.stream().filter(item -> login.equals(item.getLogin())).findFirst().orElse(null);
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<ModoTesteVO> findAll() {
		List<ModoTesteVO> lista = new ArrayList<ModoTesteVO>();
		String valor;
		try {
			valor = admParametroService.getValorByCodigo("MODO_TESTE");
		} catch (Exception e) {
			valor = "";
		}
		if (valor!=null && !valor.isEmpty()){
			lista = conv.jsonToLista(valor, new TypeReference<List<ModoTesteVO>>() {
			});
		}
		return lista;
	}
	
	/**
	 * Iniciar.
	 *
	 * @param usuario the usuario
	 * @return the usuario autenticado VO
	 */
	public UsuarioAutenticadoVO iniciar(UsuarioAutenticadoVO usuario){
		usuario.setModoTeste(false);
		
		List<ModoTesteVO> lista = findAll();
		
		Optional<ModoTesteVO> mtvo = lista.stream()
				.filter(vo -> vo.getAtivo().equals(true))
				.filter(vo -> vo.getLogin().equals(usuario.getUserName()))
				.findFirst();
		
		if (mtvo.isPresent()){
			usuario.setModoTeste(true);
			
			Optional<AdmSetor> setor = admSetorService.load(mtvo.get().getSetor());
			if (setor.isPresent()){
				usuario.getFuncionario().setSetor(setor.get().getId());	
			}
			
			Optional<AdmCargo> cargo = admCargoService.load(mtvo.get().getCargo());
			if (cargo.isPresent()){
				usuario.getFuncionario().setCodCargoPrincipal(cargo.get().getId());
				usuario.getFuncionario().setCargoPrincipal(cargo.get().toCargoVO());
			}			
		}
		
		return usuario;
	}
}

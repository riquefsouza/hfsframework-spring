/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.admin.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.hfsframework.admin.model.AdmMenu;
import br.com.hfsframework.admin.model.AdmPagina;
import br.com.hfsframework.admin.model.AdmPerfil;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdmPerfilRepository.
 */
public interface AdmPerfilRepository extends JpaRepository<AdmPerfil, Long> {

	/**
	 * Gets the descricao.
	 *
	 * @param id
	 *            the id
	 * @return the descricao
	 */
	@Query(name = "AdmPerfil.getDescricaoById")
	String getDescricao(Long id);
	
	/**
	 * Count novo.
	 *
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmPerfil.countNovo")
	Long countNovo(String novo);

	/**
	 * Count antigo novo.
	 *
	 * @param antigo
	 *            the antigo
	 * @param novo
	 *            the novo
	 * @return the long
	 */
	@Query(name = "AdmPerfil.countAntigo")
	Long countAntigo(String antigo, String novo);
	
	/**
	 * Find paginas por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findPaginasPorPerfil")
	List<AdmPagina> findPaginasPorPerfil(AdmPerfil perfil);

	/**
	 * Find usuarios por perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findUsuariosPorPerfil")
	Iterable<Long> findUsuariosPorPerfil(AdmPerfil perfil);

	/**
	 * Find perfis por usuario.
	 *
	 * @param idUsuario
	 *            the id usuario
	 * @return the list
	 */
	@Query(name = "AdmPerfil.findPerfisPorUsuario")	
	Iterable<AdmPerfil> findPerfisPorUsuario(Long idUsuario);
	
	/**
	 * Find admin menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name="AdmPerfil.findAdminMenuPaiByPerfil")
	List<AdmMenu> findAdminMenuPaiByPerfil(AdmPerfil perfil);

	/**
	 * Find menu pai by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @return the list
	 */
	@Query(name="AdmPerfil.findMenuPaiByPerfil")
	List<AdmMenu> findMenuPaiByPerfil(AdmPerfil perfil);

	/**
	 * Find admin menu by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @param menuPai
	 *            the menu pai
	 * @return the list
	 */
	@Query(name="AdmPerfil.findAdminMenuByPerfil")
	List<AdmMenu> findAdminMenuByPerfil(AdmPerfil perfil, AdmMenu menuPai);
	
	/**
	 * Find menu by perfil.
	 *
	 * @param perfil
	 *            the perfil
	 * @param menuPai
	 *            the menu pai
	 * @return the list
	 */
	@Query(name="AdmPerfil.findMenuByPerfil")
	List<AdmMenu> findMenuByPerfil(AdmPerfil perfil, AdmMenu menuPai);
	
	/**
	 * Find admin menu pai by id perfis.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @return the list
	 */
	@Query(name="AdmPerfil.findAdminMenuPaiByIdPerfis")
	List<AdmMenu> findAdminMenuPaiByIdPerfis(List<Long> listaIdPerfil);

	/**
	 * Find menu pai by id perfis.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @return the list
	 */
	@Query(name="AdmPerfil.findMenuPaiByIdPerfis")
	List<AdmMenu> findMenuPaiByIdPerfis(List<Long> listaIdPerfil);

	/**
	 * Find admin menu by id perfis.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @param menuPai the menu pai
	 * @return the list
	 */
	@Query(name="AdmPerfil.findAdminMenuByIdPerfis")
	List<AdmMenu> findAdminMenuByIdPerfis(List<Long> listaIdPerfil, AdmMenu menuPai);
	
	/**
	 * Find menu by id perfis.
	 *
	 * @param listaIdPerfil the lista id perfil
	 * @param menuPai the menu pai
	 * @return the list
	 */
	@Query(name="AdmPerfil.findMenuByIdPerfis")
	List<AdmMenu> findMenuByIdPerfis(List<Long> listaIdPerfil, AdmMenu menuPai);

	List<AdmPerfil> findByGeral(Boolean geral);
	
}

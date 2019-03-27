/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfssistema.admin.view.admParametroCategoria;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewController;

/**
 * The Class AdmParametroCategoriaController.
 */
@Controller
@RequestMapping("/admParametroCategoriaMB")
public class AdmParametroCategoriaController extends BaseViewController implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private AdmParametroCategoriaRelController rel;
	
	/** The pagina listar. */
	private String paginaListar; 

	/** The pagina editar. */
	private String paginaEditar;
	
	/**
	 * Instantiates a new adm parametro categoria controller.
	 */
	public AdmParametroCategoriaController() {
		this.paginaListar = "/private/admin/admParametroCategoria/listarAdmParametroCategoria";
		this.paginaEditar = "/private/admin/admParametroCategoria/editarAdmParametroCategoria"; 
	}

	@GetMapping("/listar")
	public String listar() {
		return getPaginaListar();
	}
	
	@ModelAttribute("listaTipoRelatorio")
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return rel.getListaTipoRelatorio();
	}
	
	/**
	 * Pega o the pagina listar.
	 *
	 * @return o the pagina listar
	 */
	public String getPaginaListar() {
		return paginaListar;
	}
	
	/**
	 * Pega o the pagina editar.
	 *
	 * @return o the pagina editar
	 */
	public String getPaginaEditar() {
		return paginaEditar;
	}
	
	/**
	 * Cancelar edicao.
	 *
	 * @return the string
	 */
	public String cancelarEdicao() {
		return getPaginaListar();
	}
	
	/**
	 * Cancelar.
	 *
	 * @return the string
	 */
	public String cancelar() {
		return getPaginaDesktop();
	}
	
}

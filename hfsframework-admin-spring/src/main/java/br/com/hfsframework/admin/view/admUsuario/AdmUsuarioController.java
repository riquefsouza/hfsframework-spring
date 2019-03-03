/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.admUsuario;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.security.model.UsuarioVO;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

// TODO: Auto-generated Javadoc
/**
 * The Class AdmUsuarioController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/admUsuarioMB")
public class AdmUsuarioController
		extends BaseViewConsulta<AdmUsuario, Long, AdmUsuarioService>
		implements IBaseViewConsulta<AdmUsuario>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The rel. */
	@Autowired
	private AdmUsuarioRelController rel;
	
	/** The lista UsuarioVO. */
	private List<UsuarioVO> listaUsuarioVO;
	
	/** The entidade. */
	@Autowired
	private UsuarioVO usuarioVO;
		
	/**
	 * Instantiates a new AdmUsuarioController.
	 */
	public AdmUsuarioController() {
		super(new AdmUsuario(),
			"/private/admin/admUsuario/listarAdmUsuario",
			"/admUsuarioMB");
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		atualizaListaDataTable();
		
		listaUsuarioVO = getBusinessController().getListaUsuarioIps();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.BaseViewCadastro#listar()
	 */
	@Override
	@GetMapping("/listar")
	public ModelAndView listar() {
		return super.listar();
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.IBaseViewRelatorio#getListaTipoRelatorio()
	 */
	@Override
	@ModelAttribute("listaTipoRelatorio")
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return rel.getListaTipoRelatorio();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.IBaseViewRelatorio#exportar(java.lang.String, java.lang.String)
	 */
	@Override
	@ResponseBody
	@GetMapping(value = "/exportar/{tipoRelatorio}/{forcarDownload}")
	public String exportar(@PathVariable("tipoRelatorio") String tipoRelatorio, 
			@PathVariable("forcarDownload") String forcarDownload)  {
		return rel.exportar(tipoRelatorio, forcarDownload);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getBean()
	 */
	@Override
	public AdmUsuario getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(AdmUsuario entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public List<AdmUsuario> getListaBean() {
		return super.getListaEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setListaBean(java.util.
	 * List)
	 */
	@Override
	public void setListaBean(List<AdmUsuario> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

	/**
	 * Gets the usuario VO.
	 *
	 * @return the usuario VO
	 */
	public UsuarioVO getUsuarioVO() {
		return usuarioVO;
	}
	
	/**
	 * Gets the lista usuario VO.
	 *
	 * @return the lista usuario VO
	 */	
	@ModelAttribute("listaUsuarioVO")
	public List<UsuarioVO> getListaUsuarioVO() {
		return listaUsuarioVO;
	}
	
}

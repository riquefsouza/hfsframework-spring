/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view.vwAdmLog;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.hfsframework.admin.model.VwAdmLog;
import br.com.hfsframework.admin.service.VwAdmLogService;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewCadastro;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;

/**
 * The Class VwAdmLogController.
 */
@Controller
@TratamentoErrosEsperados
@RequestMapping("/vwAdmLogMB")
public class VwAdmLogController
		extends BaseViewCadastro<VwAdmLog, Long, VwAdmLogService>
		implements IBaseViewCadastro<VwAdmLog, Long>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Autowired
	private VwAdmLogRelController rel;
	
	/**
	 * Instantiates a new VwAdmLogController.
	 */
	public VwAdmLogController() {
		super(new VwAdmLog(),
			"/private/admin/vwAdmLog/listarVwAdmLog",
			"/private/admin/vwAdmLog/editarVwAdmLog", 
			"/vwAdmLogMB");
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		atualizaListaDataTable();
	}
	
	@Override
	@GetMapping("/listar")
	public ModelAndView listar() {
		return super.listar();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#incluir()
	 */
	@Override
	@GetMapping("/incluir")
	public ModelAndView incluir() {
		return super.incluir(new VwAdmLog());
	}
	
	@Override
	@GetMapping("/editar/{id}")	
	public ModelAndView editar(@PathVariable("id") Long id) {
		return super.editar(id);
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#salvar(java.lang.Object, 
	 * org.springframework.validation.BindingResult, 
	 * org.springframework.web.servlet.mvc.support.RedirectAttributes)
	 */
	@Override
	@PostMapping("/salvar")
	public RedirectView salvar(@Valid VwAdmLog obj, 
			BindingResult result, RedirectAttributes attributes) {
		return super.salvar(obj.getId(), obj, result, attributes);
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.BaseViewCadastro#excluir(java.io.Serializable)
	 */
	@Override
	@GetMapping("/excluir/{id}")
	public RedirectView excluir(@PathVariable("id") Long id) {
		return super.excluir(id);
	}

	@Override
	@ModelAttribute("listaTipoRelatorio")
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return rel.getListaTipoRelatorio();
	}
	
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
	public VwAdmLog getBean() {
		return super.getEntidade();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#setBean(java.lang.
	 * Object)
	 */
	@Override
	public void setBean(VwAdmLog entidade) {
		super.setEntidade(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.jus.trt1.frameworkdirem.base.IBaseViewCadastro#getListaBean()
	 */
	@Override
	public Iterable<VwAdmLog> getListaBean() {
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
	public void setListaBean(Iterable<VwAdmLog> listaEntidade) {
		super.setListaEntidade(listaEntidade);
	}

}

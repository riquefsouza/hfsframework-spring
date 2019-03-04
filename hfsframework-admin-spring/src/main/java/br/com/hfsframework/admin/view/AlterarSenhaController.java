/**
 * <p><b>HFS Framework Spring</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2018
 */
package br.com.hfsframework.admin.view;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCrypt;
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

import br.com.hfsframework.admin.model.AdmUsuario;
import br.com.hfsframework.admin.service.AdmUsuarioService;
import br.com.hfsframework.base.relatorio.RelatorioGrupoVO;
import br.com.hfsframework.base.view.BaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewConsulta;
import br.com.hfsframework.base.view.IBaseViewRelatorio;
import br.com.hfsframework.security.model.UsuarioAutenticadoVO;
import br.com.hfsframework.util.interceptors.TratamentoErrosEsperados;
import springfox.documentation.annotations.ApiIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class AlterarSenhaController.
 */
@ApiIgnore
@Controller
@TratamentoErrosEsperados
@RequestMapping("/alterarSenhaMB")
public class AlterarSenhaController extends BaseViewConsulta<AdmUsuario, Long, AdmUsuarioService>
		implements IBaseViewConsulta<AdmUsuario>, IBaseViewRelatorio {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new AlterarSenhaController.
	 */
	public AlterarSenhaController() {
		super(new AdmUsuario(),
			"/private/alterarSenha",
			"/alterarSenhaMB");
	}

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.IBaseViewCadastro#init()
	 */
	@PostConstruct
	public void init() {
		atualizaListaDataTable();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.BaseViewCadastro#listar()
	 */
	@Override
	@GetMapping("/listar")
	public ModelAndView listar() {		
		Optional<AdmUsuario> bean = getBusinessController().load(this.getUsuarioAutenticado().getUsuario().getMatricula());		
		ModelAndView mv = new ModelAndView(getPaginaListar());
		mv.addObject("bean", bean.get());
		setEntidade(bean.get());
		return mv;
	}
	
	public boolean prepararParaSalvar(AdmUsuario obj, RedirectAttributes attributes) {
		if ((obj.getSenhaNova() == null && obj.getConfirmaSenhaNova() == null && obj.getSenhaAtual() == null)
				|| (obj.getSenhaNova().equals("") && obj.getConfirmaSenhaNova().equals("") && obj.getSenhaAtual().equals(""))) {
			attributes.addFlashAttribute("mensagem", "Por favor, preencha todos os campos");
		} else if ((obj.getSenhaNova() == null && obj.getConfirmaSenhaNova() == null)
				|| (obj.getSenhaNova().equals("") && obj.getConfirmaSenhaNova().equals(""))) {
			attributes.addFlashAttribute("mensagem", "Por favor, preencha todos os campos");
		} else {
			String senha = BCrypt.hashpw(obj.getSenhaAtual(), BCrypt.gensalt());
			
			if (senha.equals(getUsuarioAutenticado().getUsuario().getSenha())) {

				if (obj.getSenhaNova().equals(obj.getConfirmaSenhaNova())) {
					return true;
				} else {
					attributes.addFlashAttribute("mensagem", "Senha nova e confirma senha não confere.");
				}
			} else {
				attributes.addFlashAttribute("mensagem", "Senha atual não confere.");
			}
		}
		return false;
	}
	
	@PostMapping("/salvar")
	public RedirectView salvar(@Valid AdmUsuario obj, 
			BindingResult result, RedirectAttributes attributes) {
		
		if (prepararParaSalvar(obj, attributes)){
			return new RedirectView(getMapeamento()+"/listar");
		}
		
		if (result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return new RedirectView(getMapeamento()+"/listar");
		}
		
		try {
			String senha = BCrypt.hashpw(obj.getConfirmaSenhaNova(), BCrypt.gensalt());
			
			UsuarioAutenticadoVO usuarioAut = getUsuarioAutenticado();
			usuarioAut.getUsuario().setSenha(senha);
			
			
			getBusinessController().updateSenha(usuarioAut.getUsuario().getSenha(), 
					usuarioAut.getUsuario().getLogin());
			
			setUsuarioAutenticado(usuarioAut);
			
			attributes.addFlashAttribute("mensagem", "Senha alterada!");
		} catch (Exception e) {
			gerarMensagemErro(e, ERRO_SALVAR);
			return new RedirectView(getMapeamento()+"/listar");
		}
		atualizaListaDataTable();
		
		return new RedirectView(getMapeamento()+"/listar");		
	}
	

	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.IBaseViewRelatorio#getListaTipoRelatorio()
	 */
	@Override
	@ModelAttribute("listaTipoRelatorio")
	public List<RelatorioGrupoVO> getListaTipoRelatorio() {
		return null; //rel.getListaTipoRelatorio();
	}
	
	/* (non-Javadoc)
	 * @see br.com.hfsframework.base.view.IBaseViewRelatorio#exportar(java.lang.String, java.lang.String)
	 */
	@Override
	@ResponseBody
	@GetMapping(value = "/exportar/{tipoRelatorio}/{forcarDownload}")
	public String exportar(@PathVariable("tipoRelatorio") String tipoRelatorio, 
			@PathVariable("forcarDownload") String forcarDownload)  {
		return ""; //rel.exportar(tipoRelatorio, forcarDownload);
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

}

/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.hfsframework.security.model.UsuarioAutenticadoVO;

// TODO: Auto-generated Javadoc
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 * The Class AplicacaoUtil.
 */
@Component
public final class AplicacaoUtil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The log. */
	//private static final Logger log = LoggerFactory.getLogger(AplicacaoUtil.class);
	
	public static final String REALM_NAME = "HFSFRAMEWORK-ADMIN";
	
	/** The Constant PASSWORD_ENCODER. */
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	
	/** The port. */
	public static int port;
		
	/**
	 * Instantiates a new aplicacao util.
	 */
	public AplicacaoUtil() {
		super();
	}

	/**
	 * Checks if is debug mode.
	 *
	 * @return true, if is debug mode
	 */
	public boolean isDebugMode() {
		//boolean isDebug = ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
		//log.info("Sistema em modo de debug: " + isDebug);
		//return isDebug;
		return false;
	}

	/**
	 * Gets the sessao.
	 *
	 * @return the sessao
	 */
	public HttpSession getSessao() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    return attr.getRequest().getSession(); // true == permite criar		
	}	
	
	/**
	 * Sets the usuario autenticado.
	 *
	 * @param usu
	 *            the new usuario autenticado
	 */
	public void setUsuarioAutenticado(UsuarioAutenticadoVO usu){
		getSessao().setAttribute("usuarioAutenticado", usu);
	}
	
	/**
	 * Gets the usuario autenticado.
	 *
	 * @return the usuario autenticado
	 */
	public UsuarioAutenticadoVO getUsuarioAutenticado(){
		UsuarioAutenticadoVO usu = (UsuarioAutenticadoVO) getSessao().getAttribute("usuarioAutenticado");
		return usu;
	}
	
	/**
	 * Remove o usuario autenticado.
	 */
	public void removeUsuarioAutenticado(){
		getSessao().removeAttribute("usuarioAutenticado");
	}
	
}

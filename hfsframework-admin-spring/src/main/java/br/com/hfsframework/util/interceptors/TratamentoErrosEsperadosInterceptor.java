/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.util.interceptors;

import java.io.Serializable;
import java.util.Iterator;

import javax.persistence.OptimisticLockException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.hfsframework.util.exceptions.ErroEsperado;

// TODO: Auto-generated Javadoc
/**
 * The Class TratamentoErrosEsperadosInterceptor.
 */
@Aspect
@TratamentoErrosEsperados
public class TratamentoErrosEsperadosInterceptor implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 535720585764001836L;
	
	/** The log. */
	private Logger log = LoggerFactory.getLogger(TratamentoErrosEsperadosInterceptor.class);

	/**
	 * Tratamento de erros esperados.
	 *
	 * @param invocation            the invocation
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("execution(* br.com.hfsframework.util.interceptors.TratamentoErrosEsperados.*(..))")
	public Object tratamentoDeErrosEsperados(ProceedingJoinPoint invocation) throws Throwable {		
		try {
			return invocation.proceed();
		} catch (ErroEsperado e) {
			for (String mensagemErro : e.getMensagens()) {
				this.log.debug("Ocorreu o erro esperado: [" + mensagemErro + "] no método: "
						+ invocation.getSignature().getName());
				//FacesContext.getCurrentInstance().addMessage(null,
					//	new FacesMessage(FacesMessage.SEVERITY_ERROR, null, mensagemErro));
			}
			return null;
		} catch (Exception e) {
			boolean encontrouErroEsperado = false;

			Object causa = e;
			while ((causa = (Exception) ((Exception) causa).getCause()) != null) {
				if ((causa instanceof ErroEsperado)) {
					Iterator<String> localIterator2 = ((ErroEsperado) causa).getMensagens().iterator();
					while (localIterator2.hasNext()) {
						String mensagemErro = (String) localIterator2.next();
						encontrouErroEsperado = true;
						this.log.debug("Ocorreu o erro esperado: [" + mensagemErro + "] no método: "
								+ invocation.getSignature().getName());
						//FacesContext.getCurrentInstance().addMessage(null,
							//	new FacesMessage(FacesMessage.SEVERITY_ERROR, null, mensagemErro));
					}
				}
				if ((causa instanceof OptimisticLockException)) {
					String mensagemErro = "Este registro foi atualizado ou apagado por outro usuário. Favor voltar a tela inicial do sistema e repetir a operação.";
					this.log.debug(mensagemErro);
					//FacesContext.getCurrentInstance().addMessage(null,
						//	new FacesMessage(FacesMessage.SEVERITY_ERROR, null, mensagemErro));

					return null;
				}
			}
			if (encontrouErroEsperado) {
				return null;
			}
			throw e;
		//} catch (Exception e) {
			//this.log.error(e);
			//throw new ErroInesperado(e);
		}
	}
}

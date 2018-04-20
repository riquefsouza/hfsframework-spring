/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.util.interceptors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class LoggerProducer.
 */
@Aspect
public class LoggerProducer {
	
	/**
	 * Gets the logger.
	 *
	 * @param p
	 *            the p
	 * @return the logger
	 */
	@Around("execution(* br.com.hfsframework.*(..))")
	public Logger getLogger(ProceedingJoinPoint p) {
		return LoggerFactory.getLogger(p.getClass());
	}
}

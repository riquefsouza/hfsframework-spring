/**
 * <p><b>HFS Framework</b></p>
 * @author Henrique Figueiredo de Souza
 * @version 1.0
 * @since 2017
 */
package br.com.hfsframework.base.relatorio;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * The Class BaseRelatorioProducer.
 */
@Aspect
public class BaseRelatorioProducer {
	
	/** The Constant DEFAULT_PATH. */
	private static final String DEFAULT_PATH = "relatorios/";
	
	/** The Constant DEFAULT_EXTENSION. */
	private static final String DEFAULT_EXTENSION = ".jasper";

	/**
	 * Instantiates a new base relatorio producer.
	 */
	public BaseRelatorioProducer() {
	}

	/*
    @Before("execution(* set*(*)) && target(instance) && args(newValue)")
    public void beforeSetterCalled(JoinPoint thisJoinPoint, Object instance, Object newValue) {
        String methodName = thisJoinPoint.getSignature().getName();
        try {
            System.out.println(
                methodName.substring(3) + ": " +
                instance
                    .getClass()
                    .getMethod(methodName.replaceFirst("set", "get"))
                    .invoke(instance) +
                " -> " + newValue
            );
        } catch (Exception e) {
            throw new SoftException(e);
        }
    }
*/
	
	/**
	 * Cria o.
	 *
	 * @param ip
	 *            the ip
	 * @return the i base relatorio
	 */
	//@Produces
	//@Default
	//public static IBaseRelatorio create(InjectionPoint ip) {		
	//public static IBaseRelatorio create(ProceedingJoinPoint ip) {
    @Before("execution(* set*(*)) && target(instance) && args(newValue)")
    public static IBaseRelatorio create(JoinPoint jp, Object instance, Object newValue) {
    	/*
		Field field = (Field) jp.getMember();
		String path = DEFAULT_PATH + field.getName() + DEFAULT_EXTENSION;
		if (field.isAnnotationPresent(RelatorioPath.class)) {
			path = DEFAULT_PATH + ((RelatorioPath) field.getAnnotation(RelatorioPath.class)).value() + DEFAULT_EXTENSION;
		}
    	 */
    	String path = "";
		return create(path);
	}

	/**
	 * Cria o.
	 *
	 * @param path
	 *            the path
	 * @return the i base relatorio
	 */
	public static IBaseRelatorio create(String path) {
		return new BaseRelatorioImpl(path);
	}
}

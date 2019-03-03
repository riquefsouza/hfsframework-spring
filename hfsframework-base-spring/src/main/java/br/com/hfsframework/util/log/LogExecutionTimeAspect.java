package br.com.hfsframework.util.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {
	
	private static final Logger log = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

	@Around("@annotation(br.com.hfsframework.util.log.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		Object proceed = joinPoint.proceed();

		long executionTime = System.currentTimeMillis() - start;

		log.info(joinPoint.getSignature() + " executado em " + executionTime + "ms");
		return proceed;
	}
}

package com.example.pointcut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Pointcut("execution(@com.example.pointcut.annotation.CustomAnnotation * *(..))")
	public void annotatedMethod() {
	}

	@Before("annotatedMethod()")
	public void beforeAction(final JoinPoint jp) {
		log.info("Entrada en el método beforeAction de un método con anotación");
	}

	@AfterThrowing(pointcut = "annotatedMethod()", throwing = "exception")
	public void afterThrowingAction(final JoinPoint jp, final Throwable exception) {
		log.info("Entrada en el método afterThrowingAction de un método con anotación");
	}
	
	@After("annotatedMethod()")
	public void afterAction(final JoinPoint jp) {
		log.info("Entrada en el método afterAction de un método con anotación");
	}

	@AfterReturning("annotatedMethod()")
	public void afterReturningAction(final JoinPoint jp) {
		log.info("Entrada en el método afterReturningAction de un método con anotación");
	}
	
	
	
	@Pointcut("target(com.example.pointcut.service.ServicePointCut)")
	public void targetClass() {
	}

	@Before("targetClass()")
	public void beforeAnyMethodClassAction(final JoinPoint jp) {
		log.info("Entrada en el método beforeAction de una clase con punto de corte");
	}

	@AfterThrowing(pointcut = "targetClass()", throwing = "exception")
	public void afterThrowingAnyMethodClassAction(final JoinPoint jp, final Throwable exception) {
		log.info("Entrada en el método afterThrowingAction de una clase con punto de corte");
	}

	@AfterReturning("targetClass()")
	public void afterAnyMethodClassAction(final JoinPoint jp) {
		log.info("Entrada en el método afterAction de una clase con punto de corte");
	}
	
	
	
	@Pointcut("execution(public String com.example.pointcut.service.ServiceTestImpl.testAspectMethodNoAnnotated())")
	public void noAnnotatedMethod() {
	}
	
	@Before("noAnnotatedMethod()")
	public void beforeActionNoAnnotated(final JoinPoint jp) {
		log.info("Entrada en el método beforeAction de un método si anotación");
	}
	
	@AfterReturning("noAnnotatedMethod()")
	public void afterActionNoAnnotated(final JoinPoint jp) {
		log.info("Entrada en el método afterAction de un método si anotación");
	}
	
	
	@Pointcut("execution(public String com.example.pointcut.service.ServiceTestImpl.testAspectMethodNoAnnotatedAround())")
	public void noAnnotatedMethodAround() {
	}
	
	@Around("noAnnotatedMethodAround()")
	public Object aroundAction(final ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Entrada en el método aroundAction");
		log.info("Procedemos a llamar al método objetivo");
		Object retVal = null;
		try {
			retVal = joinPoint.proceed();
		} catch (Exception e) {
			log.info("Acción en caso de excepción");
			throw e;
		}
	    log.info("Acción después de la llamada al método objetivo si no se produce una excepción");
	    return retVal;
	}
}

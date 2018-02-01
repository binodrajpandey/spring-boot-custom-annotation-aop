
package com.example.demo;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Create our Aspect
 * 
 * @author binod
 */
@Aspect
@Component
public class ExampleAspect {
	private static final Logger logger = LoggerFactory.getLogger(ExampleAspect.class);

	/**
	 * now create pointcut and advice
	 * 
	 * @param joinPoint
	 */
	@Around("@annotation(LoggedInBy)")
	public Object logUserNameAndId(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("This is before method execution");

		Object proceed = joinPoint.proceed();
		//annotated method starts here
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method m = signature.getMethod();
		// joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName(),String.class);
		LoggedInBy customAnnotation = m.getAnnotation(LoggedInBy.class);
		Object dynamicName = CustomSpringExpressionLanguageParser.getDynamicValue(signature.getParameterNames(),
				joinPoint.getArgs(), customAnnotation.name());
		logger.info("Dynamic Name Fetched is:: {}", dynamicName);
		Object dynamicId = CustomSpringExpressionLanguageParser.getDynamicValue(signature.getParameterNames(),
				joinPoint.getArgs(), customAnnotation.id());
		logger.info("Dynamic ID Fetched is:: {}", dynamicId);
		return proceed;
	}
}

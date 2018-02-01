
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
	private static final Logger logger=LoggerFactory.getLogger(ExampleAspect.class);
	/**
	 * now create pointcut and advice
	 * 
	 * @param joinPoint
	 */
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("This is before method execution");
		
		Object proceed = joinPoint.proceed();
		
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method m =signature.getMethod(); 
			//	joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName(),String.class);
		LogExecutionTime customAnnotation = m.getAnnotation(LogExecutionTime.class);
		Object dynamicValue = CustomSpringExpressionLanguageParser.
                getDynamicValue(signature.getParameterNames(), joinPoint.getArgs(), customAnnotation.value());
       logger.info("Dynamic Value Fetched is:: {}",dynamicValue);
		return proceed;
	}
}

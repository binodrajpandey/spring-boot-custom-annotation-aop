
package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *Create our Aspect
 * @author binod
 */
@Aspect
@Component
public class ExampleAspect {
    /**
     * now create pointcut and advice
     * @param joinPoint
     */
    @Around("@annotation(LogExecutionTime)")
public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
 
    Object proceed = joinPoint.proceed();
 
    long executionTime = System.currentTimeMillis() - start;
 
    System.out.println(joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
    return proceed;
}
}

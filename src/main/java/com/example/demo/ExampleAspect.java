
package com.example.demo;

import java.lang.reflect.Method;

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
    System.out.println("This is before method execution");
    Object proceed = joinPoint.proceed();
 System.out.println(joinPoint.getSignature().getName());
   Method m = joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName());
 System.out.println(joinPoint.getTarget().getClass());
 System.out.println(this.getClass());
   LogExecutionTime manno=m.getAnnotation(LogExecutionTime.class);  
   System.out.println("the annotation value is"+manno.value());
    return proceed;
}
}

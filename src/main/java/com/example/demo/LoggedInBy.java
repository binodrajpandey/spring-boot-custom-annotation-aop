
package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *create our own annotation
 * @author binod
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggedInBy {
	String id() default "0";
	String name() default "'DEFAULT'";  
    
}

package br.com.crudapi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Register a class as a CRUD
 * 
 * @author Rafael de Morais - 03.2016
 * @since 1.0
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CrudApi {
	/**
	 * Id do crud
	 * @return
	 */
	String id();
}

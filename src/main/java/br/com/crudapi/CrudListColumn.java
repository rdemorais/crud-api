package br.com.crudapi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Seleciona um atributo para ser coluna na lista de crud.
 * 
 * @author Rafael de Morais
 *
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CrudListColumn {
	String friendlyName();
}
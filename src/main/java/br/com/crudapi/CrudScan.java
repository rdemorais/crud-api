package br.com.crudapi;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CrudScan implements ApplicationContextAware, InitializingBean{

	private static final Logger logger = Logger.getLogger(CrudScan.class);
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private CRUDRegister crudRegister;
	
	public void afterPropertiesSet() throws Exception {
		final Map<String, Object> cruds = applicationContext.getBeansWithAnnotation(CrudApi.class);
		
		for (final Object vazdorCrud : cruds.values()) {
			final Class<? extends Object> crudClass = vazdorCrud.getClass();
			final CrudApi anot = crudClass.getAnnotation(CrudApi.class);
			crudRegister.registerCrud(anot.id(), crudClass);
			logger.debug("Registrando Crud: " + crudClass + " com ID: " + anot.id());
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
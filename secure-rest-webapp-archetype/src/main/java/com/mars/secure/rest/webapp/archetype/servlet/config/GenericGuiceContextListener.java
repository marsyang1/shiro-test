package com.mars.secure.rest.webapp.archetype.servlet.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.mars.secure.rest.webapp.archetype.servlet.modules.BootstrapServletModule;

/**
 * This class goes mapped in web.xml and is used to inject Google Guice's Injector into the Web Application Context.
 * 
 * @author pablo.biagioli
 *
 */
public class GenericGuiceContextListener extends GuiceServletContextListener{

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new BootstrapServletModule());
	}

	
}

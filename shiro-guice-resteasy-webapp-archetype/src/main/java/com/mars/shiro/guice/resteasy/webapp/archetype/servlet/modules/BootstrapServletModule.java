package com.mars.shiro.guice.resteasy.webapp.archetype.servlet.modules;

import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.servlet.ServletModule;
import com.mars.shiro.guice.resteasy.webapp.archetype.rest.SampleRestModule;
import com.mars.shiro.guice.resteasy.webapp.archetype.servlet.config.GuiceRestEasyFilterDispatcher;
import com.mars.shiro.guice.resteasy.webapp.archetype.shiro.modules.BootstrapShiroModule;
import com.mars.shiro.guice.resteasy.webapp.archetype.shiro.modules.ShiroAnnotationsModule;

/**
 * This class bootstraps the application Servlet (JBoss RestEasy 3). If you want
 * the Shiro annotations to work, you will need to inject every Web Service's
 * constructor, so Guice's injector can handle the creation of the WS.
 * 
 * @see com.mars.shiro.guice.resteasy.webapp.archetype.rest.SampleSecuredRESTWebService
 * @author pablo.biagioli
 *
 */
public class BootstrapServletModule extends ServletModule {

	private static Logger log = LoggerFactory.getLogger(BootstrapServletModule.class);

	@Override
	protected void configureServlets() {
		super.configureServlets();
		log.info("Bootstrap Main Servlet");
		// get the bootstrapping Properties file
		install(new BootstrapPropertiesModule());
		// Initialize Persistence JPA Unit of Work if present
		// install(new MyUnitOfWorkModule());
		// Initialize Apache Shiro if present
		install(new BootstrapShiroModule(getServletContext()));
		//This allows Shiro AOP Annotations http://shiro.apache.org/java-authorization-guide.html
		install(new ShiroAnnotationsModule());
		//This Module will try to bind all the classes under .rest packages
		install(new BootstrapRestPackagesModule());
		filter("/*").through(GuiceShiroFilter.class);
		filter("/*").through(GuiceRestEasyFilterDispatcher.class);

	}
}

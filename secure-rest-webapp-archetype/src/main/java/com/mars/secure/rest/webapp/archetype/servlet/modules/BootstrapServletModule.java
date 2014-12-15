package com.mars.secure.rest.webapp.archetype.servlet.modules;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.guice.web.GuiceShiroFilter;

import com.google.inject.servlet.ServletModule;
import com.mars.secure.rest.webapp.archetype.servlet.config.GenericBootstrapConstants;
import com.mars.secure.rest.webapp.archetype.shiro.modules.BootstrapShiroModule;
import com.mars.secure.rest.webapp.archetype.shiro.modules.ShiroAnnotationsModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

/**
 * This class bootstraps the application Servlet (Jersey 1.18.1). 
 * If you want the Shiro annotations to work, you will need to inject every Web Service's constructor, so Guice's injector can handle the creation of the WS.
 * 
 * @see com.mars.secure.rest.webapp.archetype.rest.SampleSecuredRESTWebService
 * @author pablo.biagioli
 *
 */
public class BootstrapServletModule extends ServletModule{

	private static final String propertyPackages= GenericBootstrapConstants.JERSEY_PROPERTY_PACKAGES;
	
	@Override
	protected void configureServlets() {
		super.configureServlets();
		
		//get the bootstrapping Properties file
		install(new BootstrapPropertiesModule());
		
		//Initialize Persistence JPA Unit of Work if present
		//install(new MyUnitOfWorkModule());
		//Initialize Apache Shiro if present
		install(new BootstrapShiroModule(getServletContext()));
		//This allows Shiro AOP Annotations http://shiro.apache.org/java-authorization-guide.html
		install(new ShiroAnnotationsModule());
		
		Map<String, String> params = new HashMap<String, String>();
        params.put(PackagesResourceConfig.PROPERTY_PACKAGES, propertyPackages);
        //if you had a Persistence Service like JPA Unit of Work you would need to add this PersistFilter also.
        //filter("/*").through(PersistFilter.class);
        //if you had a ShiroWebModule installed above you would need to add this GuiceShiroFilter also.
        filter("/*").through(GuiceShiroFilter.class);
        serve("/rest/*").with(GuiceContainer.class, params);
        
	}
}

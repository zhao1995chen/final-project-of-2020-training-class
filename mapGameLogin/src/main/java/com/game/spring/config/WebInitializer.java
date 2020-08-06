package com.game.spring.config;

import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	private static final Logger log = LoggerFactory.getLogger(WebInitializer.class);

	private String TMP_FOLDER = "/tmp";
	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

	/**
	 * web application initializer, equivalent web.xml
	 */
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		try {
			// add log4j listener
			// container.setInitParameter("webAppRootKey", "controlCenter");
			// container.setInitParameter("log4jConfigLocation",
			// "/WEB-INF/log4j.properties");
			// container.setInitParameter("log4jRefreshInterval", "1000");
			// container.addListener(Log4jConfigListener.class);
			// add encoding filter
			FilterRegistration.Dynamic encodingFilter = container.addFilter("encodingfilter",
					new CharacterEncodingFilter());
			encodingFilter.setInitParameter("encoding", "UTF-8");
			encodingFilter.setInitParameter("forceEncoding", "true");
			encodingFilter.addMappingForUrlPatterns(null, true, "/*");
			// FilterRegistration.Dynamic portalFilter = container.addFilter("portalfilter",
			// new PortalFilter());
			// portalFilter.addMappingForUrlPatterns(null, true, "/portal/*");

			// add security filter
			// DelegatingFilterProxy filter = new
			// DelegatingFilterProxy("springSecurityFilterChain");
			// filter.setServletContext(container);
			// filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
			// container.addFilter("springSecurityFilterChain",
			// filter).addMappingForUrlPatterns(null, false, "/*");
			// add dispatcher servlet
			DispatcherServlet ds = new DispatcherServlet(new GenericWebApplicationContext());
			// ds.setDispatchOptionsRequest(true);
			ServletRegistration.Dynamic appServlet = container.addServlet("MVCdispatcher", ds);
			appServlet.setLoadOnStartup(1);
			// set multipart config
			MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, MAX_UPLOAD_SIZE,
					MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
			appServlet.setMultipartConfig(multipartConfigElement);
		} catch (Exception e) {
			log.error("web initializer error!!!", e);
			throw e;
		}
	}

}

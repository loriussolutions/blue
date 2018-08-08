package com.lorius.revenues.blue;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	private String TMP_FOLDER = "/tmp";
	private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;

	public void onStartup(ServletContext servletContext) throws ServletException {
		// Create the 'root' Spring application context
//		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
//		rootContext.register(MvcConfig.class,DatabaseConfig.class, PropertiesConfig.class);

		// Manage the lifecycle of the root application context
//		servletContext.addListener(new ContextLoaderListener(rootContext));

		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(MvcConfig.class);
		dispatcherServlet.setServletContext(servletContext);    

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

//		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER, MAX_UPLOAD_SIZE,
//				MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//		dispatcher.setMultipartConfig(multipartConfigElement);

	}

}
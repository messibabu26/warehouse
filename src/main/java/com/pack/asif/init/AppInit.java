package com.pack.asif.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pack.asif.config.AppConfig;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer { 
	 
	 //Provide Spring config file as input to web.xml(FC)  
		@Override
		protected Class<?>[] getRootConfigClasses() {
			return new Class[] {AppConfig.class};
	}
	 
		@Override
		protected Class<?>[] getServletConfigClasses() {
			return null;  
	} 
	 
		//URL - Pattern
		@Override
		protected String[] getServletMappings() {
			return new String[] {"/"};  
	} 
	 
}

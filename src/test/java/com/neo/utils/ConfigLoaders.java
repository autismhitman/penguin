package com.neo.utils;

import java.util.Properties;

import com.neo.constants.EnvType;

public class ConfigLoaders {	
	
	private Properties properties;
	private static ConfigLoaders instance;
	
	private ConfigLoaders() {
		
		String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
		
		switch(EnvType.valueOf(env.toUpperCase())){
			
		 case PROD -> properties = PropertyUtils.propertyLoader("./src/test/resources/config/prod_config.properties");
		 case STAGE ->properties = PropertyUtils.propertyLoader("./src/test/resources/config/stage_config.properties");
		  default -> throw new IllegalStateException("Env type not present " + env);
		}
			
	
	}
	
	public static ConfigLoaders getInstance() {
		
		if(instance==null) {
			
			instance = new ConfigLoaders();
		}
		return instance;
	}
	
	public String getBaseurl() {
		
		 String prop = properties.getProperty("url");
		 
		 if(prop==null) {
			 throw new RuntimeException("Url property is not found in the config file");
		 }
		 return prop;
	}

}

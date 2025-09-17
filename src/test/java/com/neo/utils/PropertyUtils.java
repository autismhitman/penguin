package com.neo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertyUtils {
	
	
   public static Properties propertyLoader(String filePath) {
	   
	   Properties properties = new Properties();
	   BufferedReader reader;
	   
	   try {
		   
		    reader = new BufferedReader(new FileReader(filePath));
		    properties.load(reader);
		    reader.close();
	   }catch(Exception e) {
		   e.printStackTrace();
		   throw new RuntimeException("Error in fetching of properties file");
	   }
	   
	   return properties;
	   
   }
}

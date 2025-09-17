package com.neo.drivers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	 
	     
	
	private static Supplier<WebDriver> getChrome = ()-> new ChromeDriver();
	private static Supplier<WebDriver> getEdge = ()-> new EdgeDriver();
 
    private static final Map<String, Supplier<WebDriver>> hmap = new HashMap<>();
    
    static {
    	
    	hmap.put("CHROME", getChrome);
    	hmap.put("EDGE", getEdge);
    }
    
    public static WebDriver getDriver(String browserName) {
    	
    	return hmap.get(browserName).get();
    }
}

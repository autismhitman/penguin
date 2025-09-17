package com.neo.drivers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.neo.constants.BrowserType;

public class DriverFactory {
	
	private static Supplier<WebDriver> getChrome = ChromeDriver::new ;
	private static Supplier<WebDriver> getEdge = EdgeDriver::new ;
	
	private static Map<String, Supplier<WebDriver>> hmap = new HashMap<>();
	
	static {
		
		hmap.put(String.valueOf(BrowserType.CHROME).toLowerCase(), getChrome);

		hmap.put(String.valueOf(BrowserType.EDGE).toLowerCase(), getEdge);
	}
	 
		
	  public static WebDriver getBrowser(String browser, boolean isRemote) {

	        if (isRemote) {
	            // Assume LambdaTestCloud is a class that handles remote setup
	            return LambdaTestCloud.setup(browser);
	        } else {
	            // Handle local browser instantiation
	            Supplier<WebDriver> driverSupplier = hmap.get(browser.toLowerCase());
	            if (driverSupplier == null) {
	                throw new IllegalArgumentException("Unsupported local browser: " + browser);
	            }
	            return driverSupplier.get();
	        }
	        
	  }

}

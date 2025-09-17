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
	 
	public static WebDriver getBrowser(String browser) {
		
		return hmap.get(browser).get();
	}

}

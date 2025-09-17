package com.neo.hooks;

import org.openqa.selenium.WebDriver;

import com.neo.constants.BrowserTypes;
import com.neo.drivers.DriverFactory;
import com.neo.frameworkcontext.SharedContext;
import com.neo.utils.ConfigLoaders;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class FrameworkHook {
	
	private SharedContext context;
	private WebDriver driver;	
	
	public FrameworkHook(SharedContext context) {
	   this.context = context;
	}
	
	@Before
	public void setup() {
	     
		String browser = System.getProperty("browser", String.valueOf(BrowserTypes.CHROME));				
		driver = DriverFactory.getDriver(browser.toUpperCase());		
		driver.manage().window().maximize();
		driver.get(ConfigLoaders.getInstance().getBaseurl());
		context.driver = driver;
	 
		System.out.println(" before : context driver "+ context.driver +" simple driver "+ driver);
	}	
	
	
	@After
	public void teardown() {
		System.out.println(" After : context driver "+ context.driver +" simple driver "+ driver);
		driver.quit();
	}

}	 

 




 

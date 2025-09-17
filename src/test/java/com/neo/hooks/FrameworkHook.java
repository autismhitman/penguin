package com.neo.hooks;

import org.openqa.selenium.WebDriver;

import com.neo.constants.BrowserType;
import com.neo.drivers.DriverFactory;
import com.neo.frameworkcontext.SharedContext;
import com.neo.utils.ConfigLoader;

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
		 
		String browser= System.getProperty("browser", String.valueOf(BrowserType.CHROME));
		String isRemote= System.getProperty("isRemote", "true");
		driver = DriverFactory.getBrowser(browser.toLowerCase(),Boolean.parseBoolean(isRemote) );
		driver.manage().window().maximize();
		driver.get(ConfigLoader.getInstance().getBaseurl());
		context.driver= driver;
		System.out.println(" before : context driver "+ context.driver +" simple driver "+ driver);
	}	
	
	@After
	public void teardown() {
		System.out.println(" After : context driver "+ context.driver +" simple driver "+ driver);
		driver.quit();
	}

}

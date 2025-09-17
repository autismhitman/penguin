package com.neo.frameworkcontext;

import org.openqa.selenium.WebDriver;

import com.neo.pojo.BillingAddress;
import com.neo.pojo.Cookies;

public class SharedContext {
	
	public WebDriver driver;
	public Cookies cookies;
	public BillingAddress billingAddress;

	public SharedContext() {
		
	       cookies = new Cookies();
	       cookies.setCookies(new io.restassured.http.Cookies());
		
	}
	
}

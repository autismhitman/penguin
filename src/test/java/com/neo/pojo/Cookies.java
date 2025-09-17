package com.neo.pojo;

import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.neo.utils.CookieUtils;

public class Cookies {
	
	private io.restassured.http.Cookies cookies;

	public io.restassured.http.Cookies getCookies() {
		return cookies;
	}

	public void setCookies(io.restassured.http.Cookies cookies) {
		this.cookies = cookies;
	}
	
	public void injectCookiesToBrowser(WebDriver driver) {
		
		List<Cookie> seleniumCookies =new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
		
		for( Cookie cookie: seleniumCookies) {
			
			driver.manage().addCookie(cookie);
		}
		
		driver.navigate().refresh();
	}

}

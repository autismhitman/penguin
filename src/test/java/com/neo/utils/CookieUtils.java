package com.neo.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;

import io.restassured.http.Cookies;

public class CookieUtils {
	
	public List<Cookie> convertRestAssuredCookiesToSeleniumCookies(Cookies cookies){
		
		List<io.restassured.http.Cookie> restAssuredcookies;
		
		restAssuredcookies = cookies.asList();
		
		List<Cookie> seleniumCookies = new ArrayList<>();
		
		for( io.restassured.http.Cookie cookie : restAssuredcookies) {
			
			seleniumCookies.add( 
					new Cookie(cookie.getName(), cookie.getValue(), cookie.getDomain(),cookie.getPath(),
							cookie.getExpiryDate(), cookie.isSecured(), cookie.isHttpOnly(), cookie.getSameSite()
							)
					);
		}
		
		
		return seleniumCookies;
	}
	
 
}

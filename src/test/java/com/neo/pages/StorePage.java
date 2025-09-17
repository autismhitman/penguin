package com.neo.pages;

import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
	
	By viewCartLink = By.cssSelector("a[title='View cart']");
     
	public StorePage(WebDriver driver) {
		super(driver);
	}
	
	public void navigateToStore() {
		
		 driver.findElement(By.linkText("Store")).click();
	}
	
	public void addProductToCart(String name) {
		
		String raw = "a[aria-label='Add “"+name+"” to your cart']";
		byte[] ref = raw.getBytes(StandardCharsets.UTF_8);
		String utf8Encoded = new String(ref,StandardCharsets.UTF_8);		
		By productNamefield = By.cssSelector(utf8Encoded);
		
		driver.findElement(productNamefield).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(viewCartLink)).click();	 
	}

}
  
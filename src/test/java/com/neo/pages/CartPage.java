package com.neo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
	
	By productNamefield = By.cssSelector("td.product-name a");
	By qtyfield = By.cssSelector("input[title='Qty']");
	By checkoutBtn = By.cssSelector(".checkout-button");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public String fetchProductName() {
		
		return driver.findElement(productNamefield).getText();
	 
	}
	
	public int fetchProductQty() {
		
		return Integer.parseInt(driver.findElement(qtyfield).getDomAttribute("value"));
	}
	
	public void clickOnCheckout() {
		
		driver.findElement(checkoutBtn).click();
	}
	
}

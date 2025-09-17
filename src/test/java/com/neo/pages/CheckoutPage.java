package com.neo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.neo.constants.FrameworkConstants;
import com.neo.pojo.BillingAddress;

public class CheckoutPage extends BasePage {

	By placeOrder_btn = By.cssSelector("button#place_order");
	By message_text = By.cssSelector("div.woocommerce-order p");	
	By firstNameField = By.id("billing_first_name");	
	By lastNameField  = By.id("billing_last_name");	
	By countryField   = By.id("billing_country");
	By addressField   = By.id("billing_address_1");
	By cityField      = By.id("billing_city");
	By stateField     = By.id("billing_state");
	By zipField       = By.id("billing_postcode");
	By emailField     = By.id("billing_email");
 
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public void navigateToCheckoutPage() {
		  driver.get(FrameworkConstants.getCheckoutlink());
		  wait.until(ExpectedConditions.urlToBe(FrameworkConstants.getCheckoutlink()));
	}

	public void clickPlaceOrder() {
		driver.findElement(placeOrder_btn).click();
	}

	public String fetchText() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(message_text));
		return driver.findElement(message_text).getText();
	}
	// |firstname| lastname|country| address_line1| city| state| zip |email|

	public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
		
	      return  enterFname(billingAddress.getFirstName())
	    		 .enterLname(billingAddress.getLastName())
	    		 .enterCountry(billingAddress.getCountry())
	    		 .enterAddress(billingAddress.getAddress())
	    		 .enterCity(billingAddress.getCity())
	    		 .enterState(billingAddress.getState())
	    		 .enterZip(billingAddress.getZip())
	    		 .enterEmail(billingAddress.getEmail());
	    		 
	}
	
	public CheckoutPage enterFname(String firstName) {
         WebElement e = driver.findElement(firstNameField);
         e.clear();
         e.sendKeys(firstName);
         return this;
	}

	public CheckoutPage enterLname(String lastName) {
		  WebElement e = driver.findElement(lastNameField);
	         e.clear();
	         e.sendKeys(lastName);
	         return this;
	}

	public CheckoutPage enterCountry(String country) {
	 
        Select select = new Select(driver.findElement(countryField));
        select.selectByVisibleText(country);
        return this;
	}

	public CheckoutPage enterAddress(String address) {
		 WebElement e = driver.findElement(addressField);
         e.clear();
         e.sendKeys(address);
         return this;
	}

	public CheckoutPage enterCity(String city) {
		 WebElement e = driver.findElement(cityField);
         e.clear();
         e.sendKeys(city);
         return this;
	}

	public CheckoutPage enterState(String state) {
		  Select select = new Select(driver.findElement(stateField));
	      select.selectByVisibleText(state);
	      return this;
	}

	public CheckoutPage enterZip(String zip) {
		 WebElement e = driver.findElement(zipField);
         e.clear();
         e.sendKeys(zip);
         return this;
	}

	public CheckoutPage enterEmail(String email) {
		 WebElement e = driver.findElement(emailField);
         e.clear();
         e.sendKeys(email);
         return this;
	}

}

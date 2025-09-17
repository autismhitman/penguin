package com.neo.stepdefinitions;

import org.assertj.core.api.Assertions;

import com.neo.apis.CartApi;
import com.neo.frameworkcontext.SharedContext;
import com.neo.pages.CartPage;
import com.neo.pages.CheckoutPage;
import com.neo.pages.PageManager;
import com.neo.pages.StorePage;
import com.neo.pojo.BillingAddress;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order {
	
	private StorePage storePage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
 
	private SharedContext context;
	
	public Order(SharedContext context) {
		storePage = PageManager.getStorePage(context.driver);
		cartPage = PageManager.getCartPage(context.driver);
		checkoutPage = PageManager.getCheckoutPage(context.driver);
		this.context = context;
	}
	
	@Given("I'm a guest customer")
	public void i_m_a_guest_customer() {
		storePage.navigateToStore();
	    
	}

	@Given("my billing details are")
	public void my_billing_details_are(BillingAddress  billingAddress) {
		context.billingAddress=billingAddress;
	}

	@Given("I have a product in the cart")
	public void i_have_a_product_in_the_cart() {
		//storePage.addProductToCart("Blue Shoes");
		CartApi cartApi = new CartApi(context.cookies.getCookies());
		cartApi.addToCart(1215,1);
		context.cookies.setCookies(cartApi.getCookies());
		context.cookies.injectCookiesToBrowser(context.driver);
	}

	@Given("I'm on the Checkout page")
	public void i_m_on_the_checkout_page() {
		//cartPage.clickOnCheckout();
		checkoutPage.navigateToCheckoutPage();
	}

	@When("I provide billing details")
	public void i_provide_billing_details() {
		checkoutPage.setBillingAddress(context.billingAddress);
	        
	}

	@When("I place an order")
	public void i_place_an_order() {
		checkoutPage.clickPlaceOrder();
	}

	@Then("the order should be placed successfully")
	public void the_order_should_be_placed_successfully() {
	    
		Assertions.assertThat(checkoutPage.fetchText()).isEqualTo("Thank you. Your order has been received.");
	}




}

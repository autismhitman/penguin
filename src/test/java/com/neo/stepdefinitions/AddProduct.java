package com.neo.stepdefinitions;

import org.assertj.core.api.Assertions;
import com.neo.frameworkcontext.SharedContext;
import com.neo.pages.CartPage;
import com.neo.pages.PageManager;
import com.neo.pages.StorePage;
import com.neo.pojo.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class AddProduct {
	

	private StorePage storePage;
	private CartPage cartPage;
	 
	public AddProduct(SharedContext context) {
		 storePage = PageManager.getStorePage(context.driver);
		 cartPage  = PageManager.getCartPage(context.driver);
	}

	@Given("I'm on the store page")
	public void i_m_on_the_store_page() {
		 storePage.navigateToStore();
	}

	@When("I add a {product} to the cart")
	public void i_add_a_to_the_cart(Product product) {
		
		storePage.addProductToCart(product.getName());	 
	}
	   
	@Then("I see {int} {product} in the cart")
	public void i_see_in_the_cart(int qty, Product product) {
		 
		Assertions.assertThat(cartPage.fetchProductName()).isEqualTo(product.getName());
		Assertions.assertThat(cartPage.fetchProductQty()).isEqualTo(qty);
		
	}

}

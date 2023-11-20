package udemyautomationjava.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import udemyautomationjava.TestComponents.BaseTest;
import udemyautomationjava.pageobjects.CartPage;
import udemyautomationjava.pageobjects.CheckoutPage;
import udemyautomationjava.pageobjects.ConfirmationPage;
import udemyautomationjava.pageobjects.LandingPage;
import udemyautomationjava.pageobjects.ProductCatalog;

public class StepDenitionImpl extends BaseTest {

	LandingPage landingPage;
	ProductCatalog productCatalog;
	CartPage cart;
	CheckoutPage checkout;
	ConfirmationPage confirmationPage;
	
	@Given("User opened LandingPage")
	public void open_CatalogPage() throws IOException {
		landingPage = lunchApplication();
	}
	
	@Given("^User Logged in with username (.+) and password (.+)$")
	public void user_logIn(String userName, String password) {
		productCatalog = landingPage.loginApplication(userName, password);  	
	}
	@When("^User added product (.+) to the Cart$")
	public void add_product_to_the_Cart(String product) {
		productCatalog.getProductsList(); 
		productCatalog.addProductToCart(product);	
	}
	@And("User proceeds to the Cart")
	public void proceed_to_the_Cart() {
		cart = productCatalog.goToCartPage();
	}
	@And("^The added product (.+) is in the Cart$")
	public void product_is_in_the_Cart(String product) {
		Boolean productMatch = cart.isProductInCart(product);
		Assert.assertTrue(productMatch);
	}
	@And("User submits the order")
	public void sumbit_the_order() {
		checkout = cart.proceedToCO();                  
		checkout.selectCountry("Ita");                          
	}
	@Then("{string} message is displayed")
	public void success_message_is_displayed(String message) {
		confirmationPage = checkout.clickSubmitBTN();	// click on submit order button	  
		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase(message));
		driver.close();
	}
	
	@Then("{string} error message is displayed")
	public void error_message_is_displayed(String message) {
		Assert.assertEquals(landingPage.getErrorMessage(), message);
		driver.close();
	}
	

}

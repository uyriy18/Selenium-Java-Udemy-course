package udemyautomationjava.stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import udemyautomationjava.TestComponents.BaseTest;
import udemyautomationjava.pageobjects.LandingPage;
import udemyautomationjava.pageobjects.ProductCatalog;

public class StepDenitionImpl extends BaseTest {
	public LandingPage landingPage = null;
	ProductCatalog productCatalog = null;
	@Given("I landed to the Product Catalog page")
	public void I_landed_on_Product_Catalog() throws IOException {
		landingPage = lunchApplication();
	}

	@Given("^Logged with username (.+) and password (.+)$")
	public void Logged_with_userName_and_password(String userName, String password) {
		productCatalog = landingPage.loginApplication(userName, password);
	}
	
	@When("^I add product (.+) to the Cart$")
	public void I_add_product_to_cart(String product) {
		productCatalog.getProductsList(); // get all products list on the page
		productCatalog.addProductToCart(product);						
	}
	
	@Given("^Checkout (.+) And submit the order$")
	public void Checkout_and_submit_the_order(String product) {
		
	}
}

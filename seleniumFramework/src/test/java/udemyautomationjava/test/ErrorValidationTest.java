package udemyautomationjava.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import udemyautomationjava.TestComponents.BaseTest;
import udemyautomationjava.pageobjects.CartPage;
import udemyautomationjava.pageobjects.CheckoutPage;
import udemyautomationjava.pageobjects.ConfirmationPage;
import udemyautomationjava.pageobjects.ProductCatalog;

public class ErrorValidationTest extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException {
		ProductCatalog productCatalog = landingPage.loginApplication("invalidEmail@as.co", "123123"); 
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

	}

	@Test
	public void productErrorValidation() {
		String productName = "zara coat 3";
		ProductCatalog productCatalog = landingPage.loginApplication("test1@as.co", "Test1234");
		productCatalog.getProductsList(); 
		productCatalog.addProductToCart(productName);
		CartPage cart = productCatalog.goToCartPage(); 
		Boolean productMatch = cart.isProductInCart("Invalid product name");
		Assert.assertFalse(productMatch); 

	}
}

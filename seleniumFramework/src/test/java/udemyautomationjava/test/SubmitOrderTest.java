package udemyautomationjava.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import udemyautomation.AbstractComponents.AbstractComponenet;
import udemyautomationjava.TestComponents.BaseTest;
import udemyautomationjava.pageobjects.CartPage;
import udemyautomationjava.pageobjects.CheckoutPage;
import udemyautomationjava.pageobjects.ConfirmationPage;
import udemyautomationjava.pageobjects.LandingPage;
import udemyautomationjava.pageobjects.MyOrdersPage;
import udemyautomationjava.pageobjects.ProductCatalog;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SubmitOrderTest extends BaseTest{
	
	String orderNumber;
	String productName = "zara coat 3";


	@Test
	public void submitOrder() throws IOException
	{		
		String countryName = "Ita";
		String expConfirmMessage = "Thankyou for the order.";		
		ProductCatalog productCatalog = landingPage.loginApplication("test@as.co", "Test1234");  // send Email and Login to the method which enters them into inputs and click submit button, after this we are creating Product catalog object and returns it 				
		productCatalog.getProductsList(); // get all products list on the page
		productCatalog.addProductToCart(productName);						
		CartPage cart = productCatalog.goToCartPage();  // Open cart page, method in the AbstractComponent class + create CartPage object
		Boolean productMatch = cart.isProductInCart(productName);
		Assert.assertTrue(productMatch);      // Check is the added product is in the cart		
		CheckoutPage checkout = cart.proceedToCO();                   // Click on Proceed to Checkout button
		checkout.selectCountry(countryName);                          // type text and select first suggestion from the country input
		ConfirmationPage confirmationPage = checkout.clickSubmitBTN();	// click on submit order button	  
		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase(expConfirmMessage)); // compare if there a success message on the confirmation page
		orderNumber = confirmationPage.setOrderNumber();
	}
	
	@Test(dependsOnMethods= {"submitOrder"}) 
	public void orderInOrderGistory() {
		ProductCatalog productCatalog = landingPage.loginApplication("test@as.co", "Test1234"); 
		MyOrdersPage ordersPage = productCatalog.goToOrdersPage();
		Assert.assertEquals(ordersPage.checkProductName(productName, orderNumber), "zara coat 3");
	}

}

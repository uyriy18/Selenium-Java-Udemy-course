package udemyautomationjava.test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
	
	List<String> orders = new ArrayList<String>();


	@Test(dataProvider = "getData", groups="PlaceOrder")
	public void submitOrder(HashMap<String,String> input) throws IOException
	{		
		String countryName = "Ita";
		String expConfirmMessage = "Thankyou for the order.";		
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));  // send Email and Login to the method which enters them into inputs and click submit button, after this we are creating Product catalog object and returns it 				
		productCatalog.getProductsList(); // get all products list on the page
		productCatalog.addProductToCart(input.get("product"));						
		CartPage cart = productCatalog.goToCartPage();  // Open cart page, method in the AbstractComponent class + create CartPage object
		Boolean productMatch = cart.isProductInCart(input.get("product"));
		Assert.assertTrue(productMatch);      // Check is the added product is in the cart		
		CheckoutPage checkout = cart.proceedToCO();                   // Click on Proceed to Checkout button
		checkout.selectCountry(countryName);                          // type text and select first suggestion from the country input
		ConfirmationPage confirmationPage = checkout.clickSubmitBTN();	// click on submit order button	  
		Assert.assertTrue(confirmationPage.getConfirmationMessage().equalsIgnoreCase(expConfirmMessage)); // compare if there a success message on the confirmation page
		String orderNumber = confirmationPage.setOrderNumber();
		orders.add(orderNumber);
	}
	
	@Test(dependsOnMethods= {"submitOrder"}, dataProvider = "getData") 
	public void orderInOrderHistory(HashMap<String,String> input) {
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email") , input.get("password")); 
		MyOrdersPage ordersPage = productCatalog.goToOrdersPage();
		String orderNumber;
		if(!orders.isEmpty()){
			orderNumber = orders.get(0);
			orders.remove(0);
			Assert.assertEquals(ordersPage.checkProductName(input.get("product"), orderNumber), input.get("product"));
		}
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		/*
		 * HashMap<String,String> map1 = new HashMap<String, String>();
		 * map1.put("email","test@as.co"); map1.put("password","Test1234");
		 * map1.put("product","zara coat 3");
		 * 
		 * HashMap<String,String> map2 = new HashMap<String, String>();
		 * map2.put("email","test1@as.co"); map2.put("password","Test1234");
		 * map2.put("product","adidas original");
		 */
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//udemyautomationjava//data//PlaceOrder.json");			
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}

}

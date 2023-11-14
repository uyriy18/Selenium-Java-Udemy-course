package udemyautomationjava.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import udemyautomation.AbstractComponents.AbstractComponenet;

public class CartPage extends AbstractComponenet{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css =".totalRow button")
	WebElement proceedToCheckoutBTN;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
		
	public Boolean isProductInCart(String productName) {
		Boolean match = cartItems.stream().anyMatch(x -> x.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage proceedToCO() {
		proceedToCheckoutBTN.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	
	

}

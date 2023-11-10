package udemyautomationjava.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import udemyautomation.AbstractComponents.AbstractComponenet;

public class ProductCatalogue extends AbstractComponenet {
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this); // method which defines WebDriver for a Page factoring (e.g
												// :"@FindBy,...").
	}

	@FindBy(css = ".card")
	List<WebElement> tiles;
	
	@FindBy(tagName="ngx-spinner")  // locator for spinner loader
	WebElement spinner;

	By tilesBy = By.cssSelector(".card"); // create a locator to send into ExplicitWait method in the
													// AbstractComponent class
	By addToCartBtn = By.cssSelector("button[class='btn w-10 rounded']"); // locator for Ad To the cart button

	By messageSuccess = By.id("toast-container"); // locator for "Added to the cart successfully" message
	
	
	
	public List<WebElement> getProductsList() {
		waitForElementToAppear(tilesBy);
		return tiles;
	}

	public WebElement getProductByName(String productName) {
		return tiles.stream()
				.filter(x -> x.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
	}
	
	public void addProductToCart(WebElement tile) {
		tile.findElement(addToCartBtn).click();
		waitForElementToAppear(messageSuccess);
		waitForElementToDisappear(spinner);
	}

}

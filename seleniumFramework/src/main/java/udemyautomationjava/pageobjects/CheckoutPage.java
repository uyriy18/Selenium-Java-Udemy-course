package udemyautomationjava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import udemyautomation.AbstractComponents.AbstractComponenet;

public class CheckoutPage extends AbstractComponenet{

	WebDriver driver;
	Actions act;
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);

	}
	
	@FindBy(css="input[placeholder='Select Country']")                      // Country input field
	WebElement countryInput;
	@FindBy(css="a[class*='action__submit']")                               // Submit button on the Checkout page
	WebElement SubmitBTN;
	@FindBy(css=".ta-results button:first-of-type")                         // Select first result from the suggestions dropdown
	WebElement firstSuggestion;
	
	By suggestions = By.cssSelector(".ta-results");                            // Suggestions in the Country input
	
	
	public void selectCountry(String text) {
		act.sendKeys(countryInput, text).build().perform();
		waitForElementToAppear(suggestions);
		firstSuggestion.click();
	}
	
	public ConfirmationPage clickSubmitBTN() {
		SubmitBTN.click();
		return new ConfirmationPage(driver);
 	}
	
	//WebElement countryInput = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
	
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
	//act.click(driver.findElement(By.cssSelector(".ta-results button:first-of-type"))).build().perform();
	//act.click(driver.findElement(By.cssSelector("a[class*='action__submit']"))).build().perform();
	

}

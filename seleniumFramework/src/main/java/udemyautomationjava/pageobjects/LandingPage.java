package udemyautomationjava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import udemyautomation.AbstractComponents.AbstractComponenet;

public class LandingPage extends AbstractComponenet {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver); // send driver to the parent class AbstractComponent
		this.driver = driver;
		PageFactory.initElements(driver, this); // method which defines WebDriver for a Page factoring (e.g
												// :"@FindBy,...").

	}

	// Page factoring

	@FindBy(id = "userEmail") // The same as WebElement userEmail = driver.findElement(By.id("userEmail"));
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement loginButton;

	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;

	public ProductCatalog loginApplication(String email, String pass) { // Action method which completes all actions on
																		// the Landing page
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
		ProductCatalog catalogue = new ProductCatalog(driver); // After successful Log in, user should be redirected to
																// the PLP page, so we can create this step in this
																// method
		return catalogue;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);

		return errorMessage.getText();
	}

}

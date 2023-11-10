package udemyautomationjava.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import udemyautomation.AbstractComponents.AbstractComponenet;


public class LandingPage extends AbstractComponenet{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);                           // send driver to the parent class AbstractComponent
		this.driver = driver;
		PageFactory.initElements(driver, this);  // method which defines WebDriver for a Page factoring (e.g :"@FindBy,..."). 
	}
	
	//Page factoring
	
	@FindBy(id="userEmail")  // The same as WebElement userEmail = driver.findElement(By.id("userEmail"));
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	public void loginApplication(String email, String pass) {  // Action method which completes all actions on the Landing page
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

}

package udemyautomationjava.pageobjects;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import udemyautomation.AbstractComponents.AbstractComponenet;

public class ConfirmationPage extends AbstractComponenet{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub.
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement message;
	@FindBy(css="label[class='ng-star-inserted']")
	WebElement orderNumberLabel;
	
	public String getConfirmationMessage() {
		
		String actText = message.getText().trim();
		return actText;
	}
	public String setOrderNumber() {
		String orderNumber =  orderNumberLabel.getText();
		orderNumber = orderNumber.replaceAll("\\|", "").trim();
		return orderNumber;	
	}

}

package udemyautomationjava.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import udemyautomation.AbstractComponents.AbstractComponenet;

public class MyOrdersPage extends AbstractComponenet{

	WebDriver driver;
	public MyOrdersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css ="table tr[class='ng-star-inserted']")
	List<WebElement> ordersList;
	
	public WebElement findOrder(String orderNumber) {
		waitForWebElementsToAppear(ordersList);
		return ordersList.stream().filter(x -> x.findElement(By.tagName("th")).getText().equalsIgnoreCase(orderNumber)).
				findFirst().orElse(null);
	}
	public String checkProductName(String productName, String orderNumber) {
		List<WebElement> order = findOrder(orderNumber).findElements(By.tagName("td"));
		return order.stream().filter(x -> x.getText().equalsIgnoreCase(productName)).findFirst().orElse(null).getText();		
	}
	

		

	
	

}

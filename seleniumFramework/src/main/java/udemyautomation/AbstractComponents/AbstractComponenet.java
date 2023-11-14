package udemyautomation.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import udemyautomationjava.pageobjects.CartPage;
import udemyautomationjava.pageobjects.MyOrdersPage;

public class AbstractComponenet {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "button[routerlink='/dashboard/cart']")
	WebElement cartIcon;
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement myOrders;

	public AbstractComponenet(WebDriver driver) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public CartPage goToCartPage() {
		cartIcon.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}

	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForWebElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForWebElementsToAppear(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	public void waitForElementToDisappear(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public MyOrdersPage goToOrdersPage() {
		myOrders.click();
		MyOrdersPage ordersPage = new MyOrdersPage(driver);
		return ordersPage;
	}

}

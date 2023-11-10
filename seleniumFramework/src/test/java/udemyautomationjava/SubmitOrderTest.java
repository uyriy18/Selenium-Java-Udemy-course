package udemyautomationjava;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;

import udemyautomationjava.pageobjects.LandingPage;
import udemyautomationjava.pageobjects.ProductCatalogue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "zara coat 3";
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		LandingPage landingPage = new LandingPage(driver);  // send Driver to the LandingPage class
		landingPage.goTo();  // opens 	driver.get("https://rahulshettyacademy.com/client/");
		landingPage.loginApplication("test@as.co", "Test1234");  // send Email and Login to the method which enters them into inputs and click submit button 
		
		ProductCatalogue productCatalog = new ProductCatalogue(driver); // Send driver to PLP
		List<WebElement> tiles = productCatalog.getProductsList(); // get all products list on the page
		productCatalog.addProductToCart(productCatalog.getProductByName(productName));


		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(x -> x.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		WebElement countryInput = driver.findElement(By.cssSelector("input[placeholder='Select Country']"));
		Actions act = new Actions(driver);
		act.sendKeys(countryInput, "Ita").build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		act.click(driver.findElement(By.cssSelector(".ta-results button:first-of-type"))).build().perform();
		act.click(driver.findElement(By.cssSelector("a[class*='action__submit']"))).build().perform();
		String successMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(successMessage.trim().equalsIgnoreCase("Thankyou for the order."));
		driver.close();

	}

}

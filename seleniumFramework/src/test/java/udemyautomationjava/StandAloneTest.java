package udemyautomationjava;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;

import udemyautomationjava.pageobjects.LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "zara coat 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		
		LandingPage page = new LandingPage(driver);  // send Driver to the LandingPage class
		
		driver.findElement(By.id("userEmail")).sendKeys("test@as.co");
		driver.findElement(By.id("userPassword")).sendKeys("Test1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='card']//b"))));
		List<WebElement> tiles = driver.findElements(By.xpath("//div[@class='card']"));

		WebElement tile = tiles.stream()
				.filter(x -> x.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findFirst()
				.orElse(null);
		tile.findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.tagName("ngx-spinner"))));
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

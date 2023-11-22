import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumPractice {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));  // if we not apply this method "enter promocode" will be failed
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		String[] productNames = { "Brocolli", "Cucumber", "Beetroot" };
		List<WebElement> tiles = driver.findElements(By.cssSelector(".product"));
		addToCart(tiles, productNames); // add all products from array to the cart

		driver.findElement(By.cssSelector("a[class='cart-icon']")).click(); // click on the minicart button
		driver.findElement(By.xpath("//div[@class='action-block']//button")).click(); // proceed to CO
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy"); // enter promocode
		driver.findElement(By.cssSelector(".promoBtn")).click(); // apply promocode
		WebDriverWait expWait = new WebDriverWait(driver,Duration.ofSeconds(5));   //  Explicit wait for 5 seconds until promocode is applied and system returns Success message
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoinfo")));
		
		String expPromoMessage = "Code applied ..!";  // expected message after applying promotion		
		Assert.assertEquals(expPromoMessage, driver.findElement(By.cssSelector(".promoinfo")).getText());  // Assertion of Successful promo message appeared
	}

	private static void addToCart(List<WebElement> tiles, String[] productNames) {

		for (WebElement tile : tiles) {
			for (String name : productNames) {
				if (tile.getText().contains(name)) {
					tile.findElement(By.cssSelector("button[type='button']")).click();
					break;
				}

			}

		}
	}

}

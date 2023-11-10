import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		String username = "rahulshettyacademy";
		String password = "learning";
		String role = "Consultant";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // if we not apply this method "enter
																			// promocode" will be failed
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		logIn(driver, username, password, role);
		addToCart(driver);
		driver.findElement(By.xpath("//div[@id='navbarResponsive']//a")).click();
		driver.findElement(By.cssSelector(".btn.btn-success")).click();

	}

	private static void logIn(WebDriver driver, String username, String password, String role) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//div[@class='form-check-inline']//span[2]")).click();
		WebElement selector = driver.findElement(By.cssSelector("select.form-control"));
		Select selectedRole = new Select(selector);
		selectedRole.selectByVisibleText(role);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

	private static void addToCart(WebDriver driver) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card.h-100")));
		List<WebElement> tiles = driver.findElements(By.cssSelector(".card.h-100"));

		for (WebElement tile : tiles) {

			tile.findElement(By.cssSelector(".btn")).click();
		}
	}

}

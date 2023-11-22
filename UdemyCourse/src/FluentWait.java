import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FluentWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		
		
		  WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  expWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish'] h4")));
		 
		
	System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText(), "Hello World!");

	}

}

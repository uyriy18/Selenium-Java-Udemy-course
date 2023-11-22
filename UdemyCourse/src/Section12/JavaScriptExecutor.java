package Section12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		int sume = 0;
		List<WebElement> cells = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		for(WebElement cell : cells) {
			sume += Integer.parseInt(cell.getText());
		}
		System.out.println("Total sume = "+sume);
		String[] amount = driver.findElement(By.className("totalAmount")).getText().split(" ");
		for(String a : amount) {
			if(a.trim().equalsIgnoreCase(String.valueOf(sume))) {
				System.out.println("Sume is valid");
			}
		}
		
		

	}

}

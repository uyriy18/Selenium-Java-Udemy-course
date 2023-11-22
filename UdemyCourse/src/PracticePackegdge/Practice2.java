package PracticePackegdge;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List <WebElement> links = driver.findElements(By.cssSelector("a"));
		System.out.println(links.size());
		WebElement footerLinks = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerLinks.findElements(By.tagName("a")).size());
		WebElement columnDriver = footerLinks.findElement(By.cssSelector("table tbody tr"));
		List <WebElement>  coloumnSections = columnDriver.findElements(By.tagName("td"));		
		System.out.println(coloumnSections.size());
		System.out.println(coloumnSections.get(0).findElements(By.tagName("a")).size());
		List <WebElement> linksInColumn = coloumnSections.get(0).findElements(By.tagName("a"));
		int i = 1;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String keysChor = Keys.chord(Keys.CONTROL,Keys.ENTER);
		for(WebElement link : linksInColumn) {
			
	       System.out.println(i++ + " link opens"); 
	       link.sendKeys(keysChor);
			
		} 
		Set <String> tabs = driver.getWindowHandles();
		/*
		 * for(String tab : tabs) { driver.switchTo().window(tab);
		 * System.out.println(driver.getTitle()); driver.close(); }
		 */
		//driver.quit();
		Iterator<String> it =  tabs.iterator();
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}

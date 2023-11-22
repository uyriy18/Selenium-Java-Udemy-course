package PracticePackegdge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assigment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
        String checkboxText = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
		System.out.println(checkboxText);
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(checkboxText);
		driver.findElement(By.id("name")).sendKeys(checkboxText);
		driver.findElement(By.id("alertbtn")).click();
		String allertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertTrue(allertText.contains(checkboxText));    
		

	}

}

package Session14;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Filters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String productName = "Rice";
        driver.findElement(By.id("search-field")).sendKeys(productName);
        List<WebElement> names = driver.findElements(By.xpath("//tr//td[1]"));
        List<WebElement>filteredNames = names.stream().filter(x -> x.getText().contains(productName)).collect(Collectors.toList());
        Assert.assertEquals(names.size(), filteredNames.size());
	}

}

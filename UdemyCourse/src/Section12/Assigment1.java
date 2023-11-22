package Section12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assigment1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		List<WebElement> rows =  driver.findElements(By.xpath("//table[@class='table-display']//tr"));
		System.out.println("Rows = " + rows.size());
		List<WebElement> colums =  driver.findElements(By.xpath("//table[@class='table-display']//tr//th"));
		System.out.println("Colums = " + colums.size());
        List<WebElement> thirdRow =  driver.findElements(By.xpath("//table[@class='table-display']//tr[3]"));
        for(WebElement r : thirdRow) {        	
        	System.out.print(r.getText()+" ");
        	System.out.println();
        }
        List<WebElement> prices = driver.findElements(By.xpath("//table[@class='table-display']//td[3]"));
        int total = 0;
        for(WebElement price : prices) {
        	total += Integer.parseInt(price.getText());
        }
        System.out.println("Total price = "+total);
	}

}

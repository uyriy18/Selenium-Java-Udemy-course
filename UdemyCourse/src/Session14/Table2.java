package Session14;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Table2 {

	private static String productName = "Beans";
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();
		WebElement nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
		List<String> filteredNames;
		
			do {
				List<WebElement> names = driver.findElements(By.xpath("//td"));
				filteredNames = names.stream().filter(x -> x.getText().contains(productName)).map(x -> getPrice(x))
						.collect(Collectors.toList());
				if(filteredNames.size()<=0) {
					nextButton.click();
				}
			}
			while(filteredNames.size()<=0);
		
		

	}

	private static String getPrice(WebElement x) {
		String price = x.findElement(By.xpath("./following-sibling::td")).getText();
		System.out.println(productName + " : " +price);
		// TODO Auto-generated method stub
		return price;
	}

}

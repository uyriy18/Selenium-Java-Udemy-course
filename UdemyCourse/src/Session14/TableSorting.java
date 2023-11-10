package Session14;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class TableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SoftAssert a = new SoftAssert();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th[role='columnheader']:nth-child(1)")).click();
		List<WebElement> table = driver.findElements(By.cssSelector("table td:nth-child(1)"));
        List<String> actualList = table.stream().map(x -> x.getText()).collect(Collectors.toList());
        List<String> expectedList = actualList.stream().sorted().collect(Collectors.toList());
	    a.assertTrue(actualList.equals(expectedList));
		a.assertAll();

	}

}

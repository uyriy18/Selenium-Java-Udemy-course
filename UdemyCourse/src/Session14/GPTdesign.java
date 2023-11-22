package Session14;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class GPTdesign {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String productName = "Rice";
        List<WebElement> names = driver.findElements(By.xpath("//td"));
        List<String> filteredNames = names.stream().filter(x -> x.getText().contains(productName)).map(x -> getPrice(x)).collect(Collectors.toList());
        filteredNames.stream().forEach(x -> System.out.println(x));

      

        driver.close();
    }

	private static String getPrice(WebElement x) {
		String price = x.findElement(By.xpath("./following-sibling::td")).getText();
		// TODO Auto-generated method stub
		return price;
	}
}
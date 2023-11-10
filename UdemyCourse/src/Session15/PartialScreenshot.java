package Session15;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parrentWindow =  it.next();
		String childWindow =  it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		String text = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.close();
		driver.switchTo().window(parrentWindow);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(text);
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));
		File screen = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("logo.png"));
	}

}

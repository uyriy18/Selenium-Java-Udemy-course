import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class GoogleTest {

	@Test
	public void homePageCheck() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444"),caps); 
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.close();
	}
}

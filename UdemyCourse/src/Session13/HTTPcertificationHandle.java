package Session13;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPcertificationHandle {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		
		// block all pop-ups
		options.setExperimentalOption("excludeSwitches",
		Arrays.asList("disable-popup-blocking"));
		// block all pop-ups
		options.addArguments("start-maximized");
		
		driver.get("https://expired.badssl.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}

}

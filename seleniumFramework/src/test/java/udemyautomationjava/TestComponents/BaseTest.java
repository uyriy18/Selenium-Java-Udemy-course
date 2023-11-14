package udemyautomationjava.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import udemyautomationjava.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fileStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//udemyautomation//resources//GlobalData.properties");
		prop.load(fileStream);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	@BeforeMethod
	public LandingPage lunchApplication() throws IOException {

		driver = initializeDriver();
	    landingPage = new LandingPage(driver);  // send Driver to the LandingPage class
		landingPage.goTo();                                 // open site URL
		return landingPage;
	}
	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

}

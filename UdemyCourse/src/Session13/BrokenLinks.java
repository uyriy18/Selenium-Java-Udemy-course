package Session13;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrokenLinks {
	static SoftAssert a = new SoftAssert();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		List <WebElement> links = driver.findElements(By.cssSelector("div[id='gf-BIG'] a"));
		for(WebElement link : links) {
			String url = link.getAttribute("href");
			String name = link.getText();
			verifyUrl(url,name);
		}
		a.assertAll();

	}
	
	private static void verifyUrl (String url, String name) throws IOException {
		URL link = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) link.openConnection();
		connection.setRequestMethod("HEAD");
		//connection.setConnectTimeout(3000);
		connection.connect();		
		a.assertTrue((connection.getResponseCode() <= 400), "FAIL! link "+url+" : "+name+" : " +connection.getResponseCode());
		/*
		 * if(connection.getResponseCode() <= 400) {
		 * System.out.println("OK! link "+url+" : "+name+" : "+
		 * connection.getResponseCode()); } else {
		 * System.out.println("FAIL! link "+url+" : "+name+" : " +
		 * connection.getResponseCode()); }
		 */
		
	}

}

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;

public class GeolocationEmulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=es");
		ChromeDriver driver = new ChromeDriver(options);
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String, Object> coordinates = new HashMap();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://google.com");
		driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Netflix");
		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).build().perform();
		driver.findElement(By.cssSelector("a[jsname='UWckNb']:first-child")).click();
		System.out.println(driver.findElement(By.cssSelector("h1")).getText());

	}

}

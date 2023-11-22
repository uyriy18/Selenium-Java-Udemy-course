import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class AngularPractice {

	public static void main(String[] args) throws InterruptedException {
		String expectedMessage = "Success! The Form has been submitted successfully!.";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Yurii");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Yurii@email.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");
		Assert.assertFalse(driver.findElement(By.cssSelector("#exampleCheck1")).isSelected());
		driver.findElement(By.cssSelector("#exampleCheck1")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#exampleCheck1")).isSelected());
		WebElement dropdown = (driver.findElement(By.cssSelector("#exampleFormControlSelect1")));
		Select gender = new Select(dropdown);
		gender.selectByVisibleText("Male");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select//option[1]")).click();
		driver.findElement(By.cssSelector("#inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("04181985");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		String actMessage = trimMessage(driver.findElement(By.className("alert-success")).getText());
		Assert.assertEquals(actMessage, expectedMessage);
		Thread.sleep(1000);
		driver.close();
	}
	
	private static String trimMessage(String message) {
		String[] act = message.split("×");
		message = act[1].trim();
		System.out.println(message);
		return message;
	}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='chk_friendsandfamily']")).isSelected());
        
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        
        if(!driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected()) {
        	driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        }
       
        Assert.assertFalse(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Thread.sleep(1000);
        for(int i = 0; i < 2; i++) {
        	driver.findElement(By.cssSelector("#hrefIncAdt")).click();
        }
        driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(), "3 Adult");
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        Thread.sleep(1000);
       
	}

}
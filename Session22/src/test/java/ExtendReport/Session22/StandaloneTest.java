package ExtendReport.Session22;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class StandaloneTest {
	
	ExtentReports extentReport;
	@Test
	public void openUrl() {
		ExtentTest test = extentReport.createTest("Open URL");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");		
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Test Fail");
		extentReport.flush();
	}
	
	@BeforeTest
	public void config() {		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\index.html");
		extentReport = new ExtentReports();
		sparkReporter.config().setReportName("Web Automation Results");
		sparkReporter.config().setDocumentTitle("Tests Results");
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Engineer", "Yurii Bartash"); 
	}

}

package Test;

import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MobileWebAPI {
	@Test(groups={"Smoke","Regression"})
	
	public void web() {
		System.out.println("Web MobileWebAPI");
		
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("Before Method 1");
	}
	@Test(groups={"Smoke"})
	public void mobiletest() {
		System.out.println("Mobile MobileWebAPI");
	}

	@Test(groups={"Smoke","Regression"})
	public void api() {
		System.out.println("API MobileWebAPI");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is BEFORE CLASS MobileWebAPI");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This is AFTER CLASS MobileWebAPI");
	}


}

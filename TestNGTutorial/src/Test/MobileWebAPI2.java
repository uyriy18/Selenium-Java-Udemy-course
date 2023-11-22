package Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileWebAPI2 {
	
	@Test(timeOut = 4000)
	public void web() {
		System.out.println("Web2");
	}
	@Test(groups={"Smoke","Regression"})
	public void mobile() {
		System.out.println("Mobile2");
	}
	@Test(dependsOnMethods = {"web","mobile"})
	public void api() {
		System.out.println("API2");
	}
	@BeforeMethod
	public void beforeMethod3() {
		System.out.println("Before Method 3");
	}

}

package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TextXMLCreated {
	@Test
	public void anotherTest() {
		System.out.println("Web Class 2");
	}
	
	@Test(groups={"Smoke"})
	public void mobileTest() {
		System.out.println("Mobile Class 2");

	}
	@AfterTest
	public void afterExecution() {
		System.out.println("AFTERTEST script execution");
	}

}

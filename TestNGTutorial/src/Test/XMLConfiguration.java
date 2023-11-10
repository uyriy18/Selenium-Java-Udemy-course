package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XMLConfiguration {
	
    @Test
	public void Test1() {
    	System.out.println("Test1");
	}
    
    @Test
    public void Test2() {
    	System.out.println("Test2");
    }
    
    @BeforeSuite
    public void beforSuite() {
    	System.out.println("This is the highrst priority test BEFORE SUITE");
    }
    
    @AfterSuite
    public void afterSuite() {
    	System.out.println("This is AFTER SUITE");
    }
    
	@BeforeTest
	public void preExecution() {
		System.out.println("This is pre BEFORE TEST");
	}

}

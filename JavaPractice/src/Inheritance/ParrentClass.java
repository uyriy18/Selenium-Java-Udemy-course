package Inheritance;
import org.testng.annotations.*;

public class ParrentClass {
	
	private static String parrentVar = "private variable";
	
	
	@Test
	public static void partentMethod1() {
		System.out.println("Public parrent method1 " + parrentVar);
	}
	@BeforeMethod
	public void partentMethod2() {
		System.out.println("Before method from parrent class");
	}
	

}

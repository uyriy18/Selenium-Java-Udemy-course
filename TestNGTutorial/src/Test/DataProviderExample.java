package Test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderExample {
	
	
	@Test(dataProvider = "userData")

	
	public static void CredentialsTest(String userName, String password)
	{
		System.out.println(userName);
		System.out.println(password);
	}
	
	
	@DataProvider
	public static Object[][] userData()
	{
		Object[][] data = new Object[3][2];
		data [0][0] = "username1";
		data [0][1] = "password1";
		data [1][0] = "username2";
		data [1][1] = "password2";
		data [2][0] = "username3";
		data [2][1] = "password3";
		return data;
				
	}

}



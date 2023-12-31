import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.devtools.v118.network.model.Response;
import org.openqa.selenium.devtools.v118.network.Network;

public class NetworkActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
		//	System.out.println(req.getHeaders());

		});
		devTools.addListener(Network.responseReceived(), response ->		
		{
			Response res = response.getResponse();
		//	System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			if(res.getStatus().toString().startsWith("4") || res.getStatus().toString().startsWith("5"))	{
				System.out.println("Request " + res.getUrl() + " was failed, status code = " + res.getStatus());
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		
		
		
		
	}

}

package Demopack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	@Given("User give some message {string}")
	public void user_give_some_message(String st) throws InterruptedException {
	   System.out.println("Yes my jenkins project executed successfully=====");
	   System.out.println("yeah i have checked my issues=======");
	   WebDriverManager.firefoxdriver().setup();
	   RemoteWebDriver driver=new ChromeDriver();
	   driver.get("https://www.google.com");
	   Thread.sleep(2000);
	   String title=driver.getTitle();
	   if(title.equals(st)) 
	   {
		Assert.assertTrue(true);   
	   }
	   else {
		Assert.assertTrue(false);
	   }
	   driver.close();
	}
}

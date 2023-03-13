package pack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowseing {
	RemoteWebDriver driver;
	 @Parameters("browserName")
	 @BeforeTest
	    public void beforeMethod(String browserName) 
	    {
		 System.out.println("Thread information:"+Thread.currentThread().getId());
		 
	    	System.out.println("browser name is:"+browserName);
	       if(browserName.equalsIgnoreCase("chrome"))
	       {
	    	   WebDriverManager.chromedriver().setup();
	    	   driver =new ChromeDriver();
	       }else if(browserName.equalsIgnoreCase("firefox"))
	       {
	    	   WebDriverManager.firefoxdriver().setup();
	    	   driver =new FirefoxDriver();
	       }else if(browserName.equalsIgnoreCase("ie"))
	       {
	    	   WebDriverManager.iedriver().setup();
	    	   driver =new InternetExplorerDriver();
	       }else {
	    	   System.out.println("no browser found=====");
	       }
	    }
    @Test
    public void testMethod() throws InterruptedException 
    {
       driver.get("https://www.google.com");
       Thread.sleep(3000);
       System.out.println("the google site launched successfully====");
    }
    @Test
    public void testmethod1() {
    	driver.close();
    }
    @AfterTest
    public void afterTestmethod() {
    	System.out.println("google site close successfully===");
    }
}

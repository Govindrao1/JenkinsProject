package PageFactoryClasses;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Utilities.WebSiteUtility;

public class Homepage {
	
	private RemoteWebDriver driver;
	WebSiteUtility webutil;
	private FluentWait<RemoteWebDriver> wait;
	public Homepage(RemoteWebDriver driver1 ) throws Exception {
		this.driver=driver1;
		PageFactory.initElements(driver, this);
		webutil=new WebSiteUtility(driver);
	    //wait=webutil.defineWait(driver);
	    
	}
	                                             
	@FindBy(id="userId")
	private WebElement  userid;
	
	@FindBy(id="pass")
	private WebElement passwd;
	
	@FindBy(name="company")
	private WebElement company;
	
	@FindBy(name="mobile number")
	private WebElement mobilenum;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submitbut;
	
	@FindBy(id="inp_val")
	private WebElement firstcrh;
	
	public void userEmailmethod() {
		wait.until(ExpectedConditions.visibilityOf(userid)).sendKeys("india123@gmail.com");
	}	    
	public void passwordMethod() {
		wait.until(ExpectedConditions.visibilityOf(passwd)).sendKeys("india123@#");
	}
	
	public void companyMethod() {
		wait.until(ExpectedConditions.visibilityOf(company)).sendKeys("TCS");
	}
	
	public void mobileNumMethod() {
		wait.until(ExpectedConditions.visibilityOf(mobilenum)).sendKeys("9876543210");
	}
	
	public void submitButtonMethod() {
		wait.until(ExpectedConditions.elementToBeClickable(mobilenum)).click();
	}
	
	public void firstCrhMethod() {
		wait.until(ExpectedConditions.visibilityOf(firstcrh)).sendKeys("family");
	}
	
	
	
}

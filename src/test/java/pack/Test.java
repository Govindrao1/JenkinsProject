package pack;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	RemoteWebDriver driver;
	FluentWait<RemoteWebDriver> wait;
	WebElement e;
	Scenario sc;
	@Before
	public void beforeMethod(Scenario s) throws Exception {
		sc=s;
	s.log("Before method executed....");
	}
	@Given("User open the chrome browser")
	public void user_open_the_chrome_browser() {
	   WebDriverManager.firefoxdriver().setup();
	   driver=new FirefoxDriver();
	   sc.log("browser opened successfully...");
	   wait=new FluentWait<RemoteWebDriver>(driver);
	   wait.pollingEvery(Duration.ofMillis(2000));
	   wait.withTimeout(Duration.ofSeconds(20));
	   
	}

	@When("User launch the yahoo site {string}")
	public void user_launch_the_yahoo_site(String url) throws InterruptedException {
	  driver.get(url);
	  WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
	  e.click();
	}

	@Then("User give the valid username and click next button")
	public void user_give_the_valid_username_and_click_next_button() throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))).sendKeys("magnitia");
     WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.name("signin")));
     e1.click();
	}

	@Then("User give the valid password and click next button")
	public void user_give_the_valid_password_and_click_next_button() throws InterruptedException  {
	WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
	e.sendKeys("tester123@#");
	 WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.id("login-signin")));
	 e1.click();
	}
	@Then("User check the compose button working correctly or not")
	public void user_check_the_compose_button_working_correctly_or_not() {
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Compose']"))).click();
	   wait.until(ExpectedConditions.visibilityOfElementLocated
			   (By.xpath("(//input[@role='combobox'])[2]"))).sendKeys("govindrouthu143@gmail.com");
	   wait.until(ExpectedConditions.visibilityOfElementLocated
			   (By.xpath("//input[@placeholder='Subject']"))).sendKeys("my name is govind");
	   wait.until(ExpectedConditions.visibilityOfElementLocated
			   (By.xpath("//div[@aria-label='Message body']"))).sendKeys("This is my first message");
	}
	@Then("User check compose fields working corrctly or not {string}")
	public void user_check_compose_fields_working_corrctly_or_not(String st) throws IOException {
		WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='D_F ab_C gl_C W_6D6F'])[6]")));
		e.click();
		File f= new File("target\\element.png");
		File scr=e.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scr, f);
		WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Insert animated GIFs']")));
		e1.click();
		File f1= new File("target\\animated.png");
		File scr1=e1.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scr1, f1);
		WebElement mes=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Send']")));
		mes.click();
		if(st.contains("your message has been sent"))
		{
			sc.log("message sent successfully====");
			Assert.assertTrue(true);
		}else
		{
			sc.log("message not sent successfully----");
			Assert.assertTrue(false);
		}
		
	}
    @When("User logout the page")
	public void user_logout_the_page() throws InterruptedException {
	 WebElement e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='presentation']")));
	 e.click();
	 WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign out']")));
	 e1.click(); 
	}
	@Then("User close the current browser")
	public void closemethod() {
		driver.close();
	}

}


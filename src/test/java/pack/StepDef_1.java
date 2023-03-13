package pack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;
import PageFactoryClasses.Homepage;
import Utilities.PropertiesUtil;
import Utilities.WebSiteUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef_1 {
	private RemoteWebDriver driver;
    PropertiesUtil  propertiesutil;
	WebSiteUtility websiteutil;
    Homepage homePage;
	WebElement e;
	Scenario sc;
	SoftAssert softassert;
	@Before
	public void beforeMethod(Scenario s) throws Exception {
		sc=s;
		softassert=new SoftAssert();
		s.log("Before method executed...");
		propertiesutil =new PropertiesUtil(driver);
	    websiteutil=new WebSiteUtility(driver);
	    homePage=new Homepage(driver);
	}
	@Given("User should launch the browser")
	public void user_should_launch_the_browser() throws Exception {
		websiteutil.openBrowser("firefox");
	}

	@When("User launches the selectorshub site {string}")
	public void user_launches_the_selectorshub_site(String string) throws Exception {
		String url=propertiesutil.getApplicationUrl(driver);
		System.out.println(url);
		websiteutil.launchSite(url);
		if(string.contains(string))
		{
			softassert.assertTrue(true);
			sc.log("the title is matched...");
		}else {
			softassert.assertTrue(false);
			sc.log("the title is not matched... ");
		}
	}

	@When("User should check the user email field working or not")
	public void user_should_check_the_user_email_field_working_or_not() throws Exception {
		homePage.userEmailmethod();
		sc.log("user mail successfully executed..");
	}

	@Then("User checks password field working currectly or not")
	public void user_checks_password_field_working_currectly_or_not() {
		homePage.passwordMethod();
		sc.log("password successfully executed..");
	}

	@Then("User gives the valid company name it is working correctly or not")
	public void user_gives_the_valid_company_name_it_is_working_correctly_or_not() {
		homePage.companyMethod();
		sc.log("company name successfully executed..");
	}

	@Then("User should check the mobile number checkbox")
	public void user_should_check_the_mobile_number_checkbox() {
		homePage.mobileNumMethod();
		sc.log("mobile number successfully executed..");
	}

	@Then("User check the submit button is clickble or not")
	public void user_check_the_submit_button_is_clickble_or_not() {
		homePage.submitButtonMethod();
		sc.log("submit button successfully clickble...");
	}

	@Then("User give vlaid data in first crush field")
	public void user_give_vlaid_data_in_first_crush_field() {
		homePage.firstCrhMethod();
		sc.log("first crush checkbox working correctly...");
	}
	@After
	public void afterMethod() {
		softassert.assertAll();
		sc.log("after method is executed....");
	}
}

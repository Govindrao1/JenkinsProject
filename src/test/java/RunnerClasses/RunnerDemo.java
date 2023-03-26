package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src\\test\\resources\\Feature\\Demo.feature"},
		glue= {"Demopack"},
		monochrome=true,
		plugin= {"pretty","html:target/passedtestresult.txt","rerun:target/failedtestresult.txt"})

public class RunnerDemo extends AbstractTestNGCucumberTests {

}

package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features= {"src\\test\\resources\\Feature\\feature_1.feature"},
		glue= {"C:\\Users\\HP\\eclipse-workspace\\org.Jenkins\\src\\test\\java\\pack\\Test.java"},
		monochrome=true,
		plugin= {"pretty","html:target/passedresult","rerun:target/failedtestresult.txt"})

public class Runner_1 extends AbstractTestNGCucumberTests{

}

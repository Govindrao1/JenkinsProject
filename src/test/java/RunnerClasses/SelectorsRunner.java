package RunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src\\test\\resources\\Feature\\feature_2.feature"},
		glue= {"C:\\Users\\HP\\eclipse-workspace\\org.Jenkins\\src\\test\\java\\pack\\StepDef_1.java"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:target/passedresult","rerun:target/failedtestresult.txt"})

public class SelectorsRunner extends AbstractTestNGCucumberTests{

}

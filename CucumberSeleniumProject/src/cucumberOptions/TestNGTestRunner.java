package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/features",glue="stepDefinition",monochrome=true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	

}

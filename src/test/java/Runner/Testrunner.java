package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(		
				   features = "classpath:/Features",
					glue = "StepDefination",
					dryRun = false,
					monochrome = true,
					plugin = { "rerun:target/failed_scenarios.txt",
							   "pretty",
							   "html:target/cucumber-reports/HtmlReport.html",
							  // "json:target/cucumber-reports/JsonReport.json",
							   //"junit:target/cucumber-reports/JUnitReport.xml",
                               "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		         )
public class Testrunner {
	 	
}

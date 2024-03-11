package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/FlipkartOrder.feature", // "Features/shopnow.feature",//feature file path
		glue = "stepDefinations", // stepdefination package name
		dryRun = false, // checking every feature step has particular stepdefinatio or not
		monochrome = true, // it will give readable format of console
		plugin = { "pretty","html:target/cucumber-reports" }// its for reports- to generate good reports
)
public class TestRun {

}

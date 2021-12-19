package StepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;  

@CucumberOptions(
		features={"src/test/resources/Features/inventory.feature"},

		monochrome = true,
		plugin = {"pretty", 
				"html:target/reports",
				"json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		glue={"StepDefinitions"},
		publish = true
		//
		//	tags={"@bgdemo"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}



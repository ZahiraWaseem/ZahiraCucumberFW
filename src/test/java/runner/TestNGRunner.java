package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "./src/test/resources/Features/",
glue = {"day21Steps","steps","hooks"},
tags = "@Smoke",

dryRun = false,
plugin = {"json:target/Report/cucumber-report.json","html:target/Report/cucumber-report.html",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
publish = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests{

	//@DataProvider(parallel = true)
    //public Object[][] scenarios() {
       
      //  return super.scenarios();
    //}


}

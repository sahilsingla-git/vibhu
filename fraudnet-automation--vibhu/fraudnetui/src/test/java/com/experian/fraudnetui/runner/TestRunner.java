package com.experian.fraudnetui.runner;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(

strict = false,

features ={ "src/test/resources/features/"} , //path of feature files//

glue= {"com/experian/fraudnetui/featuredefs"}, //path of step defination files

        plugin= {"pretty","html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json", "junit:target/cucumber/cucumber.xml","com.cucumber.listener.ExtentCucumberFormatter:target/test-reports/report.html","rerun:target/rerun.txt"}, //to generate different types of reporting

 		monochrome = true,//display the console output in a proper readable format
 		//strict = true, //it will check if any step is not defined in step definition file
 		dryRun = false, //to check the mapping is proper between feature file and step def file
 		tags = {"@PracticeLogin"}  //tags = {"@all"}

)


public class TestRunner {
	
	@AfterClass
    public static void writeExtentReport()
	{
		Reporter.loadXMLConfig(new File("D:\\fraudnet-automation\\fraudnetui\\Configs\\extent-config.xml"));
        
	}	
	

}

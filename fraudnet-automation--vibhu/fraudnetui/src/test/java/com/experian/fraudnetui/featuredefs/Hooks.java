package com.experian.fraudnetui.featuredefs;


import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.experian.fraudnetui.drivermanager.TestBase;

public class Hooks  extends TestBase{	
	
	
	@Before
	public void setup()
	{
		TestBase.driver=new ChromeDriver();

	}

	@After(order=1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				//This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);

				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				//File destinationPath = new File(System.getProperty("user.dir")+"/test-output/screenshots/" + screenshotName + ".png");

				//Copy taken screenshot from source location to destination location
				//Files.copy(sourcePath, destinationPath);

				String destDir = System.getProperty("user.dir") + "/" + "target/screenshots";
				new File(destDir ).mkdirs();
				String destFile = destDir + "/" + screenshotName+".png";
				Files.copy(sourcePath, new File(destFile ));

				//This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destFile);
			} catch (IOException e) {
			}
		}
	}

	@After(order=0)

	public void teardown()
	{
		TestBase.driver.quit();
	}

	
	
}

package com.experian.fraudnetui.featuredefs;

import java.util.concurrent.TimeUnit;

import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.pageobjects.googlepage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.junit.Assert;
import com.experian.fraudnetui.pageobjects.googlepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class google extends TestBase {

    private googlepage google=null;



    @Given("^Navigate to google home page$")
    public void navigate_to_google_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        Reporter.addStepLog("navigate to google page");

    }

    @When("^Enter some search criteria in search box$")
    public void enter_some_search_criteria_in_search_box() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        googlepage enterq=new googlepage(driver);
        enterq.enterQuery();
        Reporter.addStepLog("enter some search criteria");

    }

    @Then("^search results should appear$")
    public void search_results_should_appear() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        googlepage search=new googlepage(driver);
        boolean result=search.checkresult();
        Assert.assertTrue(result);
        Reporter.addStepLog("search results verified");
        //driver.quit();
    }

    /*@After
    public void closeBrowser() {
        driver.quit();
    }*/


}

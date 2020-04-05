package com.experian.fraudnetui.featuredefs;

import java.util.concurrent.TimeUnit;

import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.Utility.Util;
import com.experian.fraudnetui.pageobjects.LoginPage;
import com.experian.fraudnetui.pageobjects.PracticeLoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PracticeLogin extends TestBase {

    private PracticeLoginPage PracticeloginPage=null;


    @Given("^user lands on practice login page$")
    public void user_lands_on_practice_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try
        {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.get("http://demo.guru99.com/V4/");
            driver.manage().deleteAllCookies();
            Reporter.addStepLog("navigate to login page");
        }
        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }
    }

    @When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enter_and(String uname, String pwd) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        PracticeloginPage =new PracticeLoginPage(driver);
        PracticeloginPage.login(uname,pwd);
    }

    @When("^user enter mngr(\\d+) and YjaguhY$")
    public void user_enter_mngr_and_YjaguhY(String uname,String pwd) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PracticeloginPage =new PracticeLoginPage(driver);
        PracticeloginPage.login(uname,pwd);
    }

    @Then("^user lands on homepage$")
    public void user_lands_on_homepage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       // throw new PendingException();
        boolean UserLandsHomePage=PracticeloginPage.checkSuccessfullogin();
        Assert.assertTrue(UserLandsHomePage);



    }

}

package com.experian.fraudnetui.featuredefs;
import java.util.concurrent.TimeUnit;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class test extends TestBase {

    @Given("^I have variable a$")
    public void i_have_variable_a() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            //driver.navigate().to("http://www.jjdhsdhjs.com");
            driver.findElement(By.id("text")).click();
        }

        catch (Exception ex)
        {
            //Reporter.addStepLog(ex.getMessage());
            Assert.fail(ex.getMessage());

        }

    }

    @Given("^I have variable b$")
    public void i_have_variable_b() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I multiplication a and b$")
    public void i_multiplication_a_and_b() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I display the Result$")
    public void i_display_the_Result() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }


}

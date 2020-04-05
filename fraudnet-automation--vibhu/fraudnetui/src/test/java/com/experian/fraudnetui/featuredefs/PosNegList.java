package com.experian.fraudnetui.featuredefs;

import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.pageobjects.PosNegListPage;
import com.experian.fraudnetui.pageobjects.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.junit.Assert;

import java.util.List;

public class PosNegList extends TestBase {

    private LoginPage loginPage=null;
    private PosNegListPage posNegListPage =null;

    @When("^user enters username and password,organisation to login$")
    public void user_enters_username_and_password_organisation_to_login(DataTable dt) throws Throwable {

        try
        {
            loginPage = new LoginPage(driver);
            List<List<String>> data = dt.raw();
            loginPage.login(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2));
        }

        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }


    }

    @Given("^user navigates to positive tab for IP address$")
    public void user_navigates_to_positive_tab_for_IP_address() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        posNegListPage =new PosNegListPage(driver);
        posNegListPage.navigateTOList();
    }

    @When("^user makes a entry for \"([^\"]*)\" in negative tab$")
    public void user_makes_a_entry_for_in_positive_tab(String ipaddress) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        posNegListPage.makeListEntryForNegative(ipaddress);
    }

    @When("^user makes a entry for same \"([^\"]*)\" in negative tab$")
    public void user_makes_a_entry_for_same_in_negative_tab(String ipaddress) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        posNegListPage.makeDuplicateEntryForNegative(ipaddress);
    }

    @Then("^user is able to see validationmessage for duplicate entry in list$")
    public void user_is_able_to_see_validationmessage_for_duplicate_entry_in_list() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       Assert.assertTrue(posNegListPage.verifyDuplicateEntryMsg());
    }



}

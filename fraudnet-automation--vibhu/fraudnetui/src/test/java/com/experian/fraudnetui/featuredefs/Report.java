package com.experian.fraudnetui.featuredefs;
import com.cucumber.listener.Reporter;
import com.experian.fraudnetui.pageobjects.ReportPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.junit.Assert;
import java.util.List;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
public class Report extends  TestBase {

    private ReportPage reportPage =null;

    @Given("^user navigates to report tab$")
    public void user_navigates_to_report_tab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try

        {
            reportPage = new ReportPage(driver);
            reportPage.navigateToReport();
        }

        catch (Exception ex)
        {
            Reporter.addStepLog(ex.getMessage());
        }
    }

    @When("^user clicks on the investigator productivity report in standard reports$")
    public void user_clicks_on_the_investigator_productivity_report_in_standard_reports() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        reportPage.navigateToInvProdReport();
    }

    @When("^user clicks on export to csv button$")
    public void user_clicks_on_export_to_csv_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        reportPage.exportToCSV();
    }

    @Then("^user should be able to export report successfully$")
    public void user_should_be_able_to_export_report_successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
          boolean chkCSV= reportPage.csvInvProdReportExist();
          Assert.assertTrue(chkCSV);

    }
}

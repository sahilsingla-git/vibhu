package com.experian.fraudnetui.featuredefs;
import java.util.concurrent.TimeUnit;

import com.cucumber.listener.Reporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.junit.Assert;
import com.experian.fraudnetui.pageobjects.LoginPage;

public class Login extends TestBase {

   private LoginPage loginPage=null;


	@Given("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try
		{
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://qa-fn55enc-ui.41web.qa:8443/fraudnet-ui/login/internal");
			Reporter.addStepLog("navigate to login page");
		}

		catch (Exception ex)
		{
			Reporter.addStepLog(ex.getMessage());


		}
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\",\"([^\"]*)\"$")
	public void user_enters_and(String username, String password, String orgname) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {

			loginPage = new LoginPage(driver);
			loginPage.login(username, password, orgname);
		}

		catch (Exception ex)
		{

			Reporter.addStepLog(ex.getMessage());
		}
	}

	@Then("^user is successfully logged in to system$")
	public void user_is_successfully_logged_in_to_system() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		boolean usernameexists=loginPage.checkSuccessfullogin();
		Assert.assertTrue(usernameexists);
		loginPage.logOut();

	}



}

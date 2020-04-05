package com.experian.fraudnetui.featuredefs;
import java.util.concurrent.TimeUnit;
import com.cucumber.listener.Reporter;
import com.jayway.restassured.RestAssured;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.experian.fraudnetui.drivermanager.TestBase;
import org.apache.http.HttpRequest;
import org.junit.Assert;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class servicesample {

    Response response=null;

    @Given("^I setup the request URI for weather information$")
    public void i_setup_the_request_URI_for_weather_information() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";



    }

    @When("^I got the response for weather information of hyderabad$")
    public void i_got_the_response_for_weather_information_of_hyderabad() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        response = RestAssured.get("/Hyderabad");
    }

    @Then("^I validate the response for correct city temperature$")
    public void i_validate_the_response_for_correct_city_temperature() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        int statusCode = response.getStatusCode();
        boolean City=response.asString().contains("Hyderabad");
        Assert.assertEquals("status code 200 ok",200,statusCode);
        Assert.assertTrue(City);

    }



}

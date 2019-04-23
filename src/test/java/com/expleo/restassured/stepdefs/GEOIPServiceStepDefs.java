package com.expleo.restassured.stepdefs;

import com.expleo.restassured.steps.CountryNameByISOCodeSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class GEOIPServiceStepDefs {

    String twoCharIsoCode = "ZA";
    String countryName = "South Africa";

    @Steps
    CountryNameByISOCodeSteps testSteps;

    @Given("^I am using valid two character ISO codes$")
    public void iAmUsingValidTwoCharacterISOCodes()  {
        //  Nothing really needed here
    }

    @When("^I submit a valid ISO code$")
    public void iSubmitAValidISOCode() {
        testSteps.submitAValid2CharIsoCodeAs(twoCharIsoCode, countryName);
    }

    @Then("^I receive the correct country$")
    public void iReceiveTheCorrectCountry() {
        testSteps.iReceiveTheCorrectCountryNameAs(countryName);
    }
}

package com.expleo.restassured.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CountryNameByISOCodeSteps {

    private ResponseSpecification respSpec = null;
    private RequestSpecification reqSpec = null;

    @Step
    public void iReceiveTheCorrectCountryNameAs(String countryName) {
        Response response = given(reqSpec, respSpec)
                .get("{code}");
        response.then().log().all();
    }

    @Step
    public void
    submitAValid2CharIsoCodeAs(String twoCharIsoCode, String countryName) {
        setReqSpec(twoCharIsoCode);
        setRespSpec(countryName);
    }

    private void setReqSpec(String code) {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://services.groupkt.com")
                .setBasePath("/country/get/iso2code/")
                .addPathParam("code", code)
                .build();
    }

    private void setRespSpec(String expectedPathValue) {
        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("RestResponse.result.name", equalTo(expectedPathValue))
                .build();
    }
}

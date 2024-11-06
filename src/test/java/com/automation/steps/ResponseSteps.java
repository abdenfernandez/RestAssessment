package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseSteps {
    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response schema with {string}")
    public void verifyResponseSchemaWith(String filePath) {
        Response response = RestAssuredUtils.getResponse();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data/create_booking_schema.json"));
    }

    @And("store {string} into {string}")
    public void storeInto(String jsonPath, String configKey) {
        String value = RestAssuredUtils.getResponseFieldValue(jsonPath);
        ConfigReader.setProperty(configKey, value);
    }
}

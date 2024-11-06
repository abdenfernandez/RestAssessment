package com.automation.steps;


import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.lang.reflect.Field;

public class RequestSteps {


    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) {
        RestAssuredUtils.clear();
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @And("set parameter {string} to {int}")
    public void setParamTo(String key, int value) {
        RestAssuredUtils.setParam(key,value);
    }

    @Given("set request body from file {string}")
    public void set_request_body_from_file(String filePath) throws Exception {
        RestAssuredUtils.setBody(filePath);
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
    }

    @When("user performs delete call")
    public void user_performs_delete_call() {
        RestAssuredUtils.delete();
    }

    @When("user performs put call")
    public void user_performs_put_call() {
        RestAssuredUtils.put();
    }

    @When("user performs get call")
    public void user_performs_get_call() {
        RestAssuredUtils.get();
    }



}

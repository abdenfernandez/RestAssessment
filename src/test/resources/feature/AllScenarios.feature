Feature: Verify User Registration, Login, Get, Update, Delay and Delete

  Scenario: Verify User can register, login and retrieve
    Given user wants to call "/register" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "RegistrationDetails.json"
    When user performs post call
    Then verify status code is 200
    And store "id" into "reg.id"
    Given user wants to call "/login" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "LoginDetails.json"
    When user performs post call
    Then verify status code is 200
    Given user wants to call "/login" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "FakeLoginDetails.json"
    When user performs post call
    Then verify status code is 400

  Scenario: Retrieve all the users
    Given user wants to call "/users" end point
    When user performs get call
    Then verify status code is 200

  Scenario: Creating Details Using Post Method On the API
    Given user wants to call "/users" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "CreateDetails.json"
    Then user performs post call
    Then verify status code is 201

  Scenario: Verify Whether we are getting a delayed response
    Given user wants to call "/users" end point
    And set header "Content-Type" to "application/json"
    And set parameter "delay" to 3
    Then user performs get call
    Then verify status code is 200

  Scenario: Updating the details using specific id
    Given user wants to call "/users/reg.id" end point
    And set header "Content-Type" to "application/json"
    And set request body from file "UpdateDetails.json"
    When user performs put call
    Then verify status code is 200

  Scenario: Verify whether we can perform delete call
    Given user wants to call "/users/reg.id" end point
    And set header "Content-Type" to "application/json"
    When user performs delete call
    Then verify status code is 204

  Scenario: Getting the list of unknown users
    Given user wants to call "/unknown" end point
    Then user performs get call
    Then verify status code is 200


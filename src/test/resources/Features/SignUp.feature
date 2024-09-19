@tag
Feature: New user creation and login

  @tag1
  Scenario: New user creation
    Given user is on login page
    When user clicks on create new account link
    And user enters first name and last name
    And user enters username and password
    And user clicks on create account button
    Then the new user gets created

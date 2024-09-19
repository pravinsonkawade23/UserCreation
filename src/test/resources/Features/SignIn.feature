@tag
Feature: New user login

 @tag2
  Scenario: Login with user credentials
    Given user is present on login page
    And user clicks on signin link
    And user enters email and password
    And user clicks on signin button
    Then user gets logged in

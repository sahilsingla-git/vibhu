
@Report
Feature: Investigator Productivity Report Feature
  Verify export functionality for report
  Background:
    Given user navigates to Login Page
    When user enters username and password,organisation to login
      |testfraudmanager@bcone.com|Enter@12345|bondorg|


  Scenario: Verify user is able to export investigator report successfully

    Given user navigates to report tab
    When user clicks on the investigator productivity report in standard reports
    And user clicks on export to csv button
    Then user should be able to export report successfully

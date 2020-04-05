
@PostNegList
Feature: List Feature
  Verify user is not able to do duplicate entries in List
Background:
  Given user navigates to Login Page
  When user enters username and password,organisation to login
    |testfraudmanager@bcone.com|Enter@12345|bondorg|


  Scenario Outline: Verify user is not able to do duplicate entries in list

    Given user navigates to positive tab for IP address
    When user makes a entry for "<ipaddress>" in negative tab
    And user makes a entry for same "<ipaddress>" in negative tab
    Then user is able to see validationmessage for duplicate entry in list
    Examples:
      |ipaddress|
      |35.35.35.35|

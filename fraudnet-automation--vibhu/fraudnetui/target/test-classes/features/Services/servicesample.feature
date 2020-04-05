@servicesample
Feature: Check Weather Information

  Scenario: Retrieve weather information for a particular city
    Given I setup the request URI for weather information
    When I got the response for weather information of hyderabad
    Then I validate the response for correct city temperature
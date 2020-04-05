
@PracticeLogin
Feature: Practice Login

  Verify if user is able to login into practice

  Scenario Outline: Practice Login

    Given user lands on practice login page
    When  user enter "<pracusername>" and "<pracuserpwd>"
    Then  user lands on homepage
    Examples:
      |pracusername|pracuserpwd|
      |mngr253182  |YjaguhY    |








  
  @Login
  Feature: Login Feature
  Verify if user is able to Login in to Fraudnet UI
  
  Scenario Outline: Data driven login page
  Given user navigates to Login Page
  When user enters "<username>" and "<password>","<organisation>"
  Then user is successfully logged in to system
  Examples:
    |username|password|organisation|
    |testinvestigator@bcone.com|Enter@12345|bondorg|



    
    

    
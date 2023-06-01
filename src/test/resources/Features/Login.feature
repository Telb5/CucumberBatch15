Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application                //since we have hook, then we don't need "Given open browser"
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser                                             //since we have hook, then we don't need "And close"







#we call this cucumber expression == regular expression  (limited set of data)

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "ADMIN" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser







  @scenarioOutline
  #Parameterization/ Data Driven
  Scenario Outline: Login with Multiple credentials using Scenario Outline
    #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

    # Here browser will launch and close all the time whenever you wanna input data
     #to make below data align you can use---> ctrl+ alt+ l

    Examples:
      | username | password    |
      | Admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |






  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | admin    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |


  #hard Code
  #Config file
  #Cucumber Expression (regular expression) : [limited set of test data]
  #Scenario Outline :  [Parametrization], [DTT] [Browser will open and close number of times we have test data in Example tables]
  #Data Table



  #Page Object Model : an object repository [ it stores or holds all the webElements specific to a particular page]

#Feature: Searching the employee


  #@empSearch
  #Scenario: Search Employee by Id
   # Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
  #  #When user clicks on PIM option
   # When user enters valid employee id
#    And Clicks on search button
 #   And user see employee information is displayed


  #@empSearchJobTitle
#  Scenario: Search Employee by Job Title
 #   Given open the browser and launch HRMS application
  #  When user enters valid email and valid password
   # And click on login button
   # When user clicks on PIM option
   # When user select Job Title
    #And Clicks on search button
    #And user see employee information is displayed

  #I commented above code because it belongs to first example we worked on











Feature: Searching the employee

  #Background: This is used to define all the common steps that is available in multiple
  #scenarios in our feature file. One Condition is that it will work until the flow or sequence is not broken


#the rule is :    HOOKS[@BEFORE]->BAckground-->SCENARIO STEPS -->HOOKS[@AFTER]

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search Employee by ID
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid employee id
    And Clicks on search button
    And user see employee information is displayed
    #And Close the browser


  @smoke1
  Scenario: Search Employee by Job Title
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user select Job Title
    And Clicks on search button
    And user see employee information is displayed
    #And Close the browser


  #Background: This is used to define all the common steps that is available in multiple
  #             scenarios in our feature file. One Condition is that it will work until the flow or sequence is not broken
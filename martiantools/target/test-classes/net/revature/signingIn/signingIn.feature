#Author: Norman.Brumm@Revature.net
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Login for MartianTools

	Given a user is on any page of MartianTools 
	And is not signed in 

  Scenario: Logging into a user account with correct credentials
    When the user puts in a correct <username> 
    And the user inputs a correct <password>
    And clicks on the login button
    Then the user is redirected back to the current page
    And the sign in option is replaced by a menu to check their account
    
    | username | password  |
    | norman   | plainText |
    |||
    ||| 

  Scenario: Logging into a user account with the wrong credentials
    When the user puts in an incorrect <username> 
    And the user inputs an incorrect <password>
    And clicks on the login button
    Then the user is redirected back to the current page
    And the sign in option is still there but has some red text saying that the username/password was wrong
    
    | username | password      |
    | norman   | wrongPassword |
    |||
    ||| 

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
Feature: add an item to the shopping cart

	Given a user is on the category page of MartianTools 

  @tag1
  Scenario: user wants to add an item to their shopping cart
    Given User clicks on a <category>
    And user clicks on a <item>
    When user clicks on add to cart
    Then the number of items in the cart goes up by one
    And clicking on the view cart button takes you to the view cart page
    
    | category | item |
    |||
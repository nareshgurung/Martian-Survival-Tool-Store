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
@tag
Feature: checkout/purchase feature

  @tag1
  Scenario: user has items in their cart and wants to buy them
	  Given user has some item(s) in their shopping cart
    When user clicks on the checkout button
    Then user is re-directed to the checkout page to verify their order
    And once verified it allows the user to select a payment method
    And then allows them to select a shipping method
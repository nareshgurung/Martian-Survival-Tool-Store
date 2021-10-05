#Author: ars0148@gmail.com
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
Feature: Products pages for MartianTools

	Given a user is viewing a Product page for a category in the Main Content View
	And intiates a purchase

	Scenario: Selecting a purchase quantity
		When the user selects a purchase quantity
		Then the purchase quantity is displayed

	Scenario: Not selecting a purchase quantity
		When the user does not select a purchase quantity
		Then the default purchase quantity amount one is purchase quantity

	Scenario: user clicks add to cart button
		When the user clicks the add to cart button
		Then the view redirects to shopping cart 

	Scenario: user clicks buy now button
		When the user clicks the buy now button
		Then the view redirects to check out

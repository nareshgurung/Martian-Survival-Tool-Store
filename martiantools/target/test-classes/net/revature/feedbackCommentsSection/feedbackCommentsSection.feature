#Author: AlexSmith716
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

# Features:
# 	Feedback or comments section.
# User Stories:
# 	As a {user} I want to {be able to leave comments on items that I have purchased, and see others comments}
# 	As a {user} I want to {be able to ask questions about items}
Feature: Add a Feedback or comment

	Given a user clicks on the Give Feedback or Comment button

	Scenario: User submits a feedback/comment message
		Given user is authenticated
		When the user enters text in message textarea
		And the user clicks on the submit button
		Then the modal indicates successful submission
		And the modal displays a single OK button to user
		Then user clicks OK button
		And modal closes

	Scenario: User does not submit a feedback/comment message and text is in modal textarea
		Given user is authenticated
		When the user clicks the modal close button
		And text is in message textarea
		Then modal prompts confirm message to close modal
		Then user clicks OK to close modal button
		And modal closes

	Scenario: User does not submit a feedback/comment message and NO text is in modal textarea
		Given user is authenticated
		When the user clicks the modal close button
		Then modal closes

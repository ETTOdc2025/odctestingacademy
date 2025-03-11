#Author: your.email@your.domain.com
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
Feature: Broken Links

#  @tag1
#  Scenario: Broken Link Verifications
#    Given I am in page Broken Links
#    Then I verify the logo is displayed
#    Then I verify the text HTTP response code
#    Then I verify the text Broken Links"
#    Then I verify the text Home
#    Then I verify the text Name
#    Then I verify the text missing-page.html 
#    Then I verify the text Status
#    Then I verify the value QuatresCentsQuatres
#    Then I verify the int <value>
#         Examples:
#      |value |
#      |404   | 
      

@tag1
  Scenario Outline: Broken Link Verifications
    Given I am in page Broken Links
    Then I verify that the "<Text>" displayed
    Examples:
      | Text                   |
      | HTTP response code     |
      | Broken Links           |
      | Home                   |
      | Name                   |
      | missing-page.html      |
      | Status                 |

      
      
     




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
@tagregister
Feature: Register
  I want to use this template for my feature file

    
   @tagr
  Scenario: Sam is able to register successfully
    Given Sam is on Registration page
    When Sam enters "<email_id>","<password>", "<password>", "<Name>", "<Address>" and "<City>"
    And Sam clicks on Signup
    And Sam should be able to check "<signupstatus>"
    Then Sam should be navigated to booking 
     
  Examples: 
      | email_id                |password  | password   |  Name     | Address     | City        | signupstatus  | 
      | jsahani1134322@user.com     | user     |   user     | Jashwant  | Maharashtra | Navi Mumbai | RegisterPass |    


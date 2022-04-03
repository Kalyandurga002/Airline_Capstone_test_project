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
@tagBooking
Feature: Booking
  I want to use this template for test Flight Booking functionality
  

 @tagSelectFlight
      Scenario: Sam is able to select a flight
            Given Sam has login with "<username>" and "<password>"
            And Same has open home page
            When Sam selects "<Source>" as source and "<Destination>" as destination
            And Sam clicks on submit
            Then Sam is able to validate for flight id "<FlightNo>" with msg "<ExpResult>"
            
            
           Examples: 
           |  username |  password     | Source        | Destination     | FlightNo      |    ExpResult        |
            | user@user.com   |  user  | Bangalore     | Mumbai          | 5             |    Flight Present   |
            | user@user.com   |  user  | Bangalore     | Ahmedabad       | 10            |  Flight NOT Present     |
                   

Feature: Wordpress Login
  
  Scenario: Testing Login 
    Given User go to the Website
    When User click login button
    And User input username password and click login
		Then User can login to the Website
    

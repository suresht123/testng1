#Author: your.email@your.domain.com

Feature: facebbok signup

Background: 

Given user enter facebbok url

  Scenario: signup
   
    When user enter details
    And user signup
    And user go facebook home
    Then user signout
    
     Scenario: signup
  
    When user enter details by using oneD map
    |firstname|suresh|
    |surname|t|
    |emailid|suresh@gmail.com|
    |re emailid|suresh@gmail.com|
    |day|26|
    |month|May|
    |year|1984|
    And user signup
    And user go facebook home
    Then user signout
    
    Scenario Outline: signup
  
    When user enter details "<firstname>","<surname>","<emailid>","<re emailid>","<day>","<month>","<year>",
 
    And user signup
    And user go facebook home
    Then user signout
    
    Examples:
     |firstname|surname|emailid|re emailid|day|month|year|
     |suresh|t|suresh@gmail.com|suresh@gmail.com|26|May|1984|
     |devi|l|devi@gmail.com|devi@gmail.com|19|Jan|1992|
    
    
  
    
  

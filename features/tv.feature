#Author: your.email@your.domain.com

Feature: Tvpurchase

 Background:
    Given user login into flipkart

  Scenario: tv purchase
    When user search required tv
    And user select required  tv
    And user select payment method in UPI
    Then user got the confirmation 
    
    Scenario: tv purchase
    When user search required tv by using oneD list
    |REALMETV |SONYTV|SAMSUNGTV|REDMITV|LGTV|
    And  user select required  tv
    And user select payment method in UPI
    Then user got the confirmation
    
    Scenario: tv purchase
    When user search required tv by using oneD map
    |TV1|SONYTV|
    |TV2|REALMETV|
    |TV3|LGTV|
    And  user select required  tv
    And user select payment method in UPI
    Then user got the confirmation
    
       Scenario Outline: mobile purchase
    When user search required mobile "<TV>"
    And  user select required  tv
    And user select payment method in UPI
    Then user got the confirmation
    
    Examples:
     |TV|
     |REALMETV|
     |SAMSUNGTV|
     |LGTV|
  
    
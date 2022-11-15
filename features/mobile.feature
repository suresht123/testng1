#Author:janeshsuresh123@gmail.com
Feature: mobile 
  Background:
    Given user login into flipkart

  Scenario: mobile purchase
    When user search required mobile
    And  user select required  mobile
    And user select payment method in UPI
    Then user got the confirmation 
    
    Scenario: mobile purchase
    When user search required mobile by using oneD list
    |realme|VIVO|SAMSUNG mobiles|REDMI|IPHONE|
    And  user select required  mobile
    And user select payment method in UPI
    Then user got the confirmation
    
    Scenario: mobile purchase
    When user search required mobile by using oneD map
    |MOBILE1|VIVO|
    |MOBILE2|REALME|
    |MOBILE3|IPHONE|
    And  user select required  mobile
    And user select payment method in UPI
    Then user got the confirmation
    
    Scenario Outline: mobile purchase
    When user search required mobile "<MOBILE>"
    And  user select required  mobile
    And user select payment method in UPI
    Then user got the confirmation
    
    Examples:
     |MOBILE|
     |REALME|
     |IPHONE|
     |VIVO|
  


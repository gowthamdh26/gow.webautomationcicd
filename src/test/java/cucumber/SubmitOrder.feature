

@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

 Background:
Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Title of your scenario outline
    Given Logged in with username <name> and passord <password>
    When I add product <ProductName> to Cart
    And Checkout <ProductName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | name                    | password   | ProductName  |
      | gowthamdh1326@gmail.com |Gaviranga13@|ZARA COAT 3 |
      
      
   
    

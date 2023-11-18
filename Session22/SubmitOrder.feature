
@tag
Feature: Order placement from Ecommerce Web site
  Place an order as a registread user by using credit card
  
  Background:
  Given I landed to the Product Catalog page
  
  @tag2
  Scenario Outline: Positive Test Order placement
  Given Logged with username <name> and password <password>
  When I add product <productName> to the Cart
  And Checkout <productName> And submit the order
  Then "Thankyou for the order." is displayed on Confirmation page
  

 
    Examples: 
      | name        | password |productName    |status  |
      | test@as.co  |Test1234  |zara coat 3    |success |
      | test1@as.co |Test1234  |adidas original|success |
     

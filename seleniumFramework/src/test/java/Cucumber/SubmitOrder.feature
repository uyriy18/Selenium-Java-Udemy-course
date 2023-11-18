
@tag
Feature: Purchase the order from Ecommerce site
  Place an order as a registered user

  Background:
  Given User opened LandingPage
  @Regression
  Scenario: Place order Test
    Given User Logged in with username <userName> and password <password>
    When User added product <productName> to the Cart
    And User proceeds to the Cart
    And The added product <productName> is in the Cart
    And User submits the order
    Then "Thankyou for the order." message is displayed    
    Examples: 
      | userName   | password | productName |
      | test@as.co |Test1234  | zara coat 3 |


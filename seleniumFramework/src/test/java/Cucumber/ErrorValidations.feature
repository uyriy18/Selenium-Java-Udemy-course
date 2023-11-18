@tag
Feature: Error validation
  Incorrect login or password entering

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given User opened LandingPage
    When User Logged in with username <userName> and password <password>
    Then "Incorrect email or password." error message is displayed

    Examples: 
      | userName | password |
      | tt@as.co | Test1234 |

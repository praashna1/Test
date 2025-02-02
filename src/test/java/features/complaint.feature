
Feature: Submit a Complaint
@complaint
  Scenario: User submits a complaint after successful login
    Given user enters valid login details
    Given user is in complain selection
    When user fills in the complaint form
    Then user should successfully submit complain

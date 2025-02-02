Feature: Login form
  @adminLogin
  Scenario: admin is able to pass data in login form
    Given admin is in login page
    When admin enters email and password
    Then admin should be in dashboard

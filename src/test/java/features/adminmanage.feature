Feature: Login form
  @adminManage
  Scenario: admin is able to manage

    Given admin enter email and password
    Given admin is in dashboard
    When admin is in user management
    Then admin should see user data


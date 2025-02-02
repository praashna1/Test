Feature: Login form
  @adminComplain
  Scenario: admin is able to manage

    Given admin enter email and password and is in dashboard
    When admin is in complaint management board
    Then admin sees details


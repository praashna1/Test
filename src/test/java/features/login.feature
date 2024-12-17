Feature: Submit form

  Scenario Outline: user is able to pass data
    Given user enters <email> and <password>
    When user successfully passes data
    Then user should be redirected to homepage
    Examples:
      | email | password |
    |  test7668@gmail.com     |  123@Test        |

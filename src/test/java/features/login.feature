Feature: Login form
@login
  Scenario Outline: user is able to pass data in login form
    Given user enters <email> and <password>
    When user successfully passes data
    Then user should be redirected to homepage with flag <flag>
    Examples:Valid and Invalid email id.
      | email | password |flag|
    |  test7668@gmail.com     |  123@Test        |Y|
    |  test@gmail.com         |           12Test       |N|
Feature: Login form
@login
  Scenario Outline: user is able to pass data in login form
    Given user enters <email> and <password>
    When user successfully passes data
    Then user should be redirected to homepage with flag <flag>
    Examples:Valid and Invalid email id.
      | email | password |flag|
    |  ishabhatta41@gmail.com     |  Isha@1234        |Y|
    |  test@gmail.com         |           12Test       |N|
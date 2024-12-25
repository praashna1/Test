Feature: Signup
  @signup
  Scenario Outline: User can successfully sign up
    Given user enters <username>, <email>, <password>, <province>, <tole>, <ward>, <location>, <pContact>, <sContact>
    When user submits the sign-up form
    Then user should be in otp page with <flag> and <email>

    Examples:
      | username   | email           | password  | province  | tole   | ward | location | pContact   | sContact   | flag|
      | Prashna Ad | workplease4@gmail.com  | Pp@#12345  | Bagmati   | shanti | 3    | ktm      | 9802342567 | 9875231245 |  Y   |

#      | prashna12   | test@gmail.com   | Pp@1141     | bagmati  | ktm1     | 3    | shanti | 9802342567 | 9875231245 | N   |
#      | prashna    | test7668@gmail.com   | Prash@123     | bagmati  | ktm    | 3    | shanti | 9802342567 | 9875231245 | Y  |
#      | prashna    | test@gmail.com   | Pp@1     | bagmati  | ktm     | 3    | shanti | 9802342567 | 9875231221 | N   |
#      | prashna    | test@gmail.com   | Pp@1     | bagmati  | ktm      | hii   | shanti | 9802342567 | 9875231245 | N   |
#      | prashna    | test123@gmail.com   | Pp@1     | bagmati  | ktm1     | 3    | shanti | 9802342567 | 9875231245 | N   |
#      | prashna    | tes@gmail.com   | Pp@1     | bagmati11  | ktm     | 3    | shanti | 9802342567 | 9875231245 | N   |
#      | prashna    | te@gmail.com   | Pp@16578     | bagmati  | ktm     | 3    | shanti02 | 9802342567 | 9875231245 | N   |
#      | prashna    | tet@gmail.com   | Pp@1     | bagmati  | ktm     | 3    | shanti | 98023425 | 9875231245 | Y   |
#      | prashna    | tt@gmail.com   | Pp@1     | bagmati  | ktm     | 3    | shanti | 9802342567 | 9875231 | N   |
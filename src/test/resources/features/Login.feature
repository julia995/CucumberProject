Feature: Login scenarios

  @emptyUsername
  Scenario: User attempts to log in with an empty username field
    When user leaves username field empty and enters correct password
    And user clicks on login button
    Then error message "Username cannot be empty." is displayed

  @@emptyPassword
  Scenario: User attempts to login with empty password field
    When user leaves password field empty and enters correct username
    And user clicks on login button
    Then error message "Password is empty." is shown

  @incorrectCreds
  Scenario: User attempts to log in with incorrect login credentials
    When user enters incorrect username and correct password
    And user clicks on login button
    Then "Invalid credentials" error message is visible

  @correctCreds
  Scenario: User is able to log in after entering incorrect credentials
    When user enters incorrect username and correct password
    And user clicks on login button
    Then "Invalid credentials" error message is visible
    And user enters correct username and password
    And user clicks on login button
    Then user is able to see "welcome admin"


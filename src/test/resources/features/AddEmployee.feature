Feature: Adding Employee to HRMS

  Background:
    When user enters valid username and password
    And user clicks on login button
    When user clicks on PIM option
    And user clicks on Add Employee option

  @withoutID
  Scenario: Admin is able to add an employee without providing an employee ID
    And user enters firstname and lastname
    And user clicks on Save button
    Then employee added successfully

  @withID
  Scenario: Admin is able to add an employee by providing a unique employee ID
    And user enters firstname and lastname
    And user enters employee ID
    And user clicks on Save button
    Then employee with employee id is added successfully

  @noLastname
  Scenario: Error message is displayed, when admin leaves the Last Name field empty
    And user enters firstname and and leaves lastname field empty
    And user clicks on Save button
    Then error message should be displayed


  @noFirstName
  Scenario: Error message is shown when admin leaves the First Name field empty
    And user enters lastname and and leaves firstname field empty
    And user clicks on Save button
    Then error message should be displayed

  @missingName
  Scenario Outline: Error message when first name or last name is missing
    When user enters incomplete "<firstName>" "<lastName>"
    And user clicks on Save button
    Then error message "<errorMessage>" is shown on "<missingField>"
    Examples:
      | firstName | lastName | errorMessage |missingField|
      |           | Jones    | Required     |firstName   |
      | Kevin     |          | Required     |lastName    |

  @existingID
  Scenario: Error message is shown when adding employee with existing ID
    When user enters firstname and lastname
    And user enters existing employee ID "53950776"
    And user clicks on Save button
    Then error message "Failed To Save: Employee Id Exists" should be displayed





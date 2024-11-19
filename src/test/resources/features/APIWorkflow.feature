Feature: API workflow

  Background:
    Given a JWT bearer token is generated

  @api
  Scenario: create employee
    Given a request is prepared for creating the employee
    When a POST call is made to create the employee
    Then the status code for this request is 201
    Then the employee id "Employee.employee_id" is stored and values are validated

  @api
  Scenario: Get the created employee
    Given a request is prepared to get the created employee
    When a GET call is made to get the created employee
    Then the status for for get call is 200
    And the employee has same employee id "employee.employee_id" as global empid
    And the data coming from the get call should equal to the data used in POST call
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |asana        |lawrance    |ms             |Female    |1993-01-12  |permanent |QA manager   |
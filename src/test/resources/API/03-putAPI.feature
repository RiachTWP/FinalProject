Feature: Put API Automation

  @API
  Scenario: Test create new user normal
    Given go to The URL "Create Data"
    And hit api post create new user
    Then validation for status code is 200
    Then validation body post create new user
    And hit api update data
    Then validation for status code is 200
    Then validation body post update data

Feature: Post API Automation

  @API
  Scenario: Test create new user normal
    Given go to the URL "Create Data"
    And hit api post create new users
    Then validation for status code is equals 200
    Then validation response body post create new user
    Then validation responses json with JSONSchema "postCreteNewUser.json"
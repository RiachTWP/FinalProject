Feature: Delete API Automation

  @API
  Scenario: Test delete user normal
    Given go to url for "Create Data"
    And hit the api post create new users
    Then validation status for code is equals 200
    Then validation for response body post create new user
    And hit api delete new
    Then validation status for code is equals 200
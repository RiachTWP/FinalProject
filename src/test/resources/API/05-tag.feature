Feature: Tag API Automation

  @API
  Scenario: Get list users
    Given user go to The URL "Get Tag"
    Then hit api tag users
    Then validation status of code is equals 200
    And validation all response should be match with "getListTag.json"
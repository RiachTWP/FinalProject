@API
Feature:Get API Automation

  @Postive-Test
  Scenario: Get list users
    Given go to URL "Dummy API List"
    Then hit api get users
    Then validation status code is equals 200
    And validation response json with JSONSchema "getListUser.json"
    And the limit and the page should be set to their default values

  @Postive-Test
  Scenario: Get list users by id
    Given go to URL "Dummy API List by Id" with id "60d0fe4f5311236168a109ca"
    Then hit api get users
    Then validation status code is equals 200
    And validation response json with JSONSchema "getUserSingle.json"
    And validation the body contain important detail

  @Negative-Test
  Scenario: Get list users by wrong id
    Given go to URL "Dummy API List by Id" with id "dsfibwe3"
    Then hit api get users
    Then validation status code is equals 400
    And response body contain :
      | error | PARAMS_NOT_VALID |







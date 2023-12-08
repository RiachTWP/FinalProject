@Web
Feature: About Us

  @Postive-Test
  Scenario: view about us information
    Given user is on homepage
    When user click about us button
    And user can see video about information company's

  @Postive-Test
  Scenario: go to about us page and back to home page
    Given user is on homepage
    When user click about us button
    And user click close button
    And will direct go back to homepage

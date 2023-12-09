Feature: Log In

  @WEB
  Scenario: Login with valid email and password
    Given user is on homepage
    When user click button Log in
    And user login with username "sulaiman23"
    And user login with password "Sulaiman234"
    When user click login button
    Then user is on homepage

  @WEB
  Scenario: Login with invalid email and password
    Given user is on homepage
    When user click button Log in
    And user login with username "rudiv"
    And user login with password "rudiv23"
    When user click login button
    Then get message "User does not exist."

  @WEB
  Scenario: Login with valid email and invalid password
    Given user is on homepage
    When user click button Log in
    And user login with username "sulaiman23"
    And user login with password "rudiv23"
    When user click login button
    Then get message "Wrong password."

  @WEB
  Scenario: Login with valid email and blank password
    Given user is on homepage
    When user click button Log in
    And user login with username "sulaiman23"
    When user click login button
    Then get message "Please fill out Username and Password."

  @WEB
  Scenario: Login with valid email and password
    Given user is on homepage
    When user click button Log in
    Then click close button
    And will direct go back to homepage

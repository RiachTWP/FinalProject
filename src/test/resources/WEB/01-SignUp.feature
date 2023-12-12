@Web
Feature: SignUp


  @Positive-Test
  Scenario: SignUp with valid data
    Given user is on homepage
    When user click button Sign Up
    Then user input username with "febri20"
    Then user input password with "febri234"
    And user click SingUp button
    And get message "Sign up successful."
    And will direct go back to homepage

  @Positive-Test
  Scenario: SignUp with valid data already exist
    Given user is on homepage
    When user click button Sign Up
    Then user input username with "sulaiman23"
    Then user input password with "Sulaiman234"
    And user click SingUp button
    And get message "This user already exist."
    And will direct go back to homepage


  @Negative-Test
  Scenario: user don't fill the password
    Given user is on homepage
    When user click button Sign Up
    Then user input username with "sulaiman231"
    And user click SingUp button
    And get message "Please fill out Username and Password."
    And will direct go back to homepage

  @Negative-Test
  Scenario: user don't fill the username
    Given user is on homepage
    When user click button Sign Up
    Then user input password with "Sulaiman234"
    And user click SingUp button
    And get message "Please fill out Username and Password."
    And will direct go back to homepage


  @Positive-Test
  Scenario: close Sign Up menu
    Given user is on homepage
    When user click button Sign Up
    Then clik close Sign Up button
    And will direct go back to homepage

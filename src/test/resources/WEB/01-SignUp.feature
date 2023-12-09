Feature: SignUp

  @WEB
  Scenario: SignUp with valid data
    Given user is on homepage
    When user click button Sign Up
    Then user input username with "sulaiman23"
    Then user input password with "Sulaiman234"
    And user clik SingUp button
    And get message "Sign up successful."
    And will direct go back to homepage


  @WEB
  Scenario: user don't fill the password
    Given user is on homepage
    When user click button Sign Up
    Then user input username with "sulaiman231"
    And user clik SingUp button
    And get message "Please fill out Username and Password."
    And will direct go back to homepage

  @WEB
  Scenario: user don't fill the username
    Given user is on homepage
    When user click button Sign Up
    Then user input password with "Sulaiman234"
    And user clik SingUp button
    And get message "Please fill out Username and Password."
    And will direct go back to homepage


  @WEB
  Scenario: close Sign Up menu
    Given user is on homepage
    When user click button Sign Up
    Then clik close Sign Up button
    And will direct go back to homepage

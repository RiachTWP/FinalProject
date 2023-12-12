Feature: Contact

  @WEB
  Scenario: sumbit the contact with valid data
    Given user is on homepage
    When user click Contact
    Then user input Contact Email "sulaiman234@gmail.com"
    Then user input Contact Name "sulaiman"
    And user input Message "Sony xperia z5 ready stock?"
    And user click Send Message
    Then get message "Thanks for the message!!"

  @WEB
  #Failed because get message "Thanks for the message!!"
  Scenario: send message without fill Contact Email, Contact Name, and Message
    Given user is on homepage
    When user click Contact
    And user click Send Message
    Then get message "Thanks for the message!!"

  @WEB
  #Failed because get message "Thanks for the message!!"
  Scenario: send message without fill Contact Email
    Given user is on homepage
    When user click Contact
    Then user input Contact Name "sulaiman"
    And user input Message "Sony xperia z5 ready stock?"
    And user click Send Message
    Then get message "Thanks for the message!!"

  @WEB
  #Failed because get message "Thanks for the message!!"
  Scenario: send message without fill Contact Name
    Given user is on homepage
    When user click Contact
    Then user input Contact Email "sulaiman234@gmail.com"
    And user input Message "Sony xperia z5 ready stock?"
    And user click Send Message
    Then get message "Thanks for the message!!"

  @WEB
  #Failed because get message "Thanks for the message!!"
  Scenario: send message without fill Contact Email valid
    Given user is on homepage
    When user click Contact
    Then user input Contact Email "sulaiman234"
    Then user input Contact Name "sulaiman"
    And user input Message "Sony xperia z5 ready stock?"
    And user click Send Message
    Then get message "Thanks for the message!!"


  @WEB
  Scenario: sumbit the contact with valid data
    Given user is on homepage
    When user click Contact
    And user click close
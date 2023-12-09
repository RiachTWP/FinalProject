Feature: Purchase

  @WEB
  Scenario: Purchase one product with valid data
    Given user is on homepage
    When user already login
    Then user click add to cart button for these product:
      | Sony xperia z5 |
    Then user go to the cart page
    And user click Place Order button
    And user input Name "Sulaiman"
    And user input Country "Indonesia"
    And user input City "Jakarta"
    And user input Credit card "33333"
    And user input Month "January"
    And user input Year "2023"
    Then user click Purchase button
    Then transaction sucessfull and get pop up message "Thank you for your purchase!"

  @WEB
  Scenario: Purchase one product with blank data
    Given user is on homepage
    When user already login
    Then user click add to cart button for these product:
      | Sony xperia z5 |
    Then user go to the cart page
    And user click Place Order button
    Then user click Purchase button
    Then get popUpMessage "Please fill out Name and Creditcard."

  @WEB
    #Failed without product can purchase
  Scenario: dont add to cart product
    Given user is on homepage
    When user already login
    Then user go to the cart page
    And user click Place Order button
    And user input Name "Sulaiman"
    And user input Country "Indonesia"
    And user input City "Jakarta"
    And user input Credit card "33333"
    And user input Month "January"
    And user input Year "2023"
    Then user click Purchase button
    Then get popUpMessage "please add to cart product first."

  @WEB
  Scenario: Purchase one product without login
    Given user is on homepage
    Then user click add to cart button for these product:
      | Sony xperia z5 |
    Then user go to the cart page
    And user click Place Order button
    And user input Name "Sulaiman"
    And user input Country "Indonesia"
    And user input City "Jakarta"
    And user input Credit card "33333"
    And user input Month "January"
    And user input Year "2023"
    Then user click Purchase button
    Then transaction sucessfull and get pop up message "Thank you for your purchase!"

  @WEB
  Scenario: user open place order page and back to the homepage
    Given user is on homepage
    Then user go to the cart page
    And user click Place Order button
    And user click close button in place place order page
    And user click Home button
    And will direct go back to homepage
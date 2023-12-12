Feature: Cart

  @WEB
  Scenario: user add to cart 1 product
    Given user is on homepage
    Then user click add to cart button for these product:
      | Sony xperia z5 |
    Then user go to the cart page
    And the cart page should contain:
      | Sony xperia z5 |
    And calculated total price is accurate

  @WEB
  Scenario: user add to cart 2 product with sampe product
    Given user is on homepage
    Then user click add to cart button 2 times for these product:
      | Sony xperia z5 |
    Then user go to the cart page
    And the cart's item count for these product should be 2
      | Sony xperia z5 |
    And calculated total price is accurate

  @WEB
  Scenario: user add to cart 2 product with different product
    Given user is on homepage
    Then user click add to cart button for these product:
      | Sony xperia z5 |
      | Samsung galaxy s7 |
    Then user go to the cart page
    And the cart page should contain:
      | Sony xperia z5 |
      | Samsung galaxy s7 |
    And calculated total price is accurate

  @WEB
  Scenario: user delete product in cart page
    Given user is on homepage
    Then user click add to cart button for these product:
      | Samsung galaxy s7 |
    Then user go to the cart page
    Then user click delete button for product:
      | Samsung galaxy s7 |

  @WEB
  Scenario: user add all products
    Given user is on homepage
    When user click add to cart button for all product
    Then user go to the cart page
    And the cart should contain all product
    And calculated total price is accurate

  @WEB
  Scenario: user go to cart page and back to home page
    Given user is on homepage
    Then user go to the cart page
    And user click Home button
    And will direct go back to homepage
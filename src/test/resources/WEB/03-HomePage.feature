@Web
Feature: Home

  @Positive-Test
# Step failed because the product "samsung galaxy s6 " dont display if go back to the first Page
  Scenario: show all product contain Next and Previous button
    Given user is on homepage
    Then the all product in first page displayed
    When user click Next button
    Then the all product in second page displayed
    When user click Previous button
    Then user will be directed back to the all product in first page displayed

  @Positive-Test
  Scenario: user show all product Phones
    Given user is on homepage
    Then user click Phones category
    And show the all product Phones

  @Positive-Test
  Scenario: user show all product Laptops
    Given user is on homepage
    Then user click Laptops category
    And show the all product Laptops

  @Positive-Test
  Scenario: user show all product Monitors
    Given user is on homepage
    Then user click Monitors category
    And show the all product Monitors

  @Positive-Test
  Scenario: validate the product between home page and product detail page
    Given user is on homepage
    And click the product in home page and validate the product in product detail page
Feature: Saucedemo Test Feature

  Scenario: Successful Login
    Given User is on the SauceDemo login page
    When User enters valid username and password
    And User clicks the login button
    Then User is logged in successfully

  Scenario: Add Product to Cart
    Given User is on the SauceDemo login page
    When User enters valid username and password
    And User clicks the login button
    And User adds a product to the cart
    Then User's cart should contain the added product

  Scenario: Remove Product from Cart
    Given User is on the SauceDemo login page
    When User enters valid username and password
    And User clicks the login button
    And User adds a product to the cart
    Then User's cart should contain the added product
    When User removes the product from the cart
    Then User's cart should be empty

  Scenario: Checkout
    Given User is on the SauceDemo login page
    When User enters valid username and password
    And User clicks the login button
    And User adds a product to the cart
    Then User's cart should contain the added product
    When User proceeds to checkout
    Then User reaches the checkout page

  Scenario: Failed Login (negative case)
    Given User is on the SauceDemo login page
    When User enters locked out username and password
    And User clicks the login button
    Then User should see an error message

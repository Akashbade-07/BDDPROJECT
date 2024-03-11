Feature: ShopNow Checkout Process

  Scenario Outline: User navigates through the checkout process without placing an order

    Given the user opens the flipkart "<url>" website
    When verify homepage
    When the user searches for a device "<device>" and verify device details
    And adds the device to the cart
    And proceeds to checkout page and verify checkout page
    And completes the checkout process without placing the order
    Then verify that the user has navigated through the checkout process successfully
    
    Examples:
    |url|device|
    |https://www.flipkart.com|mobile|
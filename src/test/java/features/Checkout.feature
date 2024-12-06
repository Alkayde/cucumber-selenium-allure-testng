Feature: Place the order for Products

  @PlaceOrder
  Scenario Outline: Checkout page displays products added by user
    Given User is on GreenKart Landing Page
    When User searched with shortname <Name> and extracted actual name of product
    And User added the product to cart 2 times
    And User clicked on cart icon
    And User proceeded to checkout
    Then User gets to Checkout Page
    And Product added to cart are shown on Checkout Page
    And Product quantity on the Checkout Page is 3
    And User is able to place the order
    And User is able to apply promocode

    Examples:
      | Name     |
      | Mushroom |
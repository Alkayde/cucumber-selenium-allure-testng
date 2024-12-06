Feature: Search and Place the order for Products

  @OffersPage
  Scenario Outline: Search Experience for product search in both Home and Offers pages
    Given User is on GreenKart Landing Page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And validate product name in offers page matches with Landing Page

    Examples:
      | Name |
      | Beet |


  @LandingPage
  Scenario Outline: Cart Preview displays product in Home page
    Given User is on GreenKart Landing Page
    When User searched with shortname <Name> and extracted actual name of product
    And User added the product to cart 2 times
    And User clicked on cart icon
    Then Cart preview is shown
    And Cart preview contains the product

    Examples:
      | Name     |
      | Carrot   |
      | Mushroom |
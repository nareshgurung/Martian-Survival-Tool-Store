
@Inventory
Feature: Inventory Interactions
  How a user can interact with the Martian Store inventory from the home page

  @Initial-nav
  Scenario: Home Page is loaded with inventory
    Given user opens home page
    And a list of products is displayed
    And user clicks on a product
    Then user is redirected to said product page
    
    Scenario: User wants to display a specific category of products
    Given user is on the home page
    And clicks a link with category name
    Then user is redirected to said category page
    
    Scenario: user adds a product to their shopping cart
    Given: guest is currently on a product page
    And clicks 'add to cart' button
    And inventory quantity for product is reduced by one unit
    Then user does not get automatically redirected to cart, stays on current page
    
    Scenario: user tries to purchase a sold out product
    Given: product quantity is 0
    When user tries to add to cart
    And user receives a message indicating unavailable
    Then user is redirected to products category page
    
   @Logged-in
    Scenario: user adds product to wishlist
    Given: user is logged in 
    When user clicks 'add to wishlist' button
    And inventory quantities remained unchanged
    Then display confirmation to user that product was added 

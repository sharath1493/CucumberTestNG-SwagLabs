@Inventory
Feature: Inventory Page UI Functionality

  Background: Member Logged in as Stangadard User
    Given Standard User logged into SwagLabs

  @CartButtonDisplayed @InventoryTest1
  Scenario: Verify the CartButton is displayed on Inventory Page
    Given User is on Inventory Page
    Then Verify Cart button is dispalyed on Inventory Page

  @InventoryHeaderTitleDisplayed @InventoryTest2
  Scenario: Verify the Page Header title is displayed on Inventory Page
    Given User is on Inventory Page
    Then Verify Page Header title displayed as "PRODUCTS"

  @DefaultProductsOrder @InventoryTest3
  Scenario: Verify the Default Products Order on Inventory Page
    Given User is on Inventory Page
    Then Verify the default order of the product catalog is "Name (A to Z)"
    And Verify the default product order as below
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And No. of products displayed on inventory page is 6

  @ProductsOrderSortByZtoA @InventoryTest4
  Scenario: Verify the Products Order Sorted By Name Z to A on Inventory Page
    Given User is on Inventory Page
    And Verify the default order of the product catalog is "Name (A to Z)"
    When User changes the order of product catalog to "Name (Z to A)"
    Then Verify the default product order as below
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Onesie                 |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |
    And No. of products displayed on inventory page is 6

  @ProductsOrderSortByNameAtoZ @InventoryTest5
  Scenario: Verify the Products Order Sorted By Name A to Z on Inventory Page
    Given User is on Inventory Page
    And Verify the default order of the product catalog is "Name (A to Z)"
    And User changes the order of product catalog to "Name (Z to A)"
    Then User changes the order of product catalog to "Name (A to Z)"
    And Verify the default product order as below
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
    And No. of products displayed on inventory page is 6

  @ProductsOrderSortByPriceLowtoHigh @InventoryTest6
  Scenario: Verify the Products Order Sorted By Price Low to High on Inventory Page
    Given User is on Inventory Page
    And Verify the default order of the product catalog is "Name (A to Z)"
    Then User changes the order of product catalog to "Price (low to high)"
    And Verify the default product order as below
      | Sauce Labs Onesie                 |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Backpack               |
      | Sauce Labs Fleece Jacket          |
    And No. of products displayed on inventory page is 6

  @ProductsOrderSortByPriceHightoLow @InventoryTest7
  Scenario: Verify the Products Order Sorted By Price High to Low on Inventory Page
    Given User is on Inventory Page
    And Verify the default order of the product catalog is "Name (A to Z)"
    Then User changes the order of product catalog to "Price (high to low)"
    And Verify the default product order as below
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Backpack               |
      | Sauce Labs Bolt T-Shirt           |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Bike Light             |
      | Sauce Labs Onesie                 |
    And No. of products displayed on inventory page is 6

  @ProductPriceDescriptionAddtoCartButtonCheck @InventoryTest8
  Scenario: Verify the Products and associated Prices displayed are correct
    Given User is on Inventory Page
    And Verify the default order of the product catalog is "Name (A to Z)"
    Then Verify the ProductName, Descritption, Price as below
      | ProductName                       | Descritption                                                                                                                                                           | Price  |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | $29.99 |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | $9.99  |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99 |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99 |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | $15.99 |
    And No. of Add to Cart buttons displayed are 6

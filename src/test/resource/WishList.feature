Feature:
  As an enduser
  I want to add product to wishlist
  So that I can see selected product in wishlist

  Background:

  Scenario Outline: add product to wishlist

	Given I am on home page
	When I tap on menu
	And I search for a "<product>"
	And I select any product
	And I Add Product to my wishlist
	And I tap on menu
	And I tap on my wishlist
	Then I see selected product is in my wishlist
	Examples:
	  | product |
	  | green   |


  Scenario Outline:Change product size from edit wishlist
	Given I am on home page
	When I tap on menu
	And I search for a "<product>"
	And I select any product
	And I Add Product to my wishlist
	And I tap on menu
	And I tap on my wishlist
	And I edit size
	Then I see product size is edited in my wishlist

	Examples:
	  | product |
	  | Red     |

  Scenario Outline: Delete product from edit wishlist
	Given I am on home page
	When I tap on menu
	And I search for a "<product>"
	And I select any product
	And I Add Product to my wishlist
	And I click on back button
	And I select another product
	And I Add Product to my wishlist
	And I tap on menu
	And I tap on my wishlist
	And I tap on edit to delete product
	Then I see only one product is displayed


	Examples:
	  | product |
	  | Blue    |

  Scenario Outline: Clear all products in Wishlist
	Given I am on home page
	When I tap on menu
	And I search for a "<product>"
	And I select any product
	And I Add Product to my wishlist
	And I click on back button
	And I select another product
	And I Add Product to my wishlist
	And I tap on menu
	And I tap on my wishlist
	And I tap on edit to delete all products
	Then I see wishlist is empty

	Examples:
	  | product |
	  | orange  |

  @trail1

  Scenario Outline: Add to bag from wishlist
	Given I am on home page
	When I tap on menu
	And I search for a "<product>"
	And I select any product
	And I Add Product to my wishlist
	And I tap on menu
	And I tap on my wishlist
	And I add product to bag from wishlist
	And I go to basket
	Then wishlist count is zero

	Examples:
	  | product |
	  | blue    |



  #Scenario : Add same product to wishlist

  #Scenario: product should not delete from edit wishlist

  #Scenario: Product should not be added if same product is in basket







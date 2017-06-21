Feature: BAG
  As an enduser
  I want to add product to basket
  So that I can see selected product in basket


  Scenario Outline: add product to bag

	Given I am on home page
	When I tap on menu
	And I search for a "<product>"
	And I select any product
	And I add product to bag
	And I go to basket
	Then I see selected product in bag
	Examples:
	  | product |
	  | green   |
Feature: Add product functionality 
 
 
 @First
 Scenario: Add one quantity from store
 Given I'm on the store page
 When I add a "Blue Shoes" to the cart
 Then I see 1 "Blue Shoes" in the cart

  @Second
 Scenario Outline: Add one quantity from store
 Given I'm on the store page
 When I add a "<name>" to the cart
 Then I see 1 "<name>" in the cart
 
 Examples:
 | name| 
 |Anchor Bracelet|
 |Basic Blue Jeans|
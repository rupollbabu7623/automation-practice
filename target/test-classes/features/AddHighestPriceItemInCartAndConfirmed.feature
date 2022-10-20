@AddHighestIem
Feature: Confirm the highest priced listed in dresses page added to cart

  Scenario: To add the highest price item from dresses page to cart without using sort by option
    Given user navigates to automation practice page
    When User selects the dresses menu on home page
    And User selects the highest price item on displayed dresses page, adds to cart
    Then User receives added successfully pop-up window message Product successfully added to your shopping cart


##Unhappy path Scenario
# Scenario: To confirm the selected item is not highest priced on dresses page
#   Given user navigates to automation practice page
#   When User selects the dresses menu on home page
#   And User selected item is not the highest price displayed on dresses page, adds to cart
#   Then User receives added successfully pop-up window
#
#Unhappy path Scenario
# Scenario: To confirm the selected item is not from the dresses menu
#   Given user navigates to automation practice page
#   When User selects the T-Shirt or other menu than dresses menu
#   And User selects the highest price item on displayed results, adds to cart
#   Then User receives added successfully pop-up window
#
# Unhappy path Scenario
# Scenario: To confirm the selected item is not added to the cart
#   Given user navigates to automation practice page
#   When User selects the dresses menu on home page
#   And User selected item is not the highest price displayed on dresses page
#   Then User continues to shop without adding or verifying the cart





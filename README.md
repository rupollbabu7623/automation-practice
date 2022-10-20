  **Automation Practice Test Automation framework for UI testing**

## cucumber-java-junit
This project consist of happy ,Negative Scenarios

### Usage
You can run the tests by either executing mvn test or from run option of your IDE
You can set the values in Config.properties before running

***

#### Test  Parameters can be passed for Maven
browser = "firefox" || "chrome" || "ie" 

desktop:
mvn test -Dend_point=desktop -Dbrowser=chrome -Denv=test

endpoint = "desktop"

Browser size is set according to the Platform chosen and the values are taken from Config.properties


**Example Maven Commands:**

**For running Regression tests on Desktop-Chrome:**
mvn test -Dend_point=desktop -Dbrowser=chrome -Denv=test

**Cucumber Report:**

target/generated-reports/Test /index.html

**Prerequisites**:
Java jdk-1.8 or higher
Apache Maven 3 or higher
Please refer for any help in Maven.

**Environment:**
Test
 properties file to resources/config.properties

**Execution:**
Clone the repository.
Open command prompt and go to project.
To run on local environment use command
mvn test -Dend_point=desktop -Dbrowser=chrome -Denv=test

**Reporting:**
The framework produce index.html report. 

Scenarios covered 

@AddHighestIem
Feature: Confirm the highest priced listed in dresses page added to cart

Scenario: To add the highest price item from dresses page to cart without using sort by option
Given user navigates to automation practice page
When User selects the Dresses menu on home page
And User selects the highest price item on displayed dresses page, adds to cart
Then User receives added successfully pop-up window message There is 1 item in your cart.


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




package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pageobjects.HomePage;

public class HomePageStepDef {
    public HomePage homePage = Hooks.homePage;
    public Logger logger = Logger.getLogger(HomePageStepDef.class);

    @Given("user navigates to automation practice page")
    public void userNavigatesToAutomationPracticePage() {
        try {
            homePage.navigateToHomePage();
            logger.info("Navigated to homepage");
        } catch (Exception e) {
            logger.error("Navigation to homepage failed: " + e);
            Assert.fail("ERROR: Navigation to homepage failed: " + e);
        }
    }

    @When("User selects the dresses menu on home page")
    public void userSelectsTheDressesMenuOnHomePage() throws InterruptedException {
        homePage.dressesMenu();
        logger.info("User clicked on Dresses Menu");
    }

}

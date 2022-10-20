package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.apache.log4j.Logger;
import pageobjects.DressesPage;

import static stepdefinitions.BasePage.driver;

public class DressPageStepDef {
  public DressesPage dressesPage = Hooks.dressesPage;
  public Logger logger = Logger.getLogger(DressPageStepDef.class);

  @And("User selects the highest price item on displayed dresses page, adds to cart")
  public void userSelectsTheHighestPriceItemOnDisplayedDressesPageAddsToCart()
      throws InterruptedException {
    dressesPage.getHighestPriceFromTheListOfAllPriceValue();
  }

  @Then("User receives added successfully pop-up window message (.*)")
  public void userReceivesAddedSuccessfullyPopUpWindow(String message) throws InterruptedException {
    String successMessage = dressesPage.getSuccessMessage(driver);
    assertThat(successMessage,is(message));
      }

  }

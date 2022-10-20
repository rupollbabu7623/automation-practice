package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.BasePage;
import stepdefinitions.Hooks;

public class HomePage extends BasePage {

  public Logger logger = Logger.getLogger(HomePage.class);

  // Home Page- dress Menu locator
  @FindBy(xpath = "(//a[@title='Dresses'])[2]")
  protected WebElement dressesMenuLocator;

  public HomePage(RemoteWebDriver driver) {
    BasePage.driver = driver;
    PageFactory.initElements(driver, this);
  }

  // Navigate to URL
  public void navigateToHomePage() {
    driver.get(Hooks.readConfig("BASE_URL"));
  }

  //Click on Dresses Menu
  public void dressesMenu() throws InterruptedException {
    BasePage.elementToBeClickable(dressesMenuLocator);
    BasePage.highLighterMethod(driver, dressesMenuLocator);
    dressesMenuLocator.click();
  }
}

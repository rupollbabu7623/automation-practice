package stepdefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

  public static WebDriver driver;
  public static WebDriverWait wait;

  public BasePage() {}

  public BasePage(WebDriver driver) {
    BasePage.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public static void elementToBeClickable(WebElement webElement) {
    wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }

  public static void waitForWebElement() throws InterruptedException {
    Thread.sleep(5000);
  }

  // Method is for HighLight the element before performing any Actions
  public static void highLighterMethod(WebDriver driver, WebElement elementToHighlight)
      throws InterruptedException {
    String originalStyle = elementToHighlight.getAttribute("style");

    JavascriptExecutor js = (JavascriptExecutor) driver;

    for (int i = 0; i < 2; i++) {
      js.executeScript(
          "arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
          elementToHighlight);
      Thread.sleep(100);
      js.executeScript(
          "arguments[0].setAttribute('style', '" + originalStyle + "');", elementToHighlight);
      Thread.sleep(100);
    }
  }

 }

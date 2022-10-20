package pageobjects;

import io.cucumber.java.en.And;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DressesPage extends BasePage {
  public Logger logger = Logger.getLogger(DressesPage.class);

  // List of Price values in dresses
  @FindBy(xpath = "//*[@class='right-block']//div[1]/span[@class='price product-price']")
  protected List<WebElement> priceElements;

  // Successful banner
  @FindBy(css = "[class='icon-ok']")
  protected WebElement dressesMenuLocator;

  public DressesPage(RemoteWebDriver driver) {
    BasePage.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void getHighestPriceFromTheListOfAllPriceValue() throws InterruptedException {
    List<WebElement> prices = driver.findElements(By.xpath("//*[@class='right-block']//div[1]/span[@class='price product-price']"));

    Map<WebElement, Integer> map = new HashMap<WebElement, Integer>();
    for (int i = 0; i < prices.size(); i++) {
      if (prices.get(i).getText() != "") {
        map.put(prices.get(i), Integer.parseInt(prices.get(i).getText().replaceAll("[^0-9]", "")));
      }
    }
    for (Entry m : map.entrySet()) {
      logger.info(m.getKey() + " " + m.getValue());
    }
    List<Entry<WebElement, Integer>> es =
        new ArrayList<Map.Entry<WebElement, Integer>>(map.entrySet());

    es.sort(Entry.comparingByValue());

    for (Entry m : es) {
      logger.info(m.getKey() + " " + m.getValue());
    }
    es.get(es.size() - 1).getKey().click();
  }

  public String getSuccessMessage(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")));
    wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")));
    return driver
        .findElement(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2"))
        .getText();
  }
}

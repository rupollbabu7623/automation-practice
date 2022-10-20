package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import stepdefinitions.BasePage;
import stepdefinitions.Hooks;

public class Driver extends BasePage {

  private static final Logger logger = Logger.getLogger(Driver.class);

  private static final String browser = Hooks.setValue("browser");

  public Driver() {}

  public static RemoteWebDriver getDriver() {
    try {
      setEnvironmentVariables();
      switch (browser.toLowerCase()) {
        case "firefox":
          return new FirefoxDriver(firefoxOptions());
        case "ie":
          return new InternetExplorerDriver(ieOptions());
        default:
          return new ChromeDriver(chromeOptions());
      }
    } catch (Throwable err) {
      logger.fatal("Driver is not initialized" + ": " + err);
      Assert.fail("ERROR : " + "Driver is not initialized" + err);
    }
    return null;
  }

  private static void setEnvironmentVariables() {
    String endpoint = new Hooks().endpoint.toLowerCase().trim();
    System.setProperty("BrowserWidth", Hooks.readConfig(endpoint + "_browser_width"));
    System.setProperty("BrowserHeight", Hooks.readConfig(endpoint + "_browser_height"));
  }

  private static FirefoxOptions firefoxOptions() {
    WebDriverManager.firefoxdriver().setup();
    FirefoxOptions ffOptions = new FirefoxOptions();
    ffOptions.setCapability("marionette", true);
    ffOptions.addArguments("--width=" + Integer.parseInt(System.getProperty("BrowserWidth")));
    ffOptions.addArguments("--height=" + Integer.parseInt(System.getProperty("BrowserHeight")));
    return ffOptions;
  }

  private static ChromeOptions chromeOptions() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments(
        "window-size="
            + Integer.parseInt(System.getProperty("BrowserWidth"))
            + ","
            + Integer.parseInt(System.getProperty("BrowserHeight")));
    return chromeOptions;
  }

  private static InternetExplorerOptions ieOptions() {
    WebDriverManager.iedriver().setup();
    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
    ieOptions.ignoreZoomSettings();
    ieOptions.requireWindowFocus();
    return ieOptions;
  }
}

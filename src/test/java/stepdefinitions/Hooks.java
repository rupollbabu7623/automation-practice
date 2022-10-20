package stepdefinitions;

import configuration.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import pageobjects.DressesPage;
import pageobjects.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

  private RemoteWebDriver webDriver;
  public final String endpoint = setValue("end_point");

  public static BasePage basePage;
  public static HomePage homePage;
  public static DressesPage dressesPage;

  private final Logger logger = Logger.getLogger(Hooks.class);

  @Before
  public void setUp() {
    try {
      webDriver = Driver.getDriver();
      logger.info("Driver is initialized");
      webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      initPages();
      logger.info("App is initialized");
    } catch (Throwable err) {
      logger.fatal("App is not initialized" + ": " + err);
      Assert.fail("ERROR : " + "App is not initialized " + err.getMessage());
    }
  }

  @After
  public void tearDown(Scenario scenario) {
    try {
      if (scenario.isFailed()) getScreenshot(scenario);
      webDriver.quit();
      System.gc();
      logger.info("Driver Quit");
      LogManager.shutdown();
    } catch (Throwable err) {
      logger.fatal("Cannot quit from driver" + ": " + err);
      Assert.fail("ERROR : " + "Cannot quit from driver" + err);
    }
  }

  private void initPages() {
    try {
      basePage = new BasePage(webDriver);
      homePage = new HomePage(webDriver);
      dressesPage = new DressesPage(webDriver);
      BasicConfigurator.configure();
      logger.setAdditivity(false);
      logger.info("Pages are initialized");
    } catch (Throwable err) {
      logger.fatal("Pages are not initialized" + ": " + err);
      Assert.fail("ERROR : " + "Pages are not initialized" + err);
    }
  }

  private void getScreenshot(Scenario scenario) {
    try {
      File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
      String scenarioName = scenario.getName().replace(" ", "");
      FileUtils.copyFile(
          scrFile,
          new File(
              "target/screenshot/"
                  + System.getProperty("env")
                  + "/"
                  + scenarioName
                  + java.time.LocalDateTime.now()
                  + ".png"));
      byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
      scenario.embed(screenshot, "image/png");
    } catch (Throwable err) {
      logger.fatal("Failed to generate screenshot: " + err);
      Assert.fail("ERROR : " + "Failed to generate screenshot: " + err);
    }
  }

  public static String readConfig(String config) {
    Properties prop = new Properties();
    try {
      prop.load(new FileInputStream("src/test/resources/Config.properties"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return prop.getProperty(config).trim();
  }

  public static String setValue(String property) {
    return System.getProperty(property) == null
        ? readConfig(property)
        : System.getProperty(property);
  }
}

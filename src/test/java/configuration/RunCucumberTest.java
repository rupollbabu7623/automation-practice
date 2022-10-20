package configuration;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"stepdefinitions"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    features = {"src/test/resources/features"},
    monochrome = true)
public class RunCucumberTest {}

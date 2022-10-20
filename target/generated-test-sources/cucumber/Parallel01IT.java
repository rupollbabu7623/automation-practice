import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/Kittu/Desktop/Project/automation-test-practice/src/test/resources/features/AddHighestPriceItemInCartAndConfirmed.feature"},
        plugin = {"json:C:/Users/Kittu/Desktop/Project/automation-test-practice/target/cucumber-parallel/1.json"},
        monochrome = false,
        tags = {},
        glue = {"stepdefinitions"})
public class Parallel01IT {
}

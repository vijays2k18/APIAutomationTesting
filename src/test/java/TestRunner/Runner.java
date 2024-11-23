package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/feature/placeorderapi.feature", // Correct path to feature files
    glue = "Stepdefinition", // Correct package name for step definitions"
    plugin = {
        "pretty", 
        "html:target/cucumber-reports/cucumber.html", 
        "json:target/cucumber-reports/cucumber.json" 
    },
    monochrome = true // Better console readability
)
public class Runner extends AbstractTestNGCucumberTests {
    // Ensure no syntax issues here
}

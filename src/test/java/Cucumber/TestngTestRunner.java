package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Cucumber",
        glue = "Framework.stepsDefination",
        monochrome = true,
        plugin = {"pretty"}
)


public class TestngTestRunner extends AbstractTestNGCucumberTests {
}

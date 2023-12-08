package com.riachs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.riachs"},
        features = {"src/test/resources/API"},
        plugin = {"pretty",
                "html:reports/test-report-Api.html"},
        monochrome = true
)
public class cucumberApiTest {
}

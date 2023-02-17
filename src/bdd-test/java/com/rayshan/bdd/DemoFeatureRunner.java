package com.rayshan.bdd;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html", "junit:target/junit-report.xml"}
        , features = "src/bdd-test/resources/features/app.feature"
)
@ActiveProfiles(value = "test")
public class DemoFeatureRunner {
}

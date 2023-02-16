package com.rayshan.bdd.steps;

import com.rayshan.bdd.BaseIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Disabled;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

@Disabled
public class DemoFeatureTestSteps extends BaseIntegrationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoFeatureTestSteps.class);

    @Given("^Some service exists$")
    public void some_service_exists() throws Throwable {
        LOGGER.info(() -> "++ GIVEN -> some_service_exists()");
    }

    @And("^setup clean & fresh test data$")
    public void setup_clean_fresh_test_data() throws Throwable {
        LOGGER.info(() -> "++ AND -> setup_clean_fresh_test_data()");
    }

    @When("^the client calls service$")
    public void client_calls_service() throws Throwable {
        LOGGER.info(() -> "++ WHEN -> client_calls_service()");
    }

    @Then("^verify expected result$")
    public void verify_expected_result() throws Throwable {
        LOGGER.info(() -> "++ THEN -> verify_expected_result()");
    }

    @Then("^cleanup demo test data$")
    public void cleanup_test_data() throws Throwable {
        LOGGER.info(() -> "++ THEN -> cleanup_test_data()");
    }
}

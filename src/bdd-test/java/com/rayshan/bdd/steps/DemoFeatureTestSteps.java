package com.rayshan.bdd.steps;

import com.rayshan.bdd.BaseIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Disabled;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class DemoFeatureTestSteps extends BaseIntegrationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoFeatureTestSteps.class);
    private static final String SERVICE_BASE_URL = "http://localhost:8080";
    private final RestTemplate restTemplate = new RestTemplate();

    @Given("^Service is up and running$")
    public void some_service_exists() {
        LOGGER.info(() -> "++ GIVEN -> some_service_exists()");
        String response = restTemplate.getForObject(SERVICE_BASE_URL + "/api/test/hello", String.class);
        assertEquals("Hello world", response);
    }

    @And("^setup clean & fresh test data$")
    public void setup_clean_fresh_test_data() {
        LOGGER.info(() -> "++ AND -> setup_clean_fresh_test_data()");
    }

    @When("^the client calls service$")
    public void client_calls_service() {
        LOGGER.info(() -> "++ WHEN -> client_calls_service()");
    }

    @Then("^verify expected result$")
    public void verify_expected_result() {
        LOGGER.info(() -> "++ THEN -> verify_expected_result()");
    }

    @Then("^cleanup demo test data$")
    public void cleanup_test_data() {
        LOGGER.info(() -> "++ THEN -> cleanup_test_data()");
    }

    @And("User with {string} does not exist in db")
    public void userDoesNotExistsInDB(String username) {
        System.out.println("username:" + username);
    }

    @And("User with {string} and {string} exist in db")
    public void userExistsInDB(String username, String password) {
        System.out.println("username:" + username + ", password:" + password);
    }

    @Then("Login service returns success")
    public void loginServiceReturnsSuccess() {
        
    }

    @Then("Login service returns failure")
    public void loginServiceReturnsFailure() {
    }

    @When("Login url invoked with {string} and {string}")
    public void loginUrlInvokedWithAnd(String username, String password) {
        System.out.println("API invoked: username:" + username + ", password:" + password);
    }
}

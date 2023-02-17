@Smoke
Feature: Scenario to demonstrate actual spring service call from bdd test

  Scenario: Verify status after service call
    Given Service is up and running
    And setup clean & fresh test data
    When the client calls service
    Then verify expected result
    Then cleanup demo test data

  Scenario Outline: Verity login success scenarios
    Given Service is up and running
    And User with "<username>" and "<password>" exist in db
    When Login url invoked with "<username>" and "<password>"
    Then Login service returns success
    Examples:
      | username  | password  |
      | user      | password  |
      | user1     | password1 |

  Scenario Outline: Verify login failure scenario
    Given Service is up and running
    And User with "<username>" does not exist in db
    When Login url invoked with "<username>" and "<password>"
    Then Login service returns failure
    Examples:
      | username  | password |
      | abcd      | abcd     |
      | efgh      | efgh     |

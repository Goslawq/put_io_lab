Feature: Register.

  Background:
    Given I have cleared the database

  Scenario: Register
    Given I have moved to the register page
    When I fill the register form with username "jan" and password "jan", repeat password "jan", name "jan", address "ul. Kolorowa" and I submit it
    Then I should see the login page
Feature: Verify the Web Table for list of countries

  Scenario: Web Table content verification

    Given User is already on the Tables page
    When user scroll down
    Then user should be able to view countries table
    Then Close the browser
Feature: Validate button
Scenario: To validate button
 Given Open demoqa
    When double click button clicked
    Then "You have done a double click" text should display

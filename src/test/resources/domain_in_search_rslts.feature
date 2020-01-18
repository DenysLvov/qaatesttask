Feature: Test Google search

Scenario: Search for “automation”. Expected domain is found on one of the page with results
  Given I open "https://www.google.com/" url
  When I enter "automation" in search field
  Then I can find "testautomationday.com" domain in first "5" pages

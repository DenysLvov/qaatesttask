Feature: Test Google search

Scenario: Search for “automation”. Open the first link on search results page. Page's title contains searched word.
  Given I open "https://www.google.com/" url
  When I enter "automation" in search field
  Then I can find "testautomationday.com" domain in first "5" pages

Feature: Test Google search

Scenario: Search for “automation”. Open the first link on search results page. Page's title contains searched word.
  Given I open "https://www.google.com/" url
  When I enter "automation" in search field
  And I open the "1"-st link on search results page
  Then I see "automation" in the title of opened page

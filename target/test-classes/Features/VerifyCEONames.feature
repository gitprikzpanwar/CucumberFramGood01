@GetCEOName
Feature: Feature to test CEO Names
Scenario Outline: This test is to verify CEO Names
Given The user is logged in successfully and is on Home page
When the user clicks on the directory option fron the Menu bar
And the user selects the job title as "Chief Executive Officer" from the drop down
And clicks the search button
Then the user should see the CEO name as "<CEO_Name>"
Examples:
|CEO_Name|
|John Smith|

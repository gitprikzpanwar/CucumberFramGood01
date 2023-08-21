@timesheets
Feature: Feature to test Pending Timesheet

Scenario Outline: This test is to verify the pending timesheet
Given the user is on the homepage
And the user clicks on the time option from the menu
And the user enters the name as "John Smith"
And clicks on the view button
Then the user should see the message as "<message>"
Examples:
|message|
|No Timesheets Found|

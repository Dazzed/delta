Feature: Insert Employee Phone Numbers

Scenario: Insert phone numbers of employees
    Given I have phone number to be inserted
    When I call insert employee phone number service
    Then insert phone number

Scenario: when employee id is null
    Given I have phone number to be inserted and employee id to be associated with it as null
    When I call insert employee phone number service with null employee Id
    Then throw error as employee id can not be null

Scenario: Insert phone numbers of employees by calling SP
    Given I have phone number to be inserted
    When I call insert employee phone number service which calls SP
    Then insert phone number

Scenario: when phone number is provided as null
    Given I have phone number as null which needs to be inserted
    When I call employee phone numbers service to insert with null phone number
    Then throw error as employee phone number can not be null
    
Scenario: when other parameters is provided as null except Phone number and Employee Id
    Given I have other parameters as null which needs to be inserted
    When I call employee phone numbers service to insert with other null parameters
    Then insert the phone with other null parameters

Scenario: when the insert phone service url is wrong
    Given I have phone number to be inserted with wrong url
    When I call employee phone numbers service to insert with with wrong url
    Then throw error as url is wrong
Feature: Update Employee Phone Numbers

Scenario: Update phone numbers of employees
    Given I have phone number to be updated
    When I call update employee phone number service
    Then update phone number
    
Scenario: Update phone numbers of employees by calling SP
    Given I have phone number to be updated
    When I call update employee phone number service which calls SP
    Then update phone number
        
Scenario: when employee id is null
    Given I have phone number to be updated and employee id to be associated with it as null
    When I call update employee phone number service with null employee Id
    Then throw error as employee id can not be null for update phone service
    
Scenario: when phone number is provided as null
    Given I have phone number as null which needs to be updated
    When I call employee phone numbers service to update with null phone number
    Then throw error as employee phone number can not be null for update phone service

Scenario: when effective date is provided as null
    Given I have effective date as null which needs to be updated
    When I call employee phone numbers service to update with null effective date
    Then throw error as effective date can not be null for update phone service  

Scenario: when phone type code is provided as null
    Given I have phone type code as null which needs to be updated
    When I call employee phone numbers service to update with null phone type code
    Then throw error as phone type code can not be null for update phone service   

Scenario: when the update phone service url is wrong
    Given I have phone number to be updated with wrong url
    When I call employee phone numbers service to update with with wrong url
    Then throw error as update url is wrong
 
Feature: Delete Employee Phone Numbers 

Scenario: Delete phone numbers of employees 
	Given I have phone number to be deleted 
	When I call delete employee phone number service 
	Then delete phone number 
	
Scenario: Delete phone numbers of employees by calling SP 
	Given I have phone number to be deleted 
	When I call delete employee phone number service which calls SP 
	Then delete phone number 
	
Scenario: when employee id is null 
	Given I have phone number to be deleted and employee id to be associated with it as null 
	When I call delete employee phone number service with null employee Id 
	Then throw error as employee id can not be null for delete phone service
	
Scenario: when phone number is provided as null 
	Given I have phone number as null which needs to be deleted 
	When I call employee phone numbers service to delete with null phone number 
	Then throw error as employee phone number can not be null for delete phone service 
	
Scenario: when effective date is provided as null 
	Given I have effective date as null which needs to be deleted 
	When I call employee phone numbers service to delete with null effective date 
	Then throw error as effective date can not be null for delete phone service 
	
Scenario: when phone type code is provided as null 
	Given I have phone type code as null which needs to be deleted 
	When I call employee phone numbers service to delete with null phone type code 
	Then throw error as phone type code can not be null for delete phone service 
	
Scenario: when the delete phone service url is wrong 
	Given I have phone number to be deleted with wrong url 
	When I call employee phone numbers service to delete with wrong url 
	Then throw error as delete url is wrong 
	
Scenario: when employee id is incorrect 
	Given I have phone number to be deleted and employee id associated with it is incorrect 
	When I call delete employee phone number service with incorrect employee Id 
	Then throw error as employee id is incorrect for delete phone service 
	
Scenario: when phone number is incorrect 
	Given I have incorrect phone number which needs to be deleted 
	When I call employee phone number service to delete with incorrect phone number 
	Then throw error as employee phone number is incorrect for delete phone service 
	
Scenario: when effective date is incorrect 
	Given I have incorrect effective date which needs to be deleted 
	When I call employee phone number service to delete with incorrect effective date 
	Then throw error as effective date is incorrect for delete phone service 
	
Scenario: when phone type code is incorrect 
	Given I have incorrect phone type code which needs to be deleted 
	When I call employee phone number service to delete with incorrect phone type code 
	Then throw error as phone type code is incorrect for delete phone service 
    
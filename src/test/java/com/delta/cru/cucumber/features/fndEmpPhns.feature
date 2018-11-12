Feature: Get Employee phone numbers
	
	Scenario: i have employee id whose phone number details need to be retrieved
    Given I have employee id  whose phone number details need to be retrieved
    When I call Get employee phone record service
    Then employee phone number details need to be displayed
    
 	Scenario: when employee id is empty
    Given I have employee id as null whose phone number details need to be retrieved
    When I call Get employee phone record service with empty empId
    Then throw error employee id cannot be null
    
    Scenario: when employee id does not match
    Given I have employee id whose details need to be retrieved which is not available in DB
    When I call Get employee phone record service with incorrect empId
    Then dont display employee phone number details

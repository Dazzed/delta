Feature: Get Employee Id and Display Name


  Scenario: Fetch Employee Id and Name for given Employee Id
   Given I have a list of Employees
    When User hit the service with Employee Id
    Then return Employee details recieved successfully
    
  Scenario: Fetch Employee Id and Name for incorrect Employee Id
   Given I have a list of Employees
    When User hit the service with incorrect Employee Id 001
    Then return Employee details not found
    
  Scenario: Fetch Employee Id and Name for incorrect URL
   Given I have a list of Employees
    When User hit the service with incorrect URL
    Then return incorrect URL
    
  Scenario: when employee id is null
    Given I have employee id as null whose details need to be retrieved
    When I call Get employee name service
    Then throw error stating employee id cannot be null
    
   Scenario: when the header details are given as null
    Given I have given the header details as null for the correct Employee Id 
    When User calls the Get employee name service with header params as null
    Then throw error stating Header Info is not Valid
   
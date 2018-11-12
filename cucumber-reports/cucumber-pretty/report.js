$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/delta/cru/cucumber/features/delPhn.feature");
formatter.feature({
  "name": "Delete Employee Phone Numbers",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Delete phone numbers of employees",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call delete employee phone number service",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_update_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete phone number",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_valid_phone_number_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete phone numbers of employees by calling SP",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call delete employee phone number service which calls SP",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_by_calling_SP()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete phone number",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_valid_phone_number_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id is null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be deleted and employee id to be associated with it as null",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call delete employee phone number service with null employee Id",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee id can not be null for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone number is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number as null which needs to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to delete with null phone number",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee phone number can not be null for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when effective date is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have effective date as null which needs to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_null_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to delete with null effective date",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_null_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as effective date can not be null for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_null_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone type code is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone type code as null which needs to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_null_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to delete with null phone type code",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_null_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as phone type code can not be null for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_null_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when the delete phone service url is wrong",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be deleted with wrong url",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to delete with wrong url",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as delete url is wrong",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id is incorrect",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be deleted and employee id associated with it is incorrect",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_incorrect_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call delete employee phone number service with incorrect employee Id",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_incorrect_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee id is incorrect for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_incorrect_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone number is incorrect",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have incorrect phone number which needs to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_inocrrect_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone number service to delete with incorrect phone number",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_inocrrect_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee phone number is incorrect for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_inocrrect_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when effective date is incorrect",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have incorrect effective date which needs to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_incorrect_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone number service to delete with incorrect effective date",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_incorrect_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as effective date is incorrect for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_incorrect_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone type code is incorrect",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have incorrect phone type code which needs to be deleted",
  "keyword": "Given "
});
formatter.match({
  "location": "DelPhnSteps.delete_ph_number_with_incorrect_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone number service to delete with incorrect phone type code",
  "keyword": "When "
});
formatter.match({
  "location": "DelPhnSteps.call_delete_phone_service_to_delete_data_with_incorrect_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as phone type code is incorrect for delete phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "DelPhnSteps.delete_invalid_phone_number_response_for_incorrect_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/com/delta/cru/cucumber/features/fndEmp.feature");
formatter.feature({
  "name": "Get Employee Id and Display Name",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Fetch Employee Id and Name for given Employee Id",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have a list of Employees",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpSteps.i_have_a_list_of_Employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User hit the service with Employee Id",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpSteps.user_hit_the_service_with_Employee_Id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "return Employee details recieved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpSteps.return_Employee_details_recieved_succefully_and_return_status_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Fetch Employee Id and Name for incorrect Employee Id",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have a list of Employees",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpSteps.i_have_a_list_of_Employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User hit the service with incorrect Employee Id 001",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpSteps.user_hit_the_service_with_incorrect_Employee_Id(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "return Employee details not found",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpSteps.return_Employee_details_not_found_and_return_status_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Fetch Employee Id and Name for incorrect URL",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have a list of Employees",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpSteps.i_have_a_list_of_Employees()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User hit the service with incorrect URL",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpSteps.user_hit_the_service_with_incorrect_URL()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "return incorrect URL",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpSteps.return_incorrect_URL_and_return_status_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id is null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have employee id as null whose details need to be retrieved",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpSteps.I_have_employee_id_as_null_whose_details_need_to_be_retrieved()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call Get employee name service",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpSteps.I_call_Get_employee_name_service_with_empty_empId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error stating employee id cannot be null",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpSteps.employee_id_cannot_be_null()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when the header details are given as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have given the header details as null for the correct Employee Id",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpSteps.i_have_given_the_header_details_as_null_for_the_correct_Employee_Id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User calls the Get employee name service with header params as null",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpSteps.user_calls_the_Get_employee_name_service_with_header_params_as_null()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error stating Header Info is not Valid",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpSteps.throw_error_stating_Header_Info_is_not_Valid()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/com/delta/cru/cucumber/features/fndEmpPhns.feature");
formatter.feature({
  "name": "Get Employee phone numbers",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "i have employee id whose phone number details need to be retrieved",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have employee id  whose phone number details need to be retrieved",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpPhnsSteps.retrieve_employee_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call Get employee phone record service",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpPhnsSteps.user_hit_the_service_with_Employee_Id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "employee phone number details need to be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpPhnsSteps.employee_phone_number_details_need_to_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id is empty",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have employee id as null whose phone number details need to be retrieved",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpPhnsSteps.retrieve_employee_phone_number_for_null_empId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call Get employee phone record service with empty empId",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpPhnsSteps.retrieve_phone_numbers_for_empty_empId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error employee id cannot be null",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpPhnsSteps.retrieve_phone_numbers_employee_id_cannot_be_null()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id does not match",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have employee id whose details need to be retrieved which is not available in DB",
  "keyword": "Given "
});
formatter.match({
  "location": "FndEmpPhnsSteps.retrieve_employee_phone_number_for_incorrect_empId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call Get employee phone record service with incorrect empId",
  "keyword": "When "
});
formatter.match({
  "location": "FndEmpPhnsSteps.user_hit_the_service_with_incorrect_Employee_Id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "dont display employee phone number details",
  "keyword": "Then "
});
formatter.match({
  "location": "FndEmpPhnsSteps.return_Employee_details_not_found_and_return_status_code()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/com/delta/cru/cucumber/features/insPhn.feature");
formatter.feature({
  "name": "Insert Employee Phone Numbers",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Insert phone numbers of employees",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be inserted",
  "keyword": "Given "
});
formatter.match({
  "location": "InsPhnSteps.insert_ph_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call insert employee phone number service",
  "keyword": "When "
});
formatter.match({
  "location": "InsPhnSteps.call_insert_phone_service_to_insert_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insert phone number",
  "keyword": "Then "
});
formatter.match({
  "location": "InsPhnSteps.insert_valid_phone_number_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id is null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be inserted and employee id to be associated with it as null",
  "keyword": "Given "
});
formatter.match({
  "location": "InsPhnSteps.insert_ph_number_with_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call insert employee phone number service with null employee Id",
  "keyword": "When "
});
formatter.match({
  "location": "InsPhnSteps.call_insert_phone_service_to_insert_data_with_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee id can not be null",
  "keyword": "Then "
});
formatter.match({
  "location": "InsPhnSteps.insert_invalid_phone_number_response_for_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Insert phone numbers of employees by calling SP",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be inserted",
  "keyword": "Given "
});
formatter.match({
  "location": "InsPhnSteps.insert_ph_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call insert employee phone number service which calls SP",
  "keyword": "When "
});
formatter.match({
  "location": "InsPhnSteps.call_insert_phone_service_to_insert_data_by_calling_SP()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insert phone number",
  "keyword": "Then "
});
formatter.match({
  "location": "InsPhnSteps.insert_valid_phone_number_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone number is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number as null which needs to be inserted",
  "keyword": "Given "
});
formatter.match({
  "location": "InsPhnSteps.insert_ph_number_with_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to insert with null phone number",
  "keyword": "When "
});
formatter.match({
  "location": "InsPhnSteps.call_insert_phone_service_to_insert_data_with_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee phone number can not be null",
  "keyword": "Then "
});
formatter.match({
  "location": "InsPhnSteps.insert_invalid_phone_number_response_for_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when other parameters is provided as null except Phone number and Employee Id",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have other parameters as null which needs to be inserted",
  "keyword": "Given "
});
formatter.match({
  "location": "InsPhnSteps.insert_ph_number_with_null_parameters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to insert with other null parameters",
  "keyword": "When "
});
formatter.match({
  "location": "InsPhnSteps.call_insert_phone_service_to_insert_data_with_null_parameters()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insert the phone with other null parameters",
  "keyword": "Then "
});
formatter.match({
  "location": "InsPhnSteps.insert_invalid_phone_number_response_for_null_parameters()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when the insert phone service url is wrong",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be inserted with wrong url",
  "keyword": "Given "
});
formatter.match({
  "location": "InsPhnSteps.insert_ph_number_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to insert with with wrong url",
  "keyword": "When "
});
formatter.match({
  "location": "InsPhnSteps.call_insert_phone_service_to_insert_data_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as url is wrong",
  "keyword": "Then "
});
formatter.match({
  "location": "InsPhnSteps.insert_invalid_phone_number_response_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/java/com/delta/cru/cucumber/features/updtPhn.feature");
formatter.feature({
  "name": "Update Employee Phone Numbers",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Update phone numbers of employees",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be updated",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call update employee phone number service",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "update phone number",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_valid_phone_number_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Update phone numbers of employees by calling SP",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be updated",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call update employee phone number service which calls SP",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data_by_calling_SP()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "update phone number",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_valid_phone_number_response()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when employee id is null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be updated and employee id to be associated with it as null",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number_with_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call update employee phone number service with null employee Id",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data_with_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee id can not be null for update phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_invalid_phone_number_response_for_null_employee_id()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone number is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number as null which needs to be updated",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number_with_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to update with null phone number",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data_with_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as employee phone number can not be null for update phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_invalid_phone_number_response_for_null_phone_number()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when effective date is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have effective date as null which needs to be updated",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number_with_null_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to update with null effective date",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data_with_null_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as effective date can not be null for update phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_invalid_phone_number_response_for_null_effective_date()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when phone type code is provided as null",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone type code as null which needs to be updated",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number_with_null_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to update with null phone type code",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data_with_null_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as phone type code can not be null for update phone service",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_invalid_phone_number_response_for_null_phone_type_code()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "when the update phone service url is wrong",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have phone number to be updated with wrong url",
  "keyword": "Given "
});
formatter.match({
  "location": "UpdtPhnSteps.update_ph_number_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I call employee phone numbers service to update with with wrong url",
  "keyword": "When "
});
formatter.match({
  "location": "UpdtPhnSteps.call_update_phone_service_to_update_data_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "throw error as update url is wrong",
  "keyword": "Then "
});
formatter.match({
  "location": "UpdtPhnSteps.update_invalid_phone_number_response_with_wrong_url()"
});
formatter.result({
  "status": "passed"
});
});
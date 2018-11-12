package com.delta.cru.cucumber.stepdefs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.delta.cru.cucumber.TestData;
import com.delta.cru.svc.EmpSvc;
import com.delta.cru.vo.EmpPhVo;
import com.delta.cru.vo.HeaderVo;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ActiveProfiles("test")
public class DelPhnSteps {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private MvcResult mvcResult;

	@Mock
	private EmpSvc svc;
	
	List<String> hdrListVlues = null;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("CMA");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("1");
		hdrListVlues.add("application/json");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
	}

	@Given("^I have phone number to be deleted$")
	public void delete_ph_number() throws Exception {

	}

	@When("^I call delete employee phone number service$")
	public void call_delete_phone_service_to_update_data() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestData.asJsonString(TestData.deleteDataSetUpForCucumber()))).andReturn();

		// Insert the data which has been just deleted

		mockMvc.perform(post(TestData.EMP_INSRT_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestData.asJsonString(TestData.insertDataSetUpAfterDelete()))).andReturn();

	}

	@When("^I call delete employee phone number service which calls SP$")
	public void call_delete_phone_service_to_delete_data_by_calling_SP() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		mvcResult = mockMvc.perform(delete(TestData.EMP_SP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestData.asJsonString(TestData.deleteDataSetUpForCucumber()))).andReturn();

		// Insert the data which has been just deleted

		mockMvc.perform(post(TestData.EMP_INSRT_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestData.asJsonString(TestData.insertDataSetUpAfterDelete()))).andReturn();

	}

	@Then("^delete phone number$")
	public void delete_valid_phone_number_response() throws Exception {
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
	}

	@Given("^I have phone number to be deleted and employee id to be associated with it as null$")
	public void delete_ph_number_with_null_employee_id() throws Exception {

	}

	@When("^I call delete employee phone number service with null employee Id$")
	public void call_delete_phone_service_to_delete_data_with_null_employee_id() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId(null);
		empPkVo.setEmplPhNum("8587327112");
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate("12-JAN-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as employee id can not be null for delete phone service$")
	public void delete_invalid_phone_number_response_for_null_employee_id() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 500) {
				throw new Exception("Employee Id can not be null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have phone number as null which needs to be deleted$")
	public void delete_ph_number_with_null_phone_number() throws Exception {

	}

	@When("^I call employee phone numbers service to delete with null phone number$")
	public void call_delete_phone_service_to_delete_data_with_null_phone_number() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum(null);
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate("12-JAN-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as employee phone number can not be null for delete phone service$")
	public void delete_invalid_phone_number_response_for_null_phone_number() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 500) {
				throw new Exception("Employee phone number can not be null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have effective date as null which needs to be deleted$")
	public void delete_ph_number_with_null_effective_date() throws Exception {

	}

	@When("^I call employee phone numbers service to delete with null effective date$")
	public void call_delete_phone_service_to_delete_data_with_null_effective_date() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum("8587327112");
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate(null);
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as effective date can not be null for delete phone service$")
	public void delete_invalid_phone_number_response_for_null_effective_date() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 500) {
				throw new Exception("Effective Date can not be null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have phone type code as null which needs to be deleted$")
	public void delete_ph_number_with_null_phone_type_code() throws Exception {

	}

	@When("^I call employee phone numbers service to delete with null phone type code$")
	public void call_delete_phone_service_to_delete_data_with_null_phone_type_code() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum("8587327112");
		empPkVo.setPhTypCode(null);
		empPkVo.setEffDate("12-JAN-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as phone type code can not be null for delete phone service$")
	public void delete_invalid_phone_number_response_for_null_phone_type_code() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 500) {
				throw new Exception("Employee phone number can not be null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have phone number to be deleted with wrong url$")
	public void delete_ph_number_with_wrong_url() throws Exception {

	}

	@When("^I call employee phone numbers service to delete with wrong url$")
	public void call_delete_phone_service_to_delete_data_with_wrong_url() throws Exception {
		mvcResult = mockMvc.perform(delete(TestData.WRNG_EMP_DEL_URL).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(TestData.asJsonString(TestData.deleteDataSetUpForCucumber()))).andReturn();
	}

	@Then("^throw error as delete url is wrong$")
	public void delete_invalid_phone_number_response_for_wrong_url() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 404) {
				throw new Exception("Employee phone number delete URL is wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have incorrect phone number which needs to be deleted$")
	public void delete_ph_number_with_inocrrect_phone_number() throws Exception {

	}

	@When("^I call employee phone number service to delete with incorrect phone number$")
	public void call_delete_phone_service_to_delete_data_with_inocrrect_phone_number() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum("0000023565");
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate("12-JAN-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as employee phone number is incorrect for delete phone service$")
	public void delete_invalid_phone_number_response_for_inocrrect_phone_number() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 404) {
				throw new Exception("Employee phone number is incorrect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have phone number to be deleted and employee id associated with it is incorrect$")
	public void delete_ph_number_with_incorrect_employee_id() throws Exception {

	}

	@When("^I call delete employee phone number service with incorrect employee Id$")
	public void call_delete_phone_service_to_delete_data_with_incorrect_employee_id() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("1221");
		empPkVo.setEmplPhNum("8587327112");
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate("12-JAN-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as employee id is incorrect for delete phone service$")
	public void delete_invalid_phone_number_response_for_incorrect_employee_id() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 404) {
				throw new Exception("Employee id is incorrect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have incorrect effective date which needs to be deleted$")
	public void delete_ph_number_with_incorrect_effective_date() throws Exception {

	}

	@When("^I call employee phone number service to delete with incorrect effective date$")
	public void call_delete_phone_service_to_delete_data_with_incorrect_effective_date() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum("8587327112");
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate("12-APR-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as effective date is incorrect for delete phone service$")
	public void delete_invalid_phone_number_response_for_incorrect_effective_date() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 404) {
				throw new Exception("Effective Date is incorrect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Given("^I have incorrect phone type code which needs to be deleted$")
	public void delete_ph_number_with_incorrect_phone_type_code() throws Exception {

	}

	@When("^I call employee phone number service to delete with incorrect phone type code$")
	public void call_delete_phone_service_to_delete_data_with_incorrect_phone_type_code() throws Exception {
		HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum("8587327112");
		empPkVo.setPhTypCode("L");
		empPkVo.setEffDate("12-APR-19");
		mvcResult = mockMvc.perform(delete(TestData.EMP_DEL_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(TestData.asJsonString(TestData.asJsonString(empPkVo))))
				.andReturn();
	}

	@Then("^throw error as phone type code is incorrect for delete phone service$")
	public void delete_invalid_phone_number_response_for_incorrect_phone_type_code() throws Exception {
		try {
			if (mvcResult.getResponse().getStatus() == 404) {
				throw new Exception("Effective Date is incorrect");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

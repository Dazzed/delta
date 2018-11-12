package com.delta.cru.cucumber.stepdefs;

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
import com.delta.cru.vo.HeaderVo;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Ignore;

@ActiveProfiles("test")
public class FndEmpPhnsSteps {

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

    @Given("^I have employee id  whose phone number details need to be retrieved$")
    public void retrieve_employee_phone_number() throws Exception {

    }

    @When("^I call Get employee phone record service$")
    public void user_hit_the_service_with_Employee_Id() throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
        mvcResult = mockMvc.perform(
                post(TestData.FND_EMP_PHN).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(TestData.PHN_EMP_ID))
                .andReturn();
    }

    @Then("^employee phone number details need to be displayed$")
    public void employee_phone_number_details_need_to_be_displayed() {
        Assert.assertNotNull(mvcResult);
    }

    @Given("^I have employee id as null whose phone number details need to be retrieved$")
    public void retrieve_employee_phone_number_for_null_empId() throws Exception {

    }

    @When("^I call Get employee phone record service with empty empId")
    public void retrieve_phone_numbers_for_empty_empId() throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
        String nullEmpId = "";
        mvcResult = mockMvc.perform(
                post(TestData.WRNG_FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(nullEmpId))
                .andReturn();
        Assert.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Then("^throw error employee id cannot be null$")
    public void retrieve_phone_numbers_employee_id_cannot_be_null() throws Exception {
        try {
            if (mvcResult.getResponse().getStatus() == 404) {
                throw new Exception("Employee Id can not be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^I have employee id whose details need to be retrieved which is not available in DB$")
    public void retrieve_employee_phone_number_for_incorrect_empId() throws Exception {

    }

    @When("^I call Get employee phone record service with incorrect empId$")
    public void user_hit_the_service_with_incorrect_Employee_Id() throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);

        String incorrectEmpId = "0022";
        mvcResult = mockMvc.perform(
                post(TestData.FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(incorrectEmpId))
                .andReturn();
    }

    @Then("^dont display employee phone number details$")
    public void return_Employee_details_not_found_and_return_status_code() throws Exception {
        mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(404, mvcResult.getResponse().getStatus());
    }

}

package com.delta.cru.cucumber.stepdefs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.delta.cru.Application;
import com.delta.cru.cucumber.TestData;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.svc.EmpSvc;
import com.delta.cru.vo.HeaderVo;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@WebAppConfiguration
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@ActiveProfiles("test")
public class FndEmpSteps {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private MvcResult mvcResult;
    
    List<String> hdrListVlues = null;

    @Mock
    private EmpSvc svc;

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
    
    public List<String> setHdrLstAsEmpty() {
        hdrListVlues = new ArrayList<String>();
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		hdrListVlues.add(StringUtils.EMPTY);
		return hdrListVlues;
    }


    @Given("^I have a list of Employees$")
    public void i_have_a_list_of_Employees() throws Exception {

    }

    @When("^User hit the service with Employee Id$")
    public void user_hit_the_service_with_Employee_Id() throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
        mvcResult = mockMvc.perform(
                post(TestData.FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(TestData.EMP_ID))
                .andReturn();
    }

    @Then("^return Employee details recieved successfully$")
    public void return_Employee_details_recieved_succefully_and_return_status_code() {
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @When("^User hit the service with incorrect Employee Id (\\d+)$")
    public void user_hit_the_service_with_incorrect_Employee_Id(int emplId) throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
        mvcResult = mockMvc.perform(
                post(TestData.FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(emplId)))
                .andReturn();
    }

    @Then("^return Employee details not found$")
    public void return_Employee_details_not_found_and_return_status_code() throws Exception {
        mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @When("^User hit the service with incorrect URL")
    public void user_hit_the_service_with_incorrect_URL() throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
        mockMvc.perform(
                post(TestData.WRNG_FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(TestData.EMP_ID))
                .andExpect(status().is(404));
    }

    @Then("^return incorrect URL$")
    public void return_incorrect_URL_and_return_status_code() throws Exception {
        try {
            if (mvcResult.getResponse().getStatus() == 500) {
                throw new Exception("URL is wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^I have employee id as null whose details need to be retrieved$")
    public void I_have_employee_id_as_null_whose_details_need_to_be_retrieved() throws Exception {

    }

    @When("^I call Get employee name service")
    public void I_call_Get_employee_name_service_with_empty_empId() throws Exception {
    	HeaderVo headerVO = HeaderVo.createReqHeader(hdrListVlues);
		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
        String empId = "";
        mvcResult = mockMvc.perform(
                post(TestData.WRNG_FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(empId))
                .andReturn();
        Assert.assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Then("^throw error stating employee id cannot be null$")
    public void employee_id_cannot_be_null() throws Exception {
        try {
            if (mvcResult.getResponse().getStatus() == 404) {
                throw new Exception("Employee Id can not be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^I have given the header details as null for the correct Employee Id$")
    public void i_have_given_the_header_details_as_null_for_the_correct_Employee_Id()
            throws Exception {
    }

    @When("^User calls the Get employee name service with header params as null$")
    public void user_calls_the_Get_employee_name_service_with_header_params_as_null()
            throws Exception {
    	try {
        	HeaderVo headerVO = HeaderVo.createReqHeader(setHdrLstAsEmpty());
    		HttpHeaders headers = HeaderVo.createReqHeader(headerVO);
            mvcResult = mockMvc.perform(
                    post(TestData.FND_EMP_URL).headers(headers).accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON).content(TestData.EMP_ID))
                    .andReturn();
        	}catch(BsnObjExcp b){
        		 Assert.assertEquals("Header Info is not Valid", b.getMessage());
        	}
    }

    @Then("^throw error stating Http Status (\\d+) not found$")
    public void throw_error_stating_Http_Status_not_found(int arg1) throws Exception {
        try {
            if (mvcResult.getResponse().getStatus() == 400) {
                throw new Exception("Header params can not be empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Then("^throw error stating Header Info is not Valid$")
    public void throw_error_stating_Header_Info_is_not_Valid() throws Exception {
        // Response will be Null
        Assert.assertNull(mvcResult);
    }


}

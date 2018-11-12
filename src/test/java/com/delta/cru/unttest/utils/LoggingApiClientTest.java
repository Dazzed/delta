
package com.delta.cru.unttest.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;

import com.delta.cru.cnfg.CnfgReader;
import com.delta.cru.utils.LoggingApiClient;
import com.delta.cru.vo.HeaderVo;

@RunWith(MockitoJUnitRunner.class)
public class LoggingApiClientTest {
	@InjectMocks
	private LoggingApiClient loggingApiClient;
	@Mock
	ListenableFuture<ResponseEntity<String>> futureResp;
	List<String> hdrListVlues = null;
	
	@Mock
	private CnfgReader cnfgReader;
	HeaderVo hdrVo = null;

	@Before
	public void setUp() throws Exception {
		loggingApiClient = new LoggingApiClient();
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("CRU");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrVo = HeaderVo.createReqHeader(hdrListVlues);
	}

	/**
	 * Test method for Successful logging of Headers info
	 */
	@Test
	public void testLogHdrInfo() {
		loggingApiClient.logHdrInfo("https://cnsr.log.cssi.delta.com/cnsrLogCtxt/flightCrew/employee/v1/crew", hdrVo);
	}

	/**
	 * Test method during Failure scenario of logging Headers info .
	 */
	@Test
	public void testFailureOfLogHdrInfo() {
		loggingApiClient.logHdrInfo("http://test.delta.com:17513/cnsrLogCtxt/flightCrew/employee/v1/crew", hdrVo);
	}

}

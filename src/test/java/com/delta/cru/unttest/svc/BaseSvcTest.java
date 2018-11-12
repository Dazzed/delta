package com.delta.cru.unttest.svc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.cnfg.CnfgReader;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.svc.BaseSvc;
import com.delta.cru.utils.LoggingApiClient;

/**
 * @author z73790
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseSvcTest {

		@InjectMocks   
		private BaseSvc baseSvc;
	
		@Mock
	    private LoggingApiClient loggingApiClient;
		
		@Mock
	    private CnfgReader cnfgReader;
	    
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws BsnObjExcp {
		String apiCnsrRecTxt = "test";
		String rqstEmplId = "test";
		String employeeId = "0000722727";
		String ntwkIpAdr = "test";
		String transactionId ="test16May218";
		String accept = "application/json";
		String authorization = "test";
		String apcnOwnrCd ="CRU";
		String apcnDvcNm = "test";
		String apcnAppVer = "test";
		String apiReqGdttm = "test";
		String apiRsrcNm = "test";
		String contentType = "application/json";
		String apcnDvcOs = "test";
		String apcnAppNm = "test";
		String apcnDvcMacAdr = "test";
		Whitebox.setInternalState(baseSvc, "logHdrInfo", "true");
		baseSvc.processRequestHeaders(apcnOwnrCd, rqstEmplId, apiRsrcNm, apiReqGdttm, apcnAppNm, apcnAppVer, apcnDvcNm, apcnDvcOs, apcnDvcMacAdr, ntwkIpAdr, apiCnsrRecTxt, authorization, transactionId, contentType, accept, employeeId);
	}
	
	@Test
	public void testHdrMQFalse() throws BsnObjExcp {
		String apiCnsrRecTxt = "test";
		String rqstEmplId = "test";
		String employeeId = "0000722727";
		String ntwkIpAdr = "test";
		String transactionId ="test16May218";
		String accept = "application/json";
		String authorization = "test";
		String apcnOwnrCd ="CRU";
		String apcnDvcNm = "test";
		String apcnAppVer = "test";
		String apiReqGdttm = "test";
		String apiRsrcNm = "test";
		String contentType = "application/json";
		String apcnDvcOs = "test";
		String apcnAppNm = "test";
		String apcnDvcMacAdr = "test";
		Whitebox.setInternalState(baseSvc, "logHdrInfo", "false");
		baseSvc.processRequestHeaders(apcnOwnrCd, rqstEmplId, apiRsrcNm, apiReqGdttm, apcnAppNm, apcnAppVer, apcnDvcNm, apcnDvcOs, apcnDvcMacAdr, ntwkIpAdr, apiCnsrRecTxt, authorization, transactionId, contentType, accept, employeeId);
	}
	
	@Test
	public void testHdrMQNull() throws BsnObjExcp {
		String apiCnsrRecTxt = "test";
		String rqstEmplId = "test";
		String employeeId = "0000722727";
		String ntwkIpAdr = "test";
		String transactionId ="test16May218";
		String accept = "application/json";
		String authorization = "test";
		String apcnOwnrCd ="CRU";
		String apcnDvcNm = "test";
		String apcnAppVer = "test";
		String apiReqGdttm = "test";
		String apiRsrcNm = "test";
		String contentType = "application/json";
		String apcnDvcOs = "test";
		String apcnAppNm = "test";
		String apcnDvcMacAdr = "test";
		Whitebox.setInternalState(baseSvc, "logHdrInfo", null);
		baseSvc.processRequestHeaders(apcnOwnrCd, rqstEmplId, apiRsrcNm, apiReqGdttm, apcnAppNm, apcnAppVer, apcnDvcNm, apcnDvcOs, apcnDvcMacAdr, ntwkIpAdr, apiCnsrRecTxt, authorization, transactionId, contentType, accept, employeeId);
	}
	
	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testHdrInVld() throws BsnObjExcp {
		String apiCnsrRecTxt = "test";
		String rqstEmplId = "test";
		String employeeId = "0000722727";
		String ntwkIpAdr = "test";
		String transactionId ="test16May218";
		String accept = "application/json";
		String authorization = "test";
		String apcnOwnrCd =null;
		String apcnDvcNm = "test";
		String apcnAppVer = "test";
		String apiReqGdttm = "test";
		String apiRsrcNm = "test";
		String contentType = "application/json";
		String apcnDvcOs = "test";
		String apcnAppNm = "test";
		String apcnDvcMacAdr = "test";
		Whitebox.setInternalState(baseSvc, "logHdrInfo", null);
		baseSvc.processRequestHeaders(apcnOwnrCd, rqstEmplId, apiRsrcNm, apiReqGdttm, apcnAppNm, apcnAppVer, apcnDvcNm, apcnDvcOs, apcnDvcMacAdr, ntwkIpAdr, apiCnsrRecTxt, authorization, transactionId, contentType, accept, employeeId);
	}

}

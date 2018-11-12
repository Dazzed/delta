package com.delta.cru.unttest.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.vo.HeaderVo;

public class HeaderVoTest {
	Map<String, String> hdrMap = null;
	@InjectMocks
	HeaderVo headerVo;
	List<String> hdrListVlues = null;

	@Before
	public void setUp() throws Exception {
		hdrMap = new HashMap<String, String>();
		hdrMap.put("empId", "0000305574");
		hdrMap.put("apiCnsrRecTxt", "test");
		hdrMap.put("rqstEmplId", "test");
		hdrMap.put("employeeId", "0000722727");
		hdrMap.put("ntwkIpAdr", "test");
		hdrMap.put("transactionId", "test16May218");
		hdrMap.put("accept", "application/json");
		hdrMap.put("authorization", "test");
		hdrMap.put("apcnOwnrCd", "CRU");
		hdrMap.put("apcnDvcNm", "test");
		hdrMap.put("apcnAppVer", "test");
		hdrMap.put("apiReqGdttm", "test");
		hdrMap.put("apiRsrcNm", "test");
		hdrMap.put("contentType", "application/json");
		hdrMap.put("apcnDvcOs", "test");
		hdrMap.put("apcnAppNm", "test");
		hdrMap.put("apcnDvcMacAdr", "test");
	}

	@Test
	public void isValidTest() {
		headerVo = new HeaderVo();
		headerVo.setApplicationOwnerCode("");
		headerVo.setRequestedEmployeeId("");
		headerVo.setApiResourceName("");
		headerVo.setApiRequestUtcTs("");
		headerVo.setApplicationName("");
		headerVo.setApplicationVersionNum("");
		headerVo.setApplicationDeviceName("");
		headerVo.setApplicationDeviceOS("");
		headerVo.setApplicationDeviceMacAddress("");
		headerVo.setNetworkIpAddress("");
		headerVo.setApiConsumerRecordText("");
		headerVo.setAuthorization("");
		headerVo.setTransactionId("");
		headerVo.setContentType("");
		headerVo.setAccept("");
		headerVo.setEmployeeId("");
		Assert.assertNotNull(HeaderVo.isValid(headerVo));
	}

	@Test
	public void headerVoSetterGetterTest() {
		headerVo = new HeaderVo();
		headerVo.setApplicationOwnerCode("Abcd1234");
		headerVo.setRequestedEmployeeId("E512");
		headerVo.setApiResourceName("Delta");
		headerVo.setApiRequestUtcTs("Delta Crew");
		headerVo.setApplicationName("Crew Mod3");
		headerVo.setApplicationVersionNum("1");
		headerVo.setApplicationDeviceName("iPhone");
		headerVo.setApplicationDeviceOS("iOS");
		headerVo.setApplicationDeviceMacAddress("10.10.10.10");
		headerVo.setNetworkIpAddress("10.10.01.10");
		headerVo.setApiConsumerRecordText("Demo");
		headerVo.setAuthorization("Ture");
		headerVo.setTransactionId("1");
		headerVo.setContentType("JSON");
		headerVo.setAccept("False");
		headerVo.setEmployeeId("1234");
		Assert.assertEquals("Abcd1234", headerVo.getApplicationOwnerCode());
		Assert.assertEquals("E512", headerVo.getRequestedEmployeeId());
		Assert.assertEquals("Delta", headerVo.getApiResourceName());
		Assert.assertEquals("Delta Crew", headerVo.getApiRequestUtcTs());
		Assert.assertEquals("Crew Mod3", headerVo.getApplicationName());
		Assert.assertEquals("1", headerVo.getApplicationVersionNum());
		Assert.assertEquals("iPhone", headerVo.getApplicationDeviceName());
		Assert.assertEquals("iOS", headerVo.getApplicationDeviceOS());
		Assert.assertEquals("10.10.10.10", headerVo.getApplicationDeviceMacAddress());
		Assert.assertEquals("10.10.01.10", headerVo.getNetworkIpAddress());
		Assert.assertEquals("Demo", headerVo.getApiConsumerRecordText());
		Assert.assertEquals("Ture", headerVo.getAuthorization());
		Assert.assertEquals("1", headerVo.getTransactionId());
		Assert.assertEquals("JSON", headerVo.getContentType());
		Assert.assertEquals("False", headerVo.getAccept());
		Assert.assertEquals("1234", headerVo.getEmployeeId());
		Assert.assertNotEquals("A", headerVo.toString());
		Assert.assertNotEquals("A", HeaderVo.createReqHeader(headerVo).toString());
		Assert.assertNotNull(headerVo.toString());
	}

	@Test
	public void testGetHdrVoMap() throws BsnObjExcp {
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test
	public void testGetHdrVoNoLst() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test
	public void testGetHdrVoMapTxnId() throws BsnObjExcp {
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
		hdrListVlues.add("");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoAthrzNullVlue() throws BsnObjExcp {
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
		hdrListVlues.add("");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoCnsrRecNullVlue() throws BsnObjExcp {
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
		hdrListVlues.add("");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpApplOwnerCd() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("");
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpRsrcNm() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpTs() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpApplNm() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpApplVrsnNbr() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("test");
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpApplDvcNm() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("");
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
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpApplDvcMacAddr() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("CRU");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpApplDvcNwIpAddr() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpCnsrRecTxtr() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

	@Test(expected = com.delta.cru.excp.BsnObjExcp.class)
	public void testGetHdrVoExcpEmplId() throws BsnObjExcp {
		hdrListVlues = new ArrayList<String>();
		hdrListVlues.add("0000305574");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("0000722727");
		hdrListVlues.add("test");
		hdrListVlues.add("test16May218");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("test");
		hdrListVlues.add("application/json");
		hdrListVlues.add("test");
		hdrListVlues.add("");
		hdrListVlues.add("test");
		Assert.assertNotNull(HeaderVo.createReqHeader(hdrListVlues));
	}

}
package com.delta.cru.unttest.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.bo.LogMsgBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.utils.CmnUtils;

@RunWith(MockitoJUnitRunner.class)
public class CmnUtilsTest {
	@InjectMocks
	private CmnUtils cmnUtils;
	@Mock
	private LogMsgBoIfc logBo;
	@Mock
	JoinPoint joinPoint;
	@Mock
	CodeSignature codeSignature;
	List<String> inpValues;
	List<String> inpPrmNm;
	List<String> hdrListVlues = null;
	public static Map<String, String> txnIdMap;

	@Before
	public void setUp() throws Exception {
		inpValues = new ArrayList<String>();
		inpPrmNm = new ArrayList<String>();
		inpValues.add(this.getClass().getSimpleName());
		txnIdMap = new HashMap<>();
		txnIdMap.put("txnId", null);
		inpPrmNm.add("classNm");
		inpPrmNm.add("mthdNm");
	}

	@Test
	public void gnrtTrnsctionIdTest() {
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId());
	}

	@Test
	public void gnrtTrnsctionIdTestWithNullTxnId() {
		Map<String,String> txnIdMap=CmnUtils.getTxnidmap();
		txnIdMap.put("txnId", null);
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId());
	}
	
	@Test
	public void gnrtTrnsctionIdTestWithNonNullTxnId() {
		Map<String,String> txnIdMap=CmnUtils.getTxnidmap();
		txnIdMap.put("txnId", "test");
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId());
	}
	
	@Test
	public void gnrtTrnsctionIdTestDfltVal() {
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId());
	}

	@Test
	public void gnrtTrnsctionIdTestInp() {
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId("test"));
	}

	@Test
	public void gnrtTrnsctionIdTest2() {
		Map<String,String> txnIdMap=CmnUtils.getTxnidmap();
		txnIdMap.put("txnId", "test");
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(""));
	}
	
	@Test
	public void gnrtTrnsctionIdTest3() {
		Map<String,String> txnIdMap=CmnUtils.getTxnidmap();
		txnIdMap.put("txnId", null);
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(""));
	}
	
	@Test
	public void gnrtTrnsctionIdFrmMapWithNullTxnId() {
		Map<String,String> txnIdMap=CmnUtils.getTxnidmap();
		txnIdMap.put("txnId", "test");
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(null));
	}
	
	@Test
	public void gnrtTrnsctionIdTest4() {
		Map<String,String> txnIdMap=CmnUtils.getTxnidmap();
		txnIdMap.put("txnId", null);
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(null));
	}
	
	@Test
	public void gnrtTrnsctionIdFrmMap() {
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(null));
	}


	
	@Test
	public void gnrtTrnsctionIdTestInpNullVlue() {
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(null));
	}

	@Test
	public void gnrtTrnsctionIdTestInpEmptyVlue() {
		Assert.assertNotNull(CmnUtils.gnrtTrnsctionId(""));
	}

	@Test
	public void testGetInpPrmNms() {
		String[] prmNames = { "classNm", "mthdNm" };
		Mockito.when(joinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getParameterNames()).thenReturn(prmNames);
		Assert.assertNotNull(CmnUtils.getInpPrmNms(joinPoint));
	}

	@Test
	public void testGetInpPrmVlus() {
		String[] prmNames = { "classNm", "mthdNm" };
		Mockito.when(joinPoint.getArgs()).thenReturn(prmNames);
		Assert.assertNotNull(CmnUtils.getInpPrmVlus(joinPoint));
	}

	@Test
	public void testGetInpPrmNullVlus() {
		String[] prmNames = { null, "mthdNm" };
		Mockito.when(joinPoint.getArgs()).thenReturn(prmNames);
		Assert.assertNotNull(CmnUtils.getInpPrmVlus(joinPoint));
	}

	@Test
	public void testRplcTxtPrms() throws BsnObjExcp {
		inpValues.add("testRplcTxtPrms");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn("Entering @className.@methodName.");
		String logMsg = cmnUtils.getLogMsgTxt("1000", inpValues, null);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals("Entering CmnUtilsTest.testRplcTxtPrms.", logMsg);

	}

	@Test
	public void testRplcTxtPrmsNoMtch() throws BsnObjExcp {
		inpValues.add("testRplcTxtPrmsNoMtch");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn("Entering @clssName.@mthodName.");
		String logMsg = cmnUtils.getLogMsgTxt("1000", inpValues, null);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals("Entering @clssName.@mthodName.", logMsg);

	}

	@Test
	public void testRplcLstPrms() throws BsnObjExcp {
		inpValues.add("testRplcLstPrms");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn("Parameters are @listQuote.");
		String logMsg = cmnUtils.getLogMsgTxt("1000", null, inpValues);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals("Parameters are 'CmnUtilsTest','testRplcLstPrms'.", logMsg);

	}

	@Test
	public void testRplcLstPrmsNoMtch() {
		inpValues.add("testRplcLstPrms");
		String logMsg = cmnUtils.rplcLstPrms("Parameters are @lstQuote.", inpValues);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals("Parameters are @lstQuote.", logMsg);
	}

	@Test
	public void testRplcLstPrmsBrckt() throws BsnObjExcp {
		inpValues.add("testRplcLstPrms");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn("Parameters are @listBracket.");
		String logMsg = cmnUtils.getLogMsgTxt("1000", null, inpValues);
		Assert.assertNotNull(logMsg);
	}

	@Test
	public void testRplcLstPrmsNoMtch2() {
		inpValues.add("testRplcLstPrms");
		String logMsg = cmnUtils.rplcLstPrms("Parameters are @lstBracket.", inpValues);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals("Parameters are @lstBracket.", logMsg);
	}

	@Test
	public void testGetInpPrmsMap() {
		inpValues.add("testRplcTxtPrms");
		Map<String, String> inpPrmMap = CmnUtils.getInpPrmsMap(inpPrmNm, inpValues);
		Assert.assertNotNull(inpPrmMap);
		Assert.assertEquals(this.getClass().getSimpleName(), inpPrmMap.get("classNm"));
	}

	@Test
	public void testGetLogMsgTxt() throws BsnObjExcp {
		inpValues.add("testGetLogMsgTxt");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn("Entering @className.@methodName.");
		String logMsg = cmnUtils.getLogMsgTxt("1000", inpValues, null);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals("Entering CmnUtilsTest.testGetLogMsgTxt.", logMsg);
	}

	@Test
	public void testGetLogMsgTxtFrLst() throws BsnObjExcp {
		inpValues.add("testGetLogMsgTxt");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn("Parameters are @listBracket.");
		String logMsg = cmnUtils.getLogMsgTxt("1000", null, inpValues);
		Assert.assertNotNull(logMsg);
	}

	@Test
	public void testGetLogMsgTxtNull() throws BsnObjExcp {
		inpValues.add("testGetLogMsgTxt");
		Mockito.when(logBo.getLogMsg("1000")).thenReturn(null);
		String logMsg = cmnUtils.getLogMsgTxt("1000", null, inpValues);
		Assert.assertNotNull(logMsg);
		Assert.assertEquals(
				"There is some issue in Log Messages from DB.Please check it in Z_LOG_MSG table for Logging", logMsg);
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
		Assert.assertNotNull(CmnUtils.getHdrVoMap(hdrListVlues));
	}
}

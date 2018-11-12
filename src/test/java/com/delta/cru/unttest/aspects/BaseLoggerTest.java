/**
 * 
 */
package com.delta.cru.unttest.aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.aspects.BaseLogger;
import com.delta.cru.cnfg.CnfgReader;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.utils.CmnUtils;
import com.delta.cru.utils.LoggingApiClient;

@RunWith(MockitoJUnitRunner.class)
public class BaseLoggerTest {
	@InjectMocks
	BaseLogger baseLogger;
	@Mock
	private CmnUtils cmnUtils;
	@Mock
	JoinPoint joinPoint;
	@Mock
	ProceedingJoinPoint proceedingJoinPoint;
	@Mock
	CodeSignature codeSignature;
	@Mock
	private LoggingApiClient loggingApiClient;
	@Mock
	private CnfgReader cnfgReader;
	List<String> inpValues;
	List<String> inpPrmNm;
	List<String> logMsgInpPrms;

	@Before
	public void setUp() throws Exception {
		inpValues = new ArrayList<String>();
		inpPrmNm = new ArrayList<String>();
		inpValues.add(this.getClass().getSimpleName());
		logMsgInpPrms = new ArrayList<String>();
		logMsgInpPrms.add(this.getClass().getSimpleName());
		inpPrmNm.add("classNm");
		inpPrmNm.add("mthdNm");
	}

	@Test
	public void testBeforeServiceIsCalled() throws Throwable {
		String[] prmValues = {};
		Whitebox.setInternalState(baseLogger, "logHdrInfo", "true");
		Mockito.when(joinPoint.getTarget()).thenReturn(this);
		Mockito.when(joinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testBeforeServiceIsCalled");
		Mockito.when(joinPoint.getArgs()).thenReturn(prmValues);
		//baseLogger.beforeServiceIsCalled(joinPoint);
	}

	@Test
	public void testBeforeServiceIsCalledForHdrMQ() throws Throwable {
		String[] prmValues = {};
		Whitebox.setInternalState(baseLogger, "logHdrInfo", "false");
		Mockito.when(joinPoint.getTarget()).thenReturn(this);
		Mockito.when(joinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testBeforeServiceIsCalled");
		Mockito.when(joinPoint.getArgs()).thenReturn(prmValues);
		//baseLogger.beforeServiceIsCalled(joinPoint);
	}

	@Test
	public void testBeforeServiceIsCalledForNullVlueForHdrMQ() throws Throwable {
		String[] prmValues = {};
		Whitebox.setInternalState(baseLogger, "logHdrInfo", null);
		Mockito.when(joinPoint.getTarget()).thenReturn(this);
		Mockito.when(joinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testBeforeServiceIsCalled");
		Mockito.when(joinPoint.getArgs()).thenReturn(prmValues);
		//baseLogger.beforeServiceIsCalled(joinPoint);
	}

	@Test
	public void testAfterMethodReturnSucessfully() throws BsnObjExcp {
		//baseLogger.afterMethodReturnSucessfully(joinPoint);
	}

	@Test
	public void testLogExcptions() throws Throwable {
		Exception ex = new Exception("PersistenceException");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
	//	baseLogger.hndlngExcptn(proceedingJoinPoint);

	}
	
	@Test
	public void testNullExcptions() throws Throwable {
		Exception ex = new Exception();
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);

	}


	@Test
	public void testLogSqlExcptions() throws Throwable {
		Exception ex = new Exception("SQL Exception");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);
	}

	@Test
	public void testLogIndexOutOfBoundExcptions() throws Throwable {
		Exception ex = new Exception("IndexOutOfBound");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);
	}

	@Test
	public void testLogHostNotFoundExcptions() throws Throwable {
		Exception ex = new Exception("Host");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);
	}

	@Test
	public void testLogHdrNtVldExcptions() throws Throwable {
		Exception ex = new Exception("Header Info is not Valid");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);
	}

	@Test
	public void testLogNullPtrExcptions() throws Throwable {
		Exception ex = new Exception("Null");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);
	}

	@Test
	public void testLogUnknwnExcptions() throws Throwable {
		Exception ex = new Exception("UnKnown");
		Mockito.when(proceedingJoinPoint.getTarget()).thenReturn(this);
		Mockito.when(proceedingJoinPoint.getSignature()).thenReturn(codeSignature);
		Mockito.when(codeSignature.getName()).thenReturn("testLogExcptions");
		Mockito.when(proceedingJoinPoint.proceed()).thenThrow(ex);
		//baseLogger.hndlngExcptn(proceedingJoinPoint);
	}

}

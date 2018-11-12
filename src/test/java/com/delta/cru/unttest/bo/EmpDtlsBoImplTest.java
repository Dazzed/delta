package com.delta.cru.unttest.bo;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.bo.EmpDtlsBoImpl;
import com.delta.cru.dao.EmpDaoIfc;
import com.delta.cru.dao.mapper.EmpMapperIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpDtlsBoImplTest {
	public static final String EMP_PH_NBR = generateEmpNbr();
	@Mock
	private EmpDaoIfc daoIfc;
	@Mock
	private EmpMapperIfc mapperIfc;
	@InjectMocks
	private EmpDtlsBoImpl boImpl;

	@Test
	public void fndEmpTest() throws BsnObjExcp, DataAcesExcp {
		Mockito.when(daoIfc.fndEmp(Mockito.anyString())).thenReturn(TestData.getEmpData());
		List<EmpNmeVo> responseEntity = boImpl.fndEmp(TestData.EMP_ID);
		Assert.assertNotNull(responseEntity);
	}

	@Test(expected = BsnObjExcp.class)
	public void fndEmpTest_throwsBsnObjExcp() throws BsnObjExcp, DataAcesExcp {
		Mockito.when(daoIfc.fndEmp(Mockito.anyString())).thenThrow(DataAcesExcp.class);
		boImpl.fndEmp(TestData.EMP_ID);
	}

	@Test
	public void fndEmpPhnsTest() throws BsnObjExcp, DataAcesExcp {
		Mockito.when(daoIfc.fndEmpPhns(Mockito.anyString())).thenReturn(TestData.getEmpPhData());
		List<EmpPhVo> responseEntity = boImpl.fndEmpPhns(TestData.EMP_ID);
		Assert.assertNotNull(responseEntity);
	}

	@Test(expected = BsnObjExcp.class)
	public void fndEmpPhnsTest_throwsBsnObjExcp() throws BsnObjExcp, DataAcesExcp {
		Mockito.when(daoIfc.fndEmpPhns(Mockito.anyString())).thenThrow(DataAcesExcp.class);
		boImpl.fndEmpPhns(TestData.EMP_ID);
	}

	@Test
	public void convertDateFormatTest() throws BsnObjExcp {
		boImpl.convertDateFormat("2014-10-05 15:23:01");
	}

	@Test(expected = BsnObjExcp.class)
	public void convertDateFormat_throwsBsnObjExcpTest() throws BsnObjExcp {
		Mockito.when(boImpl.convertDateFormat("12-JAN-19")).thenThrow(ParseException.class);
		boImpl.convertDateFormat("12-JAN-19");
	}

	public static String generateEmpNbr() {
		int x1 = ThreadLocalRandom.current().ints(100000000, 1000000000).distinct().limit(1).findAny().getAsInt();
		String str = Integer.toString(x1) + "2";
		return str;
	}

	@Test
	public void insPhnTest() throws BsnObjExcp, ParseException {
		boImpl.insPhn(TestData.insertDataSetUp());
	}

	@Test
	public void insPhnTest_withEmptyParams() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		empPhInsVo.setEffDate(null);
		empPhInsVo.setCrtnGdttmDate(null);
		empPhInsVo.setLstUpdtGdttmDate(null);
		Mockito.when(daoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		boImpl.insPhn(empPhInsVo);
	}

	@Test(expected = BsnObjExcp.class)
	public void insPhnTest_throwsBsnObjExcpTest() throws BsnObjExcp, ParseException, DataAcesExcp {
		Mockito.doThrow(new DataAcesExcp("Error")).when(daoIfc).insPhn(Mockito.any(EmpPhVo.class));
		boImpl.insPhn(TestData.insertDataSetUp());
	}

	@Test
	public void updtPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo empPhUpdVo = TestData.updateDataSetUp();
		empPhUpdVo.setEmplPhNum(StringUtils.EMPTY);
		empPhUpdVo.setEffDate(StringUtils.EMPTY);
		empPhUpdVo.setNewEffDate(StringUtils.EMPTY);
		empPhUpdVo.setPhTypCode(StringUtils.EMPTY);
		boImpl.updtPhn(empPhUpdVo);
	}

	@Test
	public void updtPhnTest_withEmptyParams() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo updVo = TestData.updateDataSetUp();
		updVo.setCrtnGdttmDate(null);
		updVo.setLstUpdtGdttmDate(null);
		updVo.setLstUpdtSqNum(0L);
		Mockito.when(daoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		boImpl.updtPhn(updVo);
	}

	@Test
	public void updtPhnTest_withEmptyParams2() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo updVo = TestData.updateDataSetUp();
		updVo.setEmplNewPhNum("");
		updVo.setEffDate("");
		updVo.setNewEffDate("");
		updVo.setNewPhTypCode("");
		Mockito.when(daoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		boImpl.updtPhn(updVo);
		Assert.assertNull(updVo.getEmplNewPhNum());
		Assert.assertNull(updVo.getEffDate());
		Assert.assertNull(updVo.getNewEffDate());
		Assert.assertNull(updVo.getNewPhTypCode());
	}
	
	@Test
	public void updtPhnTest_withNonEmptyParams() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo updVo = TestData.updateDataSetUp();
		updVo.setEmplNewPhNum("DUMMY");
		updVo.setEffDate("DUMMY");
		updVo.setNewEffDate("DUMMY");
		updVo.setNewPhTypCode("DUMMY");
		Mockito.when(daoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		boImpl.updtPhn(updVo);
		Assert.assertNotNull(updVo.getEmplNewPhNum());
		Assert.assertNotNull(updVo.getEffDate());
		Assert.assertNotNull(updVo.getNewEffDate());
		Assert.assertNotNull(updVo.getNewPhTypCode());
	}
	
	@Test(expected = BsnObjExcp.class)
	public void updtPhnTest__throwsBsnObjExcpTest() throws BsnObjExcp, ParseException, DataAcesExcp {
		Mockito.doThrow(new DataAcesExcp("Error")).when(daoIfc).updtPhn(Mockito.any(EmpPhVo.class));
		EmpPhVo empPhUpdVo = TestData.updateDataSetUp();
		empPhUpdVo.setEmplPhNum(StringUtils.EMPTY);
		empPhUpdVo.setEffDate(StringUtils.EMPTY);
		empPhUpdVo.setNewEffDate(StringUtils.EMPTY);
		empPhUpdVo.setPhTypCode(StringUtils.EMPTY);
		boImpl.updtPhn(empPhUpdVo);
	}

	@Test
	public void delPhnTest() throws BsnObjExcp, ParseException {
		boImpl.delPhn(TestData.deleteDataSetUp());
	}

	@Test(expected = BsnObjExcp.class)
	public void delPhnTest_throwsBsnObjExcpTest() throws BsnObjExcp, ParseException, DataAcesExcp {
		Mockito.doThrow(new DataAcesExcp("Error")).when(daoIfc).delPhn(Mockito.any(EmpPhVo.class));
		boImpl.delPhn(TestData.deleteDataSetUp());
	}

}

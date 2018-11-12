package com.delta.cru.unttest.bo;

import java.text.ParseException;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.bo.EmpDtlsSPBoImpl;
import com.delta.cru.dao.EmpSPDaoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpPhVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpSPDtlsBoImplTest {
	public static final String EMP_PH_NBR = generateEmpNbr();
	@Mock
	private EmpSPDaoIfc spDaoIfc;
	@InjectMocks
	private EmpDtlsSPBoImpl spBoImpl;

	@Test
	public void insPhnTest() throws BsnObjExcp, ParseException {
		spBoImpl.insPhnBySP(TestData.insertDataSetUp());
	}

	@Test(expected = BsnObjExcp.class)
	public void insPhnTest_throwsDataAcesExcp() throws BsnObjExcp, ParseException, DataAcesExcp {
		Mockito.doThrow(new DataAcesExcp("Error")).when(spDaoIfc).insPhnBySP(Mockito.any(EmpPhVo.class));
		spBoImpl.insPhnBySP(TestData.insertDataSetUp());
	}

	@Test
	public void insPhnTest_withEmptyParams() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo insVo = TestData.insertDataSetUp();
		insVo.setEffDate(null);
		insVo.setCrtnGdttmDate(null);
		insVo.setLstUpdtGdttmDate(null);
		Mockito.when(spDaoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		spBoImpl.insPhnBySP(insVo);
	}

	@Test
	public void updtPhnTest() throws BsnObjExcp, ParseException {
		spBoImpl.updtPhnBySP(TestData.updateDataSetUp());
	}

	@Test(expected = BsnObjExcp.class)
	public void updtPhnTest__throwsDataAcesExcp() throws BsnObjExcp, ParseException, DataAcesExcp {
		Mockito.doThrow(new DataAcesExcp("Error")).when(spDaoIfc).updtPhnBySP(Mockito.any(EmpPhVo.class));
		spBoImpl.updtPhnBySP(TestData.updateDataSetUp());
	}

	@Test
	public void updtPhnTest_withEmptyParams() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo updVo = TestData.updateDataSetUp();
		updVo.setEmplPhNum(null);
		updVo.setEffDate(null);
		updVo.setPhTypCode(null);
		updVo.setCrtnGdttmDate(null);
		updVo.setLstUpdtGdttmDate(null);
		updVo.setLstUpdtSqNum(0l);
		Mockito.when(spDaoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		spBoImpl.updtPhnBySP(updVo);
	}

	@Test
	public void updtPhnTest_withEmptyParams2() throws BsnObjExcp, ParseException, DataAcesExcp {
		EmpPhVo updVo = TestData.updateDataSetUp();
		updVo.setEmplNewPhNum("");
		updVo.setEffDate("");
		updVo.setNewEffDate("");
		updVo.setNewPhTypCode("");
		Mockito.when(spDaoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		spBoImpl.updtPhnBySP(updVo);
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
		Mockito.when(spDaoIfc.getSysDate()).thenReturn(new java.sql.Date(new java.util.Date().getTime()));
		spBoImpl.updtPhnBySP(updVo);
		Assert.assertNotNull(updVo.getEmplNewPhNum());
		Assert.assertNotNull(updVo.getEffDate());
		Assert.assertNotNull(updVo.getNewEffDate());
		Assert.assertNotNull(updVo.getNewPhTypCode());
	}
	
	@Test
	public void delPhnTest() throws BsnObjExcp, ParseException {
		spBoImpl.delPhnBySP(TestData.deleteDataSetUp());
	}

	@Test(expected = BsnObjExcp.class)
	public void delPhnTest_throwsDataAcesExcp() throws DataAcesExcp, BsnObjExcp, ParseException {
		Mockito.doThrow(new DataAcesExcp("Error")).when(spDaoIfc).delPhnBySP(Mockito.any(EmpPhVo.class));
		spBoImpl.delPhnBySP(TestData.deleteDataSetUp());
	}

	public static String generateEmpNbr() {
		int x1 = ThreadLocalRandom.current().ints(100000000, 1000000000).distinct().limit(1).findAny().getAsInt();
		String str = Integer.toString(x1) + "2";
		return str;
	}

}

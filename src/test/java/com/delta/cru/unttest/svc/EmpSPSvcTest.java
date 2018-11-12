package com.delta.cru.unttest.svc;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.bo.EmpDtlsSPBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.svc.EmpSPSvc;
import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpPhVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpSPSvcTest {

	@InjectMocks
	private EmpSPSvc svc;

	@Mock
	private EmpDtlsSPBoIfc bo;
	
	@Test
	public void insPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		Mockito.when(bo.insPhnBySP(empPhInsVo)).thenReturn(TestData.DUMMY_NBR);
		svc.insPhnBySPV1(empPhInsVo);

	}
	
	@Test
	public void insPhnTest_noRowImptd() throws BsnObjExcp, ParseException {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		Mockito.when(bo.insPhnBySP(empPhInsVo)).thenReturn(TestData.DUMMY_ROWIMPTD_FORSP_NBR);
		svc.insPhnBySPV1(empPhInsVo);

	}

	@Test
	public void insPhnTest_throwsBsnObjExcp() throws BsnObjExcp, ParseException {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		Mockito.when(bo.insPhnBySP(empPhInsVo)).thenThrow(new BsnObjExcp(new Exception()));
		svc.insPhnBySPV1(empPhInsVo);

	}

	@Test
	public void updtPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo empPhUpdVo = TestData.updateDataSetUp();
		Mockito.when(bo.updtPhnBySP(empPhUpdVo)).thenReturn(TestData.DUMMY_NBR);
		svc.updtPhnBySPV1(empPhUpdVo);

	}
	
	@Test
	public void updtPhnTest_noRowImptd() throws BsnObjExcp, ParseException {
		EmpPhVo empPhUpdVo = TestData.updateDataSetUp();
		Mockito.when(bo.updtPhnBySP(empPhUpdVo)).thenReturn(TestData.DUMMY_ROWIMPTD_FORSP_NBR);
		svc.updtPhnBySPV1(empPhUpdVo);

	}
	
	@Test
	public void updtPhnTest_throwsBsnObjExcp() throws BsnObjExcp, ParseException {
		EmpPhVo empPhUpdVo = TestData.updateDataSetUp();
		Mockito.when(bo.updtPhnBySP(empPhUpdVo)).thenThrow(new BsnObjExcp(new Exception()));
		svc.updtPhnBySPV1(empPhUpdVo);

	}

	@Test
	public void delPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo pkVo = TestData.deleteDataSetUp();
		Mockito.when(bo.delPhnBySP(pkVo)).thenReturn(TestData.DUMMY_NBR);
		svc.delPhnBySPV1(pkVo);

	}
	
	@Test
	public void delPhnTest_noRowImptd() throws BsnObjExcp, ParseException {
		EmpPhVo pkVo = TestData.deleteDataSetUp();
		Mockito.when(bo.delPhnBySP(pkVo)).thenReturn(TestData.DUMMY_ROWIMPTD_FORSP_NBR);
		svc.delPhnBySPV1(pkVo);

	}

	@Test
	public void delPhnTest_throwsBsnObjExcp() throws BsnObjExcp, ParseException {
		EmpPhVo pkVo = TestData.deleteDataSetUp();
		Mockito.when(bo.delPhnBySP(pkVo)).thenThrow(new BsnObjExcp(new Exception()));
		svc.delPhnBySPV1(pkVo);

	}
}

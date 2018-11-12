package com.delta.cru.unttest.svc;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.bo.EmpDtlsBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.svc.EmpSvc;
import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpPhVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpSvcTest {

	@InjectMocks
	private EmpSvc svc;

	@Mock
	private EmpDtlsBoIfc bo;

	@Test
	public void fndEmpTest() throws BsnObjExcp {
		Mockito.when(bo.fndEmp(TestData.EMP_ID)).thenReturn(TestData.fndEmpSetUp());
		svc.fndEmpV1(TestData.EMP_ID);

	}
	
	@Test
	public void fndEmpTest_withNoParam() throws BsnObjExcp {
		svc.fndEmpV1(TestData.EMPTY_PARAM);

	}
	
	@Test
	public void fndEmpTest_EmpNotFound() throws BsnObjExcp {
		Mockito.when(bo.fndEmp(TestData.EMP_ID)).thenReturn(TestData.fndEmpSetUp_emptyList());
		svc.fndEmpV1(TestData.EMP_ID);

	}
	
	@Test
	public void fndEmpTest_throwsBsnObjExcp() throws BsnObjExcp {
		Mockito.when(bo.fndEmp(TestData.EMP_ID)).thenThrow(new BsnObjExcp(new Exception()));
		svc.fndEmpV1(TestData.EMP_ID);

	}
	
	@Test
	public void fndEmpTestV2() throws BsnObjExcp {
		Mockito.when(bo.fndEmp(TestData.EMP_ID)).thenReturn(TestData.fndEmpSetUp());
		svc.fndEmpV2(TestData.EMP_ID);

	}
	
	@Test
	public void fndEmpTestV2_withNoParam() throws BsnObjExcp {
		svc.fndEmpV2(TestData.EMPTY_PARAM);

	}
	
	@Test
	public void fndEmpTestV2_EmpNotFound() throws BsnObjExcp {
		Mockito.when(bo.fndEmp(TestData.EMP_ID)).thenReturn(TestData.fndEmpSetUp_emptyList());
		svc.fndEmpV2(TestData.EMP_ID);

	}
	
	@Test
	public void fndEmpTestV2_throwsBsnObjExcp() throws BsnObjExcp {
		Mockito.when(bo.fndEmp(TestData.EMP_ID)).thenThrow(new BsnObjExcp(new Exception()));
		svc.fndEmpV2(TestData.EMP_ID);

	}

	@Test
	public void fndEmpPhnsTest() throws BsnObjExcp {
		Mockito.when(bo.fndEmpPhns(TestData.EMP_ID)).thenReturn(TestData.fndEmpPhnsSetUp());
		svc.fndEmpPhnsV1(TestData.EMP_ID);

	}
	
	@Test
	public void fndEmpPhnsTest_withEmptyParam() throws BsnObjExcp {
		svc.fndEmpPhnsV1(TestData.EMPTY_PARAM);

	}
	
	@Test
	public void fndEmpPhnsTest_EmpNotFound() throws BsnObjExcp {
		Mockito.when(bo.fndEmpPhns(TestData.EMP_ID)).thenReturn(TestData.fndEmpPhnsSetUp_emptyList());
		svc.fndEmpPhnsV1(TestData.EMP_ID);

	}
	
	
	@Test
	public void fndEmpPhnsTest_throwsBsnObjExcp() throws BsnObjExcp {
		Mockito.when(bo.fndEmpPhns(TestData.EMP_ID)).thenThrow(new BsnObjExcp(new Exception()));
		svc.fndEmpPhnsV1(TestData.EMP_ID);

	}

	@Test
	public void insPhnTest_noRowImptd() throws BsnObjExcp, ParseException {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		Mockito.when(bo.insPhn(empPhInsVo)).thenReturn(TestData.DUMMY_ROWIMPTD_NBR);
		svc.insPhnV1(empPhInsVo);

	}
	
	@Test
	public void insPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		Mockito.when(bo.insPhn(empPhInsVo)).thenReturn(TestData.DUMMY_NBR);
		svc.insPhnV1(empPhInsVo);

	}
	
	@Test
	public void insPhnTest_throwsBsnObjExcp() throws BsnObjExcp, ParseException {
		EmpPhVo empPhInsVo = TestData.insertDataSetUp();
		Mockito.when(bo.insPhn(empPhInsVo)).thenThrow(new BsnObjExcp(new Exception()));
		svc.insPhnV1(empPhInsVo);

	}

	@Test
	public void updtPhnTest_noRowImptd() throws BsnObjExcp, ParseException {
		EmpPhVo updVo = TestData.updateDataSetUp();
		Mockito.when(bo.updtPhn(updVo)).thenReturn(TestData.DUMMY_ROWIMPTD_NBR);
		svc.updtPhnV1(updVo);

	}
	
	@Test
	public void updtPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo updVo = TestData.updateDataSetUp();
		Mockito.when(bo.updtPhn(updVo)).thenReturn(TestData.DUMMY_NBR);
		svc.updtPhnV1(updVo);

	}
	
	@Test
	public void updtPhnTest_throwsBsnObjExcp() throws BsnObjExcp, ParseException {
		EmpPhVo empPhUpdVo = TestData.updateDataSetUp();
		Mockito.when(bo.updtPhn(empPhUpdVo)).thenThrow(new BsnObjExcp(new Exception()));
		svc.updtPhnV1(empPhUpdVo);

	}

	@Test
	public void delPhnTest() throws BsnObjExcp, ParseException {
		EmpPhVo pkVo = TestData.deleteDataSetUp();
		Mockito.when(bo.delPhn(pkVo)).thenReturn(TestData.DUMMY_NBR);
		svc.delPhnV1(pkVo);

	}
	
	@Test
	public void delPhnTest_noRowImptd() throws BsnObjExcp, ParseException {
		EmpPhVo pkVo = TestData.deleteDataSetUp();
		Mockito.when(bo.delPhn(pkVo)).thenReturn(TestData.DUMMY_ROWIMPTD_NBR);
		svc.delPhnV1(pkVo);

	}

	@Test
	public void delPhnTest_throwsBsnObjExcp() throws BsnObjExcp, ParseException {
		EmpPhVo pkVo = TestData.deleteDataSetUp();
		Mockito.when(bo.delPhn(pkVo)).thenThrow(new BsnObjExcp(new Exception()));
		svc.delPhnV1(pkVo);

	}
}

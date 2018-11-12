package com.delta.cru.unttest.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.delta.cru.dao.EmpDaoImpl;
import com.delta.cru.dao.mapper.EmpMapperIfc;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpDaoImplTest {
	@InjectMocks
	private EmpDaoImpl daoImpl;
	@Mock
	private EmpMapperIfc mapperIfc;

	@Test
	public void fndEmpTest() throws DataAcesExcp {
		List<EmpNmeVo> empl = new ArrayList<>();
		Mockito.when(mapperIfc.fndEmp(Mockito.anyString())).thenReturn(empl);
		List<EmpNmeVo> responseEntity = daoImpl.fndEmp(TestData.EMP_ID);
		Assert.assertNotNull(responseEntity);
	}

	@Test(expected = DataAcesExcp.class)
	public void fndEmpTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(daoImpl.fndEmp(Mockito.anyString()))
				.thenThrow(new DataAccessException("DataAccess Exception is caught") {
					private static final long serialVersionUID = 1L;
				});
		daoImpl.fndEmp("1234");
	}

	@Test
	public void fndEmpPhnsTest() throws DataAcesExcp {
		Mockito.when(daoImpl.fndEmpPhns(Mockito.anyString())).thenReturn(new ArrayList<EmpPhVo>());
		List<EmpPhVo> responseEntity = daoImpl.fndEmpPhns("1234");
		Assert.assertNotNull(responseEntity);
	}

	@Test(expected = DataAcesExcp.class)
	public void fndEmpPhnsTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(daoImpl.fndEmpPhns(Mockito.anyString()))
				.thenThrow(new DataAccessException("DataAccess Exception is caught") {
					private static final long serialVersionUID = 1L;
				});
		daoImpl.fndEmpPhns("1234");
	}

	@Test
	public void getSeqTest() throws DataAcesExcp {
		Mockito.when(daoImpl.getSeq()).thenReturn(new Long(100000L));
		Assert.assertNotNull(daoImpl.getSeq());
	}

	@Test(expected = DataAcesExcp.class)
	public void getSysDateTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(daoImpl.getSysDate()).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		daoImpl.getSysDate();
	}

	@Test(expected = DataAcesExcp.class)
	public void insPhnTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(daoImpl.insPhn(null)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		daoImpl.insPhn(null);
	}

	@Test(expected = DataAcesExcp.class)
	public void delPhnTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(daoImpl.delPhn(null)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		daoImpl.delPhn(null);
	}

	@Test(expected = DataAcesExcp.class)
	public void updtPhnTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(daoImpl.updtPhn(null)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		daoImpl.updtPhn(null);
	}

}

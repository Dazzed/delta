package com.delta.cru.unttest.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;

import com.delta.cru.dao.EmpSPDaoImpl;
import com.delta.cru.dao.mapper.EmpSPMapperIfc;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpPhVo;

@RunWith(MockitoJUnitRunner.class)
public class EmpSPDaoImplTest {
	@InjectMocks
	private EmpSPDaoImpl spDaoImpl;
	@Mock
	private EmpSPMapperIfc spMapperIfc;

	@Test
	public void getSeqTest() throws DataAcesExcp {
		Mockito.when(spDaoImpl.getSeq()).thenReturn(new Long(100000L));
		Assert.assertNotNull(spDaoImpl.getSeq());
	}

	@Test(expected = DataAcesExcp.class)
	public void getSysDateTest_throwsDataAcesExcp() throws DataAcesExcp {
		Mockito.when(spDaoImpl.getSysDate()).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.getSysDate();
	}

	@Test(expected = DataAcesExcp.class)
	public void insPhnTest_throwsDataAcesExcp() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("-1");
		empPh.setRtnMsg("FAILED");
		Mockito.when(spDaoImpl.insPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.insPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void insPhnTest_success() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("0");
		empPh.setRtnMsg("Successfully Inserted");
		Mockito.when(spDaoImpl.insPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.insPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void insPhnTest_notSuccess1() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("5");
		empPh.setRtnMsg("Successfully Inserted_Test");
		Mockito.when(spDaoImpl.insPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.insPhnBySP(empPh);
	}
	
	@Test(expected = DataAcesExcp.class)
	public void insPhnTest_notSuccess2() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("5");
		empPh.setRtnMsg("Successfully Inserted");
		Mockito.when(spDaoImpl.insPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.insPhnBySP(empPh);
	}
	
	@Test(expected = DataAcesExcp.class)
	public void insPhnTest_notSuccess3() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("0");
		empPh.setRtnMsg("Successfully Inserted_Test");
		Mockito.when(spDaoImpl.insPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.insPhnBySP(empPh);
	}
	
	@Test(expected = DataAcesExcp.class)
	public void delPhnTest_throwsDataAcesExcp() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("-1");
		empPh.setRtnMsg("FAILED");
		Mockito.when(spDaoImpl.delPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.delPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void delPhnTest_success() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("0");
		empPh.setRtnMsg("Successfully Deleted");
		Mockito.when(spDaoImpl.delPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.delPhnBySP(empPh);
	}
	
	@Test(expected = DataAcesExcp.class)
	public void delPhnTest_notSuccess1() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("5");
		empPh.setRtnMsg("Successfully Deleted_Test");
		Mockito.when(spDaoImpl.delPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.delPhnBySP(empPh);
	}
	@Test(expected = DataAcesExcp.class)
	public void delPhnTest_notSuccess2() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("5");
		empPh.setRtnMsg("Successfully Deleted");
		Mockito.when(spDaoImpl.delPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.delPhnBySP(empPh);
	}
	@Test(expected = DataAcesExcp.class)
	public void delPhnTest_notSuccess3() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("0");
		empPh.setRtnMsg("Successfully Deleted_Test");
		Mockito.when(spDaoImpl.delPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.delPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void updtPhnTest_throwsDataAcesExcp() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("-1");
		empPh.setRtnMsg("FAILED");
		Mockito.when(spDaoImpl.updtPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.updtPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void updtPhnTest_success() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("0");
		empPh.setRtnMsg("Successfully Updated");
		Mockito.when(spDaoImpl.updtPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.updtPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void updtPhnTest_notSuccess1() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("5");
		empPh.setRtnMsg("Successfully Updated_Test");
		Mockito.when(spDaoImpl.updtPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.updtPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void updtPhnTest_notSuccess2() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("5");
		empPh.setRtnMsg("Successfully Updated");
		Mockito.when(spDaoImpl.updtPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.updtPhnBySP(empPh);
	}

	@Test(expected = DataAcesExcp.class)
	public void updtPhnTest_notSuccess3() throws DataAcesExcp {
		EmpPhVo empPh = new EmpPhVo();
		empPh.setRtnCd("0");
		empPh.setRtnMsg("Successfully Updated_Test");
		Mockito.when(spDaoImpl.updtPhnBySP(empPh)).thenThrow(new DataAccessException("DataAccess Exception is caught") {
			private static final long serialVersionUID = 1L;
		});
		spDaoImpl.updtPhnBySP(empPh);
	}

}

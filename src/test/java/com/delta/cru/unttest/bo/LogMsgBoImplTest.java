package com.delta.cru.unttest.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.bo.LogMsgBoImpl;
import com.delta.cru.dao.LogDaoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.unttest.TestData;

@RunWith(MockitoJUnitRunner.class)
public class LogMsgBoImplTest {
	@Mock
	private LogDaoIfc daoIfc;
	@InjectMocks
	private LogMsgBoImpl boImpl;

	@Test
	public void getLogMsgTest() throws BsnObjExcp {
		boImpl.getLogMsg(TestData.DUMMY);
	}

	@Test(expected = BsnObjExcp.class)
	public void getLogMsgExcpTest() throws BsnObjExcp, DataAcesExcp {
		Mockito.when(daoIfc.getLogMsg(Mockito.anyString())).thenThrow(DataAcesExcp.class);
		boImpl.getLogMsg(TestData.DUMMY);
	}
}

package com.delta.cru.unttest.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import com.delta.cru.dao.LogDaoImpl;
import com.delta.cru.dao.mapper.LogMapperIfc;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.unttest.TestData;

@RunWith(MockitoJUnitRunner.class)
public class LogDaoImplTest {
    @InjectMocks
    private LogDaoImpl logDao;

    @Mock
    private LogMapperIfc logMapper;
    
    @Test
    public void getLogMsgTest() throws DataAcesExcp {
        Mockito.when(logMapper.getLogMsg(Mockito.anyString())).thenReturn(Mockito.anyString());
        String responseEntity = logDao.getLogMsg(TestData.DUMMY);
        Assert.assertNotNull(responseEntity);
    }
    
    @Test(expected = DataAcesExcp.class)
    public void fndEmpTest_throwsDataAcesExcp() throws DataAcesExcp {
        Mockito.when(logMapper.getLogMsg(Mockito.anyString()))
                .thenThrow(new DataAccessException("DataAccess Exception is caught") {
                    private static final long serialVersionUID = 1L;
                });
        logDao.getLogMsg(TestData.DUMMY);
    }
}

package com.delta.cru.unttest.svc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.svc.AppErrorSvc;

@RunWith(MockitoJUnitRunner.class)
public class AppErrorSvcTest {
    @InjectMocks
    private AppErrorSvc appErrorSvc;

    @Test
    public void errorTest() throws BsnObjExcp {
        Assert.assertNotNull(appErrorSvc.error());
    }

    @Test
    public void getErrorPathTest() throws BsnObjExcp {
        Assert.assertNotNull(appErrorSvc.getErrorPath());
    }
}

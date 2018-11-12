package com.delta.cru.unttest.svc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmpSvcTest.class, EmpSPSvcTest.class, AppErrorSvcTest.class, BaseSvcTest.class })
public class SvcTestSuite {

}

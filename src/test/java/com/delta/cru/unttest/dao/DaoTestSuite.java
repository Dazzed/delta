package com.delta.cru.unttest.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.delta.cru.unttest.bo.LogMsgBoImplTest;

@RunWith(Suite.class)
@SuiteClasses({ EmpDaoImplTest.class, EmpSPDaoImplTest.class, LogDaoImplTest.class,
        LogMsgBoImplTest.class })
public class DaoTestSuite {

}

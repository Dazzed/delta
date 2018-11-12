package com.delta.cru.unttest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.delta.cru.unttest.aspects.ApplLoggerTest;
import com.delta.cru.unttest.aspects.BaseLoggerTest;
import com.delta.cru.unttest.aspects.ResponseHeaderAdviceTest;
import com.delta.cru.unttest.bo.BoTestSuite;
import com.delta.cru.unttest.cnfg.CnfgTestSuite;
import com.delta.cru.unttest.cnst.CnstTestSuite;
import com.delta.cru.unttest.dao.DaoTestSuite;
import com.delta.cru.unttest.excp.ExcpTestSuite;
import com.delta.cru.unttest.svc.SvcTestSuite;
import com.delta.cru.unttest.utils.UtilsTestSuite;
import com.delta.cru.unttest.vo.VoTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ BoTestSuite.class, DaoTestSuite.class, CnstTestSuite.class, SvcTestSuite.class,
        UtilsTestSuite.class, ApplicationTest.class,
        VoTestSuite.class, CnfgTestSuite.class, ExcpTestSuite.class,
        BaseLoggerTest.class,ApplLoggerTest.class,ResponseHeaderAdviceTest.class })

public class ApplicationUnitTestSuite {

}

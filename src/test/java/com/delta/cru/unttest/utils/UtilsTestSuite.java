package com.delta.cru.unttest.utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ErrorResponsesTest.class,ExcpHandlerTest.class, UtilsErrorResponseTest.class,
        CmnUtilsTest.class, LoggingApiClientTest.class })
public class UtilsTestSuite {

}

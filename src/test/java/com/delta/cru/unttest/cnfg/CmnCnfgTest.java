package com.delta.cru.unttest.cnfg;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.delta.cru.cnfg.CmnCnfg;
import com.delta.cru.cnfg.CnfgReader;

@RunWith(MockitoJUnitRunner.class)
public class CmnCnfgTest {
	@InjectMocks
	private CmnCnfg cmncnfg;
	@Mock
	private CnfgReader cnfgReader;

	@Test
	public void sessionFactoryTest() throws Exception {
		try {
			cmncnfg.sessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
    public void getOrigsAndCorsMapTest(){
	    List<String> orig = new ArrayList<>();
	    Mockito.when(cnfgReader.getAllowedOrigins()).thenReturn(orig);
	    cmncnfg.addCorsMappings(new CorsRegistry());
	    Assert.assertNotNull(cmncnfg.getOrigs());
    }

	@Test
    public void getOrigsAndCorsMapTest2(){
	    List<String> orig = new ArrayList<>();
	    orig.add("*");
	    orig.add("http://localhost:8080/");
	    Mockito.when(cnfgReader.getAllowedOrigins()).thenReturn(orig);
	    cmncnfg.addCorsMappings(new CorsRegistry());
	    Assert.assertNotNull(cmncnfg.getOrigs());
    }

	@Test
	public void testTxnMgr() {
		Assert.assertNotNull(cmncnfg.transactionManager());
	}
	
	@Test
	public void testDataSrcTest() {
		Assert.assertNotNull(cmncnfg.jndiDataSourceTest());
	}
}
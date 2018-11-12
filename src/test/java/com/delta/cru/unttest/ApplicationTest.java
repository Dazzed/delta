package com.delta.cru.unttest;

import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.delta.cru.Application;
import com.delta.cru.cnfg.CnfgReader;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {
	
	@InjectMocks
	private Application application;
	
	@Mock
	private CnfgReader cnfgReader;
	
	@Mock
	private Application application_mock;
	

	JndiObjectFactoryBean bean ;

	
    private static final Class<Application> applicationClass = Application.class;
    
    @Test
    public void configureTest() {
        Assert.assertNotNull(application.configure(new SpringApplicationBuilder(applicationClass)));
    }
    
    @Test
    public void testJndi() throws IllegalArgumentException, NamingException {
    	Mockito.when(cnfgReader.getJndiNme()).thenReturn("jdbc/CRU_TEST_DB");
        Assert.assertNotNull(application.jndiDataSrc());
    }
    
    @Test
    public void testJndiDataSource() throws IllegalArgumentException, NamingException {
    	Mockito.when(cnfgReader.getJndiNme()).thenReturn("jdbc/CRU_TEST_DB");
    	Assert.assertNotNull(application.jndiDataSource());
    }
    
    @Test
    public void testTomcatFactory() {
        Assert.assertNotNull(application.tomcatFactory());
    }

}

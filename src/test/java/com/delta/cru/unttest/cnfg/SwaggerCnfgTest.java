package com.delta.cru.unttest.cnfg;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.cnfg.SwaggerCnfg;
import com.fasterxml.classmate.TypeResolver;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class SwaggerCnfgTest {
	
	@InjectMocks
	SwaggerCnfg swaggerCnfg;
	
	@Mock
	private TypeResolver resolver;

	@Test
	public void testApiV1() {
	    Assert.assertNotNull(swaggerCnfg.apiV1() );
	}
	
	@Test
	public void testApiV2() {
	    Assert.assertNotNull(swaggerCnfg.apiV2() );
	}

}

package com.delta.cru.unttest.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.context.request.RequestAttributes;

import com.delta.cru.utils.UtilsErrorResponse;

@RunWith(MockitoJUnitRunner.class)
public class UtilsErrorResponseTest {
	@InjectMocks
	private UtilsErrorResponse errorResponse;
	@Mock
	private RequestAttributes attrs;
	
	@Test
	public void testBuildSwaggerUrl() {
		errorResponse.buildSwaggerUrl();
	}
	
	
}
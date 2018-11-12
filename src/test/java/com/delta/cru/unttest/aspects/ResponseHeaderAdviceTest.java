package com.delta.cru.unttest.aspects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ResponseBody;

import com.delta.cru.aspects.ResponseHeaderAdvice;
import com.delta.cru.cnst.CmnCnst;

@RunWith(MockitoJUnitRunner.class)
public class ResponseHeaderAdviceTest {

	@InjectMocks
	private ResponseHeaderAdvice headerAdvice;
	private String body;

	private MediaType contentType;
	
	private Class<? extends HttpMessageConverter<?>> converterType;

	private MethodParameter returnType;

	private ServerHttpRequest request;

	private ServerHttpResponse response;
	
	@Before
	public void setup() {
		this.body = "body";
		this.contentType = MediaType.TEXT_PLAIN;
		this.converterType = StringHttpMessageConverter.class;
		this.returnType = new MethodParameter(ClassUtils.getMethod(this.getClass(), "handle"), -1);
		this.request = new ServletServerHttpRequest(new MockHttpServletRequest());
		this.response = new ServletServerHttpResponse(new MockHttpServletResponse());
	}
	
	@Test
	public void beforeBodyWriteTest(){
		request.getHeaders().add(CmnCnst.TXN_ID, "1");
		Assert.assertNotNull(headerAdvice.beforeBodyWrite(this.body, this.returnType, this.contentType, this.converterType, request, response));
	}
	@Test
	public void beforeBodyWriteTest2(){
		Assert.assertNotNull(headerAdvice.beforeBodyWrite(this.body, this.returnType, this.contentType, this.converterType, request, response));
	}
	@Test
	public void beforeBodyWriteTest3(){
		request.getHeaders().add(CmnCnst.TXN_ID, "");
		Assert.assertNotNull(headerAdvice.beforeBodyWrite(this.body, this.returnType, this.contentType, this.converterType, request, response));
	}
	@Test
	public void supportstest(){
		Assert.assertTrue(headerAdvice.supports(this.returnType, this.converterType));
	}
	
	@ResponseBody
	public String handle() {
		return "";
	}
}

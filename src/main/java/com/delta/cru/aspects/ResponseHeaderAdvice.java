package com.delta.cru.aspects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.delta.cru.cnst.CmnCnst;
import com.delta.cru.utils.CmnUtils;

//@ControllerAdvice
public class ResponseHeaderAdvice implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		HttpHeaders headers = request.getHeaders();

		if (headers.containsKey(CmnCnst.TXN_ID)) {
			String txnId = headers.get(CmnCnst.TXN_ID).get(0);
			if (!StringUtils.isEmpty(txnId)) {
				response.getHeaders().add(CmnCnst.TXN_ID, CmnUtils.gnrtTrnsctionId());
			}
		}
		return body;
	}
}

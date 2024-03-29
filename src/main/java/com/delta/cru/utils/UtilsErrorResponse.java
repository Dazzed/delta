package com.delta.cru.utils;

import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;

@Component
public class UtilsErrorResponse extends DefaultErrorAttributes {

	private StringBuilder swaggerUrl = new StringBuilder();

	@PostConstruct
	public void buildSwaggerUrl() {
		swaggerUrl.append("/swagger-ui.html#/");
	}
}

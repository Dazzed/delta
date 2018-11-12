package com.delta.cru.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;

import com.delta.cru.vo.HeaderVo;

/**
 * LoggingApiClient WebService client class
 * 
 *
 */
@Component
public class LoggingApiClient {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Purpose of the method, call asynchronously Logging API for auditing.
	 * 
	 * @param uri
	 *            - URI of the Logging API
	 * @param headerVo
	 *            - input of the logging API
	 * @return - response as futureResp
	 */
	public void logHdrInfo(String uri, HeaderVo hdrVo) {
		try { 
			AsyncRestTemplate restTemplate = new AsyncRestTemplate();
			HttpEntity<HeaderVo> entity = new HttpEntity<>(hdrVo);
			MDC.put("className", this.getClass().getSimpleName());
			MDC.put("methodName", "logHdrInfo");
			restTemplate.postForEntity(uri, entity, String.class);
		}
		catch (Exception e) {
			logger.error("Following Exception Occurred.Please reach out to Profile team regarding the failure of API: "
					+ uri);
			logger.error(e.getMessage());
		}
	}

}

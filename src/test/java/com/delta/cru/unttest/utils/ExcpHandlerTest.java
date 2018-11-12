package com.delta.cru.unttest.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import com.delta.cru.utils.ExcpHandler;

@RunWith(MockitoJUnitRunner.class)
public class ExcpHandlerTest {
    @InjectMocks
    private ExcpHandler excpHandlerTest;

    @Test
    public void unSupportedMediaTypeTest() {
        HttpMediaTypeNotSupportedException exception = new HttpMediaTypeNotSupportedException(
                "MediaType not supported");
        Assert.assertNotNull(excpHandlerTest.unSupportedMediaType(exception));
    }

    @Test
    public void badRequestTest() {
        MissingServletRequestParameterException exception = new MissingServletRequestParameterException(
                "content-Type", "application/json");
        Assert.assertNotNull(excpHandlerTest.badRequest(exception));
    }

    @Test
    public void httpMessageNotReadableExceptionRequestTest() {
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("");
        Assert.assertNotNull(excpHandlerTest.httpMessageNotReadableExceptionRequest(exception));
    }

    @Test
    public void handleExceptionTest() {
        Exception exception = new Exception();
        Assert.assertNotNull(excpHandlerTest.handleException(exception));
    }

    @Test
    public void buildSwaggerUrlTest() {
        excpHandlerTest.buildSwaggerUrl();
    }
}

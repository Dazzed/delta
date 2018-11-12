package com.delta.cru.unttest.utils;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.delta.cru.utils.ErrorResponses;
import com.fasterxml.jackson.annotation.JsonProperty;


@RunWith(MockitoJUnitRunner.class)
public class ErrorResponsesTest {
	@InjectMocks
	private ErrorResponses errorResponses;
	private String code = null;
	private String message = null;
	private String developerMessage = null;
	private Object moreInfo = null;
	
	@Test
	public void codeTest() {
		Assert.assertNotNull(errorResponses.code("Code Testing"));
	}
	
	@Test
	public void testGetSetCodeTest() {
		errorResponses.setCode("Unit test");
		Assert.assertNotNull(errorResponses.getCode());
	}

	@Test
	public void messageTest() {
		Assert.assertNotNull(errorResponses.message("Message Testing"));
	}
	
	@Test
	public void testGetSetMsgTest() {
		errorResponses.setMessage("Unit test");
		Assert.assertNotNull(errorResponses.getMessage());
	}

	@Test
	public void developerMessageTest() {
		Assert.assertNotNull(errorResponses.developerMessage("Developer Testing Message"));
	}
	
	@Test
	public void testGetSetDvlprMsgTest() {
		errorResponses.setDeveloperMessage("Unit test");
		Assert.assertNotNull(errorResponses.getDeveloperMessage());
	}

	@Test
	public void moreInfoTest() {
		Assert.assertNotNull(errorResponses.moreInfo("Moreinfo Testing"));
	}
	
	@Test
	public void testGetSetMoreInfoTest() {
		errorResponses.setMoreInfo("Unit test");
		Assert.assertNotNull(errorResponses.getMoreInfo());
	}

	@Test
	public void toStringTest() {
		Assert.assertNotNull(errorResponses.toString());
	}

	@Test
	public void hashCodeTest() {
		Assert.assertNotNull(errorResponses.hashCode());
	}

	@Test
	public void equalsTest() {
		Assert.assertNotNull(errorResponses.equals(new Object()));
	}

	@Test
	public void toIndentedStringTest() {
		Assert.assertNotNull(errorResponses.toIndentedString(new Object()));
	}
	
	@Test
	public void equalsTest2() {
		Assert.assertTrue(errorResponses.equals(errorResponses));
		Assert.assertFalse(errorResponses.equals(new String()));
		Assert.assertFalse(errorResponses.equals(null));
		ErrorResponses errorResponses2=new ErrorResponses();
		ErrorResponses errorResponses3=new ErrorResponses();
		ErrorResponses errorResponses4=new ErrorResponses();

		errorResponses2.setCode("DUMMY_CODE");
		errorResponses3.setCode("DUMMY_CODE_FALSE");
		errorResponses4.setCode("DUMMY_CODE");
		errorResponses2.setDeveloperMessage("DUMMY_DEV_MESSAGE");
		errorResponses3.setDeveloperMessage("DUMMY_DEV_MESSAGE_FALSE");
		errorResponses4.setDeveloperMessage("DUMMY_DEV_MESSAGE");
		errorResponses2.setMessage("DUMMY_MESSAGE");
		errorResponses3.setMessage("DUMMY_MESSAGE_FALSE");
		errorResponses4.setMessage("DUMMY_MESSAGE");
		errorResponses2.setMoreInfo("DUMMY_MORE_INFO");
		errorResponses3.setMoreInfo("DUMMY_MORE_INFO_FALSE");
		errorResponses4.setMoreInfo("DUMMY_MORE_INFO");
		Assert.assertFalse(errorResponses.equals(errorResponses2));		
		Assert.assertTrue(errorResponses2.getCode().equals(errorResponses4.getCode()));
		Assert.assertFalse(errorResponses2.getCode().equals(errorResponses3.getCode()));		
		Assert.assertFalse(Objects.equals(errorResponses2.getDeveloperMessage(), errorResponses3.getDeveloperMessage()));
		Assert.assertTrue(Objects.equals(errorResponses2.getDeveloperMessage(), errorResponses4.getDeveloperMessage()));
		
		
	}
	
	@Test
	public void equalsTest3() {
		
	}
}

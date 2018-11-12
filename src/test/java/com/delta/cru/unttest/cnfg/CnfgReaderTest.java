package com.delta.cru.unttest.cnfg;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.cnfg.CnfgReader;
import com.delta.cru.unttest.TestData;
import org.mockito.InjectMocks;

@RunWith(MockitoJUnitRunner.class)
public class CnfgReaderTest {
	
	@InjectMocks
	CnfgReader cnfgreader;
	
	@Test
	public void cnfgReaderGetterSetterTest() {
		cnfgreader.setJndiNme(TestData.DUMMY);
		Assert.assertEquals(TestData.DUMMY, cnfgreader.getJndiNme());
		cnfgreader.setPswd(TestData.DUMMY);
		Assert.assertEquals(TestData.DUMMY, cnfgreader.getPswd());
		cnfgreader.setUrl(TestData.DUMMY);
		Assert.assertEquals(TestData.DUMMY, cnfgreader.getUrl());
		cnfgreader.setUsrNme(TestData.DUMMY);
		Assert.assertEquals(TestData.DUMMY, cnfgreader.getUsrNme());
	}

	@Test
	public void testAllowOrigins() {
		ArrayList<String> allowedOrigins = new ArrayList<>();
		allowedOrigins.add("A");
		cnfgreader.setAllowedOrigins(allowedOrigins);
		Assert.assertNotNull(cnfgreader.getAllowedOrigins());
	}

	@Test
	public void testLookUp() {
		Assert.assertEquals(true,cnfgreader.getLookup());
	}

	@Test
	public void cnfgReaderGetterSetterLogMqUrlTest() {
		cnfgreader.setLogMqUrl("TestUrl");
		Assert.assertEquals("TestUrl", cnfgreader.getLogMqUrl());

	}
}

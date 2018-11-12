package com.delta.cru.unttest.excp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.unttest.TestData;

@RunWith(MockitoJUnitRunner.class)
public class BsnObjExcpTest {

	@Test(expected = BsnObjExcp.class)
	public void bsnObjExcpTest() throws BsnObjExcp {
		if (true) {
			throw new BsnObjExcp(new Exception());
		}
	}

	@Test(expected = BsnObjExcp.class)
	public void bsnObjExcpMsgTest() throws BsnObjExcp {
		if (true) {
			throw new BsnObjExcp(TestData.DUMMY);
		}
	}
}

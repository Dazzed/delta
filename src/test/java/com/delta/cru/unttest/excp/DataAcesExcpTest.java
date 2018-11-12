package com.delta.cru.unttest.excp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.excp.DataAcesExcp;

@RunWith(MockitoJUnitRunner.class)
public class DataAcesExcpTest {

	@Test(expected = DataAcesExcp.class)
	public void dataAcesExcpTest() throws DataAcesExcp {
		if (true) {
			throw new DataAcesExcp(new Exception());
		}
	}

	@Test(expected = DataAcesExcp.class)
	public void dataAcesExcpMsgTest() throws DataAcesExcp {
		if (true) {
			throw new DataAcesExcp("Msg");
		}
	}
}

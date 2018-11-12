package com.delta.cru.unttest.cnst;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.delta.cru.cnst.CmnCnst;

@RunWith(MockitoJUnitRunner.class)
public class CmnCnstTest {

	@Test
	public void cmnCnstTest() throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<CmnCnst> constructor = CmnCnst.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		org.junit.Assert.assertNotNull(constructor.newInstance());
	}

	@Test
	public void getSingletonTest() {
		org.junit.Assert.assertNotNull(CmnCnst.getSingleton());
	}

}

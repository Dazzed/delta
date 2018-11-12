package com.delta.cru.unttest.vo;

import org.junit.Assert;
import org.junit.Test;

import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpNmeVo;

public class EmpNmeVoTest {

	@Test
	public void empNmeVoSetterGetterTest() {
		EmpNmeVo empnmevo = new EmpNmeVo();
		empnmevo.setEmplId(TestData.DUMMY);
		empnmevo.setEmplName(TestData.DUMMY);
		Assert.assertEquals(TestData.DUMMY, empnmevo.getEmplId());
		Assert.assertEquals(TestData.DUMMY, empnmevo.getEmplName());
		Assert.assertNotNull(empnmevo.toString());
	}
}
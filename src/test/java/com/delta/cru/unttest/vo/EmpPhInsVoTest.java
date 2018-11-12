package com.delta.cru.unttest.vo;

import org.junit.Assert;
import org.junit.Test;

import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpPhVo;

public class EmpPhInsVoTest {

	@Test
	public void empPhInsVoSetterGetterTest() {
		EmpPhVo empphinsvo = new EmpPhVo();
		empphinsvo.setEmplId(TestData.DUMMY);
		empphinsvo.setEmplPhNum(TestData.DUMMY);
		empphinsvo.setEffDate(TestData.DUMMY);
		empphinsvo.setPhTypCode(TestData.DUMMY);
		empphinsvo.setCtryPhNum(TestData.DUMMY);
		empphinsvo.setPhExtsNum(TestData.DUMMY);
		empphinsvo.setPhPsnlIdntNum(TestData.DUMMY);
		empphinsvo.setExpDate(TestData.DUMMY);
		empphinsvo.setEmplPhRnkNum(46);
		empphinsvo.setCrewPhSvcPvdrCode(TestData.DUMMY);
		empphinsvo.setIntlPhNbInd(TestData.DUMMY);
		empphinsvo.setArptTmZnCtryCode(TestData.DUMMY);
		empphinsvo.setArptTmZnDvCode(TestData.DUMMY);
		empphinsvo.setCrtnUsrId(TestData.DUMMY);
		empphinsvo.setCrtnGdttmDate(TestData.DUMMY);
		empphinsvo.setLstUpdtUsrId(TestData.DUMMY);
		empphinsvo.setLstUpdtGdttmDate(TestData.DUMMY);
		empphinsvo.setLstUpdtSqNum(15);
		empphinsvo.setSmsEnbdInd(TestData.DUMMY);		
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getEmplId());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getEmplPhNum());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getEffDate());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getPhTypCode());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getCtryPhNum());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getPhExtsNum());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getPhPsnlIdntNum());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getExpDate());
		Assert.assertEquals("46", empphinsvo.getEmplPhRnkNum().toString());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getCrewPhSvcPvdrCode());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getIntlPhNbInd());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getArptTmZnCtryCode());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getArptTmZnDvCode());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getCrtnUsrId());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getCrtnGdttmDate());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getLstUpdtUsrId());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getLstUpdtGdttmDate());
		Assert.assertEquals(15, empphinsvo.getLstUpdtSqNum());
		Assert.assertEquals(TestData.DUMMY, empphinsvo.getSmsEnbdInd());
		Assert.assertNotNull(empphinsvo.toString());
	}
}

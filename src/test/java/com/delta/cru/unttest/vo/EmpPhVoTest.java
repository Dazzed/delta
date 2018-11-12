package com.delta.cru.unttest.vo;

import org.junit.Assert;
import org.junit.Test;

import com.delta.cru.unttest.TestData;
import com.delta.cru.vo.EmpPhVo;

public class EmpPhVoTest {

	@Test
	public void empPhVoSetterGetterTest() {
		EmpPhVo empphno = new EmpPhVo();
		empphno.setEmplId(TestData.DUMMY);
		empphno.setEmplPhNum(TestData.DUMMY);
		empphno.setEffDate(TestData.DUMMY);
		empphno.setPhTypCode(TestData.DUMMY);
		empphno.setCtryPhNum(TestData.DUMMY);
		empphno.setPhExtsNum(TestData.DUMMY);
		empphno.setPhPsnlIdntNum(TestData.DUMMY);
		empphno.setExpDate(TestData.DUMMY);
		empphno.setEmplPhRnkNum(TestData.DUMMY_NBR);
		empphno.setCrewPhSvcPvdrCode(TestData.DUMMY);
		empphno.setIntlPhNbInd(TestData.DUMMY);
		empphno.setArptTmZnCtryCode(TestData.DUMMY);
		empphno.setArptTmZnDvCode(TestData.DUMMY);
		empphno.setCrtnUsrId(TestData.DUMMY);
		empphno.setCrtnGdttmDate(TestData.DUMMY);
		empphno.setLstUpdtUsrId(TestData.DUMMY);
		empphno.setLstUpdtGdttmDate(TestData.DUMMY);
		empphno.setLstUpdtSqNum(TestData.DUMMY_LNG_NBR);
		empphno.setSmsEnbdInd(TestData.DUMMY);
		empphno.setRtnCd(TestData.DUMMY);
		empphno.setRtnMsg(TestData.DUMMY);
		empphno.setSeqNum(TestData.DUMMY_LNG_NBR);
		Assert.assertEquals(TestData.DUMMY, empphno.getEmplId());
		Assert.assertEquals(TestData.DUMMY, empphno.getEmplPhNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getEffDate());
		Assert.assertEquals(TestData.DUMMY, empphno.getPhTypCode());
		Assert.assertEquals(TestData.DUMMY, empphno.getCtryPhNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getPhExtsNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getPhPsnlIdntNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getExpDate());
		Assert.assertEquals(TestData.DUMMY_NBR, empphno.getEmplPhRnkNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getCrewPhSvcPvdrCode());
		Assert.assertEquals(TestData.DUMMY, empphno.getArptTmZnCtryCode());
		Assert.assertEquals(TestData.DUMMY, empphno.getArptTmZnDvCode());
		Assert.assertEquals(TestData.DUMMY, empphno.getCrtnGdttmDate());
		Assert.assertEquals(TestData.DUMMY, empphno.getLstUpdtUsrId());
		Assert.assertEquals(TestData.DUMMY, empphno.getLstUpdtGdttmDate());
		Assert.assertEquals(TestData.DUMMY_LNG_NBR, empphno.getLstUpdtSqNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getSmsEnbdInd());
		Assert.assertEquals(TestData.DUMMY, empphno.getCrtnUsrId());
		Assert.assertEquals(TestData.DUMMY, empphno.getIntlPhNbInd());
		Assert.assertEquals(TestData.DUMMY_LNG_NBR, empphno.getLstUpdtSqNum());
		Assert.assertEquals(TestData.DUMMY, empphno.getRtnCd());
		Assert.assertEquals(TestData.DUMMY, empphno.getRtnMsg());
		Assert.assertEquals(TestData.DUMMY_LNG_NBR, empphno.getSeqNum());
		Assert.assertNotNull(empphno.toString());

	}
}
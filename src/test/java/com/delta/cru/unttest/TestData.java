package com.delta.cru.unttest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

public class TestData {
	public static final String EMP_ID = "0000305566";
	public static final String EMPTY_PARAM = "{}";
	public static final String EMPTY_STRING = "";
	public static final String WRG_EMP_ID = "100";
	public static final String GET_EMP_DETAIL_URL = "/name/";
	public static final String PH_NBR_URL = "/phoneNumbers";
	public static final String WRG_PH_NBR_URL = "/phoneNumbe";
	public static final String ANTHR_EMP_ID = "0000305582";
	public static final String DUMMY = "DUMMY_VALUE";
	public static final String EMP_PH_NBR = generateEmpNbr();
	public static final Integer DUMMY_NBR = 12;
	public static final Integer DUMMY_ROWIMPTD_NBR = 0;
	public static final Integer DUMMY_ROWIMPTD_FORSP_NBR = -1;
	public static final long DUMMY_LNG_NBR = 100l;

	private TestData() {
		// private constructor to avoid creation multiple instances
	}

	public static List<EmpNmeVo> fndEmpSetUp() {
		EmpNmeVo empVo1 = new EmpNmeVo();
		empVo1.setEmplId("0000305566");
		empVo1.setEmplName("John");
		EmpNmeVo empVo2 = new EmpNmeVo();
		empVo2.setEmplId("0000305566");
		empVo2.setEmplName("Doe");
		List<EmpNmeVo> empNmeVoLst = new ArrayList<EmpNmeVo>();
		empNmeVoLst.add(empVo1);
		empNmeVoLst.add(empVo2);
		return empNmeVoLst;
	}

	public static List<EmpNmeVo> fndEmpSetUp_emptyList() {
		List<EmpNmeVo> empNmeVoLst = new ArrayList<EmpNmeVo>();
		return empNmeVoLst;
	}

	public static List<EmpPhVo> fndEmpPhnsSetUp() {
		EmpPhVo empPhVo1 = new EmpPhVo();
		empPhVo1.setArptTmZnCtryCode(TestData.DUMMY);
		empPhVo1.setArptTmZnDvCode(TestData.DUMMY);
		empPhVo1.setCrewPhSvcPvdrCode(TestData.DUMMY);
		empPhVo1.setCrtnGdttmDate(TestData.DUMMY);
		empPhVo1.setCrtnUsrId(TestData.DUMMY);
		empPhVo1.setCtryPhNum(TestData.DUMMY);
		empPhVo1.setEffDate(TestData.DUMMY);
		empPhVo1.setEmplId(TestData.EMP_ID);
		EmpPhVo empPhVo2 = new EmpPhVo();
		empPhVo2.setArptTmZnCtryCode(TestData.DUMMY);
		empPhVo2.setArptTmZnDvCode(TestData.DUMMY);
		empPhVo2.setCrewPhSvcPvdrCode(TestData.DUMMY);
		empPhVo2.setCrtnGdttmDate(TestData.DUMMY);
		empPhVo2.setCrtnUsrId(TestData.DUMMY);
		empPhVo2.setCtryPhNum(TestData.DUMMY);
		empPhVo2.setEffDate(TestData.DUMMY);
		empPhVo2.setEmplId(TestData.EMP_ID);
		List<EmpPhVo> phVoList=new ArrayList<EmpPhVo>();
		phVoList.add(empPhVo1);
		phVoList.add(empPhVo2);
		return phVoList;
	}
	
	public static List<EmpPhVo> fndEmpPhnsSetUp_emptyList() {
		List<EmpPhVo> phVoList = new ArrayList<EmpPhVo>();
		return phVoList;
	}
	
	public static EmpPhVo insertDataSetUp() throws ParseException {
		EmpPhVo empVo = new EmpPhVo();
		empVo.setEmplId("0000305566");
		empVo.setEmplPhRnkNum(2);
		empVo.setEmplPhNum(EMP_PH_NBR);
		empVo.setEffDate("12-JAN-19");
		empVo.setPhTypCode("H");
		empVo.setCtryPhNum("2");
		empVo.setPhExtsNum(null);
		empVo.setPhPsnlIdntNum(null);
		empVo.setExpDate("30-Dec-99");
		empVo.setCrewPhSvcPvdrCode(null);
		empVo.setIntlPhNbInd("N");
		empVo.setArptTmZnCtryCode(null);
		empVo.setArptTmZnDvCode(null);
		empVo.setCrtnGdttmDate("09-Aug-19");
		empVo.setLstUpdtGdttmDate("12-Mar-19");
		empVo.setLstUpdtSqNum(32928915);
		empVo.setCrtnUsrId("0000575758");
		empVo.setLstUpdtUsrId("Rahul");
		empVo.setSmsEnbdInd(null);
		return empVo;
	}

	public static String generateEmpNbr() {
		int x1 = ThreadLocalRandom.current().ints(100000000, 1000000000).distinct().limit(1).findAny().getAsInt();
		String str = Integer.toString(x1) + "2";
		return str;
	}

	public static EmpPhVo updateDataSetUp() throws ParseException {
		EmpPhVo empPhUpdVo = new EmpPhVo();
		empPhUpdVo.setEmplId("0000305566");
		empPhUpdVo.setEmplPhRnkNum(2);
		empPhUpdVo.setEmplPhNum("1111114444");
		empPhUpdVo.setEffDate("12-JAN-19");
		empPhUpdVo.setPhTypCode("H");
		empPhUpdVo.setCtryPhNum("2");
		empPhUpdVo.setPhExtsNum(null);
		empPhUpdVo.setIntlPhNbInd("N");
		empPhUpdVo.setExpDate(null);
		empPhUpdVo.setCrewPhSvcPvdrCode(null);
		empPhUpdVo.setArptTmZnCtryCode(null);
		empPhUpdVo.setArptTmZnDvCode(null);
		empPhUpdVo.setCrtnUsrId("0000575758");
		empPhUpdVo.setCrtnGdttmDate("07-Aug-16");
		empPhUpdVo.setLstUpdtUsrId("ESSCRULOAD");
		empPhUpdVo.setLstUpdtGdttmDate("13-Dec-17");
		empPhUpdVo.setLstUpdtSqNum(1);
		empPhUpdVo.setSmsEnbdInd("Y");

		return empPhUpdVo;
	}

	public static EmpPhVo deleteDataSetUp() throws ParseException {
		EmpPhVo empPkVo = new EmpPhVo();
		empPkVo.setEmplId("0000305566");
		empPkVo.setEmplPhNum(EMP_PH_NBR);
		empPkVo.setPhTypCode("H");
		empPkVo.setEffDate("12-JAN-19");
		return empPkVo;
	}

	public static List<EmpNmeVo> getEmpData() {
		List<EmpNmeVo> emps = new ArrayList<>();
		EmpNmeVo empl = new EmpNmeVo();
		empl.setEmplId("0000305566");
		emps.add(empl);
		return emps;
	}
	
	public static List<EmpPhVo> getEmpPhData() {
		List<EmpPhVo> emps = new ArrayList<>();
		EmpPhVo empl = new EmpPhVo();
		empl.setEmplId("0000305566");
		empl.setEmplPhNum(EMP_PH_NBR);
		emps.add(empl);
		return emps;
	}
}

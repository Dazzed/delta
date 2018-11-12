package com.delta.cru.cucumber;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import com.delta.cru.vo.EmpPhVo;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestData {

    public static final String EMPTY_STRING = "";
    public static final String EMP_ID = "0000305566";
    public static final String WRNG_EMP_ID = "101";
    public static final String PHN_EMP_ID = "0000310362";
    public static final String WRNG_PHN_EMP_ID = "201";
    public static final String EMP_INSRT_URL = "/example/sql/v1/employees";
    public static final String EMP_SP_INSRT_URL = "/example/storedProcedure/v1/employees";
    public static final String WRNG_EMP_INSRT_URL = "/phone";
    public static final String FND_EMP_URL = "/example/sql/v1/employees/names";
    public static final String FND_EMP_PHN = "/example/sql/v1/employees/phones";
    public static final String WRNG_FND_EMP_PHN = "/phonerecord";
    public static final String WRG_PH_NBR_URL = "/phnes";
    public static final String EMP_UPDT_URL = "/example/sql/v1/employees";
    public static final String EMP_SP_UPDT_URL = "/example/storedProcedure/v1/employees";
    public static final String WRNG_EMP_UPDT_URL = "/phone";
    public static final String EMP_DEL_URL = "/example/sql/v1/employees";
    public static final String EMP_SP_DEL_URL = "/example/storedProcedure/v1/employees";
    public static final String WRNG_EMP_DEL_URL = "/phone";
    public static final String ANTHR_EMP_ID = "0000305582";
    public static final String WRNG_FND_EMP_URL = "/name";
    public static final String TEST_EMP_ID = "0000305574";
    public static final String EMP_PH_NBR = generateEmpNbr();
    public static final String EMP_PH_NBR_FR_EMPTY_PARAMS = generateEmpNbrForEmptyParams();

    private TestData() {
        // private constructor to avoid creation multiple instances
    }

    public static String createTestData() throws IOException {
        JsonFactory factory = new JsonFactory();
        StringWriter writer = new StringWriter();
        JsonGenerator jsonGenerator = factory.createGenerator(writer);
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("emplId", "0000305602");
        jsonGenerator.writeStringField("emplDisplayName", "KURTZHALTS, MARK");
        jsonGenerator.writeEndObject();
        jsonGenerator.close();
        return writer.toString();

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Date formatDate(String dt) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
        return formatter.parse(dt);
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

    public static EmpPhVo insertDataSetUpForEmptyParams() throws ParseException {

    	EmpPhVo empVo = new EmpPhVo();

        empVo.setEmplId("0000305566");
        empVo.setEmplPhRnkNum(2);
        empVo.setEmplPhNum(EMP_PH_NBR_FR_EMPTY_PARAMS);
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

    public static EmpPhVo updateDataSetUpForEmptyParams() throws ParseException {
    	EmpPhVo empPhUpdVo = new EmpPhVo();
        empPhUpdVo.setEmplId("0000305566");
        empPhUpdVo.setEmplPhRnkNum(2);
        empPhUpdVo.setCtryPhNum("2");
        empPhUpdVo.setPhExtsNum(null);
        empPhUpdVo.setIntlPhNbInd("N");
        empPhUpdVo.setExpDate(null);
        empPhUpdVo.setCrewPhSvcPvdrCode(null);
        empPhUpdVo.setArptTmZnCtryCode(null);
        empPhUpdVo.setArptTmZnDvCode(null);
        empPhUpdVo.setCrtnUsrId("0000575758");
        empPhUpdVo.setLstUpdtUsrId("ESSCRULOAD");
        empPhUpdVo.setSmsEnbdInd("Y");

        return empPhUpdVo;
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

    public static String generateEmpNbr() {
        int x1 = ThreadLocalRandom.current().ints(100000000, 1000000000).distinct().limit(1)
                .findAny().getAsInt();
        String str = Integer.toString(x1) + "2";
        return str;
    }

    public static String generateEmpNbrForEmptyParams() {
        int x1 = ThreadLocalRandom.current().ints(200000000, 1000000000).distinct().limit(1)
                .findAny().getAsInt();
        String str = Integer.toString(x1) + "2";
        return str;
    }

    public static EmpPhVo deleteDataSetUpForCucumber() throws ParseException {
    	EmpPhVo empPkVo = new EmpPhVo();
        empPkVo.setEmplId("0000305566");
        empPkVo.setEmplPhNum("8587327112");
        empPkVo.setPhTypCode("H");
        empPkVo.setEffDate("12-JAN-19");
        return empPkVo;
    }

    public static EmpPhVo insertDataSetUpAfterDelete() throws ParseException {

    	EmpPhVo empVo = new EmpPhVo();

        empVo.setEmplId("0000305566");
        empVo.setEmplPhRnkNum(2);
        empVo.setEmplPhNum("8587327112");
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
}

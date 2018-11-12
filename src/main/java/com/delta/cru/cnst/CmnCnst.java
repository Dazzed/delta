package com.delta.cru.cnst;

public class CmnCnst {
    private static final CmnCnst INSTANCE = new CmnCnst();

    private CmnCnst() {
        // Singleton
    }

    public static CmnCnst getSingleton() {
        return INSTANCE;
    }

    public static final String INSRT_MSG = "Successfully Inserted";
    public static final String INSRT_FAILURE_MSG = "Data Insertion is not successfull";
    public static final String UPDT_MSG = "Successfully Updated";
    public static final String UPDT_FAILURE_MSG = "Data Updation is not successful";
    public static final String DLTE_FAILURE_MSG = "Data Deletion is not successfull";
    public static final String DLTE_MSG = "Successfully Deleted";
    public static final String SUCCESS_MSG = "Operation successful";
    public static final String FAILED_MSG = "Operation failed";
    public static final String DT_FRMT = "dd-MMM-yy";
    public static final String SPACE = " ";
    public static final String ERR_MSG = "]Error Message:[";
    public static final String TXN_ID = "TransactionId";
   
}

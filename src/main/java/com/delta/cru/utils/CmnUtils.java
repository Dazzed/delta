package com.delta.cru.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delta.cru.bo.LogMsgBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.vo.HeaderVo;

import io.swagger.annotations.ApiModel;

/**
 * common utilities to be used across classes PLEASE DONT CHANGE THIS FILE.REACH
 * OUT TO CrewBase TEAM FOR ANY QUERIES
 */
@Component
@ApiModel(description = "common utilities to be used across classes", value = "commonUtilities")
public class CmnUtils {
    private static final String TXN_ID = "txnId";
   
    @Autowired
    private LogMsgBoIfc logMsgBo;

    protected static final Map<String, String> txnIdMap = new HashMap<>();
    
    public static Map<String, String> getTxnidmap() {
		return txnIdMap;
	}

	protected static final List<String> logMsgDrctv = new ArrayList<>();


    public static String gnrtTrnsctionId() {
        String sysCd = "CRU";
        String appCd = "BsPrd";
        String tmeStmp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("YYYYMMddHHmmssSSS"));
        String rndmNo = UUID.randomUUID().toString().substring(0, 4);
        if (txnIdMap.get(TXN_ID) != null) {
            return txnIdMap.get(TXN_ID);
        } else {
            String txnId = sysCd + appCd + tmeStmp + rndmNo;
            txnIdMap.put(TXN_ID, txnId);
            return txnId;
        }

    }
    
    public static String gnrtTrnsctionId(String txnId) {
        String sysCd = "CRU";
        String appCd = "BsPrd";
        String tmeStmp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("YYYYMMddHHmmssSSS"));
        String rndmNo = UUID.randomUUID().toString().substring(0, 4);
        if( txnId != null && !txnId.isEmpty()){
        	txnIdMap.put(TXN_ID, txnId);
            return txnId;
        }else{
	        if (txnIdMap.get(TXN_ID) != null) {
	            return txnIdMap.get(TXN_ID);
	        } else {
	            txnId = sysCd + appCd + tmeStmp + rndmNo;
	            txnIdMap.put(TXN_ID, txnId);
	            return txnId;
	        }
        }
    }

    public static List<String> getInpPrmNms(JoinPoint joinPoint) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        return Arrays.asList(codeSignature.getParameterNames());
    }

    public static List<String> getInpPrmVlus(JoinPoint joinPoint) {
        List<String> inpPrmValues = new ArrayList<>();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            String temp = null;
            if (null != joinPoint.getArgs()[i]) {
                temp = joinPoint.getArgs()[i].toString();
            }
            inpPrmValues.add(temp);
        }
        return inpPrmValues;
    }

    public String getLogMsgTxt(String msgCd, List<String> inpPrmVlue, List<String> inpLstVlue)
            throws BsnObjExcp {

        String logMsgTxt = logMsgBo.getLogMsg(msgCd);
    	logMsgDrctvMthd();

        if (logMsgTxt != null) {
            if (null != inpPrmVlue) {
                logMsgTxt = rplcTxtPrms(logMsgTxt, inpPrmVlue);
            }
            if (null != inpLstVlue) {
                logMsgTxt = rplcLstPrms(logMsgTxt, inpLstVlue);
            }
        } else {
            logMsgTxt = "There is some issue in Log Messages from DB.Please check it in Z_LOG_MSG table for Logging";
        }
        return logMsgTxt;

    }

    public String rplcTxtPrms(String logMsgTxt, List<String> rplceVlues) {
        String buffer = logMsgTxt;
        for (int count = 0; count < rplceVlues.size(); count++) {
            Pattern pattern = Pattern.compile(logMsgDrctv.get(count));
            Matcher matcher = pattern.matcher(buffer);
            if (matcher.find()) {
                buffer = matcher.replaceAll(rplceVlues.get(count));
            }
        }
        return buffer;
    }

    public String rplcLstPrms(String text, List<String> rplceVlues) {

        String buffer = text;
        StringBuilder replacementString = new StringBuilder();
        for (int count = 0; count < logMsgDrctv.size(); count++) {
            Pattern pattern = Pattern.compile(logMsgDrctv.get(count));
            Matcher matcher = pattern.matcher(buffer);
            String listQuote="@listQuote";
            String listBracket="@listBracket";
            if (logMsgDrctv.get(count).equalsIgnoreCase(listQuote)
                    || logMsgDrctv.get(count).equalsIgnoreCase(listBracket)) {
                replacementString = replacementString.append("");
                if (logMsgDrctv.get(count).equalsIgnoreCase(listQuote)) {
                    for (int i = 0; i < rplceVlues.size(); i++) {
                    	  replacementString = replacementString.append("'").append(rplceVlues.get(i)).append("'");
                        if (i + 1 < rplceVlues.size()) {
                            replacementString = replacementString.append(',');
                        }
                    }
                } else if (logMsgDrctv.get(count).equalsIgnoreCase(listBracket)) {
                    for (int i = 0; i < rplceVlues.size(); i++) {
                    	  replacementString = replacementString.append("[").append(rplceVlues.get(i)).append("]");
                        if (i + 1 < rplceVlues.size()) {
                            replacementString = replacementString.append(',');
                        }
                    }
                }
                if (matcher.find()) {
                    buffer = matcher.replaceAll(replacementString.toString());
                }
            }
        }

        return buffer;
    }

    public static Map<String, String> getInpPrmsMap(List<String> inpPrmNme,
            List<String> inpPrmVlues) {
        Map<String, String> inpPrmMap = new HashMap<>();
        IntStream.range(0, inpPrmNme.size()).parallel()
                .forEach(nbr -> inpPrmMap.put(inpPrmNme.get(nbr), inpPrmVlues.get(nbr)));
        return inpPrmMap;
    }

    public static Map<String, HeaderVo> getHdrVoMap(List<String> inpPrmVlues) throws BsnObjExcp {
        HeaderVo hdrVo = HeaderVo.createReqHeader(inpPrmVlues);
        Map<String, HeaderVo> hdrVoMap = new HashMap<>();
        hdrVoMap.put("hdrInfo", hdrVo);
        return hdrVoMap;
    }
    
    protected void logMsgDrctvMthd() {
		logMsgDrctv.add("@className");
		logMsgDrctv.add("@methodName");
		logMsgDrctv.add("@exception");
		logMsgDrctv.add("@listQuote");
		logMsgDrctv.add("@listBracket");
	}

}

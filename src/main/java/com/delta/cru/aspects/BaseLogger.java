package com.delta.cru.aspects;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.utils.CmnUtils;

// PLEASE DONT CHANGE THIS FILE.REACH OUT TO CrewBase TEAM FOR ANY QUERIES
// ADD MORE LOG STATEMENTS IN ApplLogger.java FILE 

//@Aspect
@Component
public class BaseLogger {/*

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static final String MESSAGE_ID="messageId";

    @Value("${spring.profiles.active}")
    private String activeProfile;
    
    @Value("${logging.header.enabled}")
    private String logHdrInfo;
    
    @Autowired    
    private CmnUtils cmnUtils;
    
    List<String> logMsgTxtPrms;


    @Before("execution(* com.delta.cru.svc.*.*(..))")
    public void beforeServiceIsCalled(JoinPoint joinPoint) throws Throwable {
    	
    		List<String> inpPrmVlus = CmnUtils.getInpPrmVlus(joinPoint);
            MDC.put("appId", "BsPrd" );
            MDC.put("env", activeProfile );
            
            String clsNm = joinPoint.getTarget().getClass().getSimpleName();
            String mthdNm = joinPoint.getSignature().getName() ;
            logMsgTxtPrms = new ArrayList<>();
            logMsgTxtPrms.add(mthdNm);
            logMsgTxtPrms.add(clsNm);
            MDC.put("className", clsNm );
            MDC.put("methodName", mthdNm );
        	MDC.put(MESSAGE_ID, "CruBsPrdI8000" );
        	logger.info(cmnUtils.getLogMsgTxt("CruBsPrdI8000",logMsgTxtPrms,inpPrmVlus));
    }

    @AfterReturning("execution(* com.delta.cru.svc.*.*(..))")
    public void afterMethodReturnSucessfully(JoinPoint joinPoint) throws BsnObjExcp {
    	MDC.put(MESSAGE_ID, "CruBsPrdI8001" );
      	logger.info(cmnUtils.getLogMsgTxt("CruBsPrdI8001",logMsgTxtPrms,null));
    }

   @Around("execution(* com.delta.cru.svc.*.*(..))")
   public Object hndlngExcptn(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

	   logMsgTxtPrms = new ArrayList<>();
	   String clsNm = proceedingJoinPoint.getTarget().getClass().getSimpleName();
       String mthdNm = proceedingJoinPoint.getSignature().getName() ;
       logMsgTxtPrms.add(mthdNm);
       logMsgTxtPrms.add(clsNm);
       HttpHeaders headers = new HttpHeaders();
	   headers.add("TransactionId", CmnUtils.gnrtTrnsctionId());
       Object value = null;
       try {
           value = proceedingJoinPoint.proceed();
       } catch (Exception ex) {
           logMsgTxtPrms.add(ex.getMessage());
           if(null !=ex.getMessage() && ex.getMessage().contains("Persistence")){
           		MDC.put(MESSAGE_ID, "CruBsPrdE1000" );
               logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE1000",logMsgTxtPrms,null));
           }else if(null !=ex.getMessage() && ex.getMessage().contains("SQL")){
               MDC.put(MESSAGE_ID, "CruBsPrdE1001" );
               logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE1001",logMsgTxtPrms,null));
           }else if(null !=ex.getMessage() && ex.getMessage().contains("IndexOutOfBound")){
           		MDC.put(MESSAGE_ID, "CruBsPrdE0002" );
               logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE0002",logMsgTxtPrms,null));
           }else if(null !=ex.getMessage() && ex.getMessage().contains("Host")){
           		MDC.put(MESSAGE_ID, "CruBsPrdE2000" );
               logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE2000",logMsgTxtPrms,null));
           }else if(null !=ex.getMessage() && ex.getMessage().contains("Header Info is not Valid")){
           		MDC.put(MESSAGE_ID, "CruBsPrdE0003" );
               logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE0003",logMsgTxtPrms,null));
           }else if(null !=ex.getMessage() && ex.getMessage().contains("Null")){ 
        	   MDC.put(MESSAGE_ID, "CruBsPrdE0001" );
        	   logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE0001",logMsgTxtPrms,null));
           }else { 
        	   MDC.put(MESSAGE_ID, "CruBsPrdE0000" );
               logger.error(cmnUtils.getLogMsgTxt("CruBsPrdE0000",logMsgTxtPrms,null));
           }
		  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }
       return value;
   }

*/}

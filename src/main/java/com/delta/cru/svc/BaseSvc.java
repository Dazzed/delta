package com.delta.cru.svc;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import com.delta.cru.cnfg.CnfgReader;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.utils.CmnUtils;
import com.delta.cru.utils.LoggingApiClient;
import com.delta.cru.vo.HeaderVo;

//PLEASE DONT CHANGE THIS FILE.REACH OUT TO CrewBase TEAM FOR ANY QUERIES
//The Header info parameter names are not abbreviated as it has to match the COE standards for API Development.

public class BaseSvc {
	
	@Value("${logging.header.enabled}")
    private String logHdrInfo;
    
    @Autowired    
    private LoggingApiClient loggingApiClient;
    
    @Autowired
    private CnfgReader cnfgReader;

	@ModelAttribute(value = "ResponseEntity")
	public ResponseEntity<Object> processRequestHeaders(
			@RequestHeader(name = "applicationOwnerCode",value = "applicationOwnerCode",required = true) String apcnOwnrCd,
			@RequestHeader(name = "requestedEmployeeId",value = "requestedEmployeeId",required = false) String rqstEmplId,
			@RequestHeader(name = "apiResourceName",value = "apiResourceName",required = true) String apiRsrcNm,
			@RequestHeader(name = "apiRequestUtcTs",value = "apiRequestUtcTs",required = true) String apiReqGdttm,
			@RequestHeader(name = "applicationName",value = "applicationName",	required = true) String apcnAppNm,
			@RequestHeader(name = "applicationVersionNum",value = "applicationVersionNum",required = true) String apcnAppVer,
			@RequestHeader(name = "applicationDeviceName",value = "applicationDeviceName",required = true) String apcnDvcNm,
			@RequestHeader(name = "applicationDeviceOsName",value = "applicationDeviceOsName",required = true) String apcnDvcOs,
			@RequestHeader(name = "applicationDeviceMacAdr",value = "applicationDeviceMacAdr",required = true) String apcnDvcMacAdr,
			@RequestHeader(name = "networkIpAdr",value = "networkIpAdr",required = true) String ntwkIpAdr,
			@RequestHeader(name = "apiConsumerRecordText",value = "apiConsumerRecordText",required = true) String apiCnsrRecTxt,
			@RequestHeader(name = "Authorization",value = "Authorization",required = true) String authorization,
			@RequestHeader(name = "TransactionId",value = "TransactionId",required = true) String transactionId,
			@RequestHeader(name = "Content-Type",value = "Content-Type",required = false) String contentType,
			@RequestHeader(name = "Accept",value = "Accept",required = false) String accept,
			@RequestHeader(name = "employeeId",	value = "employeeId",required = true) String employeeId) throws BsnObjExcp {
					HeaderVo headerVo = new HeaderVo();
					headerVo.setApplicationOwnerCode(apcnOwnrCd);
					headerVo.setRequestedEmployeeId(rqstEmplId);
					headerVo.setApiResourceName(apiRsrcNm);
					headerVo.setApiRequestUtcTs(apiReqGdttm);
					headerVo.setApplicationName(apcnAppNm);
					headerVo.setApplicationVersionNum(apcnAppVer);
					headerVo.setApplicationDeviceName(apcnDvcNm);
					headerVo.setApplicationDeviceOS(apcnDvcOs);
					headerVo.setApplicationDeviceMacAddress(apcnDvcMacAdr);
					headerVo.setNetworkIpAddress(ntwkIpAdr);
					headerVo.setApiConsumerRecordText(apiCnsrRecTxt);
					headerVo.setAuthorization(authorization);
					headerVo.setTransactionId(CmnUtils.gnrtTrnsctionId(transactionId));
					headerVo.setContentType(contentType);
					headerVo.setAccept(accept);
					headerVo.setEmployeeId(employeeId);
					MDC.put("userId",rqstEmplId);
			        MDC.put("transactionId", headerVo.getTransactionId() );
			        MDC.put("src_host", apcnDvcMacAdr );
			        if (!HeaderVo.isValid(headerVo)) {
						throw new BsnObjExcp("Header Info is not Valid");
					}
			        //The following code is used to send the header info to Logging MQ.
					if(null !=logHdrInfo  && logHdrInfo.equalsIgnoreCase("true")){
			         	loggingApiClient.logHdrInfo(cnfgReader.getLogMqUrl(), headerVo);
			        }
					return null;
	}
}

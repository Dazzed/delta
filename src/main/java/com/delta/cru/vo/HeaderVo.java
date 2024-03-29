package com.delta.cru.vo;

import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.utils.CmnUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "headervo")
public class HeaderVo {
    @ApiModelProperty(position = 1, required = true, value = "Application owner code from CRU. APCN_OWNR Table")
    @JsonProperty("applicationOwnerCode")
    private String applicationOwnerCode;
    @ApiModelProperty(position = 2, required = false, value = "ID of employee who requesting details on behalf of other employee")
    @JsonProperty("requestedEmployeeId")
    private String requestedEmployeeId;
    @ApiModelProperty(position = 3, required = true, value = "CSS API/resource being invoked")
    @JsonProperty("apiResourceName")
    private String apiResourceName;
    @ApiModelProperty(position = 4, required = true, value = "Request Date Time")
    @JsonProperty("apiRequestUtcTs")
    private String apiRequestUtcTs;
    @ApiModelProperty(position = 5, required = true, value = "Name of APP")
    @JsonProperty("applicationName")
    private String applicationName;
    @ApiModelProperty(position = 6, required = true, value = "Version of APP invoking API")
    @JsonProperty("applicationVersionNum")
    private String applicationVersionNum;
    @ApiModelProperty(position = 7, required = true, value = "Name of Device request came from")
    @JsonProperty("applicationDeviceName")
    private String applicationDeviceName;
    @ApiModelProperty(position = 8, required = true, value = "Operating System for Device")
    @JsonProperty("applicationDeviceOS")
    private String applicationDeviceOS;
    @ApiModelProperty(position = 9, required = true, value = "MAC address of device")
    @JsonProperty("applicationDeviceMacAddress")
    private String applicationDeviceMacAddress;
    @ApiModelProperty(position = 10, required = true, value = "IP address of network")
    @JsonProperty("networkIpAddress")
    private String networkIpAddress;
    @ApiModelProperty(position = 11, required = true, value = "This is Pipe seperated request various parameters may be part of Path/Query Param")
    @JsonProperty("apiConsumerRecordText")
    private String apiConsumerRecordText;
    @ApiModelProperty(position = 12, required = true, value = "Authorization code provided by APIGEE")
    @JsonProperty("authorization")
    private String authorization;
    @ApiModelProperty(position = 13, required = true, value = "Transaction ID generated by APIGEE/Consumer - This is what LOGING API will primarily Pick")
    @JsonProperty("transactionId")
    private String transactionId;
    @ApiModelProperty(position = 14, required = true, value = "The MIME Type for the request.Example: application/json or text/xml")
    @JsonProperty("contentType")
    private String contentType;
    @ApiModelProperty(position = 15, required = true, value = "The format(MIME Type) of the response.Example: application/json or text/xml")
    @JsonProperty("accept")
    private String accept;
    @ApiModelProperty(position = 16, required = true, value = "Employee ID for user whose information requested to API")
    @JsonProperty("employeeId")
    private String employeeId;

    public String getApplicationOwnerCode() {
        return applicationOwnerCode;
    }

    public void setApplicationOwnerCode(String applicationOwnerCode) {
        this.applicationOwnerCode = applicationOwnerCode;
    }

    public String getRequestedEmployeeId() {
        return requestedEmployeeId;
    }

    public void setRequestedEmployeeId(String requestedEmployeeId) {
        this.requestedEmployeeId = requestedEmployeeId;
    }

    public String getApiResourceName() {
        return apiResourceName;
    }

    public void setApiResourceName(String apiResourceName) {
        this.apiResourceName = apiResourceName;
    }

    public String getApiRequestUtcTs() {
        return apiRequestUtcTs;
    }

    public void setApiRequestUtcTs(String apiRequestUtcTs) {
        this.apiRequestUtcTs = apiRequestUtcTs;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersionNum() {
        return applicationVersionNum;
    }

    public void setApplicationVersionNum(String applicationVersionNum) {
        this.applicationVersionNum = applicationVersionNum;
    }

    public String getApplicationDeviceName() {
        return applicationDeviceName;
    }

    public void setApplicationDeviceName(String applicationDeviceName) {
        this.applicationDeviceName = applicationDeviceName;
    }

    public String getApplicationDeviceOS() {
        return applicationDeviceOS;
    }

    public void setApplicationDeviceOS(String applicationDeviceOS) {
        this.applicationDeviceOS = applicationDeviceOS;
    }

    public String getApplicationDeviceMacAddress() {
        return applicationDeviceMacAddress;
    }

    public void setApplicationDeviceMacAddress(String applicationDeviceMacAddress) {
        this.applicationDeviceMacAddress = applicationDeviceMacAddress;
    }

    public String getNetworkIpAddress() {
        return networkIpAddress;
    }

    public void setNetworkIpAddress(String networkIpAddress) {
        this.networkIpAddress = networkIpAddress;
    }

    public String getApiConsumerRecordText() {
        return apiConsumerRecordText;
    }

    public void setApiConsumerRecordText(String apiConsumerRecordText) {
        this.apiConsumerRecordText = apiConsumerRecordText;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public static HeaderVo createReqHeader(List<String> hdrInpVlues) throws BsnObjExcp {
        HeaderVo hdrVo = new HeaderVo();
        if(!CollectionUtils.isEmpty(hdrInpVlues)){
	        hdrVo.setApplicationOwnerCode(hdrInpVlues.get(0));
	        hdrVo.setRequestedEmployeeId(hdrInpVlues.get(1));
	        hdrVo.setApiResourceName(hdrInpVlues.get(2));
	        hdrVo.setApiRequestUtcTs(hdrInpVlues.get(3));
	        hdrVo.setApplicationName(hdrInpVlues.get(4));
	        hdrVo.setApplicationVersionNum(hdrInpVlues.get(5));
	        hdrVo.setApplicationDeviceName(hdrInpVlues.get(6));
	        hdrVo.setApplicationDeviceOS(hdrInpVlues.get(7));
	        hdrVo.setApplicationDeviceMacAddress(hdrInpVlues.get(8));
	        hdrVo.setNetworkIpAddress(hdrInpVlues.get(9));
	        hdrVo.setApiConsumerRecordText(hdrInpVlues.get(10));
	        hdrVo.setAuthorization(hdrInpVlues.get(11));
	        hdrVo.setTransactionId(CmnUtils.gnrtTrnsctionId(hdrInpVlues.get(12)));
	        hdrVo.setContentType(hdrInpVlues.get(13));
	        hdrVo.setAccept(hdrInpVlues.get(14));
	        hdrVo.setEmployeeId(hdrInpVlues.get(15));
			if(!isValid(hdrVo)){
				throw new BsnObjExcp("Header Info is not Valid");
			}
        }
        return hdrVo;
    }

    public static HttpHeaders createReqHeader(HeaderVo hdrVo) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("applicationOwnerCode", hdrVo.getApplicationOwnerCode());
        headers.add("requestedEmployeeId", hdrVo.getRequestedEmployeeId());
        headers.add("apiResourceName", hdrVo.getApiResourceName());
        headers.add("apiRequestUtcTs", hdrVo.getApiRequestUtcTs());
        headers.add("applicationName", hdrVo.getApplicationName());
        headers.add("applicationVersionNum", hdrVo.getApplicationVersionNum());
        headers.add("applicationDeviceName", hdrVo.getApplicationDeviceName());
        headers.add("applicationDeviceOsName", hdrVo.getApplicationDeviceOS());
        headers.add("applicationDeviceMacAdr", hdrVo.getApplicationDeviceMacAddress());
        headers.add("networkIpAdr", hdrVo.getNetworkIpAddress());
        headers.add("apiConsumerRecordText", hdrVo.getApiConsumerRecordText());
        headers.add("Authorization", hdrVo.getAuthorization());
        headers.add("TransactionId", hdrVo.getTransactionId());
        headers.add("Content-Type", hdrVo.getContentType());
        headers.add("Accept", hdrVo.getAccept());
        headers.add("employeeId", hdrVo.getEmployeeId());
        return headers;
    }

  
    public static boolean isValid(HeaderVo hdrVo) {
        boolean isValid = true;
        if (StringUtils.isBlank(hdrVo.getApplicationOwnerCode())
                || StringUtils.isBlank(hdrVo.getApiResourceName())
                || StringUtils.isBlank(hdrVo.getApiRequestUtcTs())
                || StringUtils.isBlank(hdrVo.getApplicationName())
                || StringUtils.isBlank(hdrVo.getApplicationVersionNum())
                || StringUtils.isBlank(hdrVo.getApplicationDeviceName())
                || StringUtils.isBlank(hdrVo.getApplicationDeviceOS())
                || StringUtils.isBlank(hdrVo.getApplicationDeviceMacAddress())
                || StringUtils.isBlank(hdrVo.getNetworkIpAddress())
                || StringUtils.isBlank(hdrVo.getApiConsumerRecordText())
                || StringUtils.isBlank(hdrVo.getAuthorization())
                || StringUtils.isBlank(hdrVo.getEmployeeId())) {
            isValid = false;
        }
        return isValid;
    }
    
    @Override
    public String toString() {
        return "HeaderVo [applicationOwnerCode=" + applicationOwnerCode + ", requestedEmployeeId="
                + requestedEmployeeId + ", apiResourceName=" + apiResourceName
                + ", apiRequestUtcTs=" + apiRequestUtcTs + ", applicationName=" + applicationName
                + ", applicationVersionNum=" + applicationVersionNum + ", applicationDeviceName="
                + applicationDeviceName + ", applicationDeviceOS=" + applicationDeviceOS
                + ", applicationDeviceMacAddress=" + applicationDeviceMacAddress
                + ", networkIpAddress=" + networkIpAddress + ", apiConsumerRecordText="
                + apiConsumerRecordText + ", authorization=" + authorization + ", transactionId="
                + transactionId + ", contentType=" + contentType + ", accept=" + accept
                + ", employeeId=" + employeeId + "]";
    }

}

package com.delta.cru.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employee phone result object", value = "empPhVo")
public class EmpPhVo implements Serializable {
	private static final long serialVersionUID = 3342777523582079533L;
	@NotNull
	@Size(min = 1, max = 10)
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Employee ID", required = true)
	private String emplId;
	@NotNull
	@JsonProperty(required = true)
	@Size(min = 6, max = 20)
	@ApiModelProperty(value = "Existing phone number", required = true)
	private String emplPhNum;
	@ApiModelProperty(value = "New phone number")
	private String emplNewPhNum;
	@NotNull
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Existing Eff Date", required = true)
	private String effDate;
	@ApiModelProperty(value = "New Eff Date")
	private String newEffDate;
	@NotNull
	@JsonProperty(required = true)
	@Size(min = 1, max = 6)
	@ApiModelProperty(value = "Existing Phone type code", required = true)
	private String phTypCode;
	@Size(max = 6)
	@ApiModelProperty(value = "New Phone type code")
	private String newPhTypCode;
	@Size(max = 4)
	@ApiModelProperty(value = "Country number")
	private String ctryPhNum;
	@Size(max = 6)
	@ApiModelProperty(value = "Extension number")
	private String phExtsNum;
	@Size(max = 15)
	@ApiModelProperty(value = "Identification number")
	private String phPsnlIdntNum;
	@ApiModelProperty(value = "Expiry date")
	private String expDate;
	@ApiModelProperty(value = "Phone rank number")
	private Integer emplPhRnkNum;
	@Size(max = 6)
	@ApiModelProperty(value = "SVC code")
	private String crewPhSvcPvdrCode;
	@ApiModelProperty(value = "International phone indicator")
	private String intlPhNbInd;
	@Size(max = 3)
	@ApiModelProperty(value = "Country code")
	private String arptTmZnCtryCode;
	@Size(max = 2)
	@ApiModelProperty(value = "Dv code")
	private String arptTmZnDvCode;
	@Size(max = 10)
	@ApiModelProperty(value = "Creation user id")
	private String crtnUsrId;
	@ApiModelProperty(value = "Creation date time")
	private String crtnGdttmDate;
	@Size(max = 10)
	@ApiModelProperty(value = "Last updated user id")
	private String lstUpdtUsrId;
	@ApiModelProperty(value = "Last updated date time")
	private String lstUpdtGdttmDate;
	@ApiModelProperty(value = "Last updated sequence number")
	private long lstUpdtSqNum;
	@Size(max = 1)
	@ApiModelProperty(value = "SMS enabled")
	private String smsEnbdInd;
	private long seqNum;
	private String rtnCd;
	private String rtnMsg;

	public String getEmplId() {
		return emplId;
	}

	public void setEmplId(String emplId) {
		this.emplId = emplId;
	}

	public String getEmplPhNum() {
		return emplPhNum;
	}

	public void setEmplPhNum(String emplPhNum) {
		this.emplPhNum = emplPhNum;
	}

	public String getEmplNewPhNum() {
		return emplNewPhNum;
	}

	public void setEmplNewPhNum(String emplNewPhNum) {
		this.emplNewPhNum = emplNewPhNum;
	}

	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	public String getNewEffDate() {
		return newEffDate;
	}

	public void setNewEffDate(String newEffDate) {
		this.newEffDate = newEffDate;
	}

	public String getPhTypCode() {
		return phTypCode;
	}

	public void setPhTypCode(String phTypCode) {
		this.phTypCode = phTypCode;
	}

	public String getNewPhTypCode() {
		return newPhTypCode;
	}

	public void setNewPhTypCode(String newPhTypCode) {
		this.newPhTypCode = newPhTypCode;
	}

	public String getCtryPhNum() {
		return ctryPhNum;
	}

	public void setCtryPhNum(String ctryPhNum) {
		this.ctryPhNum = ctryPhNum;
	}

	public String getPhExtsNum() {
		return phExtsNum;
	}

	public void setPhExtsNum(String phExtsNum) {
		this.phExtsNum = phExtsNum;
	}

	public String getPhPsnlIdntNum() {
		return phPsnlIdntNum;
	}

	public void setPhPsnlIdntNum(String phPsnlIdntNum) {
		this.phPsnlIdntNum = phPsnlIdntNum;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public Integer getEmplPhRnkNum() {
		return emplPhRnkNum;
	}

	public void setEmplPhRnkNum(Integer emplPhRnkNum) {
		this.emplPhRnkNum = emplPhRnkNum;
	}

	public String getCrewPhSvcPvdrCode() {
		return crewPhSvcPvdrCode;
	}

	public void setCrewPhSvcPvdrCode(String crewPhSvcPvdrCode) {
		this.crewPhSvcPvdrCode = crewPhSvcPvdrCode;
	}

	public String getIntlPhNbInd() {
		return intlPhNbInd;
	}

	public void setIntlPhNbInd(String intlPhNbInd) {
		this.intlPhNbInd = intlPhNbInd;
	}

	public String getArptTmZnCtryCode() {
		return arptTmZnCtryCode;
	}

	public void setArptTmZnCtryCode(String arptTmZnCtryCode) {
		this.arptTmZnCtryCode = arptTmZnCtryCode;
	}

	public String getArptTmZnDvCode() {
		return arptTmZnDvCode;
	}

	public void setArptTmZnDvCode(String arptTmZnDvCode) {
		this.arptTmZnDvCode = arptTmZnDvCode;
	}

	public String getCrtnUsrId() {
		return crtnUsrId;
	}

	public void setCrtnUsrId(String crtnUsrId) {
		this.crtnUsrId = crtnUsrId;
	}

	public String getCrtnGdttmDate() {
		return crtnGdttmDate;
	}

	public void setCrtnGdttmDate(String crtnGdttmDate) {
		this.crtnGdttmDate = crtnGdttmDate;
	}

	public String getLstUpdtUsrId() {
		return lstUpdtUsrId;
	}

	public void setLstUpdtUsrId(String lstUpdtUsrId) {
		this.lstUpdtUsrId = lstUpdtUsrId;
	}

	public String getLstUpdtGdttmDate() {
		return lstUpdtGdttmDate;
	}

	public void setLstUpdtGdttmDate(String lstUpdtGdttmDate) {
		this.lstUpdtGdttmDate = lstUpdtGdttmDate;
	}

	public long getLstUpdtSqNum() {
		return lstUpdtSqNum;
	}

	public void setLstUpdtSqNum(long lstUpdtSqNum) {
		this.lstUpdtSqNum = lstUpdtSqNum;
	}

	public String getSmsEnbdInd() {
		return smsEnbdInd;
	}

	public void setSmsEnbdInd(String smsEnbdInd) {
		this.smsEnbdInd = smsEnbdInd;
	}
	
	public long getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(long seqNum) {
		this.seqNum = seqNum;
	}

	public String getRtnCd() {
		return rtnCd;
	}

	public void setRtnCd(String rtnCd) {
		this.rtnCd = rtnCd;
	}

	public String getRtnMsg() {
		return rtnMsg;
	}

	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmpPhVo [emplId=" + emplId + ", emplPhNum=" + emplPhNum + "]";
	}

}

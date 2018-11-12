package com.delta.cru.utils;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Utils API error response object
 */
@ApiModel(description = "Utils API error response object", value = "errorResponses")
public class ErrorResponses {
	@JsonProperty("code")
	private String code = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("developerMessage")
	private String developerMessage = null;

	@JsonProperty("moreInfo")
	private Object moreInfo = null;

	public ErrorResponses code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Error Code
	 * 
	 * @return code
	 **/
	@ApiModelProperty(value = "Error Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ErrorResponses message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Error message.
	 * 
	 * @return message
	 **/
	@ApiModelProperty(value = "Error message.")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorResponses developerMessage(String developerMessage) {
		this.developerMessage = developerMessage;
		return this;
	}

	/**
	 * Status depending on the success/failure of the call.
	 * 
	 * @return developerMessage
	 **/
	@ApiModelProperty(value = "Status depending on the success/failure of the call.")
	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public ErrorResponses moreInfo(Object moreInfo) {
		this.moreInfo = moreInfo;
		return this;
	}

	/**
	 * Status depending on the success/failure of the call.
	 * 
	 * @return moreInfo
	 **/
	@ApiModelProperty(value = "Status depending on the success/failure of the call.")
	public Object getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(Object moreInfo) {
		this.moreInfo = moreInfo;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		boolean checkEquals=false;
		if (this == o) {
			checkEquals= true;
		}
		if (o == null || getClass() != o.getClass()) {
			checkEquals= false;
		}
		return checkEquals;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message, developerMessage, moreInfo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorResponses {\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    developerMessage: ").append(toIndentedString(developerMessage)).append("\n");
		sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	public String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

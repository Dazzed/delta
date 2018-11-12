package com.delta.cru.vo;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Employee Display Name result object", value = "empNmeVo")
public class EmpNmeVo implements Serializable {
	private static final long serialVersionUID = -1981878286469494014L;
	@NotNull
	@Size(min = 1, max = 10)
	@JsonProperty(required = true)
	@ApiModelProperty(value = "Employee id", required = true)
	private String emplId;
	@ApiModelProperty(value = "Employee display name")
	private String emplName;

	public String getEmplId() {
		return emplId;
	}

	public void setEmplId(String emplId) {
		this.emplId = emplId;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}

	@Override
	public String toString() {
		return "EmpNmeVo [emplId=" + emplId + ", emplName=" + emplName + "]";
	}

}

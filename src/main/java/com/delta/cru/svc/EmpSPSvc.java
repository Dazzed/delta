package com.delta.cru.svc;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.cru.bo.EmpDtlsSPBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.vo.EmpPhVo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmpSPSvc extends BaseSvc {
	@Autowired
	private EmpDtlsSPBoIfc empSPBo;

	@RequestMapping(value = "/example/storedProcedure/v1/employees", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Insert the employee phone number record", notes = "Insert employee phone record", response = EmpPhVo.class, nickname = "insPhn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Phone record inserted"),
			@ApiResponse(code = 201, message = "Phone record inserted", response = EmpPhVo.class) })
	public ResponseEntity<EmpPhVo> insPhnBySPV1(
			@ApiParam(value = "Employee Phone Object", name = "employeePhone") @RequestBody @Valid EmpPhVo empPhVo)
			throws BsnObjExcp {
		try {
			int rtrncd = empSPBo.insPhnBySP(empPhVo);
			if (rtrncd < 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empPhVo);
			}
			return ResponseEntity.status(HttpStatus.OK).body(empPhVo);
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(empPhVo);
		}
	}

	@RequestMapping(value = "/example/storedProcedure/v1/employees", method = RequestMethod.PUT, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Update the employee phone number record", notes = "Update employee phone record", response = EmpPhVo.class, nickname = "updtPhn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Phone record updated"),
			@ApiResponse(code = 201, message = "Phone record updated", response = EmpPhVo.class) })
	public ResponseEntity<EmpPhVo> updtPhnBySPV1(
			@ApiParam(value = "Employee Phone Object", name = "employeePhone") @RequestBody @Valid EmpPhVo phUpdVo)
			throws BsnObjExcp {
		try {
			int rtrncd = empSPBo.updtPhnBySP(phUpdVo);
			if (rtrncd < 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(phUpdVo);
			}
			return ResponseEntity.status(HttpStatus.OK).body(phUpdVo);
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(phUpdVo);
		}
	}

	@RequestMapping(value = "/example/storedProcedure/v1/employees", method = RequestMethod.DELETE, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Delete the employee phone number record", notes = "Delete employee phone record", response = EmpPhVo.class, nickname = "delPhn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Phone record deleted") })
	public ResponseEntity<EmpPhVo> delPhnBySPV1(
			@ApiParam(value = "Employee Object", name = "employee") @RequestBody @Valid EmpPhVo empPk)
			throws BsnObjExcp {
		try {
			int rtrncd = empSPBo.delPhnBySP(empPk);
			if (rtrncd < 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empPk);
			}
			return ResponseEntity.status(HttpStatus.OK).body(empPk);
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(empPk);
		}
	}

}

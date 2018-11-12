package com.delta.cru.svc;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.cru.bo.EmpDtlsBoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmpSvc extends BaseSvc {
	@Autowired
	private EmpDtlsBoIfc empBo;

	@RequestMapping(value = "/example/sql/v1/employees/names", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Gets the employee details for passed employee id", notes = "Gets employee name", response = EmpNmeVo.class, nickname = "fndEmp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of employee."),
			@ApiResponse(code = 201, message = "Not Created", response = EmpNmeVo.class),
			@ApiResponse(code = 204, message = "Name not found", response = EmpNmeVo.class) })
	public ResponseEntity<EmpNmeVo> fndEmpV1(
			@ApiParam(value = "Employee ID", name = "empId") @RequestBody String empId) throws BsnObjExcp {
		List<EmpNmeVo> empNmeVos = null;
		EmpNmeVo emp = new EmpNmeVo();
		if (empId.equalsIgnoreCase("{}")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(emp);
		}
		try {
			empNmeVos = empBo.fndEmp(empId);
			if (CollectionUtils.sizeIsEmpty(empNmeVos)) {
				emp.setEmplId(empId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emp);
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(empNmeVos.get(0));
			}
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emp);
		}
	}

	@RequestMapping(value = "/example/sql/v2/employees/names", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Gets the employee details for passed employee id", notes = "Gets employee name - Version 2.0", response = EmpNmeVo.class, nickname = "fndEmp")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of employee."),
			@ApiResponse(code = 201, message = "Not Created", response = EmpNmeVo.class),
			@ApiResponse(code = 204, message = "Name not found", response = EmpNmeVo.class) })
	public ResponseEntity<EmpNmeVo> fndEmpV2(@ApiParam(value = "Employee ID", name = "empId") @RequestBody String empId)
			throws BsnObjExcp {
		/*
		 *  This method has been written to introduce versioning and so, has the duplicate implementation
		 * */
		List<EmpNmeVo> empNmeVos = null;
		EmpNmeVo emp = new EmpNmeVo();
		if (empId.equalsIgnoreCase("{}")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(emp);
		}
		try {
			empNmeVos = empBo.fndEmp(empId);
			if (CollectionUtils.sizeIsEmpty(empNmeVos)) {
				emp.setEmplId(empId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emp);
			}else{
				return ResponseEntity.status(HttpStatus.OK).body(empNmeVos.get(0));
			}
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emp);
		}
	}

	@RequestMapping(value = "/example/sql/v1/employees/phones", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Gets the employee phone number record for passed employee id", notes = "Gets employee phone record", response = EmpPhVo.class, responseContainer = "List", nickname = "fndEmpPhns")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of phone records."),
			@ApiResponse(code = 201, message = "Not Created", response = EmpPhVo.class, responseContainer = "List"),
			@ApiResponse(code = 204, message = "Phone record not found", response = EmpPhVo.class, responseContainer = "List") })
	public ResponseEntity<List<EmpPhVo>> fndEmpPhnsV1(
			@ApiParam(value = "Employee ID", name = "empId") @RequestBody String empId) throws BsnObjExcp {
		List<EmpPhVo> empPhs = new ArrayList<>();
		EmpPhVo empPhVo=new EmpPhVo();
		if (empId.equalsIgnoreCase("{}")) {
			empPhs.add(empPhVo);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(empPhs);
		}
		try {
			empPhs = empBo.fndEmpPhns(empId);
			if (CollectionUtils.sizeIsEmpty(empPhs)) {
				empPhVo.setEmplId(empId);
				empPhs.add(empPhVo);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empPhs);
			}else{
				return ResponseEntity.status(HttpStatus.OK).body(empPhs);
			}
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(empPhs);
		}
	}

	@RequestMapping(value = "/example/sql/v1/employees", method = RequestMethod.POST, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Insert the employee phone number record", notes = "Insert employee phone record", response = EmpPhVo.class, nickname = "insPhn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Phone record inserted"),
			@ApiResponse(code = 201, message = "Phone record inserted", response = EmpPhVo.class) })
	public ResponseEntity<EmpPhVo> insPhnV1(
			@ApiParam(value = "Employee Phone Object", name = "employeePhone") @RequestBody @Valid EmpPhVo empPhVo)
			throws BsnObjExcp {
		try {
			int rowImptd = empBo.insPhn(empPhVo);
			if (rowImptd <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empPhVo);
			}
			return ResponseEntity.status(HttpStatus.OK).body(empPhVo);
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(empPhVo);
		}
	}

	@RequestMapping(value = "/example/sql/v1/employees", method = RequestMethod.PUT, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Update the employee phone number record", notes = "Update employee phone record", response = EmpPhVo.class, nickname = "updtPhn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Phone record updated"),
			@ApiResponse(code = 201, message = "Phone record updated", response = EmpPhVo.class) })
	public ResponseEntity<EmpPhVo> updtPhnV1(
			@ApiParam(value = "Employee Phone Object", name = "employeePhone") @RequestBody @Valid EmpPhVo phUpdVo)
			throws BsnObjExcp {
		try {
			int rowImptd = empBo.updtPhn(phUpdVo);
			if (rowImptd <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(phUpdVo);
			}
			return ResponseEntity.status(HttpStatus.OK).body(phUpdVo);
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(phUpdVo);
		}
	}

	@RequestMapping(value = "/example/sql/v1/employees", method = RequestMethod.DELETE, produces = {
			"application/json" }, consumes = { "application/json" })
	@ApiOperation(value = "Delete the employee phone number record", notes = "Delete employee phone record", response = EmpPhVo.class, nickname = "delPhn")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Phone record deleted") })
	public ResponseEntity<EmpPhVo> delPhnV1(
			@ApiParam(value = "Employee Object", name = "employee") @RequestBody @Valid EmpPhVo empPk)
			throws BsnObjExcp {
		try {
			int rowImptd = empBo.delPhn(empPk);
			if (rowImptd <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(empPk);
			}
			return ResponseEntity.status(HttpStatus.OK).body(empPk);
		} catch (BsnObjExcp bsnEx) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(empPk);
		}
	}

}

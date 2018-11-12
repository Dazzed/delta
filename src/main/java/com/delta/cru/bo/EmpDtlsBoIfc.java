package com.delta.cru.bo;

import java.util.List;

import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

public interface EmpDtlsBoIfc {
	List<EmpNmeVo> fndEmp(String empId) throws BsnObjExcp;

	List<EmpPhVo> fndEmpPhns(String empId) throws BsnObjExcp;

	int insPhn(EmpPhVo empPhVo) throws BsnObjExcp;

	int updtPhn(EmpPhVo phUpdVo) throws BsnObjExcp;

	int delPhn(EmpPhVo empPkVo) throws BsnObjExcp;

}

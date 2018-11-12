package com.delta.cru.bo;

import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.vo.EmpPhVo;

public interface EmpDtlsSPBoIfc {
	 int insPhnBySP(EmpPhVo empPhVo) throws BsnObjExcp;

	 int updtPhnBySP(EmpPhVo phUpdVo) throws BsnObjExcp;

	 int delPhnBySP(EmpPhVo empPkVo) throws BsnObjExcp;


}

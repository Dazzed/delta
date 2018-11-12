package com.delta.cru.dao;

import java.sql.Date;
import java.util.List;

import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

public interface EmpDaoIfc {
	List<EmpNmeVo> fndEmp(String empId) throws DataAcesExcp;

	List<EmpPhVo> fndEmpPhns(String empId) throws DataAcesExcp;

	int insPhn(EmpPhVo employee) throws DataAcesExcp;

	int updtPhn(EmpPhVo employee) throws DataAcesExcp;

	int delPhn(EmpPhVo employee) throws DataAcesExcp;

	Date getSysDate() throws DataAcesExcp;

	long getSeq() throws DataAcesExcp;
}

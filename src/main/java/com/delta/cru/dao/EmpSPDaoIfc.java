package com.delta.cru.dao;

import java.sql.Date;

import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EmpPhVo;

public interface EmpSPDaoIfc {
	int insPhnBySP(EmpPhVo employee) throws DataAcesExcp;

	int updtPhnBySP(EmpPhVo employee) throws DataAcesExcp;

	int delPhnBySP(EmpPhVo employee) throws DataAcesExcp;

	Date getSysDate() throws DataAcesExcp;

	long getSeq() throws DataAcesExcp;
}

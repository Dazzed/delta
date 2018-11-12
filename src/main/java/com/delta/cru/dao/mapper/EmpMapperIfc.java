package com.delta.cru.dao.mapper;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.delta.cru.vo.EmpNmeVo;
import com.delta.cru.vo.EmpPhVo;

@Component
public interface EmpMapperIfc {
	List<EmpNmeVo> fndEmp(String emplId);

	List<EmpPhVo> fndEmpPhns(String emplId);

	int insPhn(EmpPhVo empl);

	int updtPhn(EmpPhVo empl);

	int delPhn(EmpPhVo empl);

	Date getSysDate();

	long getSeq();
}

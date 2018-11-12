package com.delta.cru.dao.mapper;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.delta.cru.vo.EmpPhVo;

@Component
public interface EmpSPMapperIfc {
	int insPhnBySP(EmpPhVo empl);

	int updtPhnBySP(EmpPhVo empl);

	int delPhnBySP(EmpPhVo empl);

	Date getSysDate();

	long getSeq();
}

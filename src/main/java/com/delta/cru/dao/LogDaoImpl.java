package com.delta.cru.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.delta.cru.dao.mapper.LogMapperIfc;
import com.delta.cru.excp.DataAcesExcp;

@Repository
public class LogDaoImpl implements LogDaoIfc {
	@Autowired
	private LogMapperIfc logMapper;

	@Override
	public String getLogMsg(String msgCd) throws DataAcesExcp {
		String logMsgTxt = null;
		try {
			logMsgTxt = logMapper.getLogMsg(msgCd);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
		return logMsgTxt;
	}
}

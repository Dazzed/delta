
package com.delta.cru.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delta.cru.dao.LogDaoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;

@Service
public class LogMsgBoImpl implements LogMsgBoIfc {
	@Autowired
	private LogDaoIfc logDao;

	@Override
	public String getLogMsg(String msgCd) throws BsnObjExcp {
		String logMsgTxt = "";
		try {
			logMsgTxt = logDao.getLogMsg(msgCd);
		} catch (DataAcesExcp excp) {
			throw new BsnObjExcp(excp);
		}
		return logMsgTxt;
	}

}

package com.delta.cru.dao;

import com.delta.cru.excp.DataAcesExcp;

public interface LogDaoIfc {
    String getLogMsg(String msgCd) throws DataAcesExcp;
}

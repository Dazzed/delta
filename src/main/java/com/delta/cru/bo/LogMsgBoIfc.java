package com.delta.cru.bo;

import com.delta.cru.excp.BsnObjExcp;

public interface LogMsgBoIfc {
    String getLogMsg(String msgCd) throws BsnObjExcp;
}

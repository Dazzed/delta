package com.delta.cru.dao.mapper;

import org.springframework.stereotype.Component;

@Component
public interface LogMapperIfc {
    
    String getLogMsg(String msgCd);
}

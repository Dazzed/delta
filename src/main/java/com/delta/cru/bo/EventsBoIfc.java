package com.delta.cru.bo;

import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EventLocationVo;
import com.delta.cru.vo.EventNeedsVo;
import com.delta.cru.vo.EventUserVo;
import com.delta.cru.vo.EventVo;
import com.delta.cru.vo.EventsVo;

public interface EventsBoIfc {

	EventsVo getEventDetails(String id) throws BsnObjExcp;

	int insEventUser(EventUserVo eventUser) throws DataAcesExcp;

	int insEvent(EventVo event) throws DataAcesExcp;

	int insEventLocation(EventLocationVo eventLocation) throws DataAcesExcp;

	int insEventNeeds(EventNeedsVo eventNeeds) throws DataAcesExcp;

	String insEventDetails(EventsVo eventDetails) throws DataAcesExcp;

}

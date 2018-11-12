package com.delta.cru.dao.mapper;

import org.springframework.stereotype.Component;

import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EventLocationVo;
import com.delta.cru.vo.EventNeedsVo;
import com.delta.cru.vo.EventUserLocationNeedsVo;
import com.delta.cru.vo.EventUserVo;
import com.delta.cru.vo.EventVo;
import com.delta.cru.vo.EventsVo;

@Component
public interface EventMapperIfc {
	
	
	EventUserVo getEventUser(String id) throws DataAcesExcp;
	
	EventVo getEvent(String id) throws DataAcesExcp;
	
	EventLocationVo getEventLocation(String id) throws DataAcesExcp;
	
	EventNeedsVo getEventNeeds(String id) throws DataAcesExcp;
	
	EventUserLocationNeedsVo getEventUserLocationNeeds (String id) throws DataAcesExcp;
	
	int insEventUser(EventUserVo eventUser) throws DataAcesExcp;

	int insEvent(EventVo event) throws DataAcesExcp;

	int insEventLocation(EventLocationVo eventLocation) throws DataAcesExcp;

	int insEventNeeds(EventNeedsVo eventNeeds) throws DataAcesExcp;

	int insEventDetails(EventsVo events) throws DataAcesExcp;

	String getSeq();

	int insEventUserLocationNeeds(EventUserLocationNeedsVo eventUserLocationNeeds);
}

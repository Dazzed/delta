
package com.delta.cru.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.delta.cru.dao.EventsDaoIfc;
import com.delta.cru.excp.BsnObjExcp;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EventLocationVo;
import com.delta.cru.vo.EventNeedsVo;
import com.delta.cru.vo.EventUserLocationNeedsVo;
import com.delta.cru.vo.EventUserVo;
import com.delta.cru.vo.EventVo;
import com.delta.cru.vo.EventsVo;

@Service
public class EventsBoImpl implements EventsBoIfc {
	@Autowired
	private EventsDaoIfc daoIfc;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public EventsVo getEventDetails(String id) throws BsnObjExcp {
		
		EventsVo eventsVo = new EventsVo();
		try {
			
			EventUserLocationNeedsVo eventUserLocationNeedsVo = daoIfc.getEventUserLocationNeeds(id);
			EventUserVo eventUserVo = daoIfc.getEventUser(eventUserLocationNeedsVo.getUser_id());
			EventVo eventVo = daoIfc.getEvent(eventUserLocationNeedsVo.getEvent_id());
			EventLocationVo eventLocationVo = daoIfc.getEventLocation(eventUserLocationNeedsVo.getLocation_id());
			EventNeedsVo eventNeedsVo = daoIfc.getEventNeeds(eventUserLocationNeedsVo.getNeeds_id());
			eventsVo.setUser(eventUserVo);
			eventsVo.setEvent(eventVo);
			eventsVo.setLocation(eventLocationVo);
			eventsVo.setNeeds(eventNeedsVo);
			eventsVo.setId(id);
			
		} catch (DataAcesExcp e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return eventsVo;
	}

	@Override
	public int insEventUser(EventUserVo eventUser) throws DataAcesExcp {
		return daoIfc.insEventUser(eventUser);
	}

	@Override
	public int insEvent(EventVo event) throws DataAcesExcp {
		return daoIfc.insEvent(event);
	}

	@Override
	public int insEventLocation(EventLocationVo eventLocation) throws DataAcesExcp {
		return daoIfc.insEventLocation(eventLocation);
	}

	@Override
	public int insEventNeeds(EventNeedsVo eventNeeds) throws DataAcesExcp {
		return daoIfc.insEventNeeds(eventNeeds);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "transactionManager", rollbackFor = BsnObjExcp.class)
	public String insEventDetails(EventsVo eventDetails) throws DataAcesExcp {

		String userId = daoIfc.getSeq();
		String eventId = daoIfc.getSeq();
		String locationId = daoIfc.getSeq();
		String needId = daoIfc.getSeq();

		// setting ids
		eventDetails.getUser().setUser_id(userId);
		eventDetails.getEvent().setEvent_id(eventId);
		;
		eventDetails.getLocation().setLocation_id(locationId);
		;
		eventDetails.getNeeds().setNeeds_id(needId);
		;

		// insert into tables
		this.insEventUser(eventDetails.getUser());
		this.insEvent(eventDetails.getEvent());
		this.insEventLocation(eventDetails.getLocation());
		this.insEventNeeds(eventDetails.getNeeds());

		String eventDetailsId = daoIfc.getSeq();
		EventUserLocationNeedsVo eventUserLocationNeeds = new EventUserLocationNeedsVo();
		eventUserLocationNeeds.setEvent_details_id(eventDetailsId);
		eventUserLocationNeeds.setUser_id(String.valueOf(userId));
		eventUserLocationNeeds.setEvent_id(String.valueOf(eventId));
		eventUserLocationNeeds.setLocation_id(String.valueOf(locationId));
		eventUserLocationNeeds.setNeeds_id(String.valueOf(needId));

		daoIfc.insEventUserLocationNeeds(eventUserLocationNeeds);
		
		return eventDetailsId;
	}

}

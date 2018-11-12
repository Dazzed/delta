package com.delta.cru.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.delta.cru.dao.mapper.EventMapperIfc;
import com.delta.cru.excp.DataAcesExcp;
import com.delta.cru.vo.EventLocationVo;
import com.delta.cru.vo.EventNeedsVo;
import com.delta.cru.vo.EventUserLocationNeedsVo;
import com.delta.cru.vo.EventUserVo;
import com.delta.cru.vo.EventVo;
import com.delta.cru.vo.EventsVo;

@Repository
public class EventsDaoImpl implements EventsDaoIfc {
	@Autowired
	private EventMapperIfc mapperIfc;

	@Override
	public int insEventUser(EventUserVo eventUser) throws DataAcesExcp {
		try {
			return mapperIfc.insEventUser(eventUser);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public int insEvent(EventVo event) throws DataAcesExcp {
		try {
			return mapperIfc.insEvent(event);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public int insEventLocation(EventLocationVo eventLocation) throws DataAcesExcp {
		try {
			return mapperIfc.insEventLocation(eventLocation);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public int insEventNeeds(EventNeedsVo eventNeeds) throws DataAcesExcp {
		try {
			return mapperIfc.insEventNeeds(eventNeeds);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public int insEventDetails(EventsVo eventDetails) throws DataAcesExcp {
		try {
			return mapperIfc.insEventDetails(eventDetails);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public String getSeq() throws DataAcesExcp {
		return mapperIfc.getSeq();
	}

	@Override
	public int insEventUserLocationNeeds(EventUserLocationNeedsVo eventUserLocationNeeds) throws DataAcesExcp {
		try {
			return mapperIfc.insEventUserLocationNeeds(eventUserLocationNeeds);
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public EventUserVo getEventUser(String id) throws DataAcesExcp {
		try {
			return mapperIfc.getEventUser(String.valueOf(id));
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public EventVo getEvent(String id) throws DataAcesExcp {
		try {
			return mapperIfc.getEvent(String.valueOf(id));
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public EventLocationVo getEventLocation(String id) throws DataAcesExcp {
		try {
			return mapperIfc.getEventLocation(String.valueOf(id));
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public EventNeedsVo getEventNeeds(String id) throws DataAcesExcp {
		try {
			return mapperIfc.getEventNeeds(String.valueOf(id));
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}

	@Override
	public EventUserLocationNeedsVo getEventUserLocationNeeds(String id) throws DataAcesExcp {
		try {
			return mapperIfc.getEventUserLocationNeeds(String.valueOf(id));
		} catch (DataAccessException excp) {
			throw new DataAcesExcp(excp);
		}
	}
}

package com.delta.cru.vo;

public class EventsVo {

	private String id;
	private EventUserVo user;
	private EventVo event;
	private EventLocationVo location;
	private EventNeedsVo needs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EventUserVo getUser() {
		return user;
	}

	public void setUser(EventUserVo user) {
		this.user = user;
	}

	public EventVo getEvent() {
		return event;
	}

	public void setEvent(EventVo event) {
		this.event = event;
	}

	public EventLocationVo getLocation() {
		return location;
	}

	public void setLocation(EventLocationVo location) {
		this.location = location;
	}

	public EventNeedsVo getNeeds() {
		return needs;
	}

	public void setNeeds(EventNeedsVo needs) {
		this.needs = needs;
	}

}

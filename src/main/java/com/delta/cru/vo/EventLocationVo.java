package com.delta.cru.vo;

public class EventLocationVo {

	private String location_id;

	private String event_location;
	private String preferred_hotel;
	private String event_budget;
	private String last_year_hotel;

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getEvent_location() {
		return event_location;
	}

	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}

	public String getPreferred_hotel() {
		return preferred_hotel;
	}

	public void setPreferred_hotel(String preferred_hotel) {
		this.preferred_hotel = preferred_hotel;
	}

	public String getEvent_budget() {
		return event_budget;
	}

	public void setEvent_budget(String event_budget) {
		this.event_budget = event_budget;
	}

	public String getLast_year_hotel() {
		return last_year_hotel;
	}

	public void setLast_year_hotel(String last_year_hotel) {
		this.last_year_hotel = last_year_hotel;
	}

}

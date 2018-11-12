package com.delta.cru.vo;

public class EventVo {

	private String event_id;

	private String name;
	private String sponsor;
	private String event_date;
	private String rooms;
	private String guests;
	private String is_flexible;
	private String is_repeating;

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getGuests() {
		return guests;
	}

	public void setGuests(String guests) {
		this.guests = guests;
	}

	public String getIs_flexible() {
		return is_flexible;
	}

	public void setIs_flexible(String is_flexible) {
		this.is_flexible = is_flexible;
	}

	public String getIs_repeating() {
		return is_repeating;
	}

	public void setIs_repeating(String is_repeating) {
		this.is_repeating = is_repeating;
	}

}

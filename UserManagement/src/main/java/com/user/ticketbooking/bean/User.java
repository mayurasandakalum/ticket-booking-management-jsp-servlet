package com.user.ticketbooking.bean;

public class User {

	private int id;
	private String email;
	private String eventName;
	private int ticketCount;
	private String ticketType;

	public User(String email, String eventName, int ticketCount, String ticketType) {  //constructor
		super();
		this.email = email;
		this.eventName = eventName;
		this.ticketCount = ticketCount;
		this.ticketType = ticketType;
	}

	public User(int id, String email, String eventName, int ticketCount, String ticketType) {
		super();
		this.id = id;
		this.email = email;
		this.eventName = eventName;
		this.ticketCount = ticketCount;
		this.ticketType = ticketType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
}

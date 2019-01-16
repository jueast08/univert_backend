package com.univert.service;

public class StatusService {
	private final static String onGoingStatus = "InProgress";
	private final static String closedStatus = "Closed";
	private final static String canceledStatus = "Canceled";
	private final static String openStatus = "Open";
	
	public static String getOnGoingStatus() {
		return onGoingStatus;
	}
	public static String getClosedStatus() {
		return closedStatus;
	}
	public static String getCanceledStatus() {
		return canceledStatus;
	}
	public static String getOpenStatus() {
		return openStatus;
	}
}

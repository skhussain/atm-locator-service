package com.locatorService.models;

public class ParentResponse {
	private String returnCode;
	private String statusMessage;
	
	public ParentResponse() {
	}
	public ParentResponse(String returnCode, String statusMessage) {
		this.returnCode = returnCode;
		this.statusMessage = statusMessage;
	}
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}

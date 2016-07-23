package com.mk.projects.cbUtil;

public class CBOperationResponse {
	private boolean successful;
	private String message;
	private String reasonCode;
	private String errorStack;
	
	public CBOperationResponse () {
		this.successful = true;
	}
	
	public CBOperationResponse (String reasonCode, String message, String errorStack) {
		this.successful = false;
		this.reasonCode = reasonCode;
		this.message = message;
		this.errorStack = errorStack;
	}
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getErrorStack() {
		return errorStack;
	}
	public void setErrorStack(String errorStack) {
		this.errorStack = errorStack;
	}
}

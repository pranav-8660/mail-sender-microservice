package com.pranav.driveportal.mailsendermicroservice.model;



public class MailModel {
	
	private String title;
	private String message;
	private String to;
	
	public MailModel(String to, String title, String message) {
		super();
		this.title = title;
		this.message = message;
		this.to=to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "MailModel [title=" + title + ", message=" + message + ", to=" + to + "]";
	}
	
	
	
	

}

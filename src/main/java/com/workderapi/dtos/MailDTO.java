package com.workderapi.dtos;

import java.io.Serializable;

public class MailDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String fromEmail;
	
	private String password;
	
	private String toEmail;
	
	private String title;
	
	private String text;
	
	/*---------------------GETTERS AND SETTERS---------------------*/
	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}

package com.example.spring567.models;

import jakarta.validation.constraints.NotEmpty;

public class DropdownDto {
	
	@NotEmpty(message="This field is Required")
	private String home;
	@NotEmpty(message="This field is Required")
	private String aboutus;
	@NotEmpty(message="This field is Required")
	private String services;
	@NotEmpty(message="This field is Required")
	private String contactus;
	@NotEmpty(message="This field is Required")
	private String login;
	@NotEmpty(message="This field is Required")
	private String logout;
	@NotEmpty(message="This field is Required")
	private String feedback;
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getAboutus() {
		return aboutus;
	}
	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getContactus() {
		return contactus;
	}
	public void setContactus(String contactus) {
		this.contactus = contactus;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		this.logout = logout;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

}

package com.example.spring567.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="dropdown")

public class Dropdown {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String home;
	private String aboutus;
	private String services;
	private String contactus;
	private String login;
	private String logout;
	private String feedback;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Dropdown(String home, String aboutus, String services, String contactus, String login, String logout,
			String feedback) {
		super();
		
		this.home = home;
		this.aboutus = aboutus;
		this.services = services;
		this.contactus = contactus;
		this.login = login;
		this.logout = logout;
		this.feedback = feedback;
	}
	public Dropdown(int id) {
		super();
		this.id = id;
		
	}
	public Dropdown() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dropdown [id=" + id + ", home=" + home + ", aboutus=" + aboutus + ", services=" + services + ", contactus=" + contactus
				+ ", login=" + login + ", logout=" + logout + ", feedback=" + feedback + "]";
	}
	

}

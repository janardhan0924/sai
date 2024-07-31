package com.example.spring567.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name="navbar")
public class Navbar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String heading1;
	private String heading2;
	private String heading3;
	private String heading4;
	private String heading5;
	private String heading6;
	private String heading7;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeading1() {
		return heading1;
	}
	public void setHeading1(String heading1) {
		this.heading1 = heading1;
	}
	public String getHeading2() {
		return heading2;
	}
	public void setHeading2(String heading2) {
		this.heading2 = heading2;
	}
	public String getHeading3() {
		return heading3;
	}
	public void setHeading3(String heading3) {
		this.heading3 = heading3;
	}
	public String getHeading4() {
		return heading4;
	}
	public void setHeading4(String heading4) {
		this.heading4 = heading4;
	}
	public String getHeading5() {
		return heading5;
	}
	public void setHeading5(String heading5) {
		this.heading5 = heading5;
	}
	public String getHeading6() {
		return heading6;
	}
	public void setHeading6(String heading6) {
		this.heading6 = heading6;
	}
	public String getHeading7() {
		return heading7;
	}
	public void setHeading7(String heading7) {
		this.heading7 = heading7;
	}
	public Navbar(int id, String heading1, String heading2, String heading3, String heading4, String heading5,
			String heading6, String heading7) {
		super();
		this.id = id;
		this.heading1 = heading1;
		this.heading2 = heading2;
		this.heading3 = heading3;
		this.heading4 = heading4;
		this.heading5 = heading5;
		this.heading6 = heading6;
		this.heading7 = heading7;
	}
	public Navbar() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Navbar [id=" + id + ", heading1=" + heading1 + ", heading2=" + heading2 + ", heading3=" + heading3
				+ ", heading4=" + heading4 + ", heading5=" + heading5 + ", heading6=" + heading6 + ", heading7="
				+ heading7 + "]";
	}
	
	}
	

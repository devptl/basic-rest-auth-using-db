package com.mindfire.MappingDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String details;
	int zip;
	
	public Address() {
		System.out.println("Address created!");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
}

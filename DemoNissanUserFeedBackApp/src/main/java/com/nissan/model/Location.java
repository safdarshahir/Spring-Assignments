package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TblLocation")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationId;
	
	@Column(nullable=false,unique=true)
	private String locationName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private List<User> users;

	//default constructor
	public Location() {
		super();
	}

	//parameterized constructor
	public Location(int locationId, String locationName, List<User> users) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.users = users;
	}

	//getters and setters
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	//Override toString
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", users=" + users + "]";
	}
	
	
	
	
}

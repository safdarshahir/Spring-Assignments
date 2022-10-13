package com.nissan.dto;

public class UserLocationPostDTO {
	
	private int userId;
	private String userName;
	
	private String locationName;
	private String postDetails;
	
	//default constructor
	public UserLocationPostDTO() {
		super();
	}
	
	//parameterized constructor
	public UserLocationPostDTO(int userId, String userName, String locationName, String postDetails) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.locationName = locationName;
		this.postDetails = postDetails;
	}
	
	//getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}
	
	//overriding toString
	@Override
	public String toString() {
		return "UserLocationPostDTO [userId=" + userId + ", userName=" + userName + ", locationName=" + locationName
				+ ", postDetails=" + postDetails + "]";
	}

	
	

}

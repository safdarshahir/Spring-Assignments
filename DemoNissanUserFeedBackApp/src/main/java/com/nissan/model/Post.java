package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="TblPost")
public class Post {
	
	//declare fields 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	@Column(nullable = false)
	private String postDetails;
	
	private LocalDate postDate;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
	//default constructor
	public Post() {
		super();
	}

	//parameterized constructor
	public Post(int postId, String postDetails, LocalDate postDate, User user) {
		super();
		this.postId = postId;
		this.postDetails = postDetails;
		this.postDate = postDate;
		this.user = user;
	}

	
	//getter and setters
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostDetails() {
		return postDetails;
	}

	public void setPostDetails(String postDetails) {
		this.postDetails = postDetails;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//override toString()
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postDetails=" + postDetails + ", postDate=" + postDate + ", user=" + user
				+ "]";
	}
	
	
	
	
	
	

}

package com.nissan.service;

import java.util.List;

import com.nissan.dto.UserLocationPostDTO;
import com.nissan.model.Post;

public interface IPostService {
	
	//Add post
	Post addPost(Post post);
	
	//List posts
	List<Post> listAllPost();
	
	//get users and posts
	List<UserLocationPostDTO> getAllUserLocPosts();

}

package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dto.UserLocationPostDTO;
import com.nissan.model.Post;
import com.nissan.service.IPostService;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class PostController {
	
	@Autowired
	IPostService postService;

	@PostMapping("posts/add")
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}
	
	@GetMapping("posts")
	public List<Post> listAllPosts(){
		return postService.listAllPost();
	}
	
	@GetMapping("posts/getuserandposts")
	public List<UserLocationPostDTO> listUserAndPosts(){
		return postService.getAllUserLocPosts();
	}
	

}

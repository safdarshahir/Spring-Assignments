package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dto.UserLocationPostDTO;
import com.nissan.model.Post;
import com.nissan.repo.IPostRepository;

@Service
public class PostServiceImpl implements IPostService{

	@Autowired
	IPostRepository postRepo;
	
	@Override
	@Transactional
	public Post addPost(Post post) {
		return postRepo.save(post);
	}

	@Override
	public List<Post> listAllPost() {
		return postRepo.findAll();
	}

	@Override
	public List<UserLocationPostDTO> getAllUserLocPosts() {
		return postRepo.getAllUserLocPosts();
	}

}

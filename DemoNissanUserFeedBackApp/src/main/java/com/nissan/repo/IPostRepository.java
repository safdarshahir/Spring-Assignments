package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.dto.UserLocationPostDTO;
import com.nissan.model.Post;

@Repository
public interface IPostRepository extends JpaRepositoryImplementation<Post, Integer> {
	
	@Query("SELECT new  com.nissan.dto.UserLocationPostDTO(u.userId,u.userName,l.locationName,p.postDetails)"
			+ "FROM User u INNER JOIN u.location l INNER JOIN u.posts p ORDER BY u.userId")
	List<UserLocationPostDTO> getAllUserLocPosts();
}

package com.posts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posts.entities.Post;
import com.posts.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService 
{
	@Autowired
	PostRepository repo;

	
	public void createPost(Post post) {
		repo.save(post);
	}
}

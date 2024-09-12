package com.posts.controller;

import java.io.IOException;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.posts.entities.Post;
import com.posts.services.PostService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PostController 
{
	@Autowired
	PostService service;
	
	@PostMapping("/createPost")
	public String createPost( @RequestParam("caption") String caption,
						@RequestParam ("photo") MultipartFile photo,Model model)
	{
		Post post=new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		service.createPost(post);
		model.addAttribute("post" ,post);
		return "posts";
	}
	
}

package com.danielsantana.springmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsantana.springmongodb.domain.Post;
import com.danielsantana.springmongodb.domain.User;
import com.danielsantana.springmongodb.repository.PostRepository;
import com.danielsantana.springmongodb.services.exception.ObjectNotFoungException;

@Service
public class PostService {
	
	@Autowired
	 private PostRepository repository; 

	
	public Post findById (String id) {
		Optional<Post> post = repository.findById(id);
		if(post== null) {
			throw new ObjectNotFoungException("Objeto não encontrado");
		} else {
			return post.get();
		}
	}
	
	
	
	
	

}

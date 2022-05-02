package com.danielsantana.springmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.danielsantana.springmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{'id': ?0}")
	public Post findId(String id);

}

package com.danielsantana.springmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.danielsantana.springmongodb.domain.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{

	
	@Query("{'id': ?0}")
	public User findId(String id);
	


}

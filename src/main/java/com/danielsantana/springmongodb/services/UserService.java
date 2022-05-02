package com.danielsantana.springmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielsantana.springmongodb.domain.User;
import com.danielsantana.springmongodb.dto.UserDTO;
import com.danielsantana.springmongodb.repository.UserRepository;
import com.danielsantana.springmongodb.services.exception.ObjectNotFoungException;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository repository; 
	
	public List<User> findAll () {
		return repository.findAll();
	}
	
	public User findById (String id) {
		User user = repository.findId(id);
		if(user== null) {
			throw new ObjectNotFoungException("Objeto não encontrado");
		} else {
			return user;
		}
	}
	
	public User insert (User obj) {
		repository.insert(obj);
		return obj;
	}
	
	public void delete (String id) {
		findById(id);
		repository.deleteById(id);
	}
	public User update(User obj) {
		User newUser = repository.findId(obj.getId());
		updateData (newUser, obj);
		return repository.save(newUser);
	}
	 
	
	private void updateData(User newUser, User obj) {
		newUser.setEmail(obj.getEmail());
		newUser.setName(obj.getName());
		
	}

	public User fromDTO (UserDTO objDTO) {
		User user = new User(objDTO.getId(),objDTO.getName(), objDTO.getEmail());
		return user;
	}
	
	
	

}

package com.global.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.global.entities.User;
import com.global.repository.UserRepo;

@Service
public class UserService {

	
	@Autowired
	private UserRepo userRepo;
	
	public String insert(User customer){
		userRepo.save(customer);
		return "The Process of User Table Is Done ";
	}
	
	public String update(User customer){
		User current=this.findById(customer.getId());
		if(current!=null) {
			current.setId(customer.getId());
			current.setUserName(customer.getUserName());
			current.setPassword(customer.getPassword());
			userRepo.save(customer);
			return "The Process of User Table Is Done";
		}	
		return "Failed";
	}
	
	public List<User> findUsers() {
		return (List<User>) userRepo.findAll();
	}
	
	public User findById(int id) {
		return userRepo.findById(id).orElseThrow();
	}
	
	public String delete(int id){
		userRepo.deleteById(id);
		return "Process of User Table Is Done";
	}
	

}

package com.global.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.entities.User;
import com.global.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService customerService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody User customer){
		return ResponseEntity.ok(customerService.insert(customer));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody User customer){
		return ResponseEntity.ok(customerService.update(customer));
	}
	
	@GetMapping("/user")
	public List<User> findUser(){
		return customerService.findUsers();
	}
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable int id){
		return customerService.findById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		return ResponseEntity.ok(customerService.delete(id));
	}
	
}

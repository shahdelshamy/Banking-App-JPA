package com.global.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.global.entities.Customer;
import com.global.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	
	
}

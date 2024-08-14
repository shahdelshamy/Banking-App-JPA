package com.global.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.entities.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {

	 
	 
}

package com.global.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.entities.Customer;
import com.global.entities.Order;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

	@Query("SELECT o FROM Order o JOIN o.customers c WHERE c.id = :customerId")
    List<Order> findOrdersByCustomerId(@Param("customerId") int customerId);
	
}

package com.global.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entities.Order;
import com.global.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	Logger log=LoggerFactory.getLogger(CustomerService.class);

	
	public String insert(Order customer){
		orderRepo.save(customer);
		return "The Process of Order Table Is Done ";
	}
	
	public String update(Order customer){
		try {
		Order current=this.findById(customer.getId());
			current.setId(customer.getId());
			current.setOrderName(customer.getOrderName());
			current.setDate(customer.getDate());
			orderRepo.save(customer);
			return "The Process of Order Table Is Done";
		}catch(NoSuchElementException e){
			return "Falied "+e.getMessage();
		}
	}
	
	public List<Order> findOrders() {
		return (List<Order>) orderRepo.findAll();
	}
	
	public Order findById(int id) {
		return orderRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("the Order with id "+id+" not found"));
}
	
	public String delete(int id){
		orderRepo.deleteById(id);
		return "Process of Order Table Is Done";
	}

	
	
	
	
}

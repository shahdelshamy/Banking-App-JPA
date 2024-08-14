package com.global.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.global.entities.Customer;
import com.global.entities.Order;
import com.global.repository.CustomerRepo;

@Service
public class CustomerService {
 
	@Autowired
	private CustomerRepo customerRepo;
	
	Logger log=LoggerFactory.getLogger(CustomerService.class);
	
	public String insert(Customer customer){
		customerRepo.save(customer);
		return "The Process of Customer Table Is Done ";
	}

	public String update(Customer customer){
		try {
	        Customer current = this.findById(customer.getId());
	        log.info("the current"+current);
	        current.setId(customer.getId());
	        current.setAge(customer.getAge());
	        current.setBalance(customer.getBalance());
	        current.setFirstName(customer.getFirstName());
	        current.setLastName(customer.getLastName());
	        current.setUser(customer.getUser());
	        current.setOrders(customer.getOrders());
	        customerRepo.save(current);
	        return "The process of updating the Customer with id "+current.getId() +" is done.";
		}catch(NoSuchElementException e){
			return "Falied "+e.getMessage();
		}
	}
	
	public List<Customer> findCustomers() {
		return (List<Customer>) customerRepo.findAll();
	}
	
	public Customer findById(int id) {
		return customerRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("the Customer with id "+id+" not found"));
}
	
	public String delete(int id){
		customerRepo.deleteById(id);
		return "Process  of Customer Table Is Done";
	}
	
	
	public String deposite(int value,int id) {
		try {
			Customer current=this.findById(id);
			current.setBalance(current.getBalance()+value);
			this.insert(current);
			return "The Process success";
		}catch(NoSuchElementException e) {
			return "Failed "+e.getMessage();
		}
	}
	
	public String withdraw(int value,int id) {
		try {
			Customer current=this.findById(id);
			if(current.getBalance()>value) {
				current.setBalance(current.getBalance()-value);
				this.insert(current);
				return "The Process success";
			}else {
				return "The value you entered greater than your balance";
			}
		}catch(NoSuchElementException e) {
			return "Failed "+e.getMessage();
		}
	}
		
	public List<Order> findOrdersByCustomerId(int id){
		List<Order> orders = customerRepo.findOrdersByCustomerId(id);
        if (orders.isEmpty()) {
            log.warn("No orders found for customer ID {}", id);
        } else {
            log.info("Found {} orders for customer ID {}", orders.size(), id);
        }
        return orders;
	}
	
	
	
	
	
	
}

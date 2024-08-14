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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.entities.Customer;
import com.global.entities.Order;
import com.global.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.insert(customer));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.update(customer));
	}
	
	@GetMapping("/customers")
	public List<Customer> findCustomer(){
		return customerService.findCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer findById(@PathVariable int id){
		return customerService.findById(id);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		return ResponseEntity.ok(customerService.delete(id));
	}
	
	@GetMapping("/deposite")
	public String deposite(@RequestParam int value,@RequestParam  int id) {
		return customerService.deposite(value, id);
	}
	
	@GetMapping("/withdraw")
	public String withdraw(@RequestParam int value,@RequestParam  int id) {
		return customerService.withdraw(value, id);
	}
	
	
	@GetMapping("/findOrdByCustom/{id}")
	public List<Order> findOrdersByCustomerId(@PathVariable int id){
		return  customerService.findOrdersByCustomerId(id);
	}
	
	
}

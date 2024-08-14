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

import com.global.entities.Order;
import com.global.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Order customer){
		return ResponseEntity.ok(orderService.insert(customer));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Order customer){
		return ResponseEntity.ok(orderService.update(customer));
	}
	
	@GetMapping("/order")
	public List<Order> findOrder(){
		return orderService.findOrders();
	}
	
	@GetMapping("/order/{id}")
	public Order findById(@PathVariable int id){
		return orderService.findById(id);
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		return ResponseEntity.ok(orderService.delete(id));
	}

	
	
	
}

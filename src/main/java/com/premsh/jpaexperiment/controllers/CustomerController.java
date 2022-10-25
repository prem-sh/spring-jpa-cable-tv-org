package com.premsh.jpaexperiment.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.premsh.jpaexperiment.data.userbase.models.Customer;
import com.premsh.jpaexperiment.data.userbase.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired CustomerRepository customerRepository;
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer){
		System.out.println(customer.getUserName());
		return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> delete(@RequestBody Customer customer, @PathVariable("id") Integer id){
		customer.setCustomerId(id);
		return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		customerRepository.deleteById(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAll(){
		return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getById(@PathVariable("id") Integer id ){
		return new ResponseEntity<Customer>(customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Customer not found")), HttpStatus.OK);
	}
}

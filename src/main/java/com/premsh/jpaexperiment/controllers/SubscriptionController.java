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

import com.premsh.jpaexperiment.data.channelbase.repository.PackageRepository;
import com.premsh.jpaexperiment.data.userbase.models.Subscription;
import com.premsh.jpaexperiment.data.userbase.models.SubscriptionStatus;
import com.premsh.jpaexperiment.data.userbase.repository.SubscriptionRepository;
import com.premsh.jpaexperiment.data.userbase.repository.SubscriptionStatusRepository;
import com.premsh.jpaexperiment.dto.CreateSubscriptionDto;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
	@Autowired SubscriptionRepository subscriptionRepository;
	@Autowired SubscriptionStatusRepository subscriptionStatusRepository;
	@Autowired PackageRepository packageRepository;
	
	@GetMapping("/status/all")
	public ResponseEntity<List<SubscriptionStatus>> getAllStatus(){
		return new ResponseEntity<List<SubscriptionStatus>>(subscriptionStatusRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Subscription> create(@RequestBody CreateSubscriptionDto createSubscription){
		Subscription subscription = new Subscription();
		
		subscription.setPriceDouble(createSubscription.getPrice());
		subscription.setPackageId(
				
				);
		return new ResponseEntity<Subscription>(subscriptionRepository.save(subscription), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Subscription> delete(@RequestBody Subscription subscription, @PathVariable("id") Integer id){
		subscription.setSubscriptionId(id);
		return new ResponseEntity<Subscription>(subscriptionRepository.save(subscription), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		subscriptionRepository.deleteById(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Subscription>> getAll(){
		return new ResponseEntity<List<Subscription>>(subscriptionRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subscription> getById(@PathVariable("id") Integer id ){
		return new ResponseEntity<Subscription>(subscriptionRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Subscription not found")), HttpStatus.OK);
	}
}

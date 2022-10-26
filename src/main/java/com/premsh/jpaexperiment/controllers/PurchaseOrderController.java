package com.premsh.jpaexperiment.controllers;

import java.util.HashSet;
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

import com.premsh.jpaexperiment.data.userbase.models.PurchaseOrder;
import com.premsh.jpaexperiment.data.userbase.models.PurchaseOrderStatus;
import com.premsh.jpaexperiment.data.userbase.models.Subscription;
import com.premsh.jpaexperiment.data.userbase.repository.CustomerRepository;
import com.premsh.jpaexperiment.data.userbase.repository.PurchaseOrderStatusRepository;
import com.premsh.jpaexperiment.data.userbase.repository.PurchaseOrdersRepository;
import com.premsh.jpaexperiment.data.userbase.repository.SubscriptionRepository;
import com.premsh.jpaexperiment.dto.PurchaseOrderInputDto;

@RestController
@RequestMapping("/purchase-order")
public class PurchaseOrderController {
	@Autowired PurchaseOrdersRepository purchaseOrdersRepository;
	@Autowired PurchaseOrderStatusRepository purchaseOrderStatusRepository;
	@Autowired CustomerRepository customerRepository;
	@Autowired SubscriptionRepository subscriptionRepository;
	
	@GetMapping("/status/all")
	public ResponseEntity<List<PurchaseOrderStatus>> getAllStatus(){
		return new ResponseEntity<List<PurchaseOrderStatus>>(purchaseOrderStatusRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PurchaseOrder> create(@RequestBody PurchaseOrderInputDto purchaseOrderDto){
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setPrice(purchaseOrderDto.getPrice());
		purchaseOrder.setTax(purchaseOrderDto.getTax());
		purchaseOrder.setGrand_total(purchaseOrderDto.getGrandTotal());
		purchaseOrder.setCustomer(customerRepository.findById(purchaseOrderDto.getCustomerId()).orElseThrow(()->new EntityNotFoundException("Customer not found")));
		purchaseOrder.setStatus(purchaseOrderStatusRepository.findById(purchaseOrderDto.getStatus()).orElseThrow(()->new EntityNotFoundException("PO status not found")));
		purchaseOrder.setSubscriptions(new HashSet<Subscription>(subscriptionRepository.findAllById(purchaseOrderDto.getSubscriptions())));
		
		return new ResponseEntity<PurchaseOrder>(purchaseOrdersRepository.save(purchaseOrder), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PurchaseOrder> delete(@RequestBody PurchaseOrderInputDto purchaseOrderDto, @PathVariable("id") Integer id){
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setPurchaseOrderId(id);
		purchaseOrder.setPrice(purchaseOrderDto.getPrice());
		purchaseOrder.setTax(purchaseOrderDto.getTax());
		purchaseOrder.setGrand_total(purchaseOrderDto.getGrandTotal());
		purchaseOrder.setCustomer(customerRepository.findById(purchaseOrderDto.getCustomerId()).orElseThrow(()->new EntityNotFoundException("Customer not found")));
		purchaseOrder.setStatus(purchaseOrderStatusRepository.findById(purchaseOrderDto.getStatus()).orElseThrow(()->new EntityNotFoundException("PO status not found")));
		purchaseOrder.setSubscriptions(new HashSet<Subscription>(subscriptionRepository.findAllById(purchaseOrderDto.getSubscriptions())));
		return new ResponseEntity<PurchaseOrder>(purchaseOrdersRepository.save(purchaseOrder), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		purchaseOrdersRepository.deleteById(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PurchaseOrder>> getAll(){
		return new ResponseEntity<List<PurchaseOrder>>(purchaseOrdersRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PurchaseOrder> getById(@PathVariable("id") Integer id ){
		return new ResponseEntity<PurchaseOrder>(purchaseOrdersRepository.findById(id).orElseThrow(()->new EntityNotFoundException("PO not found")), HttpStatus.OK);
	}
}

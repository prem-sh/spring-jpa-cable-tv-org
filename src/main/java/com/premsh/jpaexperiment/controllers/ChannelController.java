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

import com.premsh.jpaexperiment.data.channelbase.models.Channel;
import com.premsh.jpaexperiment.data.channelbase.repository.ChannelRepository;

@RestController
@RequestMapping("/channel")
public class ChannelController {
	
	@Autowired ChannelRepository channelRepository;
	
	@PostMapping
	public ResponseEntity<Channel> create(@RequestBody Channel channel){
		return new ResponseEntity<Channel>(channelRepository.save(channel), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Channel> delete(@RequestBody Channel channel, @PathVariable("id") Integer id){
		channel.setChannelId(id);
		return new ResponseEntity<Channel>(channelRepository.save(channel), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		channelRepository.deleteById(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Channel>> getAll(){
		return new ResponseEntity<List<Channel>>(channelRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Channel> getById(@PathVariable("id") Integer id ){
		return new ResponseEntity<Channel>(channelRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Channel not found")), HttpStatus.OK);
	}
}

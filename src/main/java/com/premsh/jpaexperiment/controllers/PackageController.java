package com.premsh.jpaexperiment.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

import com.premsh.jpaexperiment.data.channelbase.models.Package;
import com.premsh.jpaexperiment.data.channelbase.repository.ChannelRepository;
import com.premsh.jpaexperiment.data.channelbase.repository.PackageRepository;
import com.premsh.jpaexperiment.dto.CreatePackageDto;

@RestController
@RequestMapping("/package")
public class PackageController {

@Autowired PackageRepository packageRepository;
@Autowired ChannelRepository channelRepository;
	
	@PostMapping
	public ResponseEntity<Package> create(@RequestBody CreatePackageDto createPackageDto){
		Package subscriptionPackage = new Package();
		subscriptionPackage.setPackageName(createPackageDto.getPackageName());
		subscriptionPackage.setDescription(createPackageDto.getDescription());
		subscriptionPackage.setChannels(
				createPackageDto.getChannels().stream()
				.map(
						chId->channelRepository.findById(chId).orElseThrow(
								()->new EntityNotFoundException("Channel not found")
							)
						).collect(Collectors.toList())
				);
		return new ResponseEntity<Package>(packageRepository.save(subscriptionPackage), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Package> delete(@RequestBody CreatePackageDto createPackageDto, @PathVariable("id") Integer id){
		Package subscriptionPackage = new Package();
		subscriptionPackage.setPackageName(createPackageDto.getPackageName());
		subscriptionPackage.setDescription(createPackageDto.getDescription());
		subscriptionPackage.setChannels(
				createPackageDto.getChannels().stream()
				.map(
						chId->channelRepository.findById(chId).orElseThrow(
								()->new EntityNotFoundException("Channel not found")
							)
						).collect(Collectors.toList())
				);
		subscriptionPackage.setPackageId(id);
		return new ResponseEntity<Package>(packageRepository.save(subscriptionPackage), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		packageRepository.deleteById(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Package>> getAll(){
		return new ResponseEntity<List<Package>>(packageRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Package> getById(@PathVariable("id") Integer id ){
		return new ResponseEntity<Package>(packageRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Package not found")), HttpStatus.OK);
	}	
}

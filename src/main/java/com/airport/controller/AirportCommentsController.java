package com.airport.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.airport.Model.AirportComments;
import com.airport.services.AirportCommentsService;

@RestController
@DynamicInsert
@DynamicUpdate
public class AirportCommentsController {

	@Autowired
	private AirportCommentsService service;
	
	@GetMapping("/comments")
	public CompletableFuture<ResponseEntity> getAllComments(){
		
		return service.getAirportComments().thenApply(ResponseEntity::ok);
		
	}
	
	
	@GetMapping("/threadComments")
	public ResponseEntity getCommentsthread() {
		
		CompletableFuture<List<AirportComments>> airportComments1 = service.getAirportComments();
		CompletableFuture<List<AirportComments>> airportComments2 = service.getAirportComments();
		CompletableFuture<List<AirportComments>> airportComments3 = service.getAirportComments();
		
		CompletableFuture.allOf(airportComments1,airportComments2,airportComments3).join();
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@PostMapping("/saveComment")
	public ResponseEntity<AirportComments> saveComment(@RequestBody AirportComments comment){
		
		service.saveAirportComment(comment);
		
		return ResponseEntity.status(201).body(comment);
	}
	
	
	@GetMapping("/{airportRef}")
	public ResponseEntity<List<AirportComments>> getAirportComments(@PathVariable Long airportRef){
		
		return ResponseEntity.ok(service.getAirportComment(airportRef));
	}
	
	@DeleteMapping("/comment/{id}")
	public String deleteAirportComment(@PathVariable Long id) {
		
		return service.deleteAirportComment(id);
	}
}

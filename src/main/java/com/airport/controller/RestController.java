package com.airport.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airport.Model.Airports;
import com.airport.serviceImpl.AirportCommentsServiceImpl;
import com.airport.services.AirportService;

@Controller
public class RestController {
	
	@Autowired
	private AirportService service;
	

	Logger logger = LoggerFactory.getLogger(RestController.class);


	
	@GetMapping("/airports")
	public ResponseEntity<List<Airports>> getAirports(){
		
		List<Airports> airports = service.getAirports();
		
		return ResponseEntity.ok(airports);
	}
	
	@GetMapping("/airport/{id}")
	public ResponseEntity<Airports> getAirport(@PathVariable Long id){
		
		Airports airport = service.getAirport(id);
		
		return ResponseEntity.ok(airport);
	}
	
	@PostMapping("/")
	public ResponseEntity<Airports> saveAirport(@RequestBody Airports airport){
		

		Airports savedAirport = service.saveAirport(airport);
		
		return ResponseEntity.ok(savedAirport);
	}
	
	@PutMapping("/")
	public ResponseEntity<Airports> updateAirport(@RequestBody Airports airport){
		
		Airports updateAirport = service.updateAirport(airport);
		
		return ResponseEntity.ok(updateAirport);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePort(@PathVariable Long id){
		
		String deleteAirport;
		ResponseEntity<Airports> airport = getAirport(id);
		
		if(airport != null) {
			 deleteAirport = service.deleteAirport(id);
		}
		else {
			deleteAirport = "Id Not Found";
		}
		
		return ResponseEntity.ok(deleteAirport);
	}
	
	@PostMapping("/search")
	@ResponseBody
	public ResponseEntity<List<Airports>> searchByName(@RequestParam String name) { 
		List<Airports> searchAirportByName = null;
		if (!name.isEmpty()) {
			searchAirportByName = service.searchAirportByName(name);
			
			if(!searchAirportByName.isEmpty()) return ResponseEntity.status(HttpStatus.FOUND).body(searchAirportByName);
			
			else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(searchAirportByName);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(searchAirportByName);
		}    
	}
	
	@GetMapping("/searchRandom/{keyword}")
	public ResponseEntity<List<Airports>> searchrandom(@PathVariable String keyword){
		
		List<Airports> searchResult = service.search(keyword);
		
		return ResponseEntity.ok(searchResult);
	}
	
	@PostMapping("/updateField/{id}")
	@ResponseBody
	public ResponseEntity<Airports> updateByField(
			@PathVariable Long id,
			@RequestParam String type,
			@RequestParam String name,
			@RequestParam String lattitude_deg,
			@RequestParam String longitute_deg,
			@RequestParam String elevation_ft,
			@RequestParam String continent,
			@RequestParam String iso_country,
			@RequestParam String iso_region,
			@RequestParam String municipality,
			@RequestParam String scheduled_service,
			@RequestParam String gps_code,
			@RequestParam String iata_code,
			@RequestParam String local_code,
			@RequestParam String home_link,
			@RequestParam String wikipedia_link,
			@RequestParam String keywords){
		
		Airports airport = null;
		
		if(!type.isEmpty()) {
			airport = service.getAirport(id);
			airport.setType(type);
			
			service.saveAirport(airport);	
			
			logger.info("Type field Updated");
		}
		
		if(!name.isEmpty()) {
			airport = service.getAirport(id);
			airport.setName(name);
			
			service.saveAirport(airport);
			
			logger.info("name Field updated");
		}
		
		if (!lattitude_deg.isEmpty()) {
			airport = service.getAirport(id);
			airport.setLattitude_deg(lattitude_deg);
			
			service.saveAirport(airport);
			
			logger.info("lattitude field updated");
		}
		
		if (!longitute_deg.isEmpty()) {
			airport = service.getAirport(id);
			airport.setLongitute_deg(longitute_deg);
			
			service.saveAirport(airport);
			
			logger.info("longitude field updated... ");
		}
		
		if (!elevation_ft.isEmpty()) {
			airport = service.getAirport(id);
			airport.setElevation_ft(Long.parseLong(elevation_ft));
			
			service.saveAirport(airport);
			
			logger.info("Elevation_ft field updated... ");
		}
		
		if (!continent.isEmpty()) {
			airport = service.getAirport(id);
			airport.setContinent(continent);
			
			service.saveAirport(airport);
			
			logger.info("continent field updated... ");
		}
		
		if (!iso_country.isEmpty()) {
			airport = service.getAirport(id);
			airport.setIso_country(iso_country);
			
			service.saveAirport(airport);
			
			logger.info("ISO_Country field updated... ");
		}
		
		if (!iso_region.isEmpty()) {
			airport = service.getAirport(id);
			airport.setIso_region(iso_region);
			
			service.saveAirport(airport);
			
			logger.info("ISO Region field updated... ");
		}
		
		if (!municipality.isEmpty()) {
			airport = service.getAirport(id);
			airport.setMunicipality(municipality);
			
			service.saveAirport(airport);
			
			logger.info("Municipality field updated... ");
		}
		
		if (!scheduled_service.isEmpty()) {
			airport = service.getAirport(id);
			airport.setScheduled_service(scheduled_service);
			
			service.saveAirport(airport);
			
			logger.info("Scheculed Service field updated... ");
		}
		
		if (!gps_code.isEmpty()) {
			airport = service.getAirport(id);
			airport.setGps_code(gps_code);
			
			service.saveAirport(airport);
			
			logger.info("GPS Code field updated... ");
		}
		
		if (!iata_code.isEmpty()) {
			airport = service.getAirport(id);
			airport.setIata_code(iata_code);
			
			service.saveAirport(airport);
			
			logger.info("IATA Code field updated... ");
		}
		
		if (!local_code.isEmpty()) {
			airport = service.getAirport(id);
			airport.setLocal_code(local_code);
			
			service.saveAirport(airport);
			
			logger.info("Local code field updated... ");
		}
		
		if (!home_link.isEmpty()) {
			airport = service.getAirport(id);
			airport.setHome_link(home_link);
			
			service.saveAirport(airport);
			
			logger.info("Home Link field updated... ");
		}
		
		if (!wikipedia_link.isEmpty()) {
			airport = service.getAirport(id);
			airport.setWikipedia_link(wikipedia_link);
			
			service.saveAirport(airport);
			
			logger.info("Wikipedia link field updated... ");
		}
		
		if (!keywords.isEmpty()) {
			airport = service.getAirport(id);
			airport.setKeywords(keywords);
			
			service.saveAirport(airport);
			
			logger.info("Keywords field updated... ");
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(airport);
	
	}
}

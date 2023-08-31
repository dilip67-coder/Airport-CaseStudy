package com.airport.services;

import java.util.List;

import com.airport.Model.Airports;

public interface AirportService {
	
	public List<Airports> getAirports();
	
	public Airports getAirport(long id);
	
	public Airports saveAirport(Airports airports);
	
	public Airports updateAirport(Airports airport);
	
	public String deleteAirport(long id);
	
	public List<Airports> searchAirportByName(String name);
	
	public List<Airports> search(String keyword);
	

}

package com.airport.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.airport.Model.AirportComments;


public interface AirportCommentsService {
	
	public CompletableFuture<List<AirportComments>> getAirportComments();
	
	public List<AirportComments> getAirportComment(long airportRef);
	
	public AirportComments saveAirportComment(AirportComments airports);
	
//	public AirportComments updateAirportComments(AirportComments airport);
	
	public String deleteAirportComment(long id);

}

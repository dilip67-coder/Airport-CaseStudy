package com.airport.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.airport.Model.AirportComments;
import com.airport.repository.AirportCommentsRepo;
import com.airport.services.AirportCommentsService;


@Service
public class AirportCommentsServiceImpl implements AirportCommentsService{

	@Autowired
	private AirportCommentsRepo repo;
	
	Logger logger = LoggerFactory.getLogger(AirportCommentsServiceImpl.class);

	
	@Override
	@Async
	public CompletableFuture<List<AirportComments>> getAirportComments() {
		
		logger.info("Get List of All Comments by user thread: "+Thread.currentThread().getName(), Thread.currentThread().getId());
		List<AirportComments> allComments = repo.findAll();
		
		return CompletableFuture.completedFuture(allComments);
	}

	@Override
	public List<AirportComments> getAirportComment(long airportRef) {
		
		logger.info("Get Comments of Airport Ref: "+Thread.currentThread().getName(), Thread.currentThread().getId());
		
		List<AirportComments> comments = repo.findByAirportRef(airportRef);
		
		
		return comments;
	}

	@Override
	public AirportComments saveAirportComment(AirportComments airports) {
		
		long start = System.currentTimeMillis();
		logger.info("Saving data -- "+Thread.currentThread().getName(), Thread.currentThread().getId());
		
		airports.setThreadRef(Thread.currentThread().getId());
		
		repo.save(airports);
		
		long end = System.currentTimeMillis();
		logger.info("Total time taken in ms : ",(end-start));
		
		return airports;
	}

	@Override
	public String deleteAirportComment(long id) {
		
		logger.info("delete airport comment user thread: "+Thread.currentThread().getName(), Thread.currentThread().getId());
		
		Optional<AirportComments> comment = repo.findById(id);
		
		if (comment.get() != null) {
			repo.deleteById(id);
			
			return "Deleted :"+id;
		}
		else {
			return "null";
		}
		
		
	}

}

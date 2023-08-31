package com.airport.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airport.Model.Airports;
import com.airport.repository.AirportsRepo;
import com.airport.services.AirportService;

@Service
public class AirportServiceImpl implements AirportService{
	
	@Autowired
	private AirportsRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public List<Airports> getAirports() {
		
		List<Airports> allAirports = repo.findAll();
		
		return allAirports;
	}

	@Override
	public Airports getAirport(long id) {
		
		Optional<Airports> findById = repo.findById(id);
		Airports airport = new Airports();
		
		  mapper.map(findById.get(), airport);

		
		return airport;
	}

	@Override
	public Airports saveAirport(Airports airport) {
		Airports savedAirport = repo.save(airport);
		
		return savedAirport;
	}

	@Override
	public Airports updateAirport(Airports airport) {
		
		Airports a = new Airports();
		mapper.map(airport,a);
		
		repo.save(a);
		
		return a;
	}

	@Override
	public String deleteAirport(long id) {
		
		Optional<Airports> port = repo.findById(id);
		String deletedAirport = "Airport delete with Name : "+
				port.get().getName() + " and Ident : "+port.get().getIdent();
		
		repo.deleteById(id);
		
		return deletedAirport;
	}

	@Override
	public List<Airports> searchAirportByName(String name) {
		
		List<Airports> nameSearchResult = repo.findByName(name);
		
		return nameSearchResult;
	}

	@Override
	public List<Airports> search(String keyword) {
		List<Airports> searchResult = repo.search(keyword);
		return searchResult;
	}

}

package com.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airport.Model.AirportComments;

@Repository
public interface AirportCommentsRepo extends JpaRepository<AirportComments, Long> {

	List<AirportComments> findByAirportRef(long airportRef);

}

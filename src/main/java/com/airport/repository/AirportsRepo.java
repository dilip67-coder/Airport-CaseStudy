package com.airport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airport.Model.Airports;

@Repository
public interface AirportsRepo extends JpaRepository<Airports, Long>{

	public List<Airports> findByName(String name);
	
    @Query("SELECT a FROM Airports a WHERE a.ident LIKE %?1%"
            + " OR a.type LIKE %?1%"
            + " OR a.name LIKE %?1%"
            + " OR a.continent LIKE %?1%"
            + "OR a.iso_country LIKE %?1%"
            + "OR a.iso_region LIKE %?1%"
            + "OR a.municipality LIKE %?1%"
            )
    public List<Airports> search(String keyword);
    
}

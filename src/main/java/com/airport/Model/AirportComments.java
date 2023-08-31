package com.airport.Model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class AirportComments {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;
	
	private long threadRef;
	private long airportRef;

	private String airportIdent;
	
	private Date date;
	private String memberNickname;
	private String subject;
	private String body;
	
}

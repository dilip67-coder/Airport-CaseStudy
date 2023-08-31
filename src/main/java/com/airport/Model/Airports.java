package com.airport.Model;

import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Primary;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Airports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


		private String ident;
		
		private String type;
		private String name;
		private String lattitude_deg;
		private String longitute_deg;
		private long elevation_ft;
		private String continent;
		private String iso_country;
		private String iso_region;
		private String municipality;
		private String scheduled_service;
		private String gps_code;
		private String iata_code;
		private String local_code;
		private String home_link;
		private String wikipedia_link;
		private String keywords;
		
}

package com.airport.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.airport.Model.Airports;
import com.opencsv.CSVReader;

public class ReadCsvAndStore {
	
	public static void main(String[] args) throws IOException {

	BufferedReader fileReader = new BufferedReader(new FileReader("airports.csv"));
	CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

	List<CSVRecord> csvRecords = 
			csvParser.getRecords();
		Airports airport = new Airports();
	
	for (CSVRecord csvRecord : csvRecords) {
		airport= new Airports();
	
		}
		
		/*
		 * String csvFilePath = "../Airport-caseStudy/airports.csv";
		 * 
		 * try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
		 * String[] nextLine; while ((nextLine = reader.readNext()) != null) { for
		 * (String value : nextLine) { // System.out.print(value + " | "); }
		 * 
		 * 
		 * String value=nextLine[0]; System.out.println(value+" -- ");
		 * 
		 * System.out.println(); // Move to the next line }
		 * 
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

	
}
}


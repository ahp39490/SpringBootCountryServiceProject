package com.countryservice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.demo.beans.country;
import com.countryservice.demo.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public List<country> getCountryies() {
		
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<country> getCountryById(@PathVariable(value ="id") int id) {
		
		try {
			country country = countryService.getCountryById(id);
			return new ResponseEntity<country>(country, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Country id not found.........");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getcountries/countryname")
	public ResponseEntity<country> getCountryByName(@RequestParam (value = "name") String countryName) {
		
		try {
			country country = countryService.getCountryByName(countryName);
			return new ResponseEntity<country>(country, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Country name not found.........");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/addcountry")
	public country addCountry(@RequestBody country country) {
		
		return countryService.addCountry(country);
	}
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<country> updateCountry(@PathVariable(value = "id") int id, @RequestBody country country) {
		
		try {
			country existCountry = countryService.getCountryById(id);
			
			existCountry.setCountryName(country.getCountryName());
			existCountry.setCountryCapital(country.getCountryCapital());
			
			country updateCountry =  countryService.updateCountry(existCountry);
			
			return new ResponseEntity<country>(updateCountry, HttpStatus.OK);

		} catch (Exception e) {

			System.out.println("Country name not found.........");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value ="id") int id) {
		
		return countryService.deleteCountry(id);

	}
}

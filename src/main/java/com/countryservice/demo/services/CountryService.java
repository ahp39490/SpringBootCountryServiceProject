package com.countryservice.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.countryservice.demo.beans.country;
import com.countryservice.demo.controllers.AddResponse;
import com.countryservice.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	AddResponse addResponse = new AddResponse();

	public List<country> getAllCountries() {

		return countryRepository.findAll();
	}

	public country getCountryById(int id) {

		return countryRepository.findById(id).get();

	}

	public country getCountryByName(String countryName) {

		List<country> listOfCountrries = countryRepository.findAll();
		country country = null;

		for (country con : listOfCountrries) {
			if (con.getCountryName().equalsIgnoreCase(countryName)) {
				country = con;
			}
		}
		return country;
	}

	public country addCountry(country country) {

		country.setId(getMaxId());
		countryRepository.save(country);
		
		return country;
	}

	public country updateCountry(country country) {

		countryRepository.save(country);
		return country;
		
	}

	public AddResponse deleteCountry(int id) {

		countryRepository.deleteById(id);
		addResponse.setMsg("Country Deleted!....");
		addResponse.setId(id);
		
		return addResponse;
	}

	/*
	 * Utility method to get the max id
	 */
	public int getMaxId() {
		
		return countryRepository.findAll().size()+1;

	}

}

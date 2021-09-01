//package com.countryservice.demo.services;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.countryservice.demo.beans.Country;
//import com.countryservice.demo.controllers.AddResponse;
//
//@Component
//public class C1 {
//
//	static HashMap<Integer, Country> countryIdMap;
//
//	public C1() {
//		countryIdMap = new HashMap<Integer, Country>();
//
//		Country bangladeshCountry = new Country(1, "Bangladesh", "Dakha");
//		Country USACountry = new Country(2, "USA", "Washignton");
//		Country UKCountry = new Country(3, "UK", "London");
//
//		countryIdMap.put(1, bangladeshCountry);
//		countryIdMap.put(2, USACountry);
//		countryIdMap.put(3, UKCountry);
//
//	}
//
//	public List getAllCountries() {
//		List countries = new ArrayList(countryIdMap.values());
//		return countries;
//	}
//
//	public Country getCountryById(int id) {
//		Country country = countryIdMap.get(id);
//		return country;
//	}
//
//	public Country getCountryByName(String countryName) {
//		Country country = null;
//		for (int i : countryIdMap.keySet()) {
//			if (countryIdMap.get(i).getCountryName().equals(countryName)) {
//				country = countryIdMap.get(i);
//			}
//		}
//		return country;
//	}
//
//	public Country addCountry(Country country) {
//		country.setId((getMaxId()));
//		countryIdMap.put(country.getId(), country);
//		return country;
//	}
//
//	public Country updateCountry(Country country) {
//
//		if (country.getId() > 0) {
//			countryIdMap.put(country.getId(), country);
//		}
//		return country;
//	}
//
//	public AddResponse deleteCountry(int id) {
//
//		countryIdMap.remove(id);
//		AddResponse res = new AddResponse();
//		res.setMsg("Country deleted...");
//		res.setId(id);
//
//		return res;
//	}
//
//	/*
//	 * Utility method to get the max id
//	 */
//	public static int getMaxId() {
//		int max = 0;
//		for (int id : countryIdMap.keySet()) {
//			if (max <= id) {
//				max = id;
//			}
//		}
//		return max + 1;
//	}
//
//}

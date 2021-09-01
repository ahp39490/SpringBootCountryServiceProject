package com.countryservice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.countryservice.demo.beans.country;


public interface CountryRepository extends JpaRepository<country, Integer> {

}

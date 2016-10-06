package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Country;


public interface CountryService {

	void save(Country country);
	
	Country findByName(String name);
	
	void delete(int id);
	
	List<Country> findAll();

	Country findOne(int id);

	Page<Country> findAll(Pageable pageable);

//	void delete(String name);
}

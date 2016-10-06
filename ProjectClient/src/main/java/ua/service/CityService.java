package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.City;

public interface CityService {

	City findByName(String name);
	
	void delete(int id);
	
	Page<City> findAll(Pageable pageable);
	
	List<City> findAll();
	
	void save(City city);

	City findOne(int id);

}

package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Street;

public interface StreetService {

	Street findByName(String name);
	
	void delete(int id);
	
	Page<Street> findAll(Pageable pageable);
	
	void save(Street street);

	Street findOne(int id);
	
	List<Street> findAll();
}

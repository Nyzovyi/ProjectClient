package ua.service;

import java.util.List;

import ua.entity.Name;

public interface NameService {

	void save(Name name);
	
	Name findByName(String name);
	
	void delete(int id);
	
	List<Name> findAll();

	Name findOne(int id);
	
	
}

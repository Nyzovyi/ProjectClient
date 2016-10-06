package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Adress;

public interface AdressService {
	
	void delete(int id);
	
	List<Adress> findAll();
	
	Page<Adress> findAll(Pageable pageable);
	
	void save(Adress adress);
	
	Adress findOne(int id);

	Adress findByNamberHouse(int namberHouse);

	Adress findByNamberHouse(String namberHouse);


	
}

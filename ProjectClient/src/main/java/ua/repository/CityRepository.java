package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{

	City findByName(String name);
	
	
}


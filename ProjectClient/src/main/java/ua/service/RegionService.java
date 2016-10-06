package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Region;

public interface RegionService {

//void save(String name);
	
	Region findByName(String name);
	
	void delete(int id);
	
	List<Region> findAll();
	
	Page<Region> findAll(Pageable pageable);

	void save(Region region);

	Region findOne(int id);
	
	

}

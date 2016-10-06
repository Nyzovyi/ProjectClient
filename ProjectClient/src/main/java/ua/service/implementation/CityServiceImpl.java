package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.City;
import ua.repository.CityRepository;
import ua.repository.RegionRepository;
import ua.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void save(City city) {
		cityRepository.save(city);
	}

	@Override
	public void delete(int id) {
		cityRepository.delete(id);
	}
	
	@Override
	public Page<City> findAll(Pageable pageable) {
		return cityRepository.findAll(pageable);
	}

	@Override
	public City findOne(int id) {
		return cityRepository.findOne(id);
	}

	@Override
	public City findByName(String name) {
		return cityRepository.findByName(name);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}
}

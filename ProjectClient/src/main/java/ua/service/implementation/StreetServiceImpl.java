package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Street;
import ua.repository.CityRepository;
import ua.repository.StreetRepository;
import ua.service.StreetService;

@Service
public class StreetServiceImpl implements StreetService{

	@Autowired
	private StreetRepository streetRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public Page<Street> findAll(Pageable pageable) {
		return streetRepository.findAll(pageable);
	}
	
	@Override
	public void delete(int id) {
		streetRepository.delete(id);
	}
	
	@Override
	public void save(Street street) {
		streetRepository.save(street);
	}

	@Override
	public Street findOne(int id) {
		return streetRepository.findOne(id);
	}

	@Override
	public Street findByName(String name) {
		return streetRepository.findByName(name);
	}

	@Override
	public List<Street> findAll() {
		return streetRepository.findAll();
	}
}

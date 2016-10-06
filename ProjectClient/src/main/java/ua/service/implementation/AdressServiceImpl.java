package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Adress;
import ua.repository.AdressRepository;
import ua.repository.StreetRepository;
import ua.service.AdressService;

@Service
public class AdressServiceImpl implements AdressService{

	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private StreetRepository streetRepository;
	
	@Override
	public Page<Adress> findAll(Pageable pageable) {
		return adressRepository.findAll(pageable);
	}
	
	@Override
	public void delete(int id) {
		adressRepository.delete(id);
	}
	
	@Override
	public void save(Adress adress) {
		adressRepository.save(adress);
	}
	
	@Override
	public Adress findOne(int id) {
		return adressRepository.findOne(id);
	}
	
	@Override
	public Adress findByNamberHouse(int namberHouse) { 
		return adressRepository.findByNamberHouse(namberHouse);
	}
	@Override
	public Adress findByNamberHouse(String namberHouse) {
		return adressRepository.findByNamberHouse(namberHouse);
	}

	@Override
	public List<Adress> findAll() {
		return adressRepository.findAll();
	}
	
	
	
	
	

	
}

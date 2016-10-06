package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Region;
import ua.repository.CountryRepository;
import ua.repository.RegionRepository;
import ua.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Override
	public void save(Region region) {
		regionRepository.save(region);
	}

	@Override
	public void delete(int id) {
		regionRepository.delete(id);
	}
	
	@Override
	public Page<Region> findAll(Pageable pageable) {
		return regionRepository.findAll(pageable);
	}

	@Override
	public Region findOne(int id) {
		return regionRepository.findOneCountryInited(id);
	}

	@Override
	public Region findByName(String name) {
		return regionRepository.findByName(name);
	}

	@Override
	public List<Region> findAll() {
		return regionRepository.findAll();
	}

	
}

package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Name;
import ua.repository.NameRepository;
import ua.service.NameService;

@Service
public class NameServiceImpl implements NameService{

	@Autowired
	private NameRepository NameRepository;
	
	@Override
	public void save(Name name) {
		NameRepository.save(name);
	}

	@Override
	public Name findByName(String name) {
		return NameRepository.findByName(name);
	}

	@Override
	public void delete(int id) {
		NameRepository.delete(id);
	}
	

	@Override
	public List<Name> findAll() {
		return NameRepository.findAll();
	}

	@Override
	public Name findOne(int id) {
		return NameRepository.findOne(id);
	}
	
}
